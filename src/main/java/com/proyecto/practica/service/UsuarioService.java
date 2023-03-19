package com.proyecto.practica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.practica.entity.Usuario;
import com.proyecto.practica.repository.UsuarioRepository;

@Service
public class UsuarioService {

	// injection
	@Autowired
	private UsuarioRepository repoUsuario;

	// list
	public List<Usuario> listarUsuarios() {
		return repoUsuario.findAll();
	}
	
	// search
	public List<Usuario> buscarXQueryNative(String nomUsu){
		return repoUsuario.searchByNomUsuQueryNative(nomUsu);
	}
	
	public List<Usuario> buscarXQueryJPQL(String nomUsu){
		return repoUsuario.searchByNomUsuQueryJPQL(nomUsu);
	}
	
	public List<Usuario> buscarXJPA(String nomUsu){
		return repoUsuario.findByNomUsuContainingIgnoreCase(nomUsu);
	}

}
