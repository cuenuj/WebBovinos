/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

/**
 *
 * @author cuenu
 */
public class ConexionDB {
        String Driver;
        String url ;
        String us ;
        String pass;
        
        public ConexionDB(){
            this.Driver= "com.mysql.jdbc.Driver";
            this.url=  "jdbc:mysql://192.168.0.14:3306/bovinos";
            this.us= "jp";
            this.pass= "jp";
        }

    public String getDriver() {
        return Driver;
    }

    public void setDriver(String Driver) {
        this.Driver = Driver;
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
        
        
}
