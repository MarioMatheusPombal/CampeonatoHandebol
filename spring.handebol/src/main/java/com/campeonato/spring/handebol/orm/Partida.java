package com.campeonato.spring.handebol.orm;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "partidas")
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "status")
    private String status;
    @OneToOne
    @JoinColumn(name = "estadio_id")
    private Estadio estadio;

    @OneToOne
    private Time time1;
    @OneToOne
    private Time time2;

    @Column(name = "pontuacao")
    private int pontosdostimes;
    @ManyToOne
    @JoinColumn(name = "campeonato_id")
    private Campeonato campeonato;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public Time getTime1() {
        return time1;
    }

    public void setTime1(Time time1) {
        this.time1 = time1;
    }

    public Time getTime2() {
        return time2;
    }

    public void setTime2(Time time2) {
        this.time2 = time2;
    }

    public int getPontosdostimes() {
        return pontosdostimes;
    }

    public void setPontosdostimes(int pontosdostimes) {
        this.pontosdostimes = pontosdostimes;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    @Override
    public String toString() {
        return "Partida{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", estadio=" + estadio +
                ", time1=" + time1 +
                ", time2=" + time2 +
                ", pontosdostimes=" + pontosdostimes +
                ", campeonato=" + campeonato +
                '}';
    }
}
