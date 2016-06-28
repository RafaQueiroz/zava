/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import classes.DAO;
import classes.Professor;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafael
 */
@WebServlet(name = "SvCadastraProfessor", urlPatterns = {"/SvCadastraProfessor"})
public class SvCadastraProfessor extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        String nome = (String) request.getParameter("nome");
        String email = (String) request.getParameter("email");
        int valorHora = Integer.parseInt(request.getParameter("valorHora"));
        String certificados = (String) request.getParameter("certificados");
        String senha = (String) request.getParameter("senha");
    
        Professor professor = new Professor(nome, email, valorHora, certificados, senha);
        
        try {
            DAO.insereInstrutor(professor);
        } catch (SQLException ex) {
            Logger.getLogger(SvCadastraProfessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("homeProfessor.jsp");
        rd.forward(request, response);
        
    }

    
}
