package data;

import java.io.FileWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import model.Estudante;
import view.Menu;

public class BancoDeDados extends ConexaoDataBase {

	private static Boolean validacao;
	private Integer resultadoId;
	private static Statement stm = null;

	public void adicionarEstudante(Estudante estudante) throws InterruptedException {
//		Statement é um objeto que permite executar comandos SQL por uma conexão.
		try {
			String queryAdd = String.format("INSERT INTO estudantes (nome, curso) VALUES ('%s', '%s');",
					estudante.getNome(), estudante.getCurso());
			stm = conexao.createStatement();
			int resultado = stm.executeUpdate(queryAdd);
			if (resultado > 0) {
				System.out.println("\n\t -- Estudante Adicionado --");
				System.out.println("Nome: " + estudante.getNome() + " | Curso: " + estudante.getCurso() + ".");
			} else {
				System.out.println("Erro ao Adicionar o " + estudante.getNome() + " do curso " + estudante.getCurso());
			}
			// fechando a conexao.
			stm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		TimeUnit.SECONDS.sleep(2);
		Menu.clearScreen();

	}

	public void atualizarEstudante(String id, Estudante estudante) throws InterruptedException {
		try {
			stm = conexao.createStatement();
			String queryUpdate = String.format("UPDATE estudantes SET nome = '%s', curso = '%s' WHERE id = %s",
					estudante.getNome(), estudante.getCurso(), id);
			int resultado = stm.executeUpdate(queryUpdate);
			if (resultado > 0) {
				System.out.println("\n\t -- Estudante Atualizado --");
				System.out.println("Nome: " + estudante.getNome() + " | Curso: " + estudante.getCurso() + ".");
			} else {
				System.out.println("Erro ao Editar estudante");
			}
			// fechando a conexao.
			stm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		TimeUnit.SECONDS.sleep(2);
		Menu.clearScreen();

	}

	public void removerEstudante(Estudante estudante) throws InterruptedException {
		try {
			stm = conexao.createStatement();
			String queryDelete = String.format("DELETE FROM estudantes WHERE id = %s", estudante.getID()); // Comando para o
																											// Banco de
			int resultado = stm.executeUpdate(queryDelete);
			if (resultado > 0) {
				System.out.println("\n\t -- Estudante Removido --");
			} else {
				System.out.println("Erro ao remover o estudante.");
			}
			// fechando a conexao.
			stm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		TimeUnit.SECONDS.sleep(2);
		Menu.clearScreen();

	}

	public static void listarEstudanteId() throws InterruptedException {
		try {
			String querySelect = String.format("SELECT * FROM estudantes ORDER BY id;");
			stm = conexao.createStatement();
			ResultSet resultado = stm.executeQuery(querySelect);

			if (resultado.next()) {
				System.out.println("\n\t -- LISTA DOS ESTUDANTES -- \n");
				do {
					// nomes da coluna na tabela
					int id = resultado.getInt("id");
					String nome = resultado.getString("nome");
					String curso = resultado.getString("curso");
					System.out.println("->| " + id + " - " + nome + " - " + curso);
				} while (resultado.next());
				validacao = true;
			} else {
				System.out.println("\n\t-- NENHUM ALUNO CADASTRADO NO SISTEMA --");
				validacao = false;
			}
			// fechando a conexao.
			resultado.close();
			stm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void listarEstudanteNome() {
		try {
			String querySelect = String.format("SELECT nome, STRING_AGG(curso, ', ') FROM estudantes GROUP BY nome;");
			stm = conexao.createStatement();
			ResultSet resultado = stm.executeQuery(querySelect);
			
			if (resultado.next()) {
				System.out.println("\n\t -- LISTA DOS ESTUDANTES -- \n");
				do {
					// nomes da coluna na tabela
					String nome = resultado.getString("nome");
					String string_agg = resultado.getString("string_agg");
					System.out.println("->| " + nome + " - " + string_agg);
				} while (resultado.next());
				validacao = true;
			} else {
				System.out.println("\n\t-- NENHUM ALUNO CADASTRADO NO SISTEMA --");
				validacao = false;
			}
			// fechando a conexao.
			resultado.close();
			stm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void listarEstudanteCurso() {
		try {
			String querySelect = String.format("SELECT curso, STRING_AGG(nome, ', ') FROM estudantes GROUP BY curso;");
			stm = conexao.createStatement();
			ResultSet resultado = stm.executeQuery(querySelect);

			if (resultado.next()) {
				System.out.println("\n\t -- LISTA DOS ESTUDANTES -- \n");
				do {
					// nomes da coluna na tabela
					String string_agg = resultado.getString("string_agg");
					String curso = resultado.getString("curso");
					System.out.println("->| " + curso + " - " + string_agg);
				} while (resultado.next());
				validacao = true;
			} else {
				System.out.println("\n\t-- NENHUM ALUNO CADASTRADO NO SISTEMA --");
				validacao = false;
			}
			// fechando a conexao.
			resultado.close();
			stm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void exportarArquivo(String nomeArquivo, String extensao) throws InterruptedException {
		try {
			String querySelect = String.format("SELECT * FROM estudantes ORDER BY id;");
			// Classe que trata sobre arquivos no Java - FileWriter
			FileWriter escrevaArquivo = new FileWriter("C:\\Temp\\" + nomeArquivo + "." + extensao);
			stm = conexao.createStatement();
			ResultSet resultado = stm.executeQuery(querySelect);
			while (resultado.next()) {
				int id = resultado.getInt("id");
				String nome = resultado.getString("nome");
				String curso = resultado.getString("curso");

				escrevaArquivo.write(id + ", " + nome + ", " + curso);
				escrevaArquivo.write("\n");

			}
			// fechando conexões
			escrevaArquivo.close();
			stm.close();
			Menu.clearScreen();
			System.out.println("\nArquivo Exportado com Sucesso!");
			System.out.println("Verifique no diretorio: C:\\Temp\\" + nomeArquivo + "." + extensao);
		} catch (Exception e) {
			e.printStackTrace();
		}
		TimeUnit.SECONDS.sleep(2);

	}

	public void validarIdEstudante(String id) {
		
		try {
			stm = conexao.createStatement();
			String querySelectId = String.format("SELECT * FROM estudantes WHERE id = %s", id);

			PreparedStatement preparedStatement = conexao.prepareStatement(querySelectId);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				resultadoId = 1;
			} else {
				resultadoId = 0;
			}

			// fechando a conexao.
			stm.close();

		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("Dado inválido!");
		}

	}
	
	public Boolean getValidacao() {
		return validacao;
	}

	public Integer getResultadoId() {
		return resultadoId;
	}

	// INFORMAÇÕES GERAIS

	/*
	 * Statement é um objeto que permite executar comandos SQL por uma conexão.
	 * 
	 * O .next() é usado para avançar para a próxima linha do ResultSet (resultados
	 * da tabela) fazendo assim, acessaremos cada .GET com as propriedades de String
	 * e Int.
	 */

}
