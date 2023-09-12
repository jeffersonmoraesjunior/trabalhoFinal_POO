package view;

import java.util.Scanner;

public class Menu {
	
	private Scanner sc;
	
	public Menu(Scanner sc) {
		this.sc = sc;
	}
	
	public void exibirMenu() {
		System.out.println("\n\n\t--- SEJA BEM VINDO AO ESTUDANTECH ---\n");
		System.out.println("[1] para ADICIONAR estudante ");
		System.out.println("[2] para EDITAR estudante");
		System.out.println("[3] para REMOVER estudante");
		System.out.println("[4] para LISTAR estudante");
		System.out.println("[5] para SAIR");
		System.out.println("[6] Bônus - Exportar Relatorio");
		System.out.print("\nEscolha a sua opção: ");
	}
	
//	//LIMPAR CONSOLE EM TERMINAL BASH - https://stackoverflow.com/questions/2979383/how-to-clear-the-console-using-java
//	public static void clearScreen() {
//		System.out.print("\033[H\033[2J");
//		System.out.flush();
//	}
	
	
}
