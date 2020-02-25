package com.arantzazudealbamoreno.segundaevaluacion.controller;


import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.arantzazudealbamoreno.segundaevaluacion.constant.Constants;


@Controller
public class InicioController {

	public Log log = LogFactory.getLog(InicioController.class);
	
	@GetMapping("/inicio")
	public ModelAndView redirectInicioView() {
		ModelAndView mav = new ModelAndView(Constants.INICIO_VIEW);
		log.info("Entrando en: redirectInicioView()");
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("username", user.getUsername());
		return mav;
	}
}
