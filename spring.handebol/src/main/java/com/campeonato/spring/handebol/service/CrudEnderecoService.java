package com.campeonato.spring.handebol.service;

import com.campeonato.spring.handebol.orm.Endereco;
import com.campeonato.spring.handebol.orm.Jogador;
import com.campeonato.spring.handebol.repository.EnderecoRepository;
import com.campeonato.spring.handebol.repository.JogadorRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudEnderecoService {

    private boolean system = true;
    private final EnderecoRepository repository;

    public CrudEnderecoService(EnderecoRepository repository){
        this.repository = repository;
    }

    public void inicial(Scanner scanner){
        while (system){
            System.out.println("Qual acao de Endereco deseja?");
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
        Endereco endereco = new Endereco();

        System.out.println("Digite o logradouro: ");
        String log = scanner.next();
        endereco.setLogradouro(log);

        System.out.println("Numero do endereco: ");
        String num = scanner.next();
        endereco.setNumero(num);

        System.out.println("CEP do endereco: ");
        String cep = scanner.next();
        endereco.setCep(cep);

        repository.save(endereco);
        System.out.println("Salvo!!");
    }


    private void atualizar(Scanner scanner){
        Endereco endereco = new Endereco();

        System.out.println("Id do Endereco: ");
        Integer id = scanner.nextInt();
        endereco.setId(id);

        System.out.println("Digite o logradouro: ");
        String log = scanner.next();
        endereco.setLogradouro(log);

        System.out.println("Numero do endereco: ");
        String num = scanner.next();
        endereco.setNumero(num);

        System.out.println("CEP do endereco: ");
        String cep = scanner.next();
        endereco.setCep(cep);

        repository.save(endereco);
        System.out.println("Atualizado!!");
    }
    private void visualizar(){
        Iterable<Endereco> enderecos = repository.findAll();
        enderecos.forEach(endereco -> System.out.println(endereco));
    }

    private void deletar(Scanner scanner){
        System.out.println("Digite o id para deletar");
        int id = scanner.nextInt();
        repository.deleteById(id);
        System.out.println("Deletado!!");
    }
}
