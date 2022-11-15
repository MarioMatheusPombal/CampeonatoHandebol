package com.campeonato.spring.handebol.repository;

import com.campeonato.spring.handebol.orm.Campeonato;
import com.campeonato.spring.handebol.orm.Endereco;
import com.campeonato.spring.handebol.orm.Partida;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampeonatoRepository extends CrudRepository<Campeonato, Integer> {
    @Query("SELECT c FROM Campeonato c")
    List<Campeonato> showCampeonatos();
}
