package com.example.demo_testes_pratica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo_testes_pratica.service.CalculadoraService;

@SpringBootApplication
public class DemoTestesPraticaApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemoTestesPraticaApplication.class, args);
		CalculadoraService calc = new CalculadoraService();
		calc.dividir(10, 0);
	}

}
