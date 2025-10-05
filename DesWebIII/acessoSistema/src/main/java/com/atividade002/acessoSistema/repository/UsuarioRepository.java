package com.atividade002.acessoSistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade002.acessoSistema.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
