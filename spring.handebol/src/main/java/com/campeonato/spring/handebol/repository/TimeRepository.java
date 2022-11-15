package com.campeonato.spring.handebol.repository;

import com.campeonato.spring.handebol.orm.Endereco;
import com.campeonato.spring.handebol.orm.Estadio;
import com.campeonato.spring.handebol.orm.Time;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeRepository extends CrudRepository<Time, Integer> {
    @Query("SELECT t FROM Time t")
    List<Time> showTimes();
}
