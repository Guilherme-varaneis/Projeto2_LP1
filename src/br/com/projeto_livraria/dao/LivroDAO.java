/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_livraria.dao;

import br.com.projeto_livraria.dto.LivroDTO;
import br.com.projeto_livraria.dto.EditoraDTO;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author guiva
 */
public class LivroDAO {

    public LivroDAO() {

    }
    private ResultSet rs = null;
    private Statement stmt = null;

    public boolean inserirLivro(LivroDTO livroDTO, EditoraDTO editoraDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Instancia o Statement que sera responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Insert into livro (nome_livro, genero_livro, "
                    + "autor_livro, isbn_livro,num_paginas_livro, valor_livro, custo_livro, ano_livro, id_ed) values ( "
                    + "'" + livroDTO.getNome_livro()+ "', "
                    + "'" + livroDTO.getGenero_livro() + "', "
                    + "'" + livroDTO.getAutor_livro() + "', "
                    + livroDTO.getIsbn_livro() + ", "
                    + livroDTO.getNum_paginas_livro() + ", "
                    + livroDTO.getValor() + ", "
                    + livroDTO.getCusto() + ", "
                    + livroDTO.getAno_livro() + ", "
                    + editoraDTO.getId_ed() + ") ";

            stmt.execute(comando.toUpperCase());

            ConexaoDAO.con.commit();

            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {

            ConexaoDAO.CloseDB();
        }
    }

    public boolean alterarLivro(LivroDTO livroDTO, EditoraDTO editoraDTO) {
        try {

            ConexaoDAO.ConectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = "Update livro set "
                    + "nome_livro = '" + livroDTO.getNome_livro() + "', "
                    + "genero_livro = '" + livroDTO.getGenero_livro() + "', "
                    + "autor_livro = '" + livroDTO.getAutor_livro() + "', "
                    + "isbn_livro = " + livroDTO.getIsbn_livro() + ", "
                    + "num_paginas_livro = " + livroDTO.getNum_paginas_livro() + ", "
                    + "custo_livro = " + livroDTO.getCusto() + ", "
                    + "valor_livro = " + livroDTO.getValor() + ", "
                    + "ano_livro = " + livroDTO.getAno_livro() + ", "
                    + "id_ed = " + editoraDTO.getId_ed() + " "
                    + "where id_livro = " + livroDTO.getId_livro();

            stmt.execute(comando.toUpperCase());

            ConexaoDAO.con.commit();

            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {

            ConexaoDAO.CloseDB();
        }
    }

    public ResultSet consultarLivro(LivroDTO livroDTO, int opcao) {
        try {

            ConexaoDAO.ConectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = "";
            switch (opcao) {
                case 1:
                    comando = "Select l.* "
                            + "from livro l "
                            + "where l.nome_livro ilike '" + livroDTO.getNome_livro() + "%' "
                            + "order by l.nome_livro";
                    break;
                case 2:
                    comando = "Select l.*, e.nome_ed, e.id_ed "+
                              "from livro l, editora e " +
                              "where l.id_ed = e.id_ed and " +
                              "l.id_livro = " + livroDTO.getId_livro();
                    break;

            }
            //Executa o comando SQL no banco de Dados
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }

    public boolean excluirProduto(LivroDTO livroDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Instancia o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Delete from livro where id_livro = "
                    + livroDTO.getId_livro();
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
}
