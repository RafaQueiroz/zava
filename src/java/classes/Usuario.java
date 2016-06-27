package classes;

/**
 *
 * @author 0369152
 */
public class Usuario{
    private static final int PROFESSOR = 1;
    private static final int ALUNO = 2;
        
    private int id;
    private int tipo;

    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Usuario(){
        
    }
           
    
    
    
}
