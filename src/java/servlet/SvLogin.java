package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.*;
import classes.Aluno;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

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
            boolean logado = false;
            HttpSession session = request.getSession();
            try {
                
                List<Aluno> alunos = DAO.getAlunos();
                for(Aluno aluno : alunos){
                    
                    
                    if(email.equals(aluno.getEmail()) && senha.equals(aluno.getSenha())){
                        Usuario usuario = new Usuario();
                        
                        usuario.setId(aluno.getId());
                        usuario.setTipo(2);
                        
                        destino="home.jsp";
                        session.setAttribute("aluno", aluno);
                        request.setAttribute("aluno", aluno);
                        logado = true;
                        
                        
                        break;
                    }
                }
                if(logado != true){
                    System.out.println("Entrou");

                    List<Professor> professores = DAO.getProfessores();
                    for(Professor professor : professores){
                        
                        if(email.equals(professor.getEmail()) && senha.equals(professor.getSenha())){
                            Usuario usuario = new Usuario();
                            
                            usuario.setId(professor.getId());
                            usuario.setTipo(1);
                            
                            destino="homeProfessor.jsp";
//                            session.setAttribute("professor", professor);
                            request.setAttribute("professor", professor);
                            logado = true;
                            break;
                        }
                    }
                }
                
            } catch (SQLException ex) {
                destino = "index.jsp";
                Logger.getLogger(SvLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher rd = request.getRequestDispatcher(destino);
            rd.forward(request, response);
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
