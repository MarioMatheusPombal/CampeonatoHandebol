package com.campeonato.spring.handebol.service;

import com.campeonato.spring.handebol.orm.*;
import com.campeonato.spring.handebol.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class CrudPartidaService {

    private boolean system = true;
    @Autowired
    private final PartidaRepository repository;
    private final EstadioRepository estadioRepository;
    private final CrudEstadioService crudEstadioService;
    private final CrudTimeService crudTimeService;
    private final TimeRepository timeRepository;
    private final JogadorRepository jogadorRepository;

    public CrudPartidaService(PartidaRepository repository, EstadioRepository estadioRepository, CrudEstadioService crudEstadioService, CrudTimeService crudTimeService, TimeRepository timeRepository, JogadorRepository jogadorRepository){
        this.repository = repository;
        this.estadioRepository = estadioRepository;
        this.crudEstadioService = crudEstadioService;
        this.crudTimeService = crudTimeService;
        this.timeRepository = timeRepository;
        this.jogadorRepository = jogadorRepository;
    }

    public void inicial(Scanner scanner){
        while (system){
            System.out.println("Qual acao de Partida deseja?");
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
        Partida partida = new Partida();

        System.out.println("Digite o status da Partida: ");
        String stts = scanner.next();
        partida.setStatus(stts);

        System.out.println("Id do Estádio: ");
        int num = scanner.nextInt();


        System.out.println("Id do Primeiro time: ");
        int id1 = scanner.nextInt();
        System.out.println("Id do Segundo time: ");
        int id2 = scanner.nextInt();

        Optional<Estadio> estadio = crudEstadioService.buscarPorId(num);
        partida.setEstadio(estadio.get());
        Optional<Time> time1 = crudTimeService.buscarPorID(id1);
        partida.setTime1(time1.get());
        Optional<Time> time2 = crudTimeService.buscarPorID(id2);
        partida.setTime2(time2.get());

        partida.setPontosdostimes(time1.get().getPontos() + time2.get().getPontos());
        repository.save(partida);
        System.out.println("Salvo!!");
    }



    private void atualizar(Scanner scanner){
        Partida partida = new Partida();

        System.out.println("Id da Partida: ");
        Integer id = scanner.nextInt();
        partida.setId(id);

        System.out.println("Digite o status da Partida: ");
        String stts = scanner.next();
        partida.setStatus(stts);

        System.out.println("Id do Estádio: ");
        int num = scanner.nextInt();

        System.out.println("Id do Primeiro time: ");
        int id1 = scanner.nextInt();
        System.out.println("Id do Segundo time: ");
        int id2 = scanner.nextInt();


        Optional<Estadio> estadio = crudEstadioService.buscarPorId(num);
        partida.setEstadio(estadio.get());
        Optional<Time> time1 = timeRepository.findById(id1);
        partida.setTime1(time1.get());
        Optional<Time> time2 = timeRepository.findById(id2);
        partida.setTime2(time2.get());


        partida.setPontosdostimes(time1.get().getPontos() + time2.get().getPontos());
        repository.save(partida);
        System.out.println("Atualizado!!");
    }
    public void visualizar(){
        List<Partida> list = repository.showPartidas();
        list.forEach(System.out::println);
    }

    private void deletar(Scanner scanner){
        System.out.println("Digite o id para deletar");
        int id = scanner.nextInt();
        repository.deleteById(id);
        System.out.println("Deletado!!");
    }

    private List<Time> times(Scanner scanner) {
        Boolean isTrue = true;
        List<Time> times = new ArrayList<>();

        while (isTrue) {
            System.out.println("Digite o TimeId (Para sair digite 0)");
            Integer timeId = scanner.nextInt();

            if(timeId != 0) {
                Optional<Time> optionalTime = crudTimeService.buscarPorID(timeId);
                times.add(optionalTime.get());
            } else {
                isTrue = false;
            }
        }

        return times;
    }
    public void visualizarTimes(List<Time> time){
        for (Time t: time) {
            System.out.println(t.toString());
        }
    }
    public Optional<Partida> buscarPorID(int idPartida) {
        return repository.findById(idPartida);
    }
}
