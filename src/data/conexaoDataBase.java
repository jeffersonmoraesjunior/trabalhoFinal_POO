package data;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexaoDataBase {
	
	// Parametros da Conexao
		String url;
		String usuario;
		String senha;
		protected Connection conexao; //Classe vista somente no package	

		// Construtor da conexao com o banco de dados
		public conexaoDataBase() {
			url = "jdbc:postgresql://localhost:5432/TrabalhoFinalPOO";
			usuario = "postgres";
			senha = "123456"; //Senha que eu mesmo coloquei no Banco de dados

			try {
				Class.forName("org.postgresql.Driver");
				conexao = DriverManager.getConnection(url, usuario, senha);
				System.out.println("Conexao com Banco de Dados Estabelecida.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

}
