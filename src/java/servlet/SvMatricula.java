/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import classes.Curso;
import classes.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "SvMatriicula", urlPatterns = {"/SvMatriicula"})
public class SvMatricula extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            
        try {
            List<Curso> cursos = new ArrayList<Curso>();
            cursos = DAO.getCursos();
            RequestDispatcher rd = request.getRequestDispatcher("matricula.jsp");
            request.setAttribute("listaCursos", cursos);
            rd.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SvMatricula.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    }

}
