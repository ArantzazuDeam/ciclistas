package com.arantzazudealbamoreno.segundaevaluacion.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="maillot")
public class Maillot {

	@Id
	@Column(name="codigo")
	private String codigo;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="color")
	private String color;
	
	@Column(name="premio")
	private int premio;
	
	@OneToMany(mappedBy="codigo")
	private List<Llevar> llevados;

	public Maillot() {
		super();
	}

	public Maillot(String codigo, String tipo, String color, int premio, List<Llevar> llevados) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.color = color;
		this.premio = premio;
		this.llevados = llevados;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPremio() {
		return premio;
	}

	public void setPremio(int premio) {
		this.premio = premio;
	}

	public List<Llevar> getLlevados() {
		return llevados;
	}

	public void setLlevados(List<Llevar> llevados) {
		this.llevados = llevados;
	}
	
	
}
