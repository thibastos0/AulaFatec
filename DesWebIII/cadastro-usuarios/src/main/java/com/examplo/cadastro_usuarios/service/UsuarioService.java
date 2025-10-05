package com.examplo.cadastro_usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examplo.cadastro_usuarios.model.Usuario;
import com.examplo.cadastro_usuarios.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos(){
        return usuarioRepository.findAll();
    }

    public Usuario salvar(Usuario usuario) {

        // Corrigir a sequência do autoincremento, porém deixa muito lento o salvamento
        // quando a tabela tem muitos registros
        // Verificar o maior ID atual na tabela
        // e ajustar a sequência para o próximo valor
        // para evitar conflitos de chave primária
        // Isso é necessário apenas se você estiver inserindo registros
        // com IDs definidos manualmente, o que não é o caso aqui.
        // Se você sempre deixar o banco gerar os IDs, não precisa disso.
        
        // Long maxId = usuarioRepository.findMaxId();
        // if (maxId != null) {
        //     // Ajustar a sequência para o próximo valor após o maior ID atual
        //     String sql = "ALTER SEQUENCE usuario_sequence RESTART WITH " + (maxId + 1);
        //     usuarioRepository.getEntityManager().createNativeQuery(sql).executeUpdate();
        // }

        return usuarioRepository.save(usuario);        
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public void excluir(Long id) {
        usuarioRepository.deleteById(id);
    }

}
