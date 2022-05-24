package com.projeto.sistema.agendamento.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Servico {

    private Integer id;
    private String descricao;
    private BigDecimal valor;
}
