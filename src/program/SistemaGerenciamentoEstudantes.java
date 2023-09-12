package program;

import java.util.Locale;
import java.util.Scanner;

import data.BancoDeDados;
import model.Estudante;
import view.Menu;


public class SistemaGerenciamentoEstudantes {
	
	public static void main(String[] args) {
		int opcaoMenu;

		// Menu Principal
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Menu menu = new Menu(sc);
		Estudante estudante = new Estudante();
		BancoDeDados query = new BancoDeDados();

		do {
			menu.exibirMenu();
			opcaoMenu = sc.nextInt();

			switch (opcaoMenu) {

			case 1:
				System.out.println("\n\t -- Voce escolheu ADICIONAR -- ");
				//INPUT USER
				sc.nextLine();
				System.out.print("Insira o Nome: ");
			    String nome = sc.nextLine().trim();			    
			    System.out.print("Insira o Curso: ");
			    String curso = sc.nextLine().trim();
			    
				//instanciando - conexao com Estudante
			    estudante = new Estudante(nome, curso);
			    //instanciando - conexao com o banco				
			    query.adicionarEstudante(estudante);
				break;

			case 2:
				System.out.println("\n\t -- Voce escolheu EDITAR -- ");
				query.listarEstudante();
				//INPUT
				if(query.validacao == true) {
					System.out.print("\nInforme o ID Estudante: ");
					String idEditar = sc.next().trim();
					sc.nextLine();
					System.out.print("Digite o Nome Atualizado: ");
					String nomeEditar = sc.nextLine().trim();
					System.out.print("Digite o Curso Atualizado: ");
					String cursoEditar = sc.nextLine().trim();
					
					//instanciando - conexao com Estudante
				    estudante = new Estudante(nomeEditar, cursoEditar);
					//Insercao banco de dados
					query.atualizarEstudante(idEditar, estudante);
				}								
				break;

			case 3:
				System.out.println("\n\t -- Voce escolheu REMOVER -- ");
				query.listarEstudante(); //Será listado os estudantes com base na lista mostrada acima
				if(query.validacao == true) {
					//INPUT USER			
					System.out.print("\nInforme o Id: ");
					String id = sc.next().trim();
					System.out.print("Você tem certeza que deseja excluir (y/n): ");
					char opc = sc.next().trim().charAt(0);
					if(opc == 'y') {
						//instanciando - conexao com Estudante
					    estudante = new Estudante(Integer.parseInt(id));
					    //Insercao banco de dados
						query.removerEstudante(estudante);
					}					
				}							
				break;

			case 4:
				//Relacionado ao Banco de Dados
				System.out.println("\n\t -- Voce escolheu LISTAR -- ");
				query.listarEstudante();		
				break;

			case 5:
				System.out.println("\n\t    -- ATÉ A PRÓXIMA ;D --");
				System.out.println("\tESTUDANTECH - CONECTANDO O SABER");
				System.exit(0); //Comando para fechar o systema;
				break;
			
			case 6:
				System.out.println("\n\t -- Exportar Alunos -- ");
				query.listarEstudante();
				if(query.validacao == true) {
					sc.nextLine();
					System.out.print("\nDigite o nome do Arquivo: ");
                    /* Tratamento do nomeArquivo - remove os espacos do inicio e fim(.trim()), 
                     * coloca em letras minusculas(.toLowerCase()) e substitui os " " por tracos (.replaceAll(" ", "_")) */
					String nomeArquivo = sc.nextLine().toLowerCase().trim().replaceAll(" ", "_"); 					
					System.out.println();					
					System.out.print("Digite o tipo de arquivo para ser exportado: \n- txt \n- csv\n\n-> ");					
					String extensaoArquivo = sc.next().toLowerCase().trim();
					query.exportarArquivo(nomeArquivo, extensaoArquivo);
				}
				break;

			default:
				System.out.println("Opção inválida, tente novamente!");
				break;
			}
		} 
		while(opcaoMenu != 7);

		sc.close();

	}
}
