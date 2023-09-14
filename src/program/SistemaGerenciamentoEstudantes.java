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
				Menu.exibirMenuEditar();													
				break;

			case 3:
				Menu.clearScreen();
				System.out.println("\n\t -- Você escolheu REMOVER -- \n");
				BancoDeDados.listarEstudanteId(); //Será listado os estudantes com base na lista mostrada acima
				if(BancoDeDados.getValidacao() == true) {
					//INPUT USER			
					System.out.print("\nInforme o Id: ");					
					try {
						String id = sc.next().trim();
						BancoDeDados.validarIdEstudante(id);
						if(BancoDeDados.getResultadoId() == 1) {
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
						Menu.clearScreen();
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
				Menu.exibirMenuListar();
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
				BancoDeDados.listarEstudanteId();
				
				if(BancoDeDados.getValidacao() == true) {
					sc.nextLine();
					System.out.print("\nDigite o nome do Arquivo: ");
                    /* Tratamento do nomeArquivo - remove os espacos do inicio e fim(.trim()), 
                     * coloca em letras minusculas(.toLowerCase()) e substitui os " " por tracos (.replaceAll(" ", "_")) */
					String nomeArquivo = sc.nextLine().toLowerCase().trim().replaceAll(" ", "_"); 					
					System.out.println();
					System.out.print("Escolha o tipo de arquivo para ser exportado: \n- txt \n- csv\n\nDigite Aqui: ");					
					String extensaoArquivo = sc.next().trim().toLowerCase();
					
					while(!extensaoArquivo.equals("txt") && !extensaoArquivo.equals("csv")) {
						System.out.println("\nOpção de Extensão Inválida, tente novamente.\n");
						System.out.print("Escolha o tipo de arquivo para ser exportado: \n- txt \n- csv\n\nDigite Aqui: ");							
						extensaoArquivo = sc.next().trim().toLowerCase();
					}
					query.exportarArquivo(nomeArquivo, extensaoArquivo);
				}
				break;

			default:
				Menu.clearScreen();
				System.out.println("Opção inválida, tente novamente!");
				break;
			}
		} 
		while(menu.getOpcaoMenu() != null);
		sc.close();
	}
}
