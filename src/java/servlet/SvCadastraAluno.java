package servlet;

import classes.Aluno;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 0369152
 */
public class SvCadastraAluno extends HttpServlet {

    
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");
    
          String nome = (String) request.getAttribute("nome");
          String cpf = (String) request.getAttribute("cpf");
          String email = (String) request.getAttribute("email");
          String telefone = (String) request.getAttribute("telefone");
          Date dataNasc = (Date) request.getAttribute("dataNascimento");
          
          Aluno aluno = new Aluno(nome, email, cpf, telefone, dataNasc);
          
          
    }

   

}
