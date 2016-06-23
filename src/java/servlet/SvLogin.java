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
import classes.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author 0369152
 */
@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String email = (String) request.getParameter("email");
            String senha = (String) request.getParameter("senha");
            
            String destino = "index.html";
            
            ResultSet rs;
            try {
                List<Aluno> alunos = DAO.getAlunos();
                for(Aluno aluno : alunos){
                    if(email.equals(aluno.getEmail()) && senha.equals(aluno.getSenha())){
                        destino="home.jsp";
                        request.setAttribute("aluno", aluno);
                        break;
                    }
                }
                RequestDispatcher rd = request.getRequestDispatcher(destino);
                rd.forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(SvLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
