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
}
