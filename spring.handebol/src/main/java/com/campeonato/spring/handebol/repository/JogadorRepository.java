package com.campeonato.spring.handebol.repository;

import com.campeonato.spring.handebol.orm.Jogador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogadorRepository extends CrudRepository<Jogador, Integer> {
    List<Jogador> findByNome(String nome);


}
