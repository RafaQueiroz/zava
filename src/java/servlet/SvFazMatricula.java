/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import classes.Aluno;
import classes.DAO;
import classes.Matricula;
import classes.Turma;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author rafael
 */
@WebServlet(name = "SvFazMatricula", urlPatterns = {"/SvFazMatricula"})
public class SvFazMatricula extends HttpServlet {

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Aluno aluno = new Aluno();
        aluno = (Aluno) request.getSession().getAttribute("aluno");
        
        int idTurma = Integer.parseInt(request.getParameter("tumra"));
        int idAluno = aluno.getId();
        Turma turma = DAO.getTurmaById(idTurma);
        
        Matricula matricula = new Matricula(turma, aluno);
        try {
            DAO.insereMatricula(matricula);
        } catch (SQLException ex) {
            Logger.getLogger(SvFazMatricula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
