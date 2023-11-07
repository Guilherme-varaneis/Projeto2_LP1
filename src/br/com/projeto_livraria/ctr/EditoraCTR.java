/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_livraria.ctr;
import br.com.projeto_livraria.dao.EditoraDAO;
import br.com.projeto_livraria.dto.EditoraDTO;
import br.com.projeto_livraria.dao.ConexaoDAO;
import java.sql.ResultSet;
/**
 *
 * @author guiva
 */
public class EditoraCTR {
    EditoraDAO editoraDAO = new EditoraDAO();
    public EditoraCTR(){
        
    }
     public String inserirEditora(EditoraDTO editoraDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (editoraDAO.inserirEditora(editoraDTO)) {
                return "Editora Cadastrada com Sucesso!!!";
            } else {
                return "Editora NÃO Cadastrada!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.		
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Editora NÃO Cadastrado";
        }
    }
     
      public String alterarEditora(EditoraDTO editoraDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (editoraDAO.alterarEditora(editoraDTO)) {
                return "Editora Alterada com Sucesso!!!";
            } else {
                return "Editora NÃO Alterada!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Editora NÃO Alterada!!!";
        }
    }
     
      public String excluirEditora(EditoraDTO editoraDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (editoraDAO.excluirEditora(editoraDTO)) {
                return "Editora Excluída com Sucesso!!!";
            } else {
                return "Editora NÃO Excluída!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Editora NÃO Excluído!!!";
        }
      }
     public ResultSet consultarEditora(EditoraDTO editoraDTO, int opcao) {
        //É criado um atributo do tipo ResultSet, pois este método recebe o resultado de uma consulta.
        ResultSet rs = null;
        //O atributo rs recebe a consulta realizada pelo método da classe DAO
        rs = editoraDAO.consultarEditora(editoraDTO, opcao);
        return rs;
    }
      public void CloseDB() {
        ConexaoDAO.CloseDB();
    }
    
}

