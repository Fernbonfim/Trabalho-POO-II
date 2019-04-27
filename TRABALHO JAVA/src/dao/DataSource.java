/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataSource {
    
    private String hostname;
    private int    port;
    private String database;
    private String username;
    private String password;
    private String url;
    
    private Connection connection;
    
    public DataSource(){
        try{
            hostname = "localhost";
            port     = 3306;
            database = "projeto";
            username = "root";
            password = "";
            url = "jdbc:mysql://localhost:3306/projeto?useTimezone=true&serverTimezone=UTC";
            
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection(url, username, password);
            
            System.out.println("Conectado com sucesso ao banco...");
        }
        catch(SQLException ex){
            System.out.println("Erro na conexao "+ex.getMessage());
        }
        catch(Exception ex){
            System.out.println("Erro geral "+ex.getMessage());
        }
        
    }
    
    public Connection getConnection(){
        return this.connection;
    }
    
    public void closeDataSource(){
        try{
            connection.close();
        }
        catch(Exception ex){
            System.out.println("Erro ao desconectar "+ex.getMessage());
    }
    }
    
    
}
