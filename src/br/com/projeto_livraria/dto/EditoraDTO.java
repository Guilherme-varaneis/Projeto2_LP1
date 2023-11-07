/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_livraria.dto;

/**
 *
 * @author guiva
 */
public class EditoraDTO {
     private String nome_ed;
    private String email_ed;
    private String telefone_ed;
    private String cidade;
    private String estado;
    private String pais;
    private int id_ed;

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the país
     */

    /**
     * @return the nome_ed
     */
    public String getNome_ed() {
        return nome_ed;
    }

    /**
     * @param nome_ed the nome_ed to set
     */
    public void setNome_ed(String nome_ed) {
        this.nome_ed = nome_ed;
    }

    /**
     * @return the email_ed
     */
    public String getEmail_ed() {
        return email_ed;
    }

    /**
     * @param email_ed the email_ed to set
     */
    public void setEmail_ed(String email_ed) {
        this.email_ed = email_ed;
    }

    /**
     * @return the telefone_ed
     */
    public String getTelefone_ed() {
        return telefone_ed;
    }

    /**
     * @param telefone_ed the telefone_ed to set
     */
    public void setTelefone_ed(String telefone_ed) {
        this.telefone_ed = telefone_ed;
    }

    /**
     * @return the id_ed
     */
    public int getId_ed() {
        return id_ed;
    }

    /**
     * @param id_ed the id_ed to set
     */
    public void setId_ed(int id_ed) {
        this.id_ed = id_ed;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }
}
