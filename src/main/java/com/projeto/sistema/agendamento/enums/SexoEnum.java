package com.projeto.sistema.agendamento.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum SexoEnum {

    MASCULINO("M", "MASCULINO"),
    FEMININO("F", "FEMININO");

    private String value;
    private String descricao;

    public String getValue() {
        return value;
    }

    public String getDescricao() {
        return descricao;
    }
}
