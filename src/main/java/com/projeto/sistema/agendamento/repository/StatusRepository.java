package com.projeto.sistema.agendamento.repository;

import com.projeto.sistema.agendamento.model.entity.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<StatusEntity, Integer> {

}