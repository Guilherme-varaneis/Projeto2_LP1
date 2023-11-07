/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_livraria.ctr;
import br.com.projeto_livraria.dao.FuncionarioDAO;
import br.com.projeto_livraria.dao.ConexaoDAO;
import br.com.projeto_livraria.dto.FuncionarioDTO;
import java.sql.ResultSet;

/**
 *
 * @author guiva
 */
public class FuncionarioCTR {
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    public FuncionarioCTR(){
    }
     public String inserirFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (funcionarioDAO.inserirFuncionario(funcionarioDTO)) {
                return "Funcionario Cadastrado com Sucesso!!!";
            } else {
                return "Funcionario NÃO Cadastrado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.		
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Funcionario NÃO Cadastrado";
        }
    }//Fecha o método inserirFuncionario
    
    
    /**
     * Método utilizado para controlar o acesso ao método alterarFuncionario da
     * classe FuncionarioDAO
     *
     * @param funcionarioDTO, que vem da classe da página (VIEW) 
     * @return String contendo a mensagem
     */
    public String alterarFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (funcionarioDAO.alterarFuncionario(funcionarioDTO)) {
                return "Funcionario Alterado com Sucesso!!!";
            } else {
                return "Funcionario NÃO Alterado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Funcionario NÃO Alterado!!!";
        }
    }//Fecha o método alterarFuncionario

    
    /**
     * Método utilizado para controlar o acesso ao método excluirFuncionario da
     * classe FuncionarioDAO
     *
     * @param funcionarioDTO que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String excluirFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (funcionarioDAO.excluirFuncionario(funcionarioDTO)) {
                return "Funcionario Excluído com Sucesso!!!";
            } else {
                return "Funcionario NÃO Excluído!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Funcionario NÃO Excluído!!!";
        }
    }//Fecha o método excluirFuncionario

    
    /**
     * Método utilizado para controlar o acesso ao método consultarFuncionario da
     * classe FuncionarioDAO
     *
     * @param funcionarioDTO que vem da classe da página (VIEW)
     * @param opcao que vem da classe da página (VIEW)
     * @return ResultSet com os dados do funcionario
     */
    public ResultSet consultarFuncionario(FuncionarioDTO funcionarioDTO, int opcao) {
        //É criado um atributo do tipo ResultSet, pois este método recebe o resultado de uma consulta.
        ResultSet rs = null;
        //O atributo rs recebe a consulta realizada pelo método da classe DAO
        rs = funcionarioDAO.consultarFuncionario(funcionarioDTO, opcao);
        return rs;
    }//Fecha o método consultarFuncionario
    public String logarFuncionario(FuncionarioDTO funcionarioDTO){
            return  funcionarioDAO.logarFuncionario(funcionarioDTO);
    }
    
    /**
     * Método utilizado para fechar o banco de dados
     */
    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }//Fecha o método CloseDB
    
}
    

