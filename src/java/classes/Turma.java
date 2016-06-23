/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author 0369152
 */
public class Turma { 
    private Professor professor;
    private Curso curso;
    private Date data_inicio;
    private Date data_fim;
    private int carga_horaria;

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    public int getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(int carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public Turma() {
    }

    public Turma(Professor professor, Curso curso, Date data_inicio, Date data_fim, int carga_horaria) {
        this.professor = professor;
        this.curso = curso;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.carga_horaria = carga_horaria;
    }
    
    
    
    
    
     
}
