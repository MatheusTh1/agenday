package com.projeto.sistema.agendamento.model.entity;

import com.projeto.sistema.agendamento.enums.SexoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_cliente")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer idCliente;

    @Column(name = "nome")
    private String nome;

    @Column(name = "telefone")
    private String telefone;

    @Enumerated(EnumType.STRING)
    private SexoEnum sexo;
}
