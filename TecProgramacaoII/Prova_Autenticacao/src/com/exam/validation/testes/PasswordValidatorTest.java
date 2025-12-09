package com.exam.validation.testes;

import org.junit.jupiter.api.Test;

import com.exam.validation.PasswordValidator;

import static org.junit.jupiter.api.Assertions.*;


public class PasswordValidatorTest {

    private final PasswordValidator passwordValidator = new PasswordValidator();

    @Test
    public void deveRetornarFalsoParaSenhaNull() {

        //Arrange

        //Act
        boolean passwordValidada = passwordValidator.isValid(null);

        //Assert
        assertFalse(passwordValidada, "Password = " + passwordValidada);

    }

        @Test
        public void deveRetornarFalsoParaSenhaMenorOito() {

        //Arrange

        //Act
        boolean passwordValidada = passwordValidator.isValid("Pr0va@");

        //Assert
        assertFalse(passwordValidada, "Password = " + passwordValidada);

    }

        @Test
        public void deveRetornarFalsoParaSenhaEspaco() {

        //Arrange

        //Act
        boolean passwordValidada = passwordValidator.isValid("Pr0va Tecnica@");

        //Assert
        assertFalse(passwordValidada, "Password = " + passwordValidada);

    }


    @Test
    public void deveRetornarFalsoParaSenhaSemMaiuscula() {

        //Arrange

        //Act
        boolean passwordValidada = passwordValidator.isValid("pr0vatecnica@");

        //Assert
        assertFalse(passwordValidada, "Password = " + passwordValidada);

    }


    @Test
    public void deveRetornarFalsoParaSenhaSemMinuscula() {

        //Arrange

        //Act
        boolean passwordValidada = passwordValidator.isValid("PR0VATECNICA@");

        //Assert
        assertFalse(passwordValidada, "Password = " + passwordValidada);

    }


    @Test
    public void deveRetornarFalsoParaSenhaSemNumero() {

        //Arrange

        //Act
        boolean passwordValidada = passwordValidator.isValid("ProvaTecnica@");

        //Assert
        assertFalse(passwordValidada, "Password = " + passwordValidada);

    }

    @Test
    public void deveRetornarFalsoParaSenhaSemSpecials() {

        //Arrange

        //Act
        boolean passwordValidada = passwordValidator.isValid("Pr0vaTecnica");

        //Assert
        assertFalse(passwordValidada, "Password = " + passwordValidada);

    }


    @Test
    public void deveRetornarTrueParaSenhaValida() {

        //Arrange

        //Act
        boolean passwordValidada = passwordValidator.isValid("Pr0vaTecnica@");

        //Assert
        assertTrue(passwordValidada, "Password = " + passwordValidada);

    }

}
