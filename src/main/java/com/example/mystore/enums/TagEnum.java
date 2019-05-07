package com.example.mystore.enums;

public enum TagEnum {

	neutro(0), veludo(1), couro(2), basics(3), festa(4), workwear(5), inverno(6), boho(7), estampas(8), balada(9),
	colorido(10), casual(11), liso(12), moderno(13), passeio(14), metal(15), viagem(16), delicado(17), descolado(18),
	elastano(19);

	public int posicao;

	TagEnum(int posicao) {
		this.posicao = posicao;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public static TagEnum retrieveByTag(String tag) {
		for (TagEnum tagEnum : TagEnum.values()) {
			if (tagEnum.name().toString().toLowerCase().equals(tag.toLowerCase())) {
				return tagEnum;
			}
		}

		return null;
	}
	
	public static TagEnum retrieveByPosicao(int posicao) {
		for (TagEnum tagEnum : TagEnum.values()) {
			if (tagEnum.posicao == posicao) {
				return tagEnum;
			}
		}

		return null;
	}

}
