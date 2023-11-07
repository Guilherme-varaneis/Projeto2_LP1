/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_livraria.dto;

/**
 *
 * @author guiva
 */
public class PedidoDTO {

    /**
     * @return the valor_ped
     */
    public double getValor_ped() {
        return valor_ped;
    }

    
    public void setValor_ped(double valor_ped) {
        this.valor_ped = valor_ped;
    }
    private int id_ped;
    private double valor_ped;

    /**
     * @return the id_ped
     */
    public int getId_ped() {
        return id_ped;
    }

    /**
     * @param id_ped the id_ped to set
     */
    public void setId_ped(int id_ped) {
        this.id_ped = id_ped;
    }

}  
   
