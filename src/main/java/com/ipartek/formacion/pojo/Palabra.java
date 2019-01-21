package com.ipartek.formacion.pojo;

public class Palabra {

	private String letra1;

	private String letra2;


	public Palabra() {
		super();
		this.letra1 = "letra1";
		this.letra2 = "letra2";
	}


	public Palabra(String letra1, String letra2) {
		super();
		setLetra1(letra1);
		setLetra2(letra1);
	}

	public String getLetra1() {
		return letra1;
	}


	public void setLetra1(String letra1) {
		this.letra1 = letra1;
	}


	public String getLetra2() {
		return letra2;
	}


	public void setLetra2(String letra2) {
		this.letra2 = letra2;
	}


	@Override
	public String toString() {
		return "Palabra [letra1=" + letra1 + ", letra2=" + letra2 + "]";
	}

	
	
	}

