package com.campeonato.spring.handebol.repository;

import com.campeonato.spring.handebol.orm.Endereco;
import com.campeonato.spring.handebol.orm.Estadio;
import com.campeonato.spring.handebol.orm.Jogador;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadioRepository extends CrudRepository<Estadio, Integer> {



    @Query("SELECT e FROM Estadio e")
    List<Estadio> showEstadios();

    List<Estadio> findByNome(String nome);
}
