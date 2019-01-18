package com.ipartek.formacion.pojos;

import java.sql.Date;
import java.sql.Time;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Objetivo {

	private Long id_agente;
	private Date fecha;

	private int num_multas ;  
	private float importe;
	
	public Objetivo() {
		super();
		this.id_agente = -1L;
		this.fecha = null;

		this.num_multas = -1;
		this.importe = (float) 1;
	}

	
	
	public Objetivo(Long id_agente, Date fecha, int num_multas, float importe) {
		this();
		setId_agente(id_agente);
		setFecha(fecha);
		setNum_multas(num_multas);
		setImporte(importe);
	}



	public Long getId_agente() {
		return id_agente;
	}



	public void setId_agente(Long id_agente) {
		this.id_agente = id_agente;
	}



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}






	public int getNum_multas() {
		return num_multas;
	}



	public void setNum_multas(int num_multas) {
		this.num_multas = num_multas;
	}



	public float getImporte() {
		return importe;
	}



	public void setImporte(float importe) {
		this.importe = importe;
	}



	@Override
	public String toString() {
		return "Objetivos [id_agente=" + id_agente + ", fecha=" + fecha + ", num_multas="
				+ num_multas + ", importe=" + importe + "]";
	}



	

	


}