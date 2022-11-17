package com.campeonato.spring.handebol.orm;

import jakarta.persistence.*;

import java.util.Comparator;

@Entity
@Table(name = "jogadores")
public class Jogador{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String tipo;
    private String dataNt;
    private String altura;
    private String genero;

    @ManyToOne
    @JoinColumn(name = "time_id")
    private Time time;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDataNt() {
        return dataNt;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setDataNt(String dataNt) {
        this.dataNt = dataNt;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", dataNt='" + dataNt + '\'' +
                ", altura='" + altura + '\'' +
                ", genero='" + genero + '\'' +
                ", time=" + getTime().getNome() +
                '}';
    }
}
