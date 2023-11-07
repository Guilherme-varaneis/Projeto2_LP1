/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_livraria.dao;

import br.com.projeto_livraria.dto.PedidoDTO;
import br.com.projeto_livraria.dto.ClienteDTO;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;

/**
 *
 * @author guiva
 */
public class PedidoDAO {

    public PedidoDAO() {

    }
    private ResultSet rs = null;
    Statement stmt = null;
    Statement stmt1 = null;

    public boolean inserirPedido(PedidoDTO pedidoDTO, ClienteDTO clienteDTO, JTable livros) {
        try {

            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            stmt1 = ConexaoDAO.con.createStatement();

            //comando SQL que sera executado no banco de dados
            String comando1 = "Insert into pedido (valor_ped, "
                    + "id_cliente)values ( "
                    + pedidoDTO.getValor_ped() + ","
                    + clienteDTO.getId_cli() + ")";

            //Executa o comando SQL no banco de Dados
            stmt.execute(comando1.toUpperCase(), Statement.RETURN_GENERATED_KEYS);
            rs = stmt.getGeneratedKeys();
            rs.next();

            for (int cont = 0; cont < livros.getRowCount(); cont++) {
                String comando2 = "Insert into pedido_livro (id_ped, id_livro, "
                        + "val_livro , qtd_livro) values ("
                        + rs.getInt("id_ped") + ","
                        + livros.getValueAt(cont, 0) + ", "
                        + livros.getValueAt(cont, 2) + ", "
                        + livros.getValueAt(cont, 3) + ");";
                stmt.execute(comando2);

            }
            //Da um commit no banco de dados
            ConexaoDAO.con.commit();
            //Fecha o statement
            stmt.close();
            stmt1.close();
            rs.close();
            return true;

        }//Caso tenha algum erro no codigo acima enviando uma mensaggem no console
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }// independente e dar erro ou nao ele vai fechar o banco de dados.
        finally {
            //Chama o metodo da classe CONEXAODAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }
    } //fecha chave do boolean

}
