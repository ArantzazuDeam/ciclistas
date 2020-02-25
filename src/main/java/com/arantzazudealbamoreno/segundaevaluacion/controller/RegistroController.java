package com.arantzazudealbamoreno.segundaevaluacion.controller;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.arantzazudealbamoreno.segundaevaluacion.constant.Constants;
import com.arantzazudealbamoreno.segundaevaluacion.entity.User;
import com.arantzazudealbamoreno.segundaevaluacion.entity.UserRole;
import com.arantzazudealbamoreno.segundaevaluacion.model.RegistroUsuario;
import com.arantzazudealbamoreno.segundaevaluacion.model.UserModel;
import com.arantzazudealbamoreno.segundaevaluacion.model.UserRoleModel;
import com.arantzazudealbamoreno.segundaevaluacion.service.UserRoleService;
import com.arantzazudealbamoreno.segundaevaluacion.service.UserService;

@Controller
@RequestMapping("")
public class RegistroController {
	public Log log = LogFactory.getLog(LoginController.class);
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("userRoleService")
	private UserRoleService userRoleService;
	
	@GetMapping("/registro")
	public ModelAndView redirectToRegistroView(Model model, 
			@RequestParam(name="error1", required=false) String error1,
			@RequestParam(name="error2", required=false) String error2) {
		
		log.info("Call: redirectToRegistroView()");			
		ModelAndView mav = new ModelAndView(Constants.REGISTRO_VIEW);					
		mav.addObject("usuario", new RegistroUsuario());
		model.addAttribute("error1", error1);
		model.addAttribute("error2", error2);
		return mav;
	}
	
	@PostMapping("/registro/nuevoUsuario")
	public String registrarNuevoUsuario(@ModelAttribute("usuario") RegistroUsuario usuario) {
		log.info("Call: registrarNuevoUsuario() ");
		log.info("\nUsername: " + usuario.getUsername() 
				+"\nRol: "+ usuario.getRole() 
				+"\nPassword1: " + usuario.getPassword1()
				+"\nPassword2: " + usuario.getPassword2());
		
		// Si las contraseñas son válidas:
		if( usuario.getPassword1().equals(usuario.getPassword2()) ) {
			BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
			String pass = pe.encode(usuario.getPassword1());
			UserModel userModel = new UserModel(usuario.getUsername(), pass, true);
			User user = userService.guardarUser(userModel);
			if(user!=null) {
				UserRoleModel userRoleModel = new UserRoleModel(0, user, usuario.getRole());
				UserRole userRole = userRoleService.guardarUserRole(userRoleModel);
				
				log.info("Valores de UserRole. \nId: " + userRole.getUserRoleId() + " \nUsername: " +userRole.getUser().getUsername()+ "\n Rol: " +userRole.getRole());
				
				return "redirect:/"+Constants.LOGIN_VIEW;				
			
			}else {
				return "redirect:/" +Constants.REGISTRO_VIEW;
			}

		}else {
			return "redirect:/" +Constants.REGISTRO_VIEW;
		}
		
		//UserRole userRole = new UserRole
		
	}
}
