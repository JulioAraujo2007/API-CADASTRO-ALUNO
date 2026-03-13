package br.com.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {
    Connection con;// criacao do objeto conexao
    PreparedStatement ps;//criacaoo do objeto preparacao de ambiente
    ResultSet rs;// criacao do objeto que recebe resultados
 	public void abrirBanco() throws SQLException {// criando metodo para acessar o banco
  try {
	Class.forName("com.mysql.cj.jdbc.Driver");//classe para utiliza??o do arquivo com configurçoes do serivdor mysql
	String url = "jdbc:mysql://localhost:3306/cadastro";// drive servidor e banco de dados a serem utilizados e indica??o do banco a ser utilizado
	String user ="root";// usuario do banco de dados
	String senha ="2010026456";//senha do usuario do banco de dados    
	con=(Connection) DriverManager.getConnection
	(url,user,senha);//metodo que usa os parametros para conectar com o banco
	 System.out.println("Conectado.");
  }   
	  catch (ClassNotFoundException ex) {//tratamento de erro de drive
		  System.out.println("Classe n?o encontrada, adicione o driver nas bibliotecas.");
		Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
		} 
		
		catch(SQLException e) {//tratamento de erro de SQL
		  System.out.println(e);
		  throw new RuntimeException(e);
	  } 
	  
	  
	  
	  
     }    
    
    public void fecharBanco() throws Exception{//criando metodo que fechao conex?o com o banco
       if (ps!= null) { //limpando os dados de conex?o   
            ps.close();//fechando o ambiente de conex?o
            System.out.println("Execu?ao da Query fechada\n");
    }  
        }
}
