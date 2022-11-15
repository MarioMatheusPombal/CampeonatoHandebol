package com.campeonato.spring.handebol.service;

import com.campeonato.spring.handebol.orm.Jogador;
import com.campeonato.spring.handebol.repository.JogadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class RelatoriosService {

    private Boolean system = true;
    private final JogadorRepository jogadorRepository;
    public RelatoriosService(JogadorRepository jogadorRepository){
        this.jogadorRepository = jogadorRepository;
    }


    public void inicial(Scanner scanner) {
        while(system) {
            System.out.println("Qual relatorio deseja executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Busca Jogador nome");
            System.out.println("2 - Busca Estadio nome");
            System.out.println("3 - Busca Time nome");
            System.out.println("4 - Busca Campeonato nome");

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    buscaJogadorNome(scanner);
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

}
