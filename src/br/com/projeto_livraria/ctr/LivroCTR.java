/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_livraria.ctr;

import br.com.projeto_livraria.dao.LivroDAO;
import br.com.projeto_livraria.dao.ConexaoDAO;
import br.com.projeto_livraria.dto.LivroDTO;
import br.com.projeto_livraria.dto.EditoraDTO;
import java.sql.ResultSet;

/**
 *
 * @author guiva
 */
public class LivroCTR {
    
    LivroDAO livroDAO = new LivroDAO();

    public LivroCTR() {

    }

    public String inserirLivro(LivroDTO livroDTO, EditoraDTO editoraDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (livroDAO.inserirLivro(livroDTO, editoraDTO)) {
                return "Livro Cadastrado com Sucesso!!!";
            } else {
                return "Livro NÃO Cadastrado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
        //console com o que esta acontecendo.		
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Livro NÃO Cadastrado";
        }
    }

    public String alterarLivro(LivroDTO livroDTO, EditoraDTO editoraDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (livroDAO.alterarLivro(livroDTO, editoraDTO)) {
                return "Livro Alterado com Sucesso!!!";
            } else {
                return "Livro NÃO Alterado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
        //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Livro NÃO Alterado!!!";
        }
    }

    public String excluirLivro(LivroDTO livroDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (livroDAO.excluirProduto(livroDTO)) {
                return "Livro Excluído com Sucesso!!!";
            } else {
                return "Livro NÃO Excluído!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
        //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Livro NÃO Excluído!!!";
        }
    }

    public ResultSet consultarLivro(LivroDTO livroDTO, int opcao) {
        //É criado um atributo do tipo ResultSet, pois este método recebe o resultado de uma consulta.
        ResultSet rs = null;
        //O atributo rs recebe a consulta realizada pelo método da classe DAO
        rs = livroDAO.consultarLivro(livroDTO, opcao);
        return rs;
    }

    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }

}
