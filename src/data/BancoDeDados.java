package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDeDados {
	
	public static void main(String[] args) {
		//Parametros da Conexao
		String url = "jdbc:postgresql://localhost:5432/seu_banco_de_dados";
		String usuario = "seu_usuario";
		String senha = "sua_senha";
		
		//Tratamento Obrigatorio de erros para o Banco de Dados na conexão.
		try {
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace(); // Ele mostra o Tipo de Erro e como onde foi executado.
		}
	}
	
}
