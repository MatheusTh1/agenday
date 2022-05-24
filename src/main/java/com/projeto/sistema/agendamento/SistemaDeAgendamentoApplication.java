package com.projeto.sistema.agendamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EntityScan
@SpringBootApplication
public class SistemaDeAgendamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaDeAgendamentoApplication.class, args);
	}

}
