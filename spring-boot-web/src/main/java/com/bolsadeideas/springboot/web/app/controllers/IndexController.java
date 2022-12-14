package com.bolsadeideas.springboot.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	@Value("${titulos}")
	private String textoIndex;
	
	@Value("${perfil}")
	private String textoPerfil;
	
	@Value("${listar}")
	private String textoListar;
	
	
	@GetMapping(value = {"/index","","/"})
	public String index(Model model){
		model.addAttribute("titulo", textoIndex);
		return "index";		
	}	
	
	@GetMapping("/perfil")
	public String perfil(Model model){
		Usuario usuario = new Usuario();
		usuario.setNombre("Daniel");
		usuario.setApellido("Medina");
		usuario.setEmail("daniel@gmail.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
		
		model.addAttribute("correo", "Email: ".concat(usuario.getEmail()));

		return "perfil";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", textoListar);
		
		return "listar";

	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios= Arrays.asList(new Usuario("Daniel","Medina","daniel@gmail.com"),
				new Usuario("Felipe","Moreno","felipe@gmail.com"),
				new Usuario("Liliana","Aponte","lili@gmail.com"),
				new Usuario("Tornado","Roe","tornado@gmail.com"),
				new Usuario("Kevin","Garzon","kevin@gmail.com"));
		
		return usuarios;
	}
	
}
