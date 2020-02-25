package com.arantzazudealbamoreno.segundaevaluacion.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arantzazudealbamoreno.segundaevaluacion.converter.DozerMapper;
import com.arantzazudealbamoreno.segundaevaluacion.entity.Equipo;
import com.arantzazudealbamoreno.segundaevaluacion.model.EquipoModel;
import com.arantzazudealbamoreno.segundaevaluacion.repository.EquipoRepository;
import com.arantzazudealbamoreno.segundaevaluacion.service.EquipoService;

@Service("equipoService")
public class EquipoServiceImpl implements EquipoService{

	// Repository
	@Autowired
	@Qualifier("equipoRepository")
	private EquipoRepository equipoRepository;
	
	//Dozer
	@Autowired
	@Qualifier("dozerMapper")
	private DozerMapper dozerMapper;
	
	@Override
	public List<EquipoModel> listAllEquipos() {
		List<EquipoModel> equiposModel = new ArrayList<EquipoModel>();
		for(Equipo equipo: equipoRepository.findAll()) {
			equiposModel.add(dozerMapper.equipoToEquipoModel(equipo));
		}
		return equiposModel;
	}

	@Override
	public Equipo addOrEditEquipo(EquipoModel equipoModel) {
		Equipo equipo = dozerMapper.equipoModelToEquipo(equipoModel);
		return equipoRepository.save(equipo);
	}

	@Override
	public void removeEquipo(String nomeq) {
		Equipo equipo = equipoRepository.findByNomeq(nomeq);
		equipoRepository.delete(equipo);
		
	}

	@Override
	public EquipoModel showEquipoToModify(String nomeq) {
		EquipoModel equipoModel = new EquipoModel();
		Equipo equipo = equipoRepository.findByNomeq(nomeq);
		equipoModel = dozerMapper.equipoToEquipoModel(equipo);
		return equipoModel;
	}

}
