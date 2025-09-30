package com.examplo.cadastro_usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examplo.cadastro_usuarios.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

//    @Query("SELECT COALESCE(MAX(u.id), 0) FROM Usuario u")
//    Long findMaxId();

}
