
package servlet;

import classes.Curso;
import classes.DAO;
import classes.Professor;
import classes.Turma;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafael
 */
@WebServlet(name = "SvCadastraTurma", urlPatterns = {"/SvCadastraTurma"})
public class SvCadastraTurma extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        String dataInicio = (String) request.getParameter("dataInicio");
        String dataFim = (String) request.getParameter("dataInicio");
        int cargaHoraria = Integer.parseInt(request.getParameter("cargaHoraria"));
        int idCurso = Integer.parseInt(request.getParameter("curso"));
        int idProfessor = Integer.parseInt(request.getParameter("professor"));
        
        try {
            DAO.getProfessores();
            DAO.getCursos();
            Professor professor = DAO.getProfessorById(idProfessor);
            System.err.println("Achou Professor");
            Curso curso = DAO.getCursoById(idCurso);
            System.err.println("Achou Curso");

            Turma turma = new Turma(professor, curso, dataInicio, dataFim, cargaHoraria);
            DAO.insereturma(turma);
            
        } catch (SQLException ex) {
            Logger.getLogger(SvCadastraTurma.class.getName()).log(Level.SEVERE, null, ex);
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
