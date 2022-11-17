package com.campeonato.spring.handebol.service;

import com.campeonato.spring.handebol.orm.Estadio;
import com.campeonato.spring.handebol.orm.Jogador;
import com.campeonato.spring.handebol.orm.Time;
import com.campeonato.spring.handebol.repository.EstadioRepository;
import com.campeonato.spring.handebol.repository.JogadorRepository;
import com.campeonato.spring.handebol.repository.TimeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class CrudTimeService {

    private boolean system = true;
    private final TimeRepository repository;
    private final EstadioRepository estadioRepository;
    private final CrudEstadioService estadioService;
    private final JogadorRepository jogadorRepository;
    private final CrudJogadorService jogadorService;


    public CrudTimeService(TimeRepository repository, EstadioRepository estadioRepository, CrudEstadioService estadioService, JogadorRepository jogadorRepository, CrudJogadorService jogadorService){
        this.repository = repository;
        this.estadioRepository = estadioRepository;
        this.estadioService = estadioService;
        this.jogadorRepository = jogadorRepository;
        this.jogadorService = jogadorService;
    }

    public void inicial(Scanner scanner){
        while (system){
            System.out.println("Qual acao de Time deseja?");
            System.out.println("0 - Sair");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Visualizar");
            System.out.println("4 - Deletar");
        int action = scanner.nextInt();

        switch (action){
            case 1:
                salvar(scanner);
                break;
            case 2:
                atualizar(scanner);
                break;
            case 3:
                visualizar();
                break;
            case 4:
                deletar(scanner);
                break;
            default:
                system = false;
                break;
        }
        }
    }

    private void salvar(Scanner scanner){
        Time time = new Time();

        System.out.println("Digite o nome: ");
        String nome = scanner.next();


        System.out.println("Vitorias do time: ");
        int vtr = scanner.nextInt();


        System.out.println("Gols do time: ");
        int gol = scanner.nextInt();


        System.out.println("Empates do time: ");
        int emp = scanner.nextInt();


        System.out.println("Id do Estadio: ");
        int eid = scanner.nextInt();

//        System.out.println("Id do Jogador 1: ");
//        int jg1 = scanner.nextInt();
//
//        System.out.println("Id do Jogador 2: ");
//        int jg2 = scanner.nextInt();
//
//        System.out.println("Id do Jogador 3: ");
//        int jg3 = scanner.nextInt();
//
//        System.out.println("Id do Jogador 4: ");
//        int jg4 = scanner.nextInt();
//
//        System.out.println("Id do Jogador 5: ");
//        int jg5 = scanner.nextInt();


        time.setNome(nome);
        time.setVtr(vtr);
        time.setGols(gol);
        time.setEmpates(emp);
        int pontuacao = (vtr*2)+emp;
        time.setPontos(pontuacao);

//        Optional<Jogador> jogador1 = jogadorRepository.findById(jg1);
//        time.setJogador1(jogador1.get());
//        Optional<Jogador> jogador2 = jogadorRepository.findById(jg2);
//        time.setJogador2(jogador2.get());
//        Optional<Jogador> jogador3 = jogadorRepository.findById(jg3);
//        time.setJogador3(jogador3.get());
//        Optional<Jogador> jogador4 = jogadorRepository.findById(jg4);
//        time.setJogador4(jogador4.get());
//        Optional<Jogador> jogador5 = jogadorRepository.findById(jg5);
//        time.setJogador5(jogador5.get());

        Optional<Estadio> estadio = estadioService.buscarPorId(eid);
        //Optional<Estadio> estadio = estadioRepository.findById(eid);
        time.setEstadio(estadio.get());

        repository.save(time);
        System.out.println("Salvo!!");
    }


    private void atualizar(Scanner scanner){
        Time time = new Time();

        System.out.println("Id do Time: ");
        Integer id = scanner.nextInt();
        time.setId(id);

        System.out.println("Digite o nome: ");
        String nome = scanner.next();
        time.setNome(nome);

        System.out.println("Vitorias do time: ");
        int vtr = scanner.nextInt();
        time.setVtr(vtr);

        System.out.println("Gols do time: ");
        int gol = scanner.nextInt();
        time.setGols(gol);

        System.out.println("Empates do time: ");
        int emp = scanner.nextInt();
        time.setEmpates(emp);

        System.out.println("Id do Estadio: ");
        int eid = scanner.nextInt();

//        System.out.println("Id do Jogador 1: ");
//        int jg1 = scanner.nextInt();
//
//        System.out.println("Id do Jogador 2: ");
//        int jg2 = scanner.nextInt();
//
//        System.out.println("Id do Jogador 3: ");
//        int jg3 = scanner.nextInt();
//
//        System.out.println("Id do Jogador 4: ");
//        int jg4 = scanner.nextInt();
//
//        System.out.println("Id do Jogador 5: ");
//        int jg5 = scanner.nextInt();

        int pontuacao = (vtr*2)+emp;
        time.setPontos(pontuacao);


        /*Optional<Jogador> jogador1 = jogadorRepository.findById(jg1);
        time.setJogador1(jogador1.get());
        Optional<Jogador> jogador2 = jogadorRepository.findById(jg2);
        time.setJogador2(jogador2.get());
        Optional<Jogador> jogador3 = jogadorRepository.findById(jg3);
        time.setJogador3(jogador3.get());
        Optional<Jogador> jogador4 = jogadorRepository.findById(jg4);
        time.setJogador4(jogador4.get());
        Optional<Jogador> jogador5 = jogadorRepository.findById(jg5);
        time.setJogador5(jogador5.get());*/


        Optional<Estadio> estadio = estadioService.buscarPorId(eid);
        time.setEstadio(estadio.get());

        repository.save(time);
        System.out.println("Atualizado!!");
    }
    private void visualizar(){
        List<Time> list = repository.showTimes();
        list.forEach(System.out::println);
    }

    private void deletar(Scanner scanner){
        System.out.println("Digite o id para deletar");
        int id = scanner.nextInt();
        repository.deleteById(id);
        System.out.println("Deletado!!");
    }


    public Optional<Time> buscarPorID(int idTime) {
        return repository.findById(idTime);
    }
}
