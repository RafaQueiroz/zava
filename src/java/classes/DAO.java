/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author rafael
 */
public class DAO {
    private static List<Aluno> alunos;
    private static List<Curso> cursos;
    private static List<Professor> professores;
    private static List<Turma> turmas;

    public static List<Aluno> getAlunos() throws SQLException {
        alunos = new ArrayList<Aluno>();
        
        Conexao con = new Conexao();
        ResultSet res = con.busca("select * from alunos");
        while(res.next()){
            Aluno aluno = new Aluno();
            aluno.setId(res.getInt("id"));
            aluno.setCpf(res.getString("cpf"));
            aluno.setNome(res.getString("nome"));
            aluno.setEmail(res.getString("email"));
            aluno.setTelefone(res.getString("fone"));
            aluno.setSenha(res.getString("senha"));
            alunos.add(aluno);
    }
        
        return alunos;
    }

    public static List<Curso> getCursos() throws SQLException {
        cursos = new ArrayList<Curso>();
        
        Conexao con = new Conexao();
        ResultSet res = con.busca("select * from cursos");
        
        while(res.next()){
            Curso curso = new Curso();
            curso.setId(res.getInt("id"));
            curso.setNome(res.getString("nome"));
            curso.setCarga_horaria(res.getInt("carga_horaria"));
            curso.setPreco(res.getInt("preco"));
            curso.setRequisito(res.getString("requisito"));
            cursos.add(curso);
        }
        return cursos;
    }

    public static List<Professor> getProfessores() throws SQLException {
        professores = new ArrayList<Professor>();
        Conexao con = new Conexao();
        ResultSet res = con.busca("select * from instrutores");
        
        while(res.next()){
            Professor professor = new Professor();
            
            professor.setId(res.getInt("id"));
            professor.setNome(res.getString("nome"));
            professor.setEmail(res.getString("email"));
            professor.setSenha(res.getString("senha"));
            professor.setCertificados(res.getString("certificados"));
            professor.setValor_hora(res.getInt("valor_hora"));
            professores.add(professor);
        }
        return professores;
    }

    public static List<Turma> getTurmas() throws SQLException {
        turmas = new ArrayList<Turma>();
        Conexao con = new Conexao();
        ResultSet res = con.busca("select * from turmas");
        
        while(res.next()){
            Curso curso = new Curso();
            Professor professor = new Professor();
            curso = DAO.getCursoById(res.getInt("cursos_id"));
            professor = DAO.getProfessorById(res.getInt("instrutores_id"));
            
            Turma turma = new Turma();
            
            turma.setId(res.getInt("id"));
            turma.setProfessor(professor);
            turma.setCurso(curso);
            String data = res.getString("data_inicio");
            turma.setDataInicio(data);
            data = res.getString("data_fim");
            turma.setDataInicio(data);
            turma.setCargaHoraria(res.getInt("carga_horaria"));
            turmas.add(turma);
        }
        return turmas;
    }
    
    //Operções de inserção
    public static void insereAluno(Aluno aluno) throws SQLException{
        Conexao con = new Conexao();
        String query ="insert into alunos "
                + "values(salunos.nextval, '"+aluno.getCpf()+"','"+aluno.getNome()+"','"
                +aluno.getEmail()+"','"+aluno.getTelefone()+"',to_date('"+aluno.getDataNasc()+"','dd/mm/yy'),'"
                +aluno.getSenha()+"');";
        System.out.println(query);
        con.executaQuery(query);
        System.out.println("Insere Aluno!");
    }
    
    public static void insereInstrutor(Professor professor) throws SQLException{
        Conexao con = new Conexao();
        
        String query ="insert into instrutores   values(sintrutores.nextval,'"+professor.getNome()
                        +"','"+professor.getEmail()+"',"+professor.getValor_hora()+",'"
                        +professor.getCertificados()+"','"+professor.getSenha()+"')";
        
        System.out.println(query);
        con.executaQuery(query);
        System.out.println("Insere Instrutor!");
    }
    
    public static void insereCurso(Curso curso) throws SQLException{
        Conexao con = new Conexao();
        String query ="insert into cursos values(scursos.nextval,'"+curso.getNome()+"','"
                +curso.getRequisito()+"',"+curso.getCarga_horaria()+","+curso.getPreco()+")";

        System.out.println(query);
        con.executaQuery(query);
        System.out.println("Insere Curso!");
    }
    
    public static void insereturma(Turma turma) throws SQLException{
        Conexao con = new Conexao();
        String query ="insert into turmas values(sturmas.nextval,'"+turma.getProfessor().getId()+"','"
                +turma.getCurso().getId()+"',to_date('"+turma.getDataInicio()+"','dd/mm/yy'),to_date('"+turma.getDataFim()+"','dd/mm/yy'),"+turma.getCargaHoraria()+")";

        System.out.println(query);
        con.executaQuery(query);
        System.out.println("Insere Curso!");
    }
    
    public static void insereMatricula(Matricula matricula) throws SQLException{
        Conexao con = new Conexao();
        String query ="insert into matriculasvalues(smatriculas.nextval,'"+matricula.getTurma().getId()+"',"
                +matricula.getAluno().getId()+", sysdate)";
        
        System.out.println(query);
        con.executaQuery(query);
        System.out.println("Insere Matricula!");
    }
    
    
    
    
    
    //get by id
    public static Aluno getAlunoById(int id){
        Aluno alunoSaida = new Aluno();
        for(Aluno aluno : alunos){
            if(aluno.getId() == id){
                alunoSaida = aluno;
                break;
            }
        }
        return alunoSaida;
    }
    public static Curso getCursoById(int id){
        Curso cursoSaida = new Curso();
        for(Curso curso : cursos){
            if(curso.getId() == id){
                cursoSaida = curso;
                break;
            }
        }
        return cursoSaida;
    }
    public static Professor getProfessorById(int id){
        Professor professorSaida = new Professor();
        for(Professor professor : professores){
            if(professor.getId() == id){
                professorSaida = professor;
                break;
            }
        }
        return professorSaida;
    }
    public static Turma getTurmaById(int id){
        Turma turmaSaida = new Turma();
        for(Turma turma : turmas){
            if(turma.getId() == id){
                turmaSaida = turma;
                break;
            }
        }
        return turmaSaida;
    }
    
}
