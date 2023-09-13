//java -jar trabalho.jar

package program;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import data.BancoDeDados;
import data.CriadorDeTabela;
import model.Estudante;
import view.Menu;


public class SistemaGerenciamentoEstudantes {
	
	public static void main(String[] args) throws InterruptedException {

		// Menu Principal
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Menu menu = new Menu(sc);
		Estudante estudante = new Estudante();
		BancoDeDados query = new BancoDeDados();
		CriadorDeTabela create = new CriadorDeTabela();
		
		create.construirTabelas(query.getConexao());
		
		Menu.clearScreen();
		System.out.println("\n\n\t--- SEJA BEM VINDO AO ESTUDANTECH ---\n");

		do {
			menu.exibirMenu();				
			

			switch (menu.getOpcaoMenu()) {

			case 1:
				Menu.clearScreen();
				System.out.println("\n\t -- Você escolheu ADICIONAR -- \n");
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
				Menu.clearScreen();
				System.out.println("\n\t -- Você escolheu EDITAR -- \n");
				query.listarEstudante();
				//INPUT
				if(query.getValidacao() == true) {
					System.out.print("\nInforme o ID Estudante: ");
					try {
						String idEditar = sc.next().trim();
						sc.nextLine();
						query.validarIdEstudante(idEditar);
						if(query.getResultadoId() == 1) {
							System.out.print("Digite o Nome Atualizado: ");
							String nomeEditar = sc.nextLine().trim();
							System.out.print("Digite o Curso Atualizado: ");
							String cursoEditar = sc.nextLine().trim();
							
							//instanciando - conexao com Estudante
						    estudante = new Estudante(nomeEditar, cursoEditar);
							//Insercao banco de dados
							query.atualizarEstudante(idEditar, estudante);
						}
						else {
							System.out.println("\nEsse ID não existe na lista de estudantes!");
							System.out.print("Pressione ENTER para voltar ao menu principal: ");
							sc.nextLine();
							Menu.clearScreen();
						}				
					}
					catch (InputMismatchException e) {
						System.out.println("Entrada inválida!");
					}
					catch (NullPointerException e) {
						Menu.clearScreen();
						System.out.println("\nEntrada inválida, digite um número Inteiro!");
					}						
				}								
				break;

			case 3:
				Menu.clearScreen();
				System.out.println("\n\t -- Você escolheu REMOVER -- \n");
				query.listarEstudante(); //Será listado os estudantes com base na lista mostrada acima
				if(query.getValidacao() == true) {
					//INPUT USER			
					System.out.print("\nInforme o Id: ");					
					try {
						String id = sc.next().trim();
						query.validarIdEstudante(id);
						if(query.getResultadoId() == 1) {
							System.out.print("Você tem certeza que deseja excluir (y/n): ");
							char opc = sc.next().trim().charAt(0);
							if(opc == 'y') {
								//instanciando - conexao com Estudante
							    estudante = new Estudante(Integer.parseInt(id));
							    //Insercao banco de dados
								query.removerEstudante(estudante);
							}
						}
						else {
							System.out.println("\nEsse ID não existe na lista de estudantes!");
							sc.nextLine();
							System.out.print("Pressione ENTER para voltar ao menu principal: ");
							sc.nextLine();
							Menu.clearScreen();
						}
						
					} 
					catch (InputMismatchException e) {
						System.out.println("Entrada inválida!");
					}
					catch (NullPointerException e) {
						Menu.clearScreen();
						System.out.println("\nEntrada inválida, digite um número Inteiro!");
					}					
				}							
				break;

			case 4:
				Menu.clearScreen();
				//Relacionado ao Banco de Dados
				System.out.println("\n\t -- Você escolheu LISTAR -- \n");
				query.listarEstudante();
				sc.nextLine();
				System.out.print("\nPressione ENTER para continuar: ");
				sc.nextLine();
				Menu.clearScreen();
				break;

			case 5:
				Menu.clearScreen();
				System.out.println("\n\t    -- ATÉ A PRÓXIMA ;D --");
				System.out.println("\tESTUDANTECH - CONECTANDO O SABER");
				System.exit(0); //Comando para fechar o systema;
				break;
			
			case 6:
				Menu.clearScreen();
				System.out.println("\n\t -- Você escolheu EXPORTAR -- \n");
				query.listarEstudante();
				if(query.getValidacao() == true) {
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
		while(menu.getOpcaoMenu() != 7);

		sc.close();

	}
}
