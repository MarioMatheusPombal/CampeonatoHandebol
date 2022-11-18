package com.campeonato.spring.handebol.orm;

import jakarta.persistence.*;
import org.springframework.data.repository.query.parser.Part;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "campeonatos")
public class Campeonato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nomecampeonato")
    private String nome;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "campeonato")
    private List<Partida> partidas = new ArrayList<>();
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "campeonato")
    private List<Time> times = new ArrayList<>();
    private String classificacao;

    public Campeonato() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public List<Time> getTimes() {
        return times;
    }

    public List<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<Partida> partidas) {
        this.partidas = partidas;
    }

    public void setTimes(List<Time> times) {
        this.times = times;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public void insereTime(Time time){
        times.add(time);
    }
    public void inserePartida(Partida partida){
        partidas.add(partida);
    }
    public String retornaNomeTimes(){
        String aux = "";
        for (Time t:times) {
            aux +=t.getNome();
        }
        return aux;
    }

    @Override
    public String toString() {
        return "Campeonato{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", partidas=" + partidas +
                ", times=" + times +
                ", classificacao='" + classificacao + '\'' +
                '}';
    }
}
