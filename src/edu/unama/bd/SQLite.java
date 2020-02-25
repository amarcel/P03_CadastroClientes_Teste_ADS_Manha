
package br.unama.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SQLite {
    public static Connection conectar() {
        try  {
            Connection con = DriverManager.getConnection("jdbc:sqlite:banco.db");
            System.out.println("Conexão realizada !!!!");
            
            return con;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    
}
