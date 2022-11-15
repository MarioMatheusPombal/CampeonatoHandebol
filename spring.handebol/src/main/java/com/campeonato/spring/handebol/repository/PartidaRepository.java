package com.campeonato.spring.handebol.repository;

import com.campeonato.spring.handebol.orm.Endereco;
import com.campeonato.spring.handebol.orm.Partida;
import com.campeonato.spring.handebol.orm.Time;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.parser.Part;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartidaRepository extends CrudRepository<Partida, Integer> {
    @Query("SELECT p FROM Partida p")
    List<Partida> showPartidas();
}
