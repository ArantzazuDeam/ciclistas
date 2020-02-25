package com.arantzazudealbamoreno.segundaevaluacion.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="puerto")
public class Puerto {

	@Id
	@Column(name="nompuerto")
	private String nompuerto;
	
	@Column(name="altura")
	private int altura;
	
	@Column(name="categoria")
	private String categoria;
	
	@Column(name="pendiente")
	private int pendiente;
	
	//foreign key a netapa de Etapa(netapa)
	@ManyToOne
	@JoinColumn(name="netapa")
	private Etapa netapa;
	
	//foreign key a dorsal de Ciclista(dorsal)
	@ManyToOne
	@JoinColumn(name="dorsal")
	private Ciclista dorsal;

	public Puerto() {
		super();
	}

	public Puerto(String nompuerto, int altura, String categoria, int pendiente, Etapa netapa, Ciclista dorsal) {
		super();
		this.nompuerto = nompuerto;
		this.altura = altura;
		this.categoria = categoria;
		this.pendiente = pendiente;
		this.netapa = netapa;
		this.dorsal = dorsal;
	}

	public String getNompuerto() {
		return nompuerto;
	}

	public void setNompuerto(String nompuerto) {
		this.nompuerto = nompuerto;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getPendiente() {
		return pendiente;
	}

	public void setPendiente(int pendiente) {
		this.pendiente = pendiente;
	}

	public Etapa getNetapa() {
		return netapa;
	}

	public void setNetapa(Etapa netapa) {
		this.netapa = netapa;
	}

	public Ciclista getDorsal() {
		return dorsal;
	}

	public void setDorsal(Ciclista dorsal) {
		this.dorsal = dorsal;
	}

	
	
}
