/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_livraria.dto;

/**
 *
 * @author guiva
 */
public class LivroDTO {

    /**
     * @return the custo
     */
    public double getCusto() {
        return custo;
    }

    /**
     * @param custo the custo to set
     */
    public void setCusto(double custo) {
        this.custo = custo;
    }

    /**
     * @return the valor_custo
     */
  
    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    private int id_livro;
    private String nome_livro;
    private String genero_livro;
    private String autor_livro;
    private int isbn_livro;
    private int num_paginas_livro;
    private int ano_livro;
    private double custo;
    private double valor;

    /**
     * @return the id_livro
     */
    public int getId_livro() {
        return id_livro;
    }

    /**
     * @param id_livro the id_livro to set
     */
    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }

    /**
     * @return the nome_livro
     */
    public String getNome_livro() {
        return nome_livro;
    }

    /**
     * @param nome_livro the nome_livro to set
     */
    public void setNome_livro(String nome_livro) {
        this.nome_livro = nome_livro;
    }

    /**
     * @return the genero_livro
     */
    public String getGenero_livro() {
        return genero_livro;
    }

    /**
     * @param genero_livro the genero_livro to set
     */
    public void setGenero_livro(String genero_livro) {
        this.genero_livro = genero_livro;
    }

    /**
     * @return the autor_livro
     */
    public String getAutor_livro() {
        return autor_livro;
    }

    /**
     * @param autor_livro the autor_livro to set
     */
    public void setAutor_livro(String autor_livro) {
        this.autor_livro = autor_livro;
    }

    /**
     * @return the isbn_livro
     */
    public int getIsbn_livro() {
        return isbn_livro;
    }

    /**
     * @param isbn_livro the isbn_livro to set
     */
    public void setIsbn_livro(int isbn_livro) {
        this.isbn_livro = isbn_livro;
    }

    /**
     * @return the num_paginas_livro
     */
    public int getNum_paginas_livro() {
        return num_paginas_livro;
    }

    /**
     * @param num_paginas_livro the num_paginas_livro to set
     */
    public void setNum_paginas_livro(int num_paginas_livro) {
        this.num_paginas_livro = num_paginas_livro;
    }

    /**
     * @return the ano_livro
     */
    public int getAno_livro() {
        return ano_livro;
    }

    /**
     * @param ano_livro the ano_livro to set
     */
    public void setAno_livro(int ano_livro) {
        this.ano_livro = ano_livro;
    }

   
}
