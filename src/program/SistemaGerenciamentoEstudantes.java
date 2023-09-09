package program;

import java.util.Locale;
import java.util.Scanner;

import data.BancoDeDados;
import view.Menu;

public class SistemaGerenciamentoEstudantes {
	
	public static void main(String[] args) throws InterruptedException {
		int opcaoMenu;

		// Menu Principal
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
<<<<<<< HEAD
=======
		Menu menu = new Menu();
>>>>>>> 1e650ab97597afba51cc2ccfb2cd3ba7cddec283
		BancoDeDados query = new BancoDeDados();

		do {
			menu.menuPrincipal();
			opcaoMenu = sc.nextInt();

			switch (opcaoMenu) {

			case 1:
				System.out.println("\n\t -- Voce escolheu ADICIONAR -- ");
				//INPUT USER
				sc.nextLine();
				System.out.print("Insira o Nome: ");
			    String nome = sc.nextLine();			    
			    System.out.print("Insira o Curso: ");
			    String curso = sc.nextLine();
				//instanciando - conexao com o banco				
<<<<<<< HEAD
			    query.adicionarEstudante(nome, curso);				
=======
			    query.adicionarEstudante(nome, curso);
>>>>>>> 1e650ab97597afba51cc2ccfb2cd3ba7cddec283
				break;

			case 2:
				System.out.println("\n\t -- Voce escolheu EDITAR -- ");
				query.listarEstudante();
				//INPUT
<<<<<<< HEAD
				System.out.print("\nInforme o ID Estudante: ");
				String idEditar = sc.next();
				System.out.print("Digite o Nome Atualizado: ");
				String nomeEditar = sc.next();
				System.out.print("Digite o Curso Atualizado: ");
				String cursoEditar = sc.next();
				
				//Insercao banco de dados
				query.atualizarEstudante(idEditar, nomeEditar, cursoEditar);
=======
				if(query.validacao == true) {
					System.out.print("\nInforme o ID Estudante: ");
					String idEditar = sc.next();
					sc.nextLine();
					System.out.print("Digite o Nome Atualizado: ");
					String nomeEditar = sc.nextLine();
					System.out.print("Digite o Curso Atualizado: ");
					String cursoEditar = sc.nextLine();
					
					//Insercao banco de dados
					query.atualizarEstudante(idEditar, nomeEditar, cursoEditar);
				}
>>>>>>> 1e650ab97597afba51cc2ccfb2cd3ba7cddec283
				break;

			case 3:
				System.out.println("\n\t -- Voce escolheu REMOVER -- ");
				query.listarEstudante(); //Será listado os estudantes com base na lista mostrada acima
				//INPUT USER
<<<<<<< HEAD
				System.out.print("\nInforme o Id: ");
				String id = sc.next();
				System.out.print("Você tem certeza que deseja excluir (y/n): ");
				char opc = sc.next().charAt(0);
				if(opc == 'y') {
					query.removerEstudando(id);
=======
				if(query.validacao == true) {
					System.out.print("\nInforme o Id: ");
					String id = sc.next();
					System.out.print("Você tem certeza que deseja excluir (y/n): ");
					char opc = sc.next().charAt(0);
					if(opc == 'y') {
						query.removerEstudando(id);
					}
>>>>>>> 1e650ab97597afba51cc2ccfb2cd3ba7cddec283
				}
				break;

			case 4:
<<<<<<< HEAD
				System.out.println("Voce escolheu LISTAR");
=======
				System.out.println("\n\t -- Voce escolheu LISTAR -- ");
>>>>>>> 1e650ab97597afba51cc2ccfb2cd3ba7cddec283
				query.listarEstudante();		
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
		while(opcaoMenu != 5);

		sc.close();

	}
	
}