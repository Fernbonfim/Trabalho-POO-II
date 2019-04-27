/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ClientesDAO {
    private DataSource dataSource;
    
    public ClientesDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }
            
    //mostrando os dados
    public ArrayList<Clientes> readAll(){
        try{
            Scanner input = new Scanner(System.in);
            int a;
            System.out.printf("Informe o id:\n");
            a = input.nextInt();
            
            String SQL = "SELECT *FROM cliente where id = '+a'"; //Especificar valor a ser mostrado
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            
            ArrayList<Clientes> lista = new ArrayList<Clientes>();            
            
            while(rs.next()){
                Clientes cli = new Clientes();
                System.out.printf("id\n"+ a);
                System.out.printf("nome\n");
                System.out.printf("email\n");
                System.out.printf("telefone\n");
                
                
                
                lista.add(cli);
            }ps.close();
            return lista;
            }
        catch (SQLException ex){
            System.out.println("Erro ao Recuperar Clientes "+ex.getMessage());
        }
        catch(Exception ex){
            System.out.println("Erro geral..."+ex.getMessage());
        }
        return null;
    }
    
    
    
    //deletando os dados
public void remover(int id){
        String sql = "delete from cliente where id = ?"; //especificar o valor a ser deletado
        try{
            PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ps.setInt(1, 2);
            ps.executeUpdate();
            ps.close();
            
        }catch(Exception ex){
            System.out.println("Não foi possível remover o registro");
        }
    }

    
    //atualizando os dados
    public void atualizar(Clientes clientes, int id){
        String sql = "update cliente set nome = ?, email = ?,"
                + "telefone = ?"
                + " where id = ?";
        
        try{
            PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
            ps.setString(2, clientes.getNome());
            ps.setString(3, clientes.getEmail());
            ps.setString(4, clientes.getTelefone());
            
            ps.executeUpdate();
        }catch(Exception ex){
            System.out.println("Não foi possível atualizar");
        }
    }    


    public void inserir(Clientes clientes) {       
        try {
            String sql = "INSERT INTO cliente "
                    + "(id, name, email, telefone)"
                    + "values (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
            ps.setInt(1, clientes.getId());
            ps.setString(2, clientes.getNome());
            ps.setString(3, clientes.getEmail());
            ps.setString(4, clientes.getTelefone());
            
            ps.executeUpdate();

            ps.close();

        } catch (Exception ex) {
            System.out.println("Erro ao inserir cliente");
        }
    }


    
}
