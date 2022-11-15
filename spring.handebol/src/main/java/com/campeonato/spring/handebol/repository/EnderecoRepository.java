package com.campeonato.spring.handebol.repository;

import com.campeonato.spring.handebol.orm.Endereco;
import com.campeonato.spring.handebol.orm.Jogador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Integer> {

}
