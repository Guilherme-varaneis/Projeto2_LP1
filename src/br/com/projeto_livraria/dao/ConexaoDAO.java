/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_livraria.dao;
import java.sql.*;

/**
 *
 * @author guiva
 */
public class ConexaoDAO {
    public static Connection con = null;
    public ConexaoDAO(){
        
    }public static void ConectDB(){
     try {
            
            String dsn = "Projeto_Livro";
            String user = "postgres"; 
            String senha = "postdba"; 
          
            DriverManager.registerDriver(new org.postgresql.Driver());

            String url = "jdbc:postgresql://localhost:5432/" + dsn;
           
            con = DriverManager.getConnection(url, user, senha);

            con.setAutoCommit(false);
            if (con == null) {
                System.out.println("erro ao abrir o banco");
            }
        }//fecha o try
        //Caso ocorra problemas para abrir o banco de dados é emitido a mensagem no console.
        catch (Exception e) {
            System.out.println("Problema ao abrir a base de dados! " + e.getMessage());
        }//fecha o catch
    }//Fecha o método ConectDB

    /**
     * Método que fecha a conexão com o banco de dados é do tipo static para que
     * não seja necessário instanciar um objeto da classe, chamando os metodos
     * de forma direta.Ex: classe.nome_do_metodo
     */
    public static void CloseDB() {
        try {
            con.close();
        }
        
        catch (Exception e) {
            System.out.println("Problema ao fechar a base de dados! " + 
                e.getMessage());
        }
    }
    
    
}
