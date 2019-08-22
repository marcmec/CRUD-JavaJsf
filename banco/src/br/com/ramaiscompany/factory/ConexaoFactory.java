package br.com.ramaiscompany.factory;

import br.com.ramaiscompany.util.BancoUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	
	 	private static final String LINK_BANCO_DE_DADOS ="jdbc:postgresql://localhost:8080/telefone";
	    private static  final String USUARIO_BANCO_DE_DADOS ="postgres";
	    private static  final String SENHA_BANCO_DE_DADOS ="SUASENHAHUEHUE";



	public static Connection getConexao() throws BancoUtil {
		
		 Connection conexao= null;
	        try{
	            Class.forName("org.postgresql.Driver");
	            conexao= DriverManager.getConnection(LINK_BANCO_DE_DADOS, USUARIO_BANCO_DE_DADOS, SENHA_BANCO_DE_DADOS);
	            conexao.setAutoCommit(false);
	        }catch (SQLException e){
				throw  new BancoUtil("Nao foi possivel ser conectado ao banco de dados!", e);
	        }catch (ClassNotFoundException e){
	            throw  new BancoUtil("Problema ao acionar o Driver do banco de dados!", e);
	        }
	        return conexao;
	    }
		
	

}
