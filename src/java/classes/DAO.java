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
        ResultSet res = con.busca("select * from cursos;");
        
        while(res.next()){
            Curso curso = new Curso();
            curso.setId(res.getInt("id"));
            curso.setNome(res.getString("nome"));
            curso.setCarga_horaria(res.getInt("carga_horaria"));
            curso.setPreco(res.getInt("preco"));
            curso.setRequisito(res.getString("requisitos"));
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
        }
        return professores;
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
        
        String query ="insert into professor "
                + "values(scursos.nextval, '"+professor.getNome()
                +"','"+professor.getEmail()+"',"+professor.getValor_hora()+",'"
                +"','"+professor.getCertificados()+ professor.getSenha()+"')";
        
        System.out.println(query);
        con.executaQuery(query);
        System.out.println("Insere Instrutor!");
    }
    
    public static void insereCurso(Curso curso) throws SQLException{
        Conexao con = new Conexao();
        String query ="insert into cursos values(scursos.nextval,'"+curso.getNome()+"','"+curso.getRequisito()+"',"+curso.getCarga_horaria()+","+curso.getPreco()+")";
//        String query ="insert into cursos values(scursos.nextvalue,'"+curso.getNome()+"','"+curso.getRequisito()+"',"+curso.getCarga_horaria()+",400)";
        System.out.println(query);
        con.executaQuery(query);
        System.out.println("Insere Curso!");
    }
    
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
    
}
