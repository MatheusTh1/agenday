package com.projeto.sistema.agendamento.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BarbeiroDTO {

    private Integer id;
    private String nome;
    private String cpf;
}
