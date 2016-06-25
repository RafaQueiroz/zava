/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Calendar;

/**
 *
 * @author 0369152
 */
public class Curso {
    private int id;
    private String nome;
    private String requisito;
    private int carga_horaria;
    private int preco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRequisito() {
        return requisito;
    }

    public void setRequisito(String requisito) {
        this.requisito = requisito;
    }

    public int getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(int carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public Curso(String nome, String requisito, int carga_horaria, int preco) {
        this.nome = nome;
        this.requisito = requisito;
        this.carga_horaria = carga_horaria;
        this.preco = preco;
    }
    public Curso(){
        
    }
    
    
    
    
    
    
    
}
