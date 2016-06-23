/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.Date;

/**
 *
 * @author rafael
 */
public class Matricula {
    private Turma turma;
    private Aluno aluno;
    private Date data_matricula;

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Date getData_matricula() {
        return data_matricula;
    }

    public void setData_matricula(Date data_matricula) {
        this.data_matricula = data_matricula;
    }

    public Matricula() {
    }

    public Matricula(Turma turma, Aluno aluno, Date data_matricula) {
        this.turma = turma;
        this.aluno = aluno;
        this.data_matricula = data_matricula;
    }
    
    
}
