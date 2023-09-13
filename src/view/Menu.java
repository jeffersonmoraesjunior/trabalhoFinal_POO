package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	
	private Scanner sc;
	public int opcaoMenu = 0;
	
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
	
//	//LIMPAR CONSOLE EM TERMINAL BASH - https://stackoverflow.com/questions/2979383/how-to-clear-the-console-using-java
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	
	
}
