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
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
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
        
        HttpSession httpSession = request.getSession(true);
        aluno = (Aluno) httpSession.getAttribute("aluno");
        
        int idTurma = Integer.parseInt(request.getParameter("turma"));
        System.out.println(aluno.getNome()+" "+idTurma);
        
        Turma turma = new Turma();
        try {
            DAO.getProfessores();
            DAO.getCursos();
            DAO.getTurmas();
            turma = DAO.getTurmaById(idTurma);
            
            Matricula matricula = new Matricula(turma, aluno);
            DAO.insereMatricula(matricula);
            
            RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
            rd.forward(request, response);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SvFazMatricula.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
    }
}
