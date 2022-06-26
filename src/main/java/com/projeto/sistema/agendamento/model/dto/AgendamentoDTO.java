package com.projeto.sistema.agendamento.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoDTO {

    private Integer idAgenda;
    private Integer idBarbeiro;
    private Integer idCliente;
    private Integer idServico;
}
