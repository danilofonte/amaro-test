package com.example.mystore.converter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.example.mystore.enums.TagEnum;
import com.example.mystore.model.Product;
import com.example.mystore.model.Tag;
import com.example.mystore.stereotypes.ConverterComponent;

@ConverterComponent
public class TagConverter {

	public Tag convertTagListToTag(final List<String> tags, final Product product)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Tag tagVar = new Tag();

		for (String tag : tags) {

			TagEnum tagEnum = TagEnum.retrieveByTag(tag);

			Method[] methods = tagVar.getClass().getMethods();

			for (Method m : methods) {

				if (m.getName().toLowerCase().contains("setposicao")
						&& m.getName().toLowerCase().replace("setposicao","").equals(String.valueOf(tagEnum.posicao))) {
					m.invoke(tagVar, 1);
				}

			}
			

		}

		List<String> pos = new ArrayList<>();

		Method[] methods = tagVar.getClass().getMethods();

		for (Method m : methods) {

			if (m.getName().toLowerCase().contains("getposicao")) {
				int valor = (int) m.invoke(tagVar);

				if (valor != 1) {
					pos.add(m.getName().replace("getposicao", ""));
				}
			}

		}

		for (String p : pos) {

			for (Method m : methods) {

				if (m.getName().toLowerCase().replace("setposicao","").contains(p.toLowerCase()) && m.getName().toLowerCase().contains("set")) {
					m.invoke(tagVar, 0);
				}

			}
		}

		tagVar.setProduct(product);
		return tagVar;

	}
	
	

	public List<String> convertTagToTagList(Tag tag)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		List<String> tags = new ArrayList<>();

		Method[] methods = tag.getClass().getMethods();

		for (Method method : methods) {

			if (method.getName().contains("getPosicao")) {
				int valor = (int) method.invoke(tag);

				if (valor > 0) {
					
					String methodNameReplaced = method.getName().replace("getPosicao", "");

					TagEnum tagEnum = TagEnum
							.retrieveByPosicao(Integer.valueOf(methodNameReplaced));

					tags.add(tagEnum.name().toString());
				}
			}

		}

		return tags;

	}
	
	public int[] convertTagToTagListInt(Tag tag)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		int[] tags = new int[20];
		
		for (int i=0;i<20;i++) {
			tags[i] = 0;
		}

		Method[] methods = tag.getClass().getMethods();

		for (Method method : methods) {

			if (method.getName().contains("getPosicao")) {
				int valor = (int) method.invoke(tag);

				if (valor > 0) {
					
					String methodNameReplaced = method.getName().replace("getPosicao", "");

					TagEnum tagEnum = TagEnum
							.retrieveByPosicao(Integer.valueOf(methodNameReplaced));

					tags[Integer.valueOf(methodNameReplaced)] = valor;
				}
			}

		}

		return tags;

	}

}
