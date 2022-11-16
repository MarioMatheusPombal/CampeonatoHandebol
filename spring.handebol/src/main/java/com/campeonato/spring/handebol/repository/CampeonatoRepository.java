package com.campeonato.spring.handebol.repository;

import com.campeonato.spring.handebol.orm.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampeonatoRepository extends CrudRepository<Campeonato, Integer> {
    @Query("SELECT c FROM Campeonato c")
    List<Campeonato> showCampeonatos();

    List<Campeonato> findByNome(String nome);

    @Query("SELECT c FROM Campeonato c ORDER BY c.nome")
    List<Campeonato> ordenarNomeCamp();

    @Query("SELECT c FROM Campeonato c ORDER BY c.partidas")
    List<Campeonato> ordenarCampPartida();

    @Query("SELECT c FROM Campeonato c ORDER BY c.times")
    List<Campeonato> ordenarCampTimes();
}
