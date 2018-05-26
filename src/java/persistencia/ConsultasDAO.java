/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.resource.cci.ResultSet;
import persistencia.Finca;
import persistencia.ConexionDB;
/**
 *
 * @author cuenu
 */
public class ConsultasDAO implements Operaciones{

    ConexionDB db = new ConexionDB();
    @Override
    public String insertar(Object obj) {
    
        Finca f= (Finca)obj;
        Connection conn = null;
        PreparedStatement pst;
        String sql="INSERT INTO finca VALUES(?,?,?,?,?)";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
                    db.getUrl(),
                    db.getUs(),
                    db.getPass());
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, f.getId_finca());
            pst.setString(2, f.getNombre_finca());
            pst.setString(3, f.getExtencion_finca());
            pst.setString(4, f.getId_dueno());
            pst.setString(5, f.getId_lugar());
            int filas = pst.executeUpdate();
            respuesta= "se registro "+filas+" nuevos elementos";
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return respuesta;
    } 

    @Override
    public String modificar(Object obj) {
        Finca f= (Finca)obj;
        Connection conn = null;
        PreparedStatement pst;
        String sql="UPDATE finca SET nombre_finca=?, extencion_finca=?, cedula=?, i_lugar=? WHERE id_finca=? ";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
                    db.getUrl(),
                    db.getUs(),
                    db.getPass());
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, f.getNombre_finca());
            pst.setString(2, f.getExtencion_finca());
            pst.setString(3, f.getId_dueno());
            pst.setString(4, f.getId_lugar());
            pst.setString(5, f.getId_finca());
            int filas = pst.executeUpdate();
            respuesta= "se modificó "+filas+" elementos";
            conn.close();
        } catch (Exception e) {
        }
        
        return respuesta;
    }

    @Override
    public String eliminar(Object obj) {
    
        Finca f= (Finca)obj;
        Connection conn = null;
        PreparedStatement pst;
        String sql="DELETE FROM finca WHERE id_finca=?";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
                    db.getUrl(),
                    db.getUs(),
                    db.getPass());
            pst = conn.prepareStatement(sql);
            pst.setString(1, f.getId_finca());           
            int filas = pst.executeUpdate();
            respuesta= "se eliminó "+filas+" elementos";
            conn.close();
        } catch (Exception e) {
        }
        
        return respuesta;
    }

    @Override
    public List<Finca> Consultar() {
    
        List<Finca> datos = new ArrayList<>();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql="SELECT * FROM finca";
        System.out.println("Consultar ...");
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
                    db.getUrl(),
                    db.getUs(),
                    db.getPass());
            pst = conn.prepareStatement(sql);
            rs = (ResultSet) pst.executeQuery();
            System.out.println("Consultar ...resulset..." +rs);
            while (rs.next()) {                
                datos.add(new Finca(rs.getString("id_finca"),
                        rs.getString("nombre_finca"),
                        rs.getString("extencion_finca"),
                        rs.getString("cedula"),
                        rs.getString("i_lugar")));
                
            }
            System.out.println("lee la BD..");
            conn.close();
        } catch (Exception e) {
            System.out.println("NO lee la consulta de BD..");
        }
        return datos;
    }

    @Override
    public List<?> filtrar(String campo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insertarAnimal(Object obj) {
    
        Animal a= (Animal)obj;
        Connection conn;
        PreparedStatement pst;
        String sql="INSERT INTO animal VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        String respuesta="";
        System.out.println("persistencia......ConsultasDAO.......insertarAnimal()");
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
                    db.getUrl(),
                    db.getUs(),
                    db.getPass());
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, a.getId_animal());
            pst.setString(2, a.getNombre_animal());
            pst.setString(3, a.getFecha_nacimiento());
            pst.setString(4, a.getRaza_animal());
            pst.setString(5, a.getGenero_animal());
            pst.setString(6, a.getMetodo_concepcion());
            pst.setString(7, a.getEtapa_vida());
            pst.setString(8, a.getNombrePadre());
            pst.setString(9, a.getNombreMadre());
            pst.setString(10, a.getFoto_animal());
            pst.setString(11, a.getObservaciones());
            pst.setString(12, a.getId_finca());
            int filas = pst.executeUpdate();
            respuesta= "se registro "+filas+" nuevo  Animal.";
            conn.close();
        } catch (Exception e) {
            System.out.println("error al insertar Animal..");
            respuesta= "Error!!  No se realizo registro. Verifique los datos e intente nuevamente.";
        }
        
        return respuesta;
    }

    @Override
    public String modificarAnimal(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String eliminarAnimal(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<?> ConsultarAnimal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<?> filtrarAnimal(String campo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insertarInseminacion(Object obj) {
        Inseminacion in = (Inseminacion)obj;
        Connection conn;
        PreparedStatement pst;
        String sql="INSERT INTO inseminacion VALUES(?,?,?,?,?,?,?)";
        String respuesta="";
        System.out.println("persistencia......ConsultasDAO.......insertarInseminacion()");
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
                    db.getUrl(),
                    db.getUs(),
                    db.getPass());
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, in.getId_inseminacion());
            pst.setString(2, in.getFecha_inseminacion());
            pst.setString(3, in.getRaza_pajilla());
            pst.setString(4, in.getSexada());
            pst.setString(5, in.getId_veterinario());
            pst.setString(6, in.getId_animal());
            pst.setString(7, in.getInseminacion_exitosa());
            int filas = pst.executeUpdate();
            respuesta = "se registro "+filas+" nuevo elemento de Inseminacion";
            System.out.println("registro exitoso ... respuesta:"+ respuesta);
            conn.close();
        } catch (Exception e) {
            System.out.println("error al insertar Inseminacion..");
            respuesta = "error en el registro!! verifique los datos e intente nuevamente";
        }
        
        return respuesta;
    
    }
    

    @Override
    public String modificarInseminacion(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String eliminarInseminacion(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<?> ConsultarInseminacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<?> filtrarInseminacion(String campo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insertarLeche(Object obj) {
    
        Leche leche = (Leche)obj;
        Connection conn;
        PreparedStatement pst;
        String sql="INSERT INTO leche VALUES(?,?,?)";
        String respuesta="";
        System.out.println("persistencia......ConsultasDAO.......insertarLeche()");
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
                    db.getUrl(),
                    db.getUs(),
                    db.getPass());
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, leche.getFecha_leche());
            pst.setString(2, leche.getLitros_leche());
            pst.setString(3, leche.getId_animal());
           
            int filas = pst.executeUpdate();
            respuesta = "se registro "+filas+" nuevo día de Producción de Leche";
            System.out.println("registro exitoso ... respuesta:"+ respuesta);
            conn.close();
        } catch (Exception e) {
            System.out.println("error al insertar Produccion Leche..");
        }
        
        return respuesta;    
    
    }

    @Override
    public String modificarLeche(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<?> ConsultarLeche() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
