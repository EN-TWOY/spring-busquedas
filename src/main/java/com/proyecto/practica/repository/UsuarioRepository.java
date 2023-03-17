package com.proyecto.practica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyecto.practica.entity.UsuarioDTO;

public interface UsuarioRepository extends JpaRepository<UsuarioDTO, Integer>{
	
	// Query Native
	@Query(value = "select * from tb_usuario u where upper(u.nom_usu) like upper(concat('%', ?1,'%'))", nativeQuery = true)
	List<UsuarioDTO> searchByNomUsuQueryNative(String nomUsu);

	// Query JPQL
	@Query("from UsuarioDTO c where upper(c.nomUsu) like upper(concat('%', :nomUsu,'%'))")
	List<UsuarioDTO> searchByNomUsuQueryJPQL(@Param("nomUsu") String nomUsu);

	// JPA
	List<UsuarioDTO> findByNomUsuContainingIgnoreCase(String nomUsu);
}
