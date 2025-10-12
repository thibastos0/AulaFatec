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
        return userRepository.findById(id);
    }

    public User salvar(User user) {
        return userRepository.save(user);
    }

    public User atualizar(String id, User userAtualizado){
        Optional<User> userExistente = userRepository.findById(id);
        if (userExistente.isPresent()) {
            User user = userExistente.get();
            user.setName(userAtualizado.getName());
            user.setMail(userAtualizado.getMail());
            return userRepository.save(user);
        } else {
            throw new RuntimeException("Usuário não encontrado com ID: " + id);
        }
    }

    public void deletar(String id) {
        userRepository.deleteById(id);
    }

}
