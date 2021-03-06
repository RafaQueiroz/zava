package servlet;

import classes.Curso;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author rafael
 */
@WebServlet(name = "SvCadastraCurso", urlPatterns = {"/SvCadastraCurso"})
public class SvCadastraCurso extends HttpServlet {

        
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        
        Professor professor = new Professor();
        HttpSession httpSession = request.getSession(true);

        professor = (Professor) httpSession.getAttribute("professor");
        System.out.println(professor.getNome()+" "+professor.getId());
        
        
        
        String nome = (String) request.getParameter("nome");
        String requisitos = (String) request.getParameter("requisitos");
        int cargaHoraria = Integer.parseInt(request.getParameter("cargaHoraria"));
        int preco = Integer.parseInt(request.getParameter("preco"));
        
        Curso curso = new Curso(nome, requisitos, cargaHoraria, preco);
        
        try {
            DAO.insereCurso(curso);
        } catch (SQLException ex) {
            Logger.getLogger(SvCadastraCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("homeProfessor.jsp");
        rd.forward(request, response);
        
    }

}
