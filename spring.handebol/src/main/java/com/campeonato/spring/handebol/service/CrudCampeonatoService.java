package com.campeonato.spring.handebol.service;

import com.campeonato.spring.handebol.orm.Campeonato;
import com.campeonato.spring.handebol.orm.Estadio;
import com.campeonato.spring.handebol.orm.Partida;
import com.campeonato.spring.handebol.orm.Time;
import com.campeonato.spring.handebol.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class CrudCampeonatoService {

    private boolean system = true;
    @Autowired
    private final CampeonatoRepository repository;
    @Autowired
    private final PartidaRepository partidaRepository;
    @Autowired
    private final EstadioRepository estadioRepository;
    @Autowired
    private final CrudEstadioService crudEstadioService;
    @Autowired
    private final CrudTimeService crudTimeService;
    @Autowired
    private final TimeRepository timeRepository;
    @Autowired
    private final JogadorRepository jogadorRepository;
    private final CrudPartidaService crudPartidaService;

    public CrudCampeonatoService(CampeonatoRepository repository, PartidaRepository partidaRepository, EstadioRepository estadioRepository, CrudEstadioService crudEstadioService, CrudTimeService crudTimeService, TimeRepository timeRepository, JogadorRepository jogadorRepository, CrudPartidaService crudPartidaService){
        this.repository = repository;
        this.partidaRepository = partidaRepository;
        this.estadioRepository = estadioRepository;
        this.crudEstadioService = crudEstadioService;
        this.crudTimeService = crudTimeService;
        this.timeRepository = timeRepository;
        this.jogadorRepository = jogadorRepository;
        this.crudPartidaService = crudPartidaService;
    }

    public void inicial(Scanner scanner){
        while (system){
            System.out.println("Qual acao de Campeonato deseja?");
            System.out.println("0 - Sair");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Visualizar");
            System.out.println("4 - Deletar");
            System.out.println("5 - Buscar nome");
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
            case 5:
                buscaCampeonatoNome(scanner);
                break;
            default:
                system = false;
                break;
        }
        }
    }

    private void salvar(Scanner scanner){
        Campeonato campeonato = new Campeonato();

        System.out.println("Digite o nome do Campeonato: ");
        String nome = scanner.next();
        campeonato.setNome(nome);

        System.out.println("Id do Estádio: ");
        int num = scanner.nextInt();

        List<Time> times = times(scanner);
        campeonato.setTimes(times);

        List<Partida> partidas = partidas(scanner);
        campeonato.setPartidas(partidas);

        repository.save(campeonato);
        System.out.println("Salvo!!");
    }


    private void atualizar(Scanner scanner){
        Campeonato campeonato = new Campeonato();

        System.out.println("Id do Campeonato: ");
        Integer id = scanner.nextInt();
        campeonato.setId(id);

        System.out.println("Digite o nome do Campeonato: ");
        String nome = scanner.next();
        campeonato.setNome(nome);

        System.out.println("Id do Estádio: ");
        int num = scanner.nextInt();

        List<Time> times = times(scanner);
        campeonato.setTimes(times);

        List<Partida> partidas = partidas(scanner);
        campeonato.setPartidas(partidas);

        repository.save(campeonato);
        System.out.println("Atualizado!!");
    }
    private void visualizar(){
        List<Campeonato> list = repository.showCampeonatos();
        list.forEach(System.out::println);
    }

    private void deletar(Scanner scanner){
        System.out.println("Digite o id para deletar");
        int id = scanner.nextInt();
        repository.deleteById(id);
        System.out.println("Deletado!!");
    }
    private void buscaCampeonatoNome(Scanner scanner){
        System.out.println("Qual nome deseja pesquisar:");
        String nome = scanner.next();
        List<Campeonato> list = repository.findByNome(nome);
        list.forEach(System.out::println);
    }

    private List<Time> times(Scanner scanner) {
        Boolean isTrue = true;
        List<Time> times = new ArrayList<>();

        while (isTrue) {
            System.out.println("Digite o TimeId (Para sair digite 0)");
            Integer timeId = scanner.nextInt();

            if(timeId != 0) {
                Optional<Time> optionalTime = timeRepository.findById(timeId);
                times.add(optionalTime.get());
            } else {
                isTrue = false;
            }
        }

        return times;
    }
    private List<Partida> partidas(Scanner scanner) {
        Boolean isTrue = true;
        List<Partida> partidas = new ArrayList<>();

        while (isTrue) {
            System.out.println("Digite a partidaId (Para sair digite 0)");
            Integer partidaId = scanner.nextInt();

            if(partidaId != 0) {
                Optional<Partida> optionalTime = partidaRepository.findById(partidaId);
                partidas.add(optionalTime.get());
            } else {
                isTrue = false;
            }
        }

        return partidas;
    }
    public Optional<Campeonato> buscarPorID(int idCamp) {
        return repository.findById(idCamp);
    }

}
