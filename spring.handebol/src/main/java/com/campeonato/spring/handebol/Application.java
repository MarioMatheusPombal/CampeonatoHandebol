package com.campeonato.spring.handebol;

import com.campeonato.spring.handebol.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private final CrudJogadorService crudJogadorService;
	private final CrudEnderecoService crudEnderecoService;
	private final CrudEstadioService crudEstadioService;
	private final RelatoriosService relatoriosService;
	private final CrudTimeService crudTimeService;
	private final CrudPartidaService crudPartidaService;
	private final CrudCampeonatoService crudCampeonatoService;
	private Boolean system = true;


	public Application(CrudJogadorService crudJogadorService, CrudEnderecoService crudEnderecoService, CrudEstadioService crudEstadioService, RelatoriosService relatoriosService, CrudTimeService crudTimeService, CrudPartidaService crudPartidaService, CrudCampeonatoService crudCampeonatoService){
		this.crudJogadorService = crudJogadorService;
		this.crudEnderecoService = crudEnderecoService;
		this.crudEstadioService = crudEstadioService;
		this.relatoriosService = relatoriosService;
		this.crudTimeService = crudTimeService;
		this.crudPartidaService = crudPartidaService;
		this.crudCampeonatoService = crudCampeonatoService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while (system){
			System.out.println("Qual acao voce quer?");
			System.out.println("0 - Sair");
			System.out.println("1 - Relatorios");
			System.out.println("2 - Jogador");
			System.out.println("3 - Endereco");
			System.out.println("4 - Estadio");
			System.out.println("5 - Time");
			System.out.println("6 - Partida");
			System.out.println("7 - Campeonato");


			int action = scanner.nextInt();

			switch (action){
				case 1:
					relatoriosService.inicial(scanner);
					break;
				case 2:
					crudJogadorService.inicial(scanner);
					break;
				case 3:
					crudEnderecoService.inicial(scanner);
					break;
				case 4:
					crudEstadioService.inicial(scanner);
					break;
				case 5:
					crudTimeService.inicial(scanner);
					break;
				case 6:
					crudPartidaService.inicial(scanner);
					break;
				case 7:
					crudCampeonatoService.inicial(scanner);
					break;
				default:
					system = false;
					break;
			}
		}
	}
}
