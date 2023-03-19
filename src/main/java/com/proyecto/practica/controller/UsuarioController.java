package com.proyecto.practica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.practica.entity.Usuario;
import com.proyecto.practica.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	// injection
	@Autowired
	private UsuarioService serviUsuario;
	
	// list
	@RequestMapping("/lista")
	public String inicio(Model model) {

		List<Usuario> dataUsuario = serviUsuario.listarUsuarios();
		model.addAttribute("listUsuarios", dataUsuario);
		
		return "usuario";
	}
	
	// search
	@GetMapping("/buscarNative")
	public String searchCustomerQueryNative(@RequestParam("nomNative") String nomUsu, Model model) {
		try {
			model.addAttribute("listUsuarios", serviUsuario.buscarXQueryNative(nomUsu));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "usuario";
	}
	
	@GetMapping("/buscarJPQL")
	public String searchCustomerQueryJPQL(@RequestParam("nomJPQL") String nomUsu, Model model) {
		try {
			model.addAttribute("listUsuarios", serviUsuario.buscarXQueryJPQL(nomUsu));	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "usuario";
	}
	
	@GetMapping("/buscarJPA")
	public String searchCustomerSpringDataJPA(@RequestParam("nomJPA") String nomUsu, Model model) {
		try {
			model.addAttribute("listUsuarios", serviUsuario.buscarXJPA(nomUsu));	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "usuario";
	}
	
}
