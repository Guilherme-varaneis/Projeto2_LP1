/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_livraria.dao;
import br.com.projeto_livraria.dto.EditoraDTO;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author guiva
 */
public class EditoraDAO {
    public EditoraDAO(){
        
    }
    
     private ResultSet rs = null;
    //Manipular o banco de dados
    private Statement stmt = null;
    
    
    /**
     * Método utilizado para inserir um objeto editoraDTO no banco de dados
     *
     * @param editoraDTO, que vem da classe EditoraCTR
     * @return Um boolean
     */
    public boolean inserirEditora(EditoraDTO editoraDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Instancia o Statement que sera responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Insert into editora (nome_ed, email_ed, "
                    + "telefone_ed ,cidade_ed, estado_ed, pais_ed) values ( "
                    + "'" + editoraDTO.getNome_ed()+ "', "
                    + "'" + editoraDTO.getEmail_ed()+ "', "
                    + "'" + editoraDTO.getTelefone_ed() + "', "
                    + "'" + editoraDTO.getCidade()+ "', "
                    + "'" + editoraDTO.getEstado()+ "', "
                    + "'" + editoraDTO.getPais() + "')";
                    
                   
            
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
    }
    
    
    /**
     * Método utilizado para alterar um objeto editoraDTO no banco de dados
     *
     * @param editoraDTO, que vem da classe EditoraCTR
     * @return Um boolean
     */
    public boolean alterarEditora(EditoraDTO editoraDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Update editora set "
                    + "nome_ed = '" + editoraDTO.getNome_ed()+ "', "
                    + "email_ed = '" + editoraDTO.getEmail_ed()+ "', "
                    + "telefone_ed = '" + editoraDTO.getTelefone_ed()+ "',"
                    + "cidade_ed = '" + editoraDTO.getCidade()+ "', "
                    + "estado_ed = '" + editoraDTO.getEstado() + "', "
                    + "pais_ed = '" + editoraDTO.getPais() + ", "
                    + "where id_ed = " + editoraDTO.getId_ed();                   
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
    }
    
    
    /**
     * Método utilizado para excluir um objeto editoraDTO no banco de dados
     *
     * @param editoraDTO que vem da classe EditoraCTR
     * @return Um boolean
     */
    public boolean excluirEditora(EditoraDTO editoraDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Instancia o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Delete from editora where id_ed = " 
                             + editoraDTO.getId_ed();

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
    }
    
        
    
    /**
     * Método utilizado para consultar um objeto editoraDTO no banco de dados
     *
     * @param editoraDTO, que vem da classe EditoraCTR
     * @param opcao, que vem da classe EditoraCTR
     * @return Um ResultSet com os dados do editora
     */
    public ResultSet consultarEditora(EditoraDTO editoraDTO, int opcao) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "";
             switch (opcao){
                case 1:
                     comando = "Select e.id_ed, e.nome_ed "+
                              "from editora e "+
                              "where e.nome_ed ilike '" + editoraDTO.getNome_ed()+ "%' " +
                              "order by e.nome_ed";    
                break;
                case 2:
                    comando = "Select e.nome_ed, e.email_ed, e.telefone_ed, e.cidade_ed, e.estado_ed, e.pais_ed  "+
                              "from editora e " +
                              "where e.id_ed = " + editoraDTO.getId_ed();
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


