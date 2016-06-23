/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Início da classe de conexão//
public class Conexao {

   public Connection con;  
   public Statement stm;  
   public ResultSet res = null;  
  
    public Conexao() {  
  
      try {  
  
         Class.forName("oracle.jdbc.driver.OracleDriver");  
         con =  
            DriverManager.getConnection(  
              "jdbc:oracle:thin:@oracle.inf.poa.ifrs.edu.br:1521:XE", "usr75","usr75");  
         stm = con.createStatement();   
           
      } catch (Exception e) {  
         System.out.println("não foi possível conectar ao banco" + e.getMessage());  
      }  
    } 
    
    public void executaQuery(String query){  
     
      try {  
         stm.executeUpdate(query);
         con.commit();
         System.out.println("Registro inserido");
      }catch (SQLException e){System.out.println("Erro na inserção:" + e.getMessage());}  
        
    }
    
    public ResultSet busca(String query){
                  
      try { 
         res = stm.executeQuery(query);
           
      }catch (SQLException e){System.out.println("Erro na busca:" + e.getMessage());}  
        
      return res;  
    }
    public void close() throws SQLException{
        con.close();
    }
    
}
