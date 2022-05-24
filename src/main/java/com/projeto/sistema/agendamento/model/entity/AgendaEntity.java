package com.projeto.sistema.agendamento.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_agenda")
public class AgendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idAgenda;

    @Column(name = "data_disponivel")
    private Date dataDisponivel;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private ClienteEntity clienteEntity;

    @OneToOne
    @JoinColumn(name = "idStatus")
    private StatusEntity statusEntity;

    @ManyToOne
    @JoinColumn(name = "idBarbeiro")
    private BarbeiroEntity barbeiroEntity;
}
