package com.arantzazudealbamoreno.segundaevaluacion.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="etapa")
public class Etapa {

	@Id
	@Column(name="netapa")
	private int netapa;
	
	@Column(name="km")
	private int km;
	
	@Column(name="salida")
	private String salida;
	
	@Column(name="llegada")
	private String llegada;
	
	// dorsal, fk a Ciclista(dorsal)
	@ManyToOne
	@JoinColumn(name="dorsal")
	private Ciclista dorsal;
	
	@OneToMany(mappedBy="netapa")
	private List<Puerto> puertos;
	
	@OneToMany(mappedBy="netapa")
	private List<Llevar> llevados;

	public Etapa() {
		super();
	}

	public Etapa(int netapa, int km, String salida, String llegada, Ciclista dorsal, List<Puerto> puertos,
			List<Llevar> llevados) {
		super();
		this.netapa = netapa;
		this.km = km;
		this.salida = salida;
		this.llegada = llegada;
		this.dorsal = dorsal;
		this.puertos = puertos;
		this.llevados = llevados;
	}

	public int getNetapa() {
		return netapa;
	}

	public void setNetapa(int netapa) {
		this.netapa = netapa;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public String getSalida() {
		return salida;
	}

	public void setSalida(String salida) {
		this.salida = salida;
	}

	public String getLlegada() {
		return llegada;
	}

	public void setLlegada(String llegada) {
		this.llegada = llegada;
	}

	public Ciclista getDorsal() {
		return dorsal;
	}

	public void setDorsal(Ciclista dorsal) {
		this.dorsal = dorsal;
	}

	public List<Puerto> getPuertos() {
		return puertos;
	}

	public void setPuertos(List<Puerto> puertos) {
		this.puertos = puertos;
	}

	public List<Llevar> getLlevados() {
		return llevados;
	}

	public void setLlevados(List<Llevar> llevados) {
		this.llevados = llevados;
	}
	
	
}

