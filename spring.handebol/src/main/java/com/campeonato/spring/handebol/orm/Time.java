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

    @OneToOne
    private Jogador jogador1;
    @OneToOne
    private Jogador jogador2;
    @OneToOne
    private Jogador jogador3;
    @OneToOne
    private Jogador jogador4;
    @OneToOne
    private Jogador jogador5;
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

    public Jogador getJogador1() {
        return jogador1;
    }

    public void setJogador1(Jogador jogador1) {
        this.jogador1 = jogador1;
    }

    public Jogador getJogador2() {
        return jogador2;
    }

    public void setJogador2(Jogador jogador2) {
        this.jogador2 = jogador2;
    }

    public Jogador getJogador3() {
        return jogador3;
    }

    public void setJogador3(Jogador jogador3) {
        this.jogador3 = jogador3;
    }

    public Jogador getJogador4() {
        return jogador4;
    }

    public void setJogador4(Jogador jogador4) {
        this.jogador4 = jogador4;
    }

    public Jogador getJogador5() {
        return jogador5;
    }

    public void setJogador5(Jogador jogador5) {
        this.jogador5 = jogador5;
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
                ", jogador1=" + jogador1 +
                ", jogador2=" + jogador2 +
                ", jogador3=" + jogador3 +
                ", jogador4=" + jogador4 +
                ", jogador5=" + jogador5 +
                ", vtr=" + vtr +
                ", gols=" + gols +
                ", empates=" + empates +
                ", pontos=" + pontos +
                ", partida=" + partida +
                ", campeonato=" + campeonato +
                '}';
    }
}
