package com.projeto.sistema.agendamento.service;

import com.projeto.sistema.agendamento.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;



}
