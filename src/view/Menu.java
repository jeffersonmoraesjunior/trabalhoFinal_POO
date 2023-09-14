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
	        } 
	        catch (InputMismatchException e) {
	        	Menu.clearScreen();
	            System.out.println("\nEntrada inválida! Digite um número inteiro.");
	            // Limpe o buffer do scanner e tente novamente.
	            sc.nextLine();
	        } 
	        catch (NullPointerException e) {
	            Menu.clearScreen();
	            System.out.println("\nEntrada inválida, digite um número Inteiro!");
	            // Limpe o buffer do scanner e tente novamente.
	            sc.nextLine();
	        }
	    }
		
	}
	
	//LIMPAR CONSOLE EM TERMINAL BASH - https://stackoverflow.com/questions/2979383/how-to-clear-the-console-using-java
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
			
			System.out.print("\n[1] Listar por 'ID'"
						   + "\n[2] Listar por 'Nome'"
						   + "\n[3] Listar po 'Curso' \n");
			
			System.out.print("\nInforme Opção: ");
			opcao = sc.nextInt();
			
			if(opcao == 1) {
				Menu.clearScreen();
				BancoDeDados.listarEstudanteId();
			}
			else if(opcao == 2) {
				Menu.clearScreen();
				BancoDeDados.listarEstudanteNome();
			}
			else if(opcao == 3) {
				Menu.clearScreen();
				BancoDeDados.listarEstudanteCurso();
			}
			else {
				System.out.println("Entrada inválida, tente novamente.");
			}
		}
		catch(Exception e) {
			System.out.println("Erro ao listar, digite um número inteiro.");
		}
	}
	
	public static void exibirMenuEditar() throws InterruptedException {	
		
		try {
				System.out.println("Qual opção deseja editar: ");
				
				System.out.print("\n[1] Editar apenas o Nome"
							   + "\n[2] Editar apenas o Curso"
							   + "\n[3] Editar ambos (Nome e Curso) \n");
				
				System.out.print("\nInforme Opção: ");
				opcaoMenuEditarEstudante = sc.nextInt();
				
		}
		catch(Exception e) {
			System.out.println("Erro ao listar, digite um número inteiro.");
		}
	}
	
	public static int getOpcaoMenuEditarEstudante() {
		return opcaoMenuEditarEstudante;
	}
	
	
	
	
}
