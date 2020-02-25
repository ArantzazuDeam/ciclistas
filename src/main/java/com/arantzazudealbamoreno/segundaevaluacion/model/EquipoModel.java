package com.arantzazudealbamoreno.segundaevaluacion.model;

import java.util.List;

import com.arantzazudealbamoreno.segundaevaluacion.entity.Ciclista;

public class EquipoModel {
	
	private String nomeq;
	private String director;
	private String logo;
	private List<Ciclista> ciclistas;
	
	public EquipoModel() {
		super();
	}

	public EquipoModel(String nomeq, String director, String logo) {
		super();
		this.nomeq = nomeq;
		this.director = director;
		this.logo = logo;
	}

	
	public EquipoModel(String nomeq, String director, String logo, List<Ciclista> ciclistas) {
		super();
		this.nomeq = nomeq;
		this.director = director;
		this.logo = logo;
		this.ciclistas = ciclistas;
	}



	public String getNomeq() {
		return nomeq;
	}

	public void setNomeq(String nomeq) {
		this.nomeq = nomeq;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public List<Ciclista> getCiclistas() {
		return ciclistas;
	}

	public void setCiclistas(List<Ciclista> ciclistas) {
		this.ciclistas = ciclistas;
	}
	
	
}
