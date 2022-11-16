package com.campeonato.spring.handebol.orm;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "times")
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @OneToOne
    @JoinColumn(name = "estadio_id")
    private Estadio estadio;

    @Column(name = "jogadores")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "time")
    List<Jogador> jogadores = new ArrayList();
    @Column(name = "vitorias")
    private int vtr;
    @Column(name = "gols")
    private int gols;
    @Column(name = "empates")
    private int empates;

    @Column(name = "pontuacao")
    private int pontos;

    @OneToOne
    private Partida partida;
    @ManyToOne
    @JoinColumn(name = "campeonato_id")
    private Campeonato campeonato;

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
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

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public int getVtr() {
        return vtr;
    }

    public void setVtr(int vtr) {
        this.vtr = vtr;
    }

    public int getGols() {
        return gols;
    }

    public void setGols(int gols) {
        this.gols = gols;
    }

    public int getEmpates() {
        return empates;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    @Override
    public String toString() {
        return "Time{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", estadio=" + estadio +
                ", jogadores=" + jogadores +
                ", vtr=" + vtr +
                ", gols=" + gols +
                ", empates=" + empates +
                ", pontos=" + pontos +
                ", partida=" + partida +
                ", campeonato=" + campeonato +
                '}';
    }
}
