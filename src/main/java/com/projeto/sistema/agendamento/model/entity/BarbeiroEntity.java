package com.projeto.sistema.agendamento.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_barbeiro")
public class BarbeiroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idBarbeiro;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @OneToMany(mappedBy="barbeiroEntity")
    private List<AgendaEntity> agendaEntity = new ArrayList<AgendaEntity>();
}
