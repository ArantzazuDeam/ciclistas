package com.arantzazudealbamoreno.segundaevaluacion.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arantzazudealbamoreno.segundaevaluacion.entity.Equipo;

public interface EquipoRepository extends JpaRepository<Equipo, Serializable>{

	public abstract Equipo findByNomeq(String nomeq);
}
