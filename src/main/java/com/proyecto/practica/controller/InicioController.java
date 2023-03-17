package com.proyecto.practica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.practica.repository.UsuarioRepository;

@Controller
public class InicioController {
	
	// injection 
	@Autowired
	private UsuarioRepository repoUsuario;

	@RequestMapping("/inicio")
	public String inicio(Model model) {
		
		Long usuarios = repoUsuario.count();
		
		model.addAttribute("cantUsuario", usuarios);

		return "index";
	}
}
