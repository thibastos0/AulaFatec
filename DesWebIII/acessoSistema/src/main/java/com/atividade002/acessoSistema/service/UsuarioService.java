package com.atividade002.acessoSistema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atividade002.acessoSistema.model.Usuario;
import com.atividade002.acessoSistema.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPorId(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public void excluir(Long id){
        usuarioRepository.deleteById(id);
    }

     // Método específico para autenticação
    public Usuario autenticar(String nome, String mail) {
        List<Usuario> usuarios = this.listarTodos();
        return usuarios.stream()
                .filter(u -> nome.equals(u.getNome()) && mail.equals(u.getEmail()))
                .findFirst()
                .orElse(null);
    }

}
