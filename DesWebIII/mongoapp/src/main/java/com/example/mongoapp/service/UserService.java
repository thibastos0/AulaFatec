package com.example.mongoapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mongoapp.model.User;
import com.example.mongoapp.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listarTodos(){
        return userRepository.findAll();        
    }

    public Optional<User> buscarPorId(String id){

        if (id == null) {
            throw new IllegalArgumentException("ID vazio.");
        }
        return userRepository.findById(id);
    }

    public User salvar(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Dados do usuário não podem ser nulos");
        }
        return userRepository.save(user);
    }

    public User atualizar(String id, User userAtualizado){
        
        if (id == null) {
            throw new IllegalArgumentException("ID vazio.");
        }
        
        Optional<User> userExistente = userRepository.findById(id);

        if (userExistente.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado com ID: " + id);
        }
        
        if (userAtualizado.getName() == null || userAtualizado.getName().isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }

        if (userAtualizado.getMail() == null || userAtualizado.getMail().isBlank()) {
            throw new IllegalArgumentException("E-mail não pode ser vazio");
        }

        User user = userExistente.get();
        user.setName(userAtualizado.getName());
        user.setMail(userAtualizado.getMail());
            

        return userRepository.save(user);
    }

    public void deletar(String id) {
        if (id == null) {
            throw new IllegalArgumentException("ID vazio.");
        }
        userRepository.deleteById(id);
    }

}
