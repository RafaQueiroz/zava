package servlet;

import classes.Aluno;
import classes.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.rmi.server.Dispatcher;

/**
 *
 * @author 0369152
 */
public class SvCadastraAluno extends HttpServlet {

    
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");
    
          String nome = (String) request.getParameter("nome");
          String cpf = (String) request.getParameter("cpf");
          String email = (String) request.getParameter("email");
          String telefone = (String) request.getParameter("telefone");
          String dataNasc = (String) request.getParameter("dataNascimento");
          String senha = (String) request.getParameter("senha");
          
          Aluno aluno = new Aluno(nome, email, cpf, telefone, dataNasc,senha);
        
          try {
            DAO.insereAluno(aluno);
        } catch (SQLException ex) {
            Logger.getLogger(SvCadastraAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
         RequestDispatcher rd = request.getRequestDispatcher("./cadastro/cadastroAlunos.jsp");
         rd.forward(request, response);
          
          
    }

   

}
