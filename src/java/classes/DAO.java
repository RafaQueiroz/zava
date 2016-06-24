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
        ResultSet res = con.busca("select * from usuarios;");
        while(res.next()){
            Aluno aluno = new Aluno();
            aluno.setId(res.getInt("id"));
            aluno.setNome(res.getString("nome"));
            aluno.setEmail(res.getString("email"));
            aluno.setSenha(res.getString("senha"));
            aluno.setCpf(res.getString("cpf"));
            aluno.setTelefone(res.getString("telefone"));
            alunos.add(aluno);
    }
        con.close();
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
        con.close();
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
        con.close();
        return professores;
    }
    
    public static void insereUsuario(Usuario usuario) throws SQLException{
        Conexao con = new Conexao();
        String query ="insert into Alunos "
                + "values(susuarios.nextval, '"+usuario.getNome()
                +"','"+usuario.getEmail()+"','"+usuario.getCpf()+"','"
                + usuario.getSenha()+"');";
        Statement stm = con.getStm();
        stm.execute(query);
        con.getCon().commit();
        con.close();
    }
    
    public static void insereInstrutor(Professor professor) throws SQLException{
        Conexao con = new Conexao();
        String query ="insert into professor "
                + "values(scursos.nextval, '"+professor.getNome()
                +"','"+professor.getEmail()+"',"+professor.getValor_hora()+",'"
                +"','"+professor.getCertificados()+ professor.getSenha()+"');";
        Statement stm = con.getStm();
        stm.execute(query);
        con.getCon().commit();
        con.close();
    }
    
    public static void insereCurso(Curso curso) throws SQLException{
        Conexao con = new Conexao();
        String query ="insert into professor "
                + "values(sprofessores.nextval, '"+curso.getNome()
                +"','"+curso.getRequisito()+"',"+curso.getCarga_horaria()+",'"
                +"',"+curso.getPreco()+");";
        Statement stm = con.getStm();
        stm.execute(query);
        con.getCon().commit();
        con.close();
    }
    
}
