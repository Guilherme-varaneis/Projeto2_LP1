/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_livraria.ctr;
import br.com.projeto_livraria.dao.PedidoDAO;
import br.com.projeto_livraria.dto.PedidoDTO;
import br.com.projeto_livraria.dto.ClienteDTO;
import javax.swing.JTable;
/**
 *
 * @author guiva
 */
public class PedidoCTR {
    PedidoDAO pedidoDAO = new PedidoDAO();
    
    public PedidoCTR(){
        
    }
    
    public String inserirPedido(PedidoDTO pedidoDTO, ClienteDTO clienteDTO, JTable livros) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (pedidoDAO.inserirPedido(pedidoDTO, clienteDTO, livros)) {
                return "Pedido Cadastrado com Sucesso!!!";
            } else {
                return "Pedido NÃO Cadastrado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
        //console com o que esta acontecendo.		
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Pedido NÃO Cadastrado";
        }
    }
}
