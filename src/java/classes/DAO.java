/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
    
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private static List<Usuario> usuarios;

    public static List<Aluno> getAlunos() throws SQLException {
        alunos = new ArrayList<Aluno>();
        Conexao con = new Conexao();
        ResultSet res = con.busca("select * from usuarios;");
        while(res.next()){
            Aluno aluno = new Aluno();
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
            curso.setNome(res.getString("nome"));
            curso.setCarga_horaria(res.getInt("carga_horaria"));
            curso.setPreco(res.getInt("preco"));
            curso.setRequisito(res.getString("requisitos"));
            cursos.add(curso);
        }
        con.close();
        return cursos;
    }

    public static List<Professor> getProfessores() {
        professores = new ArrayList<Professor>();
        
        return professores;
    }

    public static List<Usuario> getUsuarios() {
        return usuarios;
    }
    
    
    
}
