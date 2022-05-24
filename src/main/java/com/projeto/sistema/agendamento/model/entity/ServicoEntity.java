package com.projeto.sistema.agendamento.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_servico")
public class ServicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer idServico;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "valor")
    private BigDecimal valor;
}
