
package classes;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author 0369152
 */
public class Turma { 
    private int id;
    private Professor professor;
    private Curso curso;
    private String dataInicio;
    private String dataFim;
    private int cargaHoraria;
    private List<Aluno> alunos;

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    
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

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    
    public Turma() {
    }

    public Turma(Professor professor, Curso curso, String dataInicio, String dataFim, int cargaHoraria) {
        this.professor = professor;
        this.curso = curso;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.cargaHoraria = cargaHoraria;
    }
    
    
    public Turma(int idProfessor, int idCurso, String dataInicio, String dataFim, int cargaHoraria) {
        Professor professor = new Professor();
        Curso curso = new Curso();
        
        professor = DAO.getProfessorById(idProfessor);
        curso = DAO.getCursoById(idCurso);
        
        this.professor = professor;
        this.curso = curso;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.cargaHoraria = cargaHoraria;
    }

    
    
    
    
    
    
     
}
