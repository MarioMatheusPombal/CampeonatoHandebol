package com.campeonato.spring.handebol.service;

import com.campeonato.spring.handebol.orm.Jogador;
import com.campeonato.spring.handebol.orm.Time;
import com.campeonato.spring.handebol.repository.JogadorRepository;
import com.campeonato.spring.handebol.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class CrudJogadorService {

    private boolean system = true;
    private final JogadorRepository repository;
    @Autowired
    private TimeRepository timeRepository;

    public CrudJogadorService(JogadorRepository repository){
        this.repository = repository;
    }

    public void inicial(Scanner scanner){
        while (system){
            System.out.println("Qual acao de Jogador deseja?");
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
        Jogador jogador = new Jogador();

        System.out.println("Nome do Jogador: ");
        String nome = scanner.next();
        jogador.setNome(nome);

        System.out.println("Tipo do Jogador: ");
        String tipo = scanner.next();
        jogador.setTipo(tipo);

        System.out.println("Data de nascimento do Jogador: ");
        String data = scanner.next();
        jogador.setDataNt(data);

        System.out.println("Altura do Jogador: ");
        String altura = scanner.next();
        jogador.setAltura(altura);

        System.out.println("Genero do Jogador: ");
        String genero = scanner.next();
        jogador.setGenero(genero);

        List<Time> times = (List<Time>) timeRepository.findAll();
        System.out.println("Escolha um time");
        for (int i = 0; i < times.size(); i++) {
            System.out.println(" (" + i + ") " + times.get(i).getNome());
        }
        System.out.println("Choose do Time: ");
        jogador.setTime(times.get(scanner.nextInt()));


        repository.save(jogador);
        System.out.println("Salvo!!");


    }


    private void atualizar(Scanner scanner){
        Jogador jogador = new Jogador();

        System.out.println("Id do Jogador: ");
        Integer id = scanner.nextInt();
        jogador.setId(id);

        System.out.println("Nome do Jogador: ");
        String nome = scanner.next();
        jogador.setNome(nome);

        System.out.println("Tipo do Jogador: ");
        String tipo = scanner.next();
        jogador.setTipo(tipo);

        System.out.println("Data de nascimento do Jogador: ");
        String data = scanner.next();
        jogador.setDataNt(data);

        System.out.println("Altura do Jogador: ");
        String altura = scanner.next();
        jogador.setAltura(altura);

        System.out.println("Genero do Jogador: ");
        String genero = scanner.next();
        jogador.setGenero(genero);

        repository.save(jogador);
        System.out.println("Atualizado!!");
    }
    private void visualizar(){
        Iterable<Jogador> jogadores = repository.findAll();
        jogadores.forEach(jogador1 -> System.out.println(jogador1));
    }

    private void deletar(Scanner scanner){
        System.out.println("Digite o id para deletar");
        int id = scanner.nextInt();
        repository.deleteById(id);
        System.out.println("Deletado!!");
    }
    public Optional<Jogador> buscarPorId(int idJgd) {
        return repository.findById(idJgd);
    }
}
