/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author cuenu
 */

public class Consultas{
    
    Conexion con = null;
    String Respuesta;
    
    public boolean auteticacion(String correo, String contrasena){
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        
            
        try {        
            con = new Conexion();
            String Consulta = "SELECT * FROM usuario WHERE correo_usuario =? AND contrasena =?";
            pst = con.getConnection().prepareStatement(Consulta);
            pst.setString(1, correo);
            pst.setString(2, contrasena);
            rs = pst.executeQuery();
            if (rs.absolute(1)) {
                System.out.println("if....");
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("error de autenticacion ");
        }finally{
            if(con!=null){
                con.cerrarConexion();
            }
        }
        return false;
    }
    public boolean  Funcionario(String correo, String contrasena){
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = new Conexion();
            String Consulta = "SELECT * FROM funcionario,usuario WHERE funcionario.funcionario=usuario.cedula_usuario AND correo_usuario =? AND contrasena =?";
            pst = con.getConnection().prepareStatement(Consulta);
            pst.setString(1, correo);
            pst.setString(2, contrasena);
            rs = pst.executeQuery();
            if (rs.absolute(1)) {
                System.out.println("funcionario correcto!!");
                return true;
            }
        } catch (Exception e) {
            System.err.println("no es funcionario ");
        }finally{
            try {
                if (con.getConnection()!=null) con.getConnection().close();
                if (pst!=null) pst.close();
                if (rs!= null) rs.close();
            } catch (Exception e) {
                System.out.println("error cerrando conexión"+ e);
            }
        }
        return false;
    }
    public boolean RegistroUsuario(String contrasenaFunc, String cedula, String nombre,String apellido,String correo, String contrasena, String telefono ){
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {
            con = new Conexion();
            String Consul = "SELECT * FROM funcionario,usuario WHERE funcionario.funcionario=usuario.cedula_usuario AND contrasena =?";
            pst = con.getConnection().prepareStatement(Consul);
            pst.setString(1, contrasenaFunc);
            rs = pst.executeQuery();
            System.err.println("Funcionario correcto");
            if (rs.absolute(1)) {
                try {
                    String Consulta1 = ("INSERT INTO usuario (cedula_usuario,nombre_usuario,apellidos_usuario,correo_usuario,contrasena,telefono_usuario) VALUES(?,?,?,?,?,?)");
                    pst = con.getConnection().prepareStatement(Consulta1);
                    pst.setString(1, cedula);
                    pst.setString(2, nombre);
                    pst.setString(3, apellido);
                    pst.setString(4, correo);
                    pst.setString(5, contrasena);
                    pst.setString(6, telefono);
                    
                    if (pst.executeUpdate() == 1) {
                        return true;
                        
                    }
                } catch (Exception e) {
                    System.err.println("error de inserción ");
                }  
            }
        }catch (Exception e) {
                    System.err.println("contraseña de administrador incorrecta ");
        }finally{
            try {
                if (con.getConnection()!=null) con.getConnection().close();
                if (pst!=null) pst.close();
            } catch (Exception e) {
                System.out.println("error cerrando conexión"+ e);
            }
        }
        
        return false;
    }
    public boolean RegistroFuncionario(String cargo,String cedula){
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {

            String Consulta2 = ("insert into funcionario (cargo_funcionario,funcionario) values(?,?)");
            pst = con.getConnection().prepareStatement(Consulta2);
            pst.setString(1, cargo);
            pst.setString(2, cedula);
            if (pst.executeUpdate() == 1) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
  
   public List<Finca> Consultar() {
    
        List<Finca> datos = new ArrayList<>();
        PreparedStatement pst;
        ResultSet rs;
        String sql="SELECT * FROM finca";
        System.out.println("Consultar ...");
        try {
            con = new Conexion();
            pst = con.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            System.out.println("Consultar ...resulset..." +rs);
            while (rs.next()) {                
                datos.add(new Finca(rs.getString("id_finca"),
                        rs.getString("nombre_finca"),
                        rs.getString("extencion_finca"),
                        rs.getString("cedula"),
                        rs.getString("i_lugar")));
                
            }
            System.out.println("lee la BD..");
            con.getConnection().close();
        } catch (Exception e) {
            System.out.println("NO lee la consulta de BD..");
        }
        return datos;
    }
    public boolean RegistroVeterinario(String contrasenaFunc, String cedula, String nombre,String apellidos,String titulo,String correo,  String telefono ){
        
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {
            con = new Conexion();
            String Consul = "SELECT * FROM funcionario,usuario WHERE funcionario.funcionario=usuario.cedula_usuario AND contrasena =?";
            pst = con.getConnection().prepareStatement(Consul);
            pst.setString(1, contrasenaFunc);
            rs = pst.executeQuery();
            System.err.println("Funcionario correcto");
            if (rs.absolute(1)) {
                try {
                    String Consulta1 = ("INSERT INTO veterinario (cedula_veterinario,nombre_usuario,apellidos_usuario,titulo,correo_usuario,telefono_usuario) VALUES(?,?,?,?,?,?)");
                    pst = con.getConnection().prepareStatement(Consulta1);
                    pst.setString(1, cedula);
                    pst.setString(2, nombre);
                    pst.setString(3, apellidos);
                    pst.setString(5, titulo);
                    pst.setString(4, correo);
                    pst.setString(6, telefono);
                    
                    if (pst.executeUpdate() == 1) {
                        setRespuesta("Registro veterinario Exitoso!!");
                        return true;
                        
                    }
                } catch (Exception e) {
                    System.err.println("error de inserción ");
                    setRespuesta("Error en la Inserción de veterinario.  verifique los datos e intente de nuevo");
                }  
            }
        }catch (Exception e) {
                    System.err.println("contraseña de administrador incorrecta ");
        }finally{
            try {
                if (con.getConnection()!=null) con.getConnection().close();
                if (pst!=null) pst.close();
            } catch (Exception e) {
                System.out.println("error cerrando conexión"+ e);
            }
        }
        
        return false;
    }
    public List<Finca> filtrar(String campo) {
   
        List<Finca> datos = new ArrayList<>();
        PreparedStatement pst;
        ResultSet rs;
        String sql="SELECT * FROM finca WHERE id_finca=?";
        System.out.println("Consultar ...");
        try {
            con = new Conexion();
            pst = con.getConnection().prepareStatement(sql);
            pst.setString(1, campo);
            rs = pst.executeQuery();
            System.out.println("Consultar ...resulset..." +rs);
            while (rs.next()) {                
                datos.add(new Finca(rs.getString("id_finca"),
                        rs.getString("nombre_finca"),
                        rs.getString("extencion_finca"),
                        rs.getString("cedula"),
                        rs.getString("i_lugar")));
                
            }
            System.out.println("filtra la BD..");
            con.getConnection().close();
        } catch (Exception e) {
            System.out.println("NO lee la consulta de BD..");
        }
        return datos;
    }
 
    public List<Animal> filtrarAnimal(String campo) {
   
        List<Animal> datos = new ArrayList<>();
        PreparedStatement pst;
        ResultSet rs;
        String sql="SELECT * FROM animal WHERE id_finca=?";
        System.out.println("Consultar ...");
        try {
            con = new Conexion();
            pst = con.getConnection().prepareStatement(sql);
            pst.setString(1, campo);
            rs = pst.executeQuery();
            System.out.println("Consultar ...resulset..." +rs);
            while (rs.next()) {                
                datos.add(new Animal( 
                        rs.getString("id_animal"), rs.getString("nombre_animal"),
                        rs.getString("fecha_nacimiento"), rs.getString("raza_animal"),
                        rs.getString("genero_animal"), rs.getString("metodo_concepcion"),
                        rs.getString("etapa_animall"), rs.getString("nombre_padre"),
                        rs.getString("nombre_madre"), rs.getString("foto_animal"),
                        rs.getString("observaciones"), rs.getString("id_finca")));
                
            }
            System.out.println("filtra la BD..");
            con.getConnection().close();
        } catch (Exception e) {
            System.out.println("NO lee la consulta de BD..");
        }
        return datos;
    }
    public boolean registroInseminacionExitosa(String id_inseminacion, String exito){
        
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {
            con = new Conexion();
            String Consul = "SELECT * FROM inseminacion WHERE  id_inseminacion =?";
            pst = con.getConnection().prepareStatement(Consul);
            pst.setString(1, id_inseminacion);
            rs = pst.executeQuery();
            System.err.println("Inseminacion existente");
            if (rs.absolute(1)) {
                try {
                    String Consulta1 = ("UPDATE inseminacion SET inseminacion_exitosa=?  WHERE  id_inseminacion =?");
                    pst = con.getConnection().prepareStatement(Consulta1);
                    pst.setString(1, exito);
                    pst.setString(2, id_inseminacion);                    
                    if (pst.executeUpdate() == 1) {
                        setRespuesta("Registro de inseminación Correcto!!");
                        return true;
                        
                    }
                } catch (Exception e) {
                    System.err.println("error de inserción en Inseminacion");
                    setRespuesta("Error !!  Datos de inseminación No guardados!!");
                }  
            }
        }catch (Exception e) {
                    System.err.println("no existe el codigo de la inseminacion ");
                    setRespuesta("Error !!  no existe el código de la inseminación!!");
        }finally{
            try {
                if (con.getConnection()!=null) con.getConnection().close();
                if (pst!=null) pst.close();
            } catch (Exception e) {
                System.out.println("error cerrando conexión"+ e);
            }
        }
        return false;
    }

    public String getRespuesta() {
        return Respuesta;
    }

    public void setRespuesta(String Respuesta) {
        this.Respuesta = Respuesta;
    }

    
}

