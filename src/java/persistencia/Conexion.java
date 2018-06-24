/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cuenu
 * clase conexión, gestiona una conexion con la Base de datos, donde el constructor centra la conexión
 */
public class Conexion {
        Connection conn = null;
        Statement st = null;
        String url = "jdbc:mysql://192.168.1.6:3306/bovinos";
        String us = "jp";
        String pass = "jp";
   
    public Conexion(){    
        /*
        *constructor de la clase Conexion
        */
        try{
          Class.forName("com.mysql.jdbc.Driver");
          conn = (Connection)DriverManager.getConnection(url,us,pass);
          st = (Statement) conn.createStatement();
          System.out.println("Conexion en Linea \n");
        }catch(Exception ex){
            ex.printStackTrace();
           System.out.println("Error en la conexion! ... intente mas tarde."); 
        }
    }
    public Connection getConnection(){
        return conn;
    }

    public String getUrl() {
        return url;
    } 

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUs() {
        return us;
    }

    public void setUs(String us) {
        this.us = us;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public void cerrarConexion(){
            try {
                this.conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
