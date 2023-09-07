package program;

import java.util.Locale;
import java.util.Scanner;

public class SistemaGerenciamentoEstudantes {

	public static void main(String[] args) {
		int opcaoMenu;

		// Menu Principal
		Locale.setDefault(Locale.US);;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("\n\t--- SEJA BEM VINDO AO ESTUDANTECH ---\n");
			System.out.println("[1] para ADICIONAR estudante ");
			System.out.println("[2] para EDITAR estudante");
			System.out.println("[3] para REMOVER estudante");
			System.out.println("[4] para LISTAR estudante");
			System.out.println("[5] para SAIR");

			opcaoMenu = sc.nextInt();

			switch (opcaoMenu) {

			case 1:
				System.out.println("Voce escolheu ADICIONAR");
				break;

			case 2:
				System.out.println("Voce escolheu EDITAR");
				break;

			case 3:
				System.out.println("Voce escolheu REMOVER");
				break;

			case 4:
				System.out.println("Voce escolheu LISTAR");
				break;

			case 5:
				System.out.println("\n\t    -- ATÉ A PRÓXIMA ;D --");
				System.out.println("\tESTUDANTECH - CONECTANDO O SABER");
				System.exit(0); //Comando para fechar o systema;
				break;

			default:
				System.out.println("Opção inválida, tente novamente!");
				break;
			}
		}
		while (opcaoMenu != 5);

		sc.close();

	}

}
