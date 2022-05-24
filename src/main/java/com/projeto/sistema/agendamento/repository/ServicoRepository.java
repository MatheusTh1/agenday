package com.projeto.sistema.agendamento.repository;

import com.projeto.sistema.agendamento.model.entity.ServicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<ServicoEntity, Integer> {

}