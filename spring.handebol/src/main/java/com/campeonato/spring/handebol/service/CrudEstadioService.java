package com.campeonato.spring.handebol.service;

import com.campeonato.spring.handebol.orm.Endereco;
import com.campeonato.spring.handebol.orm.Estadio;
import com.campeonato.spring.handebol.orm.Jogador;
import com.campeonato.spring.handebol.repository.EnderecoRepository;
import com.campeonato.spring.handebol.repository.EstadioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class CrudEstadioService {

    private boolean system = true;
    @Autowired
    private final EstadioRepository repository;
    @Autowired
    private final EnderecoRepository enderecoRepository;

    public CrudEstadioService(EstadioRepository repository, EnderecoRepository enderecoRepository){
        this.repository = repository;
        this.enderecoRepository = enderecoRepository;
    }

    public void inicial(Scanner scanner){
        while (system){
            System.out.println("Qual acao de Estadio deseja?");
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
                buscaEstadioNome(scanner);
                break;
            default:
                system = false;
                break;
        }
        }
    }


    private void salvar(Scanner scanner){
        Estadio estadio = new Estadio();

        System.out.println("Digite o nome: ");
        String nome = scanner.next();
        estadio.setNome(nome);

        System.out.println("Digite o id do endereco que deseja buscar");
        Integer id = scanner.nextInt();



        Optional<Endereco> enderecos = enderecoRepository.findById(id);
        estadio.setEndereco(enderecos.get());
        repository.save(estadio);

        System.out.println("Salvo!!");
    }


    private void atualizar(Scanner scanner){
        Estadio estadio = new Estadio();

        System.out.println("Id do Endereco: ");
        Integer id = scanner.nextInt();
        estadio.setId(id);


        System.out.println("Digite o nome: ");
        String nome = scanner.next();
        estadio.setNome(nome);

        System.out.println("Digite o id do endereco");
        Integer eid = scanner.nextInt();

        Optional<Endereco> enderecos = enderecoRepository.findById(eid);
        estadio.setEndereco(enderecos.get());
        repository.save(estadio);

        System.out.println("Atualizado!!");
    }
    private void visualizar(){
        List<Estadio> list = repository.showEstadios();
        list.forEach(System.out::println);
    }

    private void deletar(Scanner scanner){
        System.out.println("Digite o id para deletar");
        int id = scanner.nextInt();
        repository.deleteById(id);
        System.out.println("Deletado!!");
    }

    private void buscaEstadioNome(Scanner scanner){
        System.out.println("Qual nome deseja pesquisar:");
        String nome = scanner.next();
        List<Estadio> list = repository.findByNome(nome);
        list.forEach(System.out::println);
    }
    public Optional<Estadio> buscarPorId(int idEstadio) {
        return repository.findById(idEstadio);
    }

}
