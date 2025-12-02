package com.example.mongoapp.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.mongoapp.model.User;
import com.example.mongoapp.repository.UserRepository;

public class UserServiceTest {


    @Mock // Simula o acesso ao banco de dados e cria um mock do UserRepository
    private UserRepository userRepository;

    @InjectMocks // Injeta o mock do UserRepository no UserService
    private UserService userService;

    public UserServiceTest() {
        MockitoAnnotations.openMocks(this); // Inicializa os mocks
    }

    @Test
    @DisplayName("Deve atualizar usuário com sucesso quando dados válidos são fornecidos")
    void deveAtualizarUsuarioComSucesso_case1() {

        User antigo = new User();
        antigo.setId("123");
        antigo.setName("Nome antigo");
        antigo.setMail("antigo@mail.com");
        User atualizado = new User();
        atualizado.setId("123");
        atualizado.setName("Novo Nome");
        atualizado.setMail("novo@mail.com");

        when(userRepository.findById("123")).thenReturn(Optional.of(antigo));
        when(userRepository.save(any(User.class))).thenReturn(atualizado); 

        User resultado = userService.atualizar("123", atualizado);

        assertEquals("Novo Nome", resultado.getName());
        assertEquals("novo@mail.com", resultado.getMail());
        verify(userRepository).save(any(User.class));

    }

    @Test
    @DisplayName("Deve lançar IllegalArgumentException quando o ID for nulo ao atualizar usuário")
    void deveLancarExceptionQuandoIdNulo_case2() {
        User atualizado = new User();
        atualizado.setName("Novo Nome");
        atualizado.setMail("novo@mail.com");

        assertThrows(IllegalArgumentException.class, () -> {
            userService.atualizar(null, atualizado);
        });
    }

    @Test
    @DisplayName("Deve lançar RuntimeException quando o usuário não for encontrado ao atualizar")
    void deveLancarExceptionQuandoUsuarioNaoEncontrado_case3() {
        User atualizado = new User();
        atualizado.setName("Novo Nome");
        atualizado.setMail("novo@mail.com");

        when(userRepository.findById("123")).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            userService.atualizar("123", atualizado);
        });
    }

    @Test
    @DisplayName("Deve lançar IllegalArgumentException quando o nome for nulo ou vazio ao atualizar usuário")
    void deveLancarExceptionQuandoNomeInvalido_case4() {
        User invalido = new User();
        invalido.setId("123");
        invalido.setName("");
        invalido.setMail("atualizado@mail.com");

        when(userRepository.findById("123")).thenReturn(Optional.of(new User()));

        assertThrows(IllegalArgumentException.class, () -> {
            userService.atualizar("123", invalido);
        });
    }

    @Test
    @DisplayName("Deve lançar IllegalArgumentException quando o e-mail for nulo ou vazio ao atualizar usuário")
    void deveLancarExceptionQuandoEmailInvalido_case5() {
        User invalido = new User();
        invalido.setId("123");
        invalido.setName("Nome Atualizado");
        invalido.setMail("");   

        when(userRepository.findById("123")).thenReturn(Optional.of(new User()));

        assertThrows(IllegalArgumentException.class, () -> {
            userService.atualizar("123", invalido);
        });
    }

}
