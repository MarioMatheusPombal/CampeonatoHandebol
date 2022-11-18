package com.campeonato.spring.handebol.service;

import com.campeonato.spring.handebol.orm.*;
import com.campeonato.spring.handebol.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class RelatoriosService {

    private Boolean system = true;
    private final JogadorRepository jogadorRepository;
    private final EstadioRepository estadioRepository;
    private final TimeRepository timeRepository;
    private final CampeonatoRepository campeonatoRepository;
    private final PartidaRepository partidaRepository;
    public RelatoriosService(JogadorRepository jogadorRepository, EstadioRepository estadioRepository, TimeRepository timeRepository, CampeonatoRepository campeonatoRepository, PartidaRepository partidaRepository){
        this.jogadorRepository = jogadorRepository;
        this.estadioRepository = estadioRepository;
        this.timeRepository = timeRepository;
        this.campeonatoRepository = campeonatoRepository;
        this.partidaRepository = partidaRepository;
    }


    public void inicial(Scanner scanner) {
        String nome;
        while(system) {
            System.out.println("Qual relatorio deseja executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Busca Jogador nome");
            System.out.println("2 - Ordenar Jogador nome");
            System.out.println("3 - Ordenar Jogador time");
            System.out.println("4 - Busca Estadio nome");
            System.out.println("5 - Busca Time nome");
            System.out.println("6 - Ordenar Time nome");
            System.out.println("7 - Ordenar Time Classificacao");
            System.out.println("8 - Busca Campeonato nome");
            System.out.println("9 - Ordenar Campeonato nome");
            System.out.println("10 - Ordenar Campeonato partidas");
            System.out.println("11 - Ordenar Campeonato times");
            System.out.println("12 - Ordenar Partidas Pontuacao Times");
            System.out.println("13 - Buscar Partida pela Data");


            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    buscaJogadorNome(scanner);
                    break;
                case 2:
                    List<Jogador> listJNome = jogadorRepository.ordenarNomeJogador();
                    listJNome.forEach(System.out::println);
                    break;
                case 3:
                    List<Jogador> listJTime = jogadorRepository.ordenarTimeJogador();
                    listJTime.forEach(System.out::println);
                    break;
                case 4:
                    buscaEstadioNome(scanner);
                    break;
                case 5:
                    buscaTimeNome(scanner);
                    break;
                case 6:
                    List<Time> listTNome = timeRepository.ordenarNomeTimes();
                    listTNome.forEach(System.out::println);
                    break;
                case 7:
                    List<Time> listTClass = timeRepository.ordenarClassificacaoTimes();
                    listTClass.forEach(System.out::println);
                    break;
                case 8:
                    buscaCampeonatoNome(scanner);
                    break;
                case 9:
                    List<Campeonato> listCNome = campeonatoRepository.ordenarNomeCamp();
                    listCNome.forEach(System.out::println);
                    break;
                case 10:
                    List<Campeonato> listCPartida = campeonatoRepository.ordenarCampPartida();
                    listCPartida.forEach(System.out::println);
                    break;
                case 11:
                    List<Campeonato> listCTime = campeonatoRepository.ordenarCampTimes();
                    listCTime.forEach(System.out::println);
                    break;
                case 12:
                    List<Partida> listPtsTimes = partidaRepository.organziarPartidasClassificacaoTimes();
                    listPtsTimes.forEach(System.out::println);
                    break;
                case 13:
                    buscaPartidaData(scanner);
                    break;
                case 14:
                    printCamp();
                    break;
                default:
                    system = false;
                    break;
            }

        }
    }

    private void buscaJogadorNome(Scanner scanner){
        System.out.println("Qual nome deseja pesquisar:");
        String nome = scanner.next();
        List<Jogador> list = jogadorRepository.findByNome(nome);
        list.forEach(System.out::println);
    }
    private void buscaEstadioNome(Scanner scanner){
        System.out.println("Qual nome deseja pesquisar:");
        String nome = scanner.next();
        List<Estadio> list = estadioRepository.findByNome(nome);
        list.forEach(System.out::println);
    }
    private void buscaTimeNome(Scanner scanner){
        System.out.println("Qual nome deseja pesquisar:");
        String nome = scanner.next();
        List<Time> list = timeRepository.findByNome(nome);
        list.forEach(System.out::println);
    }
    private void buscaCampeonatoNome(Scanner scanner){
        System.out.println("Qual nome deseja pesquisar:");
        String nome = scanner.next();
        List<Campeonato> list = campeonatoRepository.findByNome(nome);
        list.forEach(System.out::println);
    }
    private void buscaPartidaData(Scanner scanner){
        System.out.println("Qual data deseja pesquisar:");
        String data = scanner.next();
        List<Partida> list = partidaRepository.findByData(data);
        list.forEach(System.out::println);
    }
    private void printCamp(){
        Iterable<Campeonato> list = campeonatoRepository.findAll();
        for (Campeonato c:list) {
            System.out.println(c.toString());
            for (Time t: c.getTimes()) {
                System.out.println("1");
                System.out.println(t.getNome());
            }
        }
    }

}
