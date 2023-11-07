/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_livraria.dao;
import br.com.projeto_livraria.dto.ClienteDTO;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author guiva
 */
public class ClienteDAO {
    
    public ClienteDAO(){
        }
      //Atributo do tipo ResultSet utilizado para realizar consultas
    private ResultSet rs = null;
    //Manipular o banco de dados
    private Statement stmt = null;
    
    public boolean inserirCliente(ClienteDTO clienteDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Instancia o Statement que sera responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Insert into cliente (nome_cli, logradouro_cli, "
                    + " bairro_cli, cidade_cli, estado_cli, cep_cli, rg_cli, cpf_cli, numero_cli, telefone_cli, email_cli) values ( "
                    + "'" + clienteDTO.getNome() + "', "
                    + "'" + clienteDTO.getLogradouro()+ "', "
                    + "'" + clienteDTO.getBairro()+ "', "
                    + "'" + clienteDTO.getCidade()+ "', "
                    + "'" + clienteDTO.getEstado()+ "', "
                    + "'" + clienteDTO.getCep()+ "', "
                    + "'" + clienteDTO.getRg()+ "', "
                    + "'" + clienteDTO.getCpf()+ "', "
                    + clienteDTO.getNumero()+ ","
                    + "'" + clienteDTO.getTelefone()+ "', "
                    + "'" + clienteDTO.getEmail()+"')";
            
            //Executa o comando SQL no banco de Dados
            stmt.execute(comando.toUpperCase());
            //Da um commit no banco de dados
            ConexaoDAO.con.commit();
            //Fecha o statement
            stmt.close();
            return true;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } //Independente de dar erro ou não ele vai fechar o banco de dados.
        finally {
            //Chama o metodo da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }
    }//Fecha o método inserirCliente
    
     public boolean alterarCliente(ClienteDTO clienteDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Update cliente set" 
                    + "nome_cli = '" + clienteDTO.getNome() + "', "
                    + "logradouro_cli = '" + clienteDTO.getLogradouro()+ "', "
                    + "bairro_cli = '" + clienteDTO.getBairro()+ "', "
                    + "cidade_cli = '" + clienteDTO.getCidade()+ "', "
                    + "estado_cli = '" + clienteDTO.getEstado()+ "', "
                    + "cep_cli = '" + clienteDTO.getCep()+ "', "
                    + "rg_cli = '" + clienteDTO.getRg()+ "', "
                    + "cpf_cli = '" + clienteDTO.getCpf()+ "', "
                    + "numero_cli = " + clienteDTO.getNumero()+", "
                    + "telefone_cli = '" + clienteDTO.getTelefone()+"', "
                    + "email_cli = '" + clienteDTO.getEmail()+"',"
                    + "where id_cliente = '" + clienteDTO.getId_cli();
                    
                       
            //Executa o comando SQL no banco de Dados
            stmt.execute(comando.toUpperCase());
            //Da um commit no banco de dados
            ConexaoDAO.con.commit();
            //Fecha o statement
            stmt.close();
            return true;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem 
          //no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } //Independente de dar erro ou não ele vai fechar o banco de dados.
        finally {
            //Chama o metodo da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }
    }//Fecha o método alterarCliente
    
     public boolean excluirCliente(ClienteDTO clienteDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Instancia o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Delete from cliente where id_cliente = " 
                             + clienteDTO.getId_cli();

            //Executa o comando SQL no banco de Dados
            stmt.execute(comando);
            //Da um commit no banco de dados
            ConexaoDAO.con.commit();
            //Fecha o statement
            stmt.close();
            return true;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } //Independente de dar erro ou não ele vai fechar o banco de dados.
        finally {
            //Chama o metodo da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }
    }//Fecha o método excluirCliente
    public ResultSet consultarCliente(ClienteDTO clienteDTO, int opcao) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "";
            switch (opcao){
                case 1:
                    comando = "Select c.* "+
                              "from cliente c "+
                              "where nome_cli like '" + clienteDTO.getNome()+ "%' " +
                              "order by c.nome_cli";    
                break;
                case 2:
                    comando = "Select c.* "+
                              "from cliente c " +
                              "where c.id_cliente = " + clienteDTO.getId_cli();
                break;
                case 3:
                    comando = "Select c.id_cliente, c.nome_cli "+
                              "from cliente c ";
                break; 
            }
            //Executa o comando SQL no banco de Dados
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }
    
    
    
    
    
    }
    

