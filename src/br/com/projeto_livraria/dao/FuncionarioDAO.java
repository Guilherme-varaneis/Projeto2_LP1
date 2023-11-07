/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_livraria.dao;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import br.com.projeto_livraria.dto.FuncionarioDTO;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Clock;

/**
 *
 * @author guiva
 */
public class FuncionarioDAO {
    
    /**
     * Método construtor da classe
     */
    public FuncionarioDAO() {
    }

    //Atributo do tipo ResultSet utilizado para realizar consultas
    private ResultSet rs = null;
    //Manipular o banco de dados
    private Statement stmt = null;
    
    
    /**
     * Método utilizado para inserir um objeto funcionarioDTO no banco de dados
     *
     * @param funcionarioDTO, que vem da classe FuncionarioCTR
     * @return Um boolean
     */
    public boolean inserirFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Instancia o Statement que sera responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Insert into funcionario (nome_fun, login_fun, cpf_fun, "
                    + "senha_fun, tipo_fun) values ( "
                    + "'" + funcionarioDTO.getNome_fun().toUpperCase()+ "', "
                    + "'" + funcionarioDTO.getLogin_fun()+ "', "
                    + "'" + funcionarioDTO.getCpf_fun()+ "', "
                    + "'" + criptografar(funcionarioDTO.getSenha_fun()) + "',"
                    + "'" + funcionarioDTO.getTipo_fun().toUpperCase()+"') ";
               
            
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
    }//Fecha o método inserirFuncionario
    
    
    /**
     * Método utilizado para alterar um objeto funcionarioDTO no banco de dados
     *
     * @param funcionarioDTO, que vem da classe FuncionarioCTR
     * @return Um boolean
     */
    public boolean alterarFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Update funcionario set "
                    + "nome_fun = '" + funcionarioDTO.getNome_fun().toUpperCase()+ "', "
                    + "login_fun = '" + funcionarioDTO.getLogin_fun()+ "', "
                    + "cpf_fun = '" + funcionarioDTO.getCpf_fun()+ "', ";
                    
                    if(funcionarioDTO.getSenha_fun()!= null){
                        comando+= "senha_fun = '" +criptografar(funcionarioDTO.getSenha_fun()) + "', ";
                    }
                    comando+="tipo_fun = '"+ funcionarioDTO.getTipo_fun().toUpperCase() + "'"
                    + "where id_fun = " + funcionarioDTO.getId_fun();
                       
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
    }//Fecha o método alterarFuncionario
    
    
    /**
     * Método utilizado para excluir um objeto funcionarioDTO no banco de dados
     *
     * @param funcionarioDTO que vem da classe FuncionarioCTR
     * @return Um boolean
     */
    public boolean excluirFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Instancia o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Delete from funcionario where id_fun = " 
                             + funcionarioDTO.getId_fun();

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
    }//Fecha o método excluirFuncionario
    
        
    
    /**
     * Método utilizado para consultar um objeto funcionarioDTO no banco de dados
     *
     * @param funcionarioDTO, que vem da classe FuncionarioCTR
     * @param opcao, que vem da classe FuncionarioCTR
     * @return Um ResultSet com os dados do funcionario
     */
    public ResultSet consultarFuncionario(FuncionarioDTO funcionarioDTO, int opcao) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "";
            switch (opcao){
                case 1:
                    comando = "Select f.* "+
                              "from funcionario f "+
                              "where nome_fun like '" + funcionarioDTO.getNome_fun()+ "%' " +
                              "order by f.nome_fun";    
                break;
                case 2:
                    comando = "Select f.* "+
                              "from funcionario f " +
                              "where f.id_fun = " + funcionarioDTO.getId_fun();
                break;
                case 3:
                    comando = "Select f.id_fun, f.nome_fun "+
                              "from funcionario f ";
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
public String logarFuncionario(FuncionarioDTO funcionarioDTO){
       try{ 
           ConexaoDAO.ConectDB();
       
       stmt = ConexaoDAO.con.createStatement();
       
       String comando = "Select f.tipo_fun " + 
                        "from funcionario f "+
                        "where f.login_fun = '" + funcionarioDTO.getLogin_fun()+"'"+
                        "and f.senha_fun = '" + criptografar(funcionarioDTO.getSenha_fun())+"'";
       rs = null;
       rs = stmt.executeQuery(comando);
       if(rs.next()){
           return rs.getString("tipo_fun");
       }else{
        return "";
       }
}catch(Exception e){
           System.out.println(e.getMessage());
           return "";
}finally{
           ConexaoDAO.CloseDB();
       }
}
       private static MessageDigest md  = null;
       static{
           try{
               md = MessageDigest.getInstance("MD5");
           }catch (NoSuchAlgorithmException ex){
               ex.printStackTrace();
           }
       }
       private static char[] hexCodes(byte[]text){
           char[] hexOutput = new char  [text.length * 3];
           String hexString;
           
           for (int i = 0; i< text.length; i++){
               hexString = "00" + Integer.toHexString(text[i]);
               hexString.toUpperCase().getChars(hexString.length() - 3, hexString.length(), hexOutput, i * 3);
             }
            return hexOutput;
       }
       public static String criptografar(String pwd){
            if(md != null){
                return new String (hexCodes(md.digest(pwd.getBytes())));
            }
            return null;
       }
      
}//Fecha classe FuncionarioDAO

    

