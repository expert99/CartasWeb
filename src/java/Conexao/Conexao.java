/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Ricardo
 */
public class Conexao {
    
    public Connection getConexao(){
          
          try {
              Connection conexao = null;
              String url = "jdbc:mysql://127.0.0.1:3306/cartas";
              String user = "root";
              String pass = "";
              conexao = DriverManager.getConnection(url, user, pass);
              return conexao;
              
              
              
          } catch (Exception e) {
              return null;
          }
          
          
          
          
      }
    
}
