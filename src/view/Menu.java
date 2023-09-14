package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import data.BancoDeDados;
import model.Estudante;

public class Menu {

	private static Scanner sc;
	private int opcaoMenu = 0;
	private static int opcaoMenuEditarEstudante = 0;

	public Menu(Scanner sc) {
		this.sc = sc;
	}

	public void exibirMenu() throws InterruptedException {
		while (true) {
			try {
				System.out.println("\n    -- MENU PRINCIPAL --\n");
				System.out.println("[1] para ADICIONAR estudante ");
				System.out.println("[2] para EDITAR estudante");
				System.out.println("[3] para REMOVER estudante");
				System.out.println("[4] para LISTAR estudante");
				System.out.println("[5] para SAIR");
				System.out.println("[6] Bônus - Exportar Relatorio");
				System.out.print("\nEscolha a sua opção: ");
				opcaoMenu = sc.nextInt();

				// Se a entrada estiver correta, saia do loop.
				break;				
			} catch (InputMismatchException e) {
				Menu.clearScreen();
				System.out.println("\nEntrada inválida! Digite um número inteiro.");
				// Limpe o buffer do scanner e tente novamente.
				sc.nextLine();
			} catch (NullPointerException e) {
				Menu.clearScreen();
				System.out.println("\nEntrada inválida, digite um número Inteiro!");
				// Limpe o buffer do scanner e tente novamente.
				sc.nextLine();
			}
		}

	}

	// LIMPAR CONSOLE EM TERMINAL BASH -
	// https://stackoverflow.com/questions/2979383/how-to-clear-the-console-using-java
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public Integer getOpcaoMenu() {
		return opcaoMenu;
	}

	public static void exibirMenuListar() throws InterruptedException {
		int opcao = 0;

		try {
			System.out.println("Qual opção deseja listar: ");

			System.out.print("\n[1] Listar por 'ID'" + "\n[2] Listar por 'Nome'" + "\n[3] Listar por 'Curso' \n");

			System.out.print("\nInforme Opção: ");
			opcao = sc.nextInt();

			if (opcao == 1) {
				Menu.clearScreen();
				BancoDeDados.listarEstudanteId();
			} else if (opcao == 2) {
				Menu.clearScreen();
				BancoDeDados.listarEstudanteNome();
			} else if (opcao == 3) {
				Menu.clearScreen();
				BancoDeDados.listarEstudanteCurso();
			} else {
				Menu.clearScreen();
				System.out.println("Entrada inválida, tente novamente.");
			}
		} catch (Exception e) {
			Menu.clearScreen();
			System.out.println("Erro ao listar, digite um número inteiro.");
		}
	}

	public static void exibirMenuEditar() throws InterruptedException {
		try {
			Estudante estudante = new Estudante();
			String nomeEditar = "Não foi atualizado";
			String cursoEditar = "Não foi atualizado";
			System.out.println("Qual opção deseja editar: ");

			do {

				System.out.print("\n[1] Editar apenas o Nome" + "\n[2] Editar apenas o Curso"
						+ "\n[3] Editar ambos (Nome e Curso) \n");

				System.out.print("\nInforme a opção: ");
				opcaoMenuEditarEstudante = sc.nextInt();
				
				if(opcaoMenuEditarEstudante < 1 || opcaoMenuEditarEstudante > 3) {
					Menu.clearScreen();
					System.out.println("Entrada inválida! Digite um número das opções.");
				}

			} while (opcaoMenuEditarEstudante < 1 || opcaoMenuEditarEstudante > 3);

			BancoDeDados.listarEstudanteId();

			if (BancoDeDados.getValidacao() == true) {
				System.out.print("\nInforme o ID Estudante: ");
				try {
					String idEditar = sc.next().trim();
					sc.nextLine();
					BancoDeDados.validarIdEstudante(idEditar);
					if (BancoDeDados.getResultadoId() == 1) {
						try {
							if (Menu.getOpcaoMenuEditarEstudante() == 1) {
								System.out.print("Digite o nome atualizado: ");
								nomeEditar = sc.nextLine().trim();
								Menu.clearScreen();
								estudante = new Estudante(nomeEditar, cursoEditar);
								BancoDeDados.atualizarEstudanteNome(idEditar, estudante);
							} else if (Menu.getOpcaoMenuEditarEstudante() == 2) {
								System.out.print("Digite o curso atualizado: ");
								cursoEditar = sc.nextLine().trim();
								Menu.clearScreen();
								estudante = new Estudante(nomeEditar, cursoEditar);
								BancoDeDados.atualizarEstudanteCurso(idEditar, estudante);
							} else if (Menu.getOpcaoMenuEditarEstudante() == 3) {
								System.out.print("Digite o nome atualizado: ");
								nomeEditar = sc.nextLine().trim();
								System.out.print("Digite o curso atualizado: ");
								cursoEditar = sc.nextLine().trim();
								Menu.clearScreen();
								estudante = new Estudante(nomeEditar, cursoEditar);
								BancoDeDados.atualizarEstudanteAmbos(idEditar, estudante);
							} else {
								Menu.clearScreen();
								System.out.println("Entrada inválida, tente novamente.");
							}
						} catch (Exception e) {
							Menu.clearScreen();
							System.out.println("Erro ao editar, digite um número inteiro.");
						}
					} else {
						System.out.println("\nEsse ID não existe na lista de estudantes!");
						System.out.print("Pressione ENTER para voltar ao menu principal: ");
						sc.nextLine();
						Menu.clearScreen();
					}
				} catch (InputMismatchException e) {
					Menu.clearScreen();
					System.out.println("Entrada inválida!");
				} catch (NullPointerException e) {
					Menu.clearScreen();
					System.out.println("\nEntrada inválida, digite um número Inteiro!");
				}
			}
		} catch (Exception e) {
			Menu.clearScreen();
			System.out.println("Erro ao listar, digite um número inteiro.");
			sc.next();
		}
	}

	public static int getOpcaoMenuEditarEstudante() {
		return opcaoMenuEditarEstudante;
	}

}
