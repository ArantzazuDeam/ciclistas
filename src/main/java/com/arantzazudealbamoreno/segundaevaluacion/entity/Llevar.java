package com.arantzazudealbamoreno.segundaevaluacion.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="llevar")
public class Llevar {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="llevar_id")
	private int llevar_id;
	
	@ManyToOne	
	@JoinColumn(name="dorsal")
	private Ciclista dorsal; // fk a Ciclista(dorsal)
	
	@ManyToOne	
	@JoinColumn(name="netapa")
	private Etapa netapa; // fk a Etapa(netapa)
	
	@ManyToOne	
	@JoinColumn(name="codigo")
	private Maillot codigo; // fk a Maillot(codigo)

	public Llevar() {
		super();
	}

	public Llevar(int llevar_id, Ciclista dorsal, Etapa netapa, Maillot codigo) {
		super();
		this.llevar_id = llevar_id;
		this.dorsal = dorsal;
		this.netapa = netapa;
		this.codigo = codigo;
	}

	public int getLlevar_id() {
		return llevar_id;
	}

	public void setLlevar_id(int llevar_id) {
		this.llevar_id = llevar_id;
	}

	public Ciclista getDorsal() {
		return dorsal;
	}

	public void setDorsal(Ciclista dorsal) {
		this.dorsal = dorsal;
	}

	public Etapa getNetapa() {
		return netapa;
	}

	public void setNetapa(Etapa netapa) {
		this.netapa = netapa;
	}

	public Maillot getCodigo() {
		return codigo;
	}

	public void setCodigo(Maillot codigo) {
		this.codigo = codigo;
	}
	
	
	
	
}
