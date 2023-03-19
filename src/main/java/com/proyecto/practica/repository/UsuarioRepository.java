package com.proyecto.practica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyecto.practica.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	// Query Native
	@Query(value = "select * from tb_usuario u where upper(u.nom_usu) like upper(concat('%', ?1,'%'))", nativeQuery = true)
	List<Usuario> searchByNomUsuQueryNative(String nomUsu);

	// Query JPQL
	@Query("from Usuario c where upper(c.nomUsu) like upper(concat('%', :nomUsu,'%'))")
	List<Usuario> searchByNomUsuQueryJPQL(@Param("nomUsu") String nomUsu);

	// JPA
	List<Usuario> findByNomUsuContainingIgnoreCase(String nomUsu);
}
