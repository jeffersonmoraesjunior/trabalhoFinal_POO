package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BancoDeDados {
	//Parametros da Conexao
	private String url;
	private String usuario;
	private String senha;
	private Connection conexao;
	
	//Construtor da conexao com o banco de dados
	public BancoDeDados(){
		url = "jdbc:postgresql://localhost:5432/trabalhoFinalPoo";
		usuario = "postgres";
		senha = "1234"; //Senha que eu mesmo coloquei
		
		try {
			Class.forName("org.postgresql.Driver");
			conexao = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conexao Sucedida");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//executa uma instrução para o Banco de dados
	public int executaSQL(String sql) {
		try {
			Statement stm = conexao.createStatement();
			int res = stm.executeUpdate(sql);
			conexao.close();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public ResultSet selectFrom(String sql) {
		try {
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			conexao.close();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
}
