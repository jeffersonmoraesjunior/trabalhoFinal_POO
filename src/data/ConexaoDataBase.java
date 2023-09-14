package data;

import java.sql.Connection;
import java.sql.DriverManager;

import view.Menu;

public class ConexaoDataBase {
	
	// Parametros da Conexao

		private String url;
		private String usuario;
		private String senha;
		protected static Connection conexao; //Classe vista somente no package		


		// Construtor da conexao com o banco de dados
		public ConexaoDataBase() {
			url = "jdbc:postgresql://localhost:5432/TrabalhoFinalPOO";
			usuario = "postgres";
			senha = "123456"; //Senha que eu mesmo coloquei no Banco de dados

			try {
				Class.forName("org.postgresql.Driver");
				conexao = DriverManager.getConnection(url, usuario, senha);
				System.out.println("Conexao com Banco de Dados Estabelecida.");
			} catch (Exception e) {
				Menu.clearScreen();
				e.printStackTrace();
			}
		}

		public Connection getConexao() {
			return conexao;
		}

		

}
