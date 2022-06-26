package com.projeto.sistema.agendamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@EntityScan
@EnableCaching
@SpringBootApplication
@EnableSpringDataWebSupport
public class SistemaDeAgendamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaDeAgendamentoApplication.class, args);
	}

}
