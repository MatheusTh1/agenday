package com.projeto.sistema.agendamento.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_agendamento")
public class AgendamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idAgenda")
    private AgendaEntity agendaEntity;

    @OneToOne
    @JoinColumn(name = "idServico")
    private ServicoEntity servicoEntity;
}
