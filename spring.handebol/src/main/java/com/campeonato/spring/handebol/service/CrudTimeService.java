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


        time.setNome(nome);
        time.setVtr(vtr);
        time.setGols(gol);
        time.setEmpates(emp);
        int pontuacao = (vtr*2)+emp;
        time.setPontos(pontuacao);

        List<Jogador> jogadors = jogadores(scanner);
        time.setJogadores(jogadors);

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


        int pontuacao = (vtr*2)+emp;
        time.setPontos(pontuacao);


        List<Jogador> jogadors = jogadores(scanner);
        time.setJogadores(jogadors);


        Optional<Estadio> estadio = estadioService.buscarPorId(eid);
        time.setEstadio(estadio.get());

        repository.save(time);
        System.out.println("Salvo!!");
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

    private List<Jogador> jogadores(Scanner scanner) {
        Boolean isTrue = true;
        List<Jogador> jogadors = new ArrayList<>();

        while (isTrue) {
            System.out.println("Digite o JogadorId (Para sair digite 0)");
            Integer jogadorId = scanner.nextInt();

            if(jogadorId != 0) {
                Optional<Jogador> jogador = jogadorRepository.findById(jogadorId);
                jogadors.add(jogador.get());
            } else {
                isTrue = false;
            }
        }

        return jogadors;
    }
    public Optional<Time> buscarPorID(int idTime) {
        return repository.findById(idTime);
    }
}
