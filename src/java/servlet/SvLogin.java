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
            System.out.println("Email(Login): "+ email);
            System.out.println("Email(senha): "+ senha);
            
            String destino = "index.html";
            boolean logado = false;
            try {
                
                List<Aluno> alunos = DAO.getAlunos();
                for(Aluno aluno : alunos){
                    System.out.println("Email(Banco): "+ aluno.getEmail());
                    System.out.println("Email(Banco): "+ aluno.getSenha());
                    
                    if(email.equals(aluno.getEmail()) && senha.equals(aluno.getSenha())){
                        Aluno alunoSaida = new Aluno();
                        alunoSaida = aluno;
                        destino="home.jsp";
                        request.setAttribute("aluno", alunoSaida);
                        logado = true;
                        break;
                    }
                }
                
                System.out.println(logado);
                if(true){
                    System.out.println("Entrou");

                    List<Professor> professores = DAO.getProfessores();
                    for(Professor professor : professores){
                        System.out.println("Email(Banco): "+ professor.getEmail());
                        System.out.println("Email(Banco): "+ professor.getSenha());
                        if(email.equals(professor.getEmail()) && senha.equals(professor.getSenha())){
                            Professor professorSaida = new Professor();
                            professorSaida = professor;
                            destino="homeProfessor.jsp";
                            request.setAttribute("professor", professorSaida);
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
