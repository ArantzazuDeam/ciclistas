package com.arantzazudealbamoreno.segundaevaluacion.controller;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.arantzazudealbamoreno.segundaevaluacion.constant.Constants;
import com.arantzazudealbamoreno.segundaevaluacion.model.EquipoModel;
import com.arantzazudealbamoreno.segundaevaluacion.service.EquipoService;

@Controller
@RequestMapping("")
public class EquipoController {
	
	@Autowired
	@Qualifier("equipoService")
	private EquipoService equipoService;
	
	public Log log = LogFactory.getLog(EquipoController.class);
	
	@GetMapping("/equipo")
	public ModelAndView redirectCiclistasView() {
		ModelAndView mav = new ModelAndView(Constants.EQUIPO_VIEW);
		log.info("Entrando en: redirectEquipoView()");
				
		mav.addObject("equipo", new EquipoModel());
		mav.addObject("equipos", equipoService.listAllEquipos());
		return mav;
	}
	
	
	@GetMapping("/equipo/form-equipo")
	public ModelAndView showFormEquipo(
			@RequestParam(name="nomeq", required=true) String nomeq) {
		log.info("Call: showFormEquipo. Nombre equipo: " + nomeq);
		ModelAndView mav = new ModelAndView(Constants.EQUIPO_FORM_VIEW);
		if(nomeq.equals("")) {
			mav.addObject("equipo", new EquipoModel());
		}else {
			mav.addObject("equipo", equipoService.showEquipoToModify(nomeq));
		}
		return mav;
	}
	
	//Crear o editar
	@PostMapping("/equipo/crearEquipo")
	public String crearEquipo(Model model,
			@ModelAttribute("equipo") EquipoModel equipoModel) {
		log.info("Call: crearEquipo() -> nomeq " + equipoModel.getNomeq());
		if(null != equipoService.addOrEditEquipo(equipoModel)) {
			model.addAttribute("resultado", 1);
		}else {
			model.addAttribute("resultado", 0);
		}
		return "redirect:/" + Constants.EQUIPO_VIEW;
	}
	
	//Eliminar un equipo
	@PostMapping("/equipo/eliminarequipo")
	public String removeEquipo(
			@RequestParam(name="nomeq", required=true) String nomeq) {
		log.info("Call: removeEquipo() -> nomeq: "+nomeq);
		equipoService.removeEquipo(nomeq);
		return "redirect:/" + Constants.EQUIPO_VIEW;
	}
}
