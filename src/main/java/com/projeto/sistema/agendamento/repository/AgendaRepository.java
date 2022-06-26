package com.projeto.sistema.agendamento.repository;

import com.projeto.sistema.agendamento.model.entity.AgendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgendaRepository extends JpaRepository<AgendaEntity, Integer>  {

    @Query(value = "SELECT agenda FROM AgendaEntity agenda WHERE agenda.statusEntity.idStatus = 1")
    List<AgendaEntity> findByStatusAvailable();
}
