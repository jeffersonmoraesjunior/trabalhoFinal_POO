package program;

import java.util.Locale;
import java.util.Scanner;

import data.BancoDeDados;

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
				System.out.println("\n\t -- Voce escolheu ADICIONAR -- ");
				BancoDeDados dbAdicionar = new BancoDeDados();
				//INPUT USER
				System.out.print("Insira o Nome: ");
			    String nome = sc.next();
			    sc.nextLine(); // Consuma a quebra de linha pendente
			    System.out.print("Insira o Curso: ");
			    String curso = sc.nextLine();
				//instanciando - conexao com o banco				
				dbAdicionar.adicionarEstudante(nome, curso);				
				break;

			case 2:
				System.out.println("\n\t -- Voce escolheu EDITAR -- ");
				BancoDeDados dbEditar = new BancoDeDados();
				dbEditar.listarEstudante();
				//INPUT
				System.out.print("\nInforme o ID Estudante: ");
				String idEditar = sc.next();
				System.out.print("Digite o Nome Atualizado: ");
				String nomeEditar = sc.next();
				System.out.print("Digite o Curso Atualizado: ");
				String cursoEditar = sc.next();
				
				//Insercao banco de dados
				dbEditar.atualizarEstudante(idEditar, nomeEditar, cursoEditar);
				break;

			case 3:
				System.out.println("\n\t -- Voce escolheu REMOVER -- ");
				BancoDeDados dbDelete = new BancoDeDados();
				dbDelete.listarEstudante(); //Será listado os estudantes com base na lista mostrada acima
				//INPUT USER
				System.out.print("\nInforme o Id: ");
				String id = sc.next();
				System.out.print("Você tem certeza que deseja excluir (y/n): ");
				char opc = sc.next().charAt(0);
				if(opc == 'y') {
					dbDelete.removerEstudando(id);
				}
				break;

			case 4:
				System.out.println("Voce escolheu LISTAR");
				BancoDeDados dbListar = new BancoDeDados();
				dbListar.listarEstudante();		
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
