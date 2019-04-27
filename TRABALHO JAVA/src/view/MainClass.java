
import dao.ClientesDAO;
import dao.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dao.Clientes;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ferna
 */
public class MainClass {
    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        
        Scanner input = new Scanner(System.in);
        int i, n;
        
        ClientesDAO clieDao = new ClientesDAO(dataSource);
        ArrayList<Clientes> lista = clieDao.readAll();
        
            for (Clientes c : lista){
            System.out.println("Nome: " + c.getNome());
            System.out.println("Email: " + c.getEmail());
            System.out.println("Telefone: " + c.getTelefone ());
            System.out.println("-----------------------------------");
        
        }
        dataSource.closeDataSource();
        
    }
}
