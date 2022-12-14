package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	/*
	 * Redirecciona la página a el app/index, cambia la URL en el navegador ya que redirige a una 
	 * nueva página y petición HTTP
	 * */
	
	@GetMapping("/")
	public String home() {
		//return "redirect:https://www.google.com"; * Redirige a google
		return "forward:/app/index"; /*Es la mejor opción para un home, por que no cambia la ruta, rutas propias del
		proyecto*/
		//return "redirect:/app/index";
	}
	
}
