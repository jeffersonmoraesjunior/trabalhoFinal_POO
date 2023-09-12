package data;

import java.io.FileWriter;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Estudante;

public class BancoDeDados extends conexaoDataBase{
	
	public boolean validacao;
	private Statement stm = null;
	

	public void adicionarEstudante(Estudante estudante) {
//		Statement é um objeto que permite executar comandos SQL por uma conexão.
		try {
			String queryAdd = String.format("INSERT INTO estudantes (nome, curso) VALUES ('%s', '%s');", estudante.getNome(), estudante.getCurso());
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

	}

	public void atualizarEstudante(String id, Estudante estudante) {
		try {
			stm = conexao.createStatement();
			String queryUpdate = String.format("UPDATE estudantes SET nome = '%s', curso = '%s' WHERE id = %s", estudante.getNome(), estudante.getCurso(), id);
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

	}

	public void removerEstudante(Estudante estudante) {
		try {			
			stm = conexao.createStatement();
			String queryDelete = String.format("DELETE FROM estudantes WHERE id = %s", estudante.getID()); // Comando para o Banco de																					
			int resultado = stm.executeUpdate(queryDelete);				
			if (resultado > 0) {
				System.out.println("\n\t -- Estudante Remover --");
			} else {
				System.out.println("Erro ao remover o estudante.");
			}
			// fechando a conexao.
			stm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void listarEstudante() {
		try {
			String querySelect = String.format("SELECT * FROM estudantes ORDER BY id;");
			stm = conexao.createStatement();
			ResultSet resultado = stm.executeQuery(querySelect);
		
			if (resultado.next()) {				
				System.out.println("\n\t -- LISTA DOS ESTUDANTES -- ");
				do {
					// nomes da coluna na tabela
					int id = resultado.getInt("id");
					String nome = resultado.getString("nome");
					String curso = resultado.getString("curso");
					System.out.println("->| " + id + " - " + nome + " - " + curso);
				} while (resultado.next());
				this.validacao = true;
			} else {
				System.out.println("\n\t-- NENHUM ALUNO CADASTRADO NO SISTEMA --");
				this.validacao = false;
			}
			// fechando a conexao.
			resultado.close();
			stm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void exportarArquivo(String nomeArquivo, String extensao) {
		try {
			String querySelect = String.format("SELECT * FROM estudantes ORDER BY id;");
			//Classe que trata sobre arquivos no Java - FileWriter
			FileWriter escrevaArquivo = new FileWriter("C:\\Temp\\" + nomeArquivo + "." + extensao);
			stm = conexao.createStatement();
			ResultSet resultado = stm.executeQuery(querySelect);
			while(resultado.next()) {
				int id = resultado.getInt("id");
				String nome = resultado.getString("nome");
				String curso = resultado.getString("curso");
				
				escrevaArquivo.write(id + ", " + nome + ", " + curso);
				escrevaArquivo.write("\n");			
					
			}
			//fechando conexões
			escrevaArquivo.close();
			stm.close();
			System.out.println("\nArquivo Exportado com Sucesso!");
			System.out.println("Verifique no diretorio: C:\\Temp\\" + nomeArquivo + "." + extensao);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//INFORMAÇÕES GERAIS
	
	/* Statement é um objeto que permite executar comandos SQL por uma conexão.
	 * 
	 * O .next() é usado para avançar para a próxima linha do ResultSet (resultados da tabela) fazendo assim, acessaremos cada .GET com as propriedades de String e Int.
	 */

}
