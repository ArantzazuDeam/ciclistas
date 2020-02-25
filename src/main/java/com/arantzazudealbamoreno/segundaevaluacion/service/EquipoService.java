package com.arantzazudealbamoreno.segundaevaluacion.service;

import java.util.List;

import com.arantzazudealbamoreno.segundaevaluacion.entity.Equipo;
import com.arantzazudealbamoreno.segundaevaluacion.model.EquipoModel;

public interface EquipoService {
	public abstract List<EquipoModel> listAllEquipos();
	public abstract Equipo addOrEditEquipo(EquipoModel equipoModel);
	public abstract void removeEquipo(String nomeq);
	public abstract EquipoModel showEquipoToModify(String nomeq);
}
