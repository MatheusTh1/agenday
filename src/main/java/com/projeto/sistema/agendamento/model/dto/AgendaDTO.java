package com.projeto.sistema.agendamento.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgendaDTO {

    private Integer id;
    private String data;
    private ClienteDTO cliente;
    private BarbeiroDTO barbeiro;
    private ServicoDTO servico;
    private StatusDTO status;
}
