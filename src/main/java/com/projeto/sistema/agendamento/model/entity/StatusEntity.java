package com.projeto.sistema.agendamento.model.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_status")
public class StatusEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer idStatus;

    @Column(name = "descricao")
    private String descricao;
}
