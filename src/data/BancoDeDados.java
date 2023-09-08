package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

public class BancoDeDados {

	// Parametros da Conexao
	private String url;
	private String usuario;
	private String senha;
	private Connection conexao;

	// Construtor da conexao com o banco de dados
	public BancoDeDados() {
		url = "jdbc:postgresql://localhost:5432/TrabalhoFinalPOO";
		usuario = "postgres";
		senha = "123456"; // Senha que eu mesmo coloquei

		try {
			Class.forName("org.postgresql.Driver");
			conexao = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conexao Sucedida");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void adicionarEstudante(String nome, String curso) {
		Statement stm;
		try {
			String queryAdd = String.format("INSERT INTO estudantes (nome, curso) VALUES ('%s', '%s');", nome, curso);
			stm = conexao.createStatement();
			int resultado = stm.executeUpdate(queryAdd);
			if (resultado > 0) {
				System.out.println("\n\t -- Estudante Adicionado --");
				System.out.println("Nome: " + nome + " | Curso: " + curso + ".");
				TimeUnit.SECONDS.sleep(2);				
			} else {
				System.out.println("Erro ao Adicionar o " + nome + " do curso " + curso);
			}
			// fechando a conexao.
			stm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void atualizarEstudante(String id, String nome, String curso) {
		Statement stm;
		try {
			stm = conexao.createStatement();
			String queryUpdate = String.format("UPDATE estudantes SET nome = '%s', curso = '%s' WHERE id = %s", nome,
					curso, id);
			int resultado = stm.executeUpdate(queryUpdate);
			if (resultado > 0) {
				System.out.println("\n\t -- Estudante Atualizado --");
			} else {
				System.out.println("Erro ao Editar estudante");
			}
			// fechando a conexao.
			stm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void removerEstudando(String id) {
		Statement stm;
		try {
			stm = conexao.createStatement();
			String queryDelete = String.format("DELETE FROM estudantes WHERE id = %s", id); // Comando para o Banco de
																							// Dados
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
		Statement stm;
		try {
			String querySelect = String.format("SELECT * FROM estudantes ORDER BY id;");
			stm = conexao.createStatement();
			ResultSet resultado = stm.executeQuery(querySelect);
			System.out.println("\n\t -- LISTA DOS ESTUDANTES -- ");
			while (resultado.next()) {
				int id = resultado.getInt("id"); // nomes da coluna na tabela
				String nome = resultado.getString("nome");
				String curso = resultado.getString("curso");
				System.out.println("->| " + id + " - " + nome + " - " + curso);
			}
			// fechando a conexao.
			resultado.close();
			stm.close();
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
