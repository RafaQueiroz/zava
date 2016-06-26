package classes;

/**
 *
 * @author 0369152
 */
public class Usuario{
    private static final int PROFESSOR = 1;
    private static final int ALUNO = 2;
    
    
    private String nome;
    private String email;
    private String senha;
    private String cpf;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Usuario(String nome, String email, String senha, String cpf) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
    }
    
    public Usuario(){
        
    }
           
    
    
    
}
