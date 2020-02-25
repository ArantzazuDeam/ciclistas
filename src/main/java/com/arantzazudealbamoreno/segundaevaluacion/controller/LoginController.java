package com.arantzazudealbamoreno.segundaevaluacion.controller;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arantzazudealbamoreno.segundaevaluacion.constant.Constants;


@Controller
public class LoginController {
	public Log log = LogFactory.getLog(LoginController.class);
	
	@GetMapping("/login")
	public String showLoginForm(Model model, 
			@RequestParam(name="error", required=false) String error,
			@RequestParam(name="logout", required=false) String logout) {
		
		log.info("Entrando en showLoginForm");
		log.info("El valor de error es: " +error);
		log.info("El valor de logout es: " +logout);
		log.info("El modelo es: " + model.toString());
		
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		//model.addAttribute("userCredentials", new UserCredential());
		return Constants.LOGIN_VIEW;
	}
	
	@GetMapping({"/loginsuccess", "/"})
	public String loginCheck() {
		log.info("Call loginCheck()");
		log.info("Redirigiendo a inicio");
		return "redirect:/"+Constants.INICIO_VIEW;
	}
}
