package com.example.mystore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tag")
public class Tag {

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "P_0")
	private int posicao0;

	@Column(name = "P_1")
	private int posicao1;

	@Column(name = "P_2")
	private int posicao2;

	@Column(name = "P_3")
	private int posicao3;

	@Column(name = "P_4")
	private int posicao4;

	@Column(name = "P_5")
	private int posicao5;

	@Column(name = "P_6")
	private int posicao6;

	@Column(name = "P_7")
	private int posicao7;

	@Column(name = "P_8")
	private int posicao8;

	@Column(name = "P_9")
	private int posicao9;

	@Column(name = "P_10")
	private int posicao10;

	@Column(name = "P_11")
	private int posicao11;

	@Column(name = "P_12")
	private int posicao12;

	@Column(name = "p_13")
	private int posicao13;

	@Column(name = "P_14")
	private int posicao14;

	@Column(name = "P_15")
	private int posicao15;

	@Column(name = "P_16")
	private int posicao16;

	@Column(name = "P_17")
	private int posicao17;

	@Column(name = "P_18")
	private int posicao18;

	@Column(name = "P_19")
	private int posicao19;

	@OneToOne
	@MapsId
	private Product product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPosicao0() {
		return posicao0;
	}

	public void setPosicao0(int posicao0) {
		this.posicao0 = posicao0;
	}

	public int getPosicao1() {
		return posicao1;
	}

	public void setPosicao1(int posicao1) {
		this.posicao1 = posicao1;
	}

	public int getPosicao2() {
		return posicao2;
	}

	public void setPosicao2(int posicao2) {
		this.posicao2 = posicao2;
	}

	public int getPosicao3() {
		return posicao3;
	}

	public void setPosicao3(int posicao3) {
		this.posicao3 = posicao3;
	}

	public int getPosicao4() {
		return posicao4;
	}

	public void setPosicao4(int posicao4) {
		this.posicao4 = posicao4;
	}

	public int getPosicao5() {
		return posicao5;
	}

	public void setPosicao5(int posicao5) {
		this.posicao5 = posicao5;
	}

	public int getPosicao6() {
		return posicao6;
	}

	public void setPosicao6(int posicao6) {
		this.posicao6 = posicao6;
	}

	public int getPosicao7() {
		return posicao7;
	}

	public void setPosicao7(int posicao7) {
		this.posicao7 = posicao7;
	}

	public int getPosicao8() {
		return posicao8;
	}

	public void setPosicao8(int posicao8) {
		this.posicao8 = posicao8;
	}

	public int getPosicao9() {
		return posicao9;
	}

	public void setPosicao9(int posicao9) {
		this.posicao9 = posicao9;
	}

	public int getPosicao10() {
		return posicao10;
	}

	public void setPosicao10(int posicao10) {
		this.posicao10 = posicao10;
	}

	public int getPosicao11() {
		return posicao11;
	}

	public void setPosicao11(int posicao11) {
		this.posicao11 = posicao11;
	}

	public int getPosicao12() {
		return posicao12;
	}

	public void setPosicao12(int posicao12) {
		this.posicao12 = posicao12;
	}

	public int getPosicao13() {
		return posicao13;
	}

	public void setPosicao13(int posicao13) {
		this.posicao13 = posicao13;
	}

	public int getPosicao14() {
		return posicao14;
	}

	public void setPosicao14(int posicao14) {
		this.posicao14 = posicao14;
	}

	public int getPosicao15() {
		return posicao15;
	}

	public void setPosicao15(int posicao15) {
		this.posicao15 = posicao15;
	}

	public int getPosicao16() {
		return posicao16;
	}

	public void setPosicao16(int posicao16) {
		this.posicao16 = posicao16;
	}

	public int getPosicao17() {
		return posicao17;
	}

	public void setPosicao17(int posicao17) {
		this.posicao17 = posicao17;
	}

	public int getPosicao18() {
		return posicao18;
	}

	public void setPosicao18(int posicao18) {
		this.posicao18 = posicao18;
	}

	public int getPosicao19() {
		return posicao19;
	}

	public void setPosicao19(int posicao19) {
		this.posicao19 = posicao19;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	

}
