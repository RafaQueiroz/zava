/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author 0369152
 */
public class Professor{
    private String nome;
    private String email;
    private int valor_hora;
    private String certificados;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getValor_hora() {
        return valor_hora;
    }

    public void setValor_hora(int valor_hora) {
        this.valor_hora = valor_hora;
    }

    public String getCertificados() {
        return certificados;
    }

    public void setCertificados(String certificados) {
        this.certificados = certificados;
    }

    public Professor() {
    }

    public Professor(String nome, String email, int valor_hora, String certificados) {
        this.nome = nome;
        this.email = email;
        this.valor_hora = valor_hora;
        this.certificados = certificados;
    }
      
    
    
    
    
}
