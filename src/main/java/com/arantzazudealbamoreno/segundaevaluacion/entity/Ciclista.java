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
@Table(name="ciclista")
public class Ciclista {
	
	@Id
	@Column(name="dorsal")
	private int dorsal;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="foto")
	private String foto;
	
	@Column(name="edad")
	private int edad;
	
	// fk nomeq -> Referencia a Equipo(nomeq) 
	@ManyToOne
	@JoinColumn(name="nomeq")
	private Equipo nomeq;
	
	// onetomany: llevar, puertos y etapas
	@OneToMany(mappedBy="dorsal")
	private List<Llevar> llevar;
	
	@OneToMany(mappedBy="dorsal")
	private List<Puerto> puertos;
	
	@OneToMany(mappedBy="dorsal")
	private List<Etapa> etapas;

	public Ciclista() {
		super();
	}

	public Ciclista(int dorsal, String nombre, String foto, int edad, Equipo nomeq, List<Llevar> llevar,
			List<Puerto> puertos, List<Etapa> etapas) {
		super();
		this.dorsal = dorsal;
		this.nombre = nombre;
		this.foto = foto;
		this.edad = edad;
		this.nomeq = nomeq;
		this.llevar = llevar;
		this.puertos = puertos;
		this.etapas = etapas;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Equipo getNomeq() {
		return nomeq;
	}

	public void setNomeq(Equipo nomeq) {
		this.nomeq = nomeq;
	}

	public List<Llevar> getLlevar() {
		return llevar;
	}

	public void setLlevar(List<Llevar> llevar) {
		this.llevar = llevar;
	}

	public List<Puerto> getPuertos() {
		return puertos;
	}

	public void setPuertos(List<Puerto> puertos) {
		this.puertos = puertos;
	}

	public List<Etapa> getEtapas() {
		return etapas;
	}

	public void setEtapas(List<Etapa> etapas) {
		this.etapas = etapas;
	}
	
	
	
}
