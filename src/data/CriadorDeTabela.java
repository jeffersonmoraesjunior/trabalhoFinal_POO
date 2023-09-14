package data;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import view.Menu;

public class CriadorDeTabela {
	public void construirTabelas(Connection conexao) {

		String sql = criarSql();

		try {
			Statement statement = conexao.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			Menu.clearScreen();
			System.out.println("Não foi possível obter o Statement da conexão.");
			System.out.println("Erro: " + e.getMessage());
		}
	}

	private String criarSql() {
		String sql = "CREATE TABLE IF NOT EXISTS estudantes ( id SERIAL PRIMARY KEY, nome VARCHAR(100) NOT NULL, curso VARCHAR(100) NOT NULL );";
		return sql;
	}
}
