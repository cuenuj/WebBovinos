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
    
        String respuesta="";
        Finca f = (Finca)obj;
        Connection conn = null;
        PreparedStatement pst;
        String sql="INSERT INTO finca VALUES(?,?,?,?,?,?)";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
                    db.getUrl(),
                    db.getUs(),
                    db.getPass());
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, f.getId_finca());
            pst.setString(2, f.getNombre_finca());
            pst.setString(3, f.getCordenada_latitud());
            pst.setString(4, f.getCordenada_longitud());
            pst.setString(5, f.getId_dueno());
            pst.setString(6, f.getId_lugar());
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
            pst.setString(1, f.getId_finca());
            pst.setString(2, f.getNombre_finca());
            pst.setString(3, f.getCordenada_latitud());
            pst.setString(4, f.getCordenada_longitud());
            pst.setString(5, f.getId_dueno());
            pst.setString(6, f.getId_lugar());
            int filas = pst.executeUpdate();
            respuesta= "se modificó "+filas+" elementos";
            conn.close();
        } catch (Exception e) {
        }
        
        return respuesta;
    }

    @Override
    public String eliminar(String obj) {
    
        Finca f= new Finca();
        Connection conn = null;
        PreparedStatement pst;
        String sql="DELETE FROM finca WHERE id_finca=?";
        String respuesta="";
        int filas =0;
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
                    db.getUrl(),
                    db.getUs(),
                    db.getPass());
            pst = conn.prepareStatement(sql);
            pst.setString(1, obj);           
            filas = pst.executeUpdate();
            respuesta= "se eliminó "+filas+" elementos";
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return respuesta;
    }

    @Override
    public List<Finca> Consultar() {
    
        List<Finca> datos = new ArrayList<>();
        
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
            e.printStackTrace();
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
        
        String respuesta="";
        
        try {
            
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
                    db.getUrl(),
                    db.getUs(),
                    db.getPass());
            String sql="INSERT INTO leche VALUES(?,?,?)";
            pst = conn.prepareStatement(sql);
            System.out.println("persistencia......ConsultasDAO.......insertarLeche()");
            pst.setString(1, leche.getFecha_leche());
            pst.setInt(2, leche.getLitros_leche());
            pst.setString(3, leche.getId_animal());
           
            int filas = pst.executeUpdate();
            respuesta = "se registro "+filas+" nuevo día de Producción de Leche";
            System.out.println("registro exitoso ... respuesta:"+ respuesta);
            conn.close();
        } catch (Exception e) {
            System.out.println("error al insertar Produccion Leche..");
            respuesta= "error al insertar Produccion Leche";
            e.printStackTrace();
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

    @Override
    public boolean insertarHistoria(Object obj) {
        
                HistoriaClinica historia = (HistoriaClinica)obj;
                Connection conn1;
                PreparedStatement pst1;
                String sql1="INSERT INTO historia_clinica VALUES(?,?)";
                try {
                    Class.forName(db.getDriver());
                    conn1 = DriverManager.getConnection(
                            db.getUrl(),
                            db.getUs(),
                            db.getPass());
                    pst1 = conn1.prepareStatement(sql1);

                    pst1.setString(1, historia.getId_historia());
                    pst1.setString(2, historia.getId_animal());
                    
                    if( pst1.executeUpdate()==1){
                        return true;
                    }
                    conn1.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
           

    
    @Override
    public List<?> ConsultarHistoria() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insertarDetalleHistoria(Object obj) {
    
                DetalleHistorial detalle = (DetalleHistorial)obj;
                Connection conn1;
                PreparedStatement pst1;
                String respuesta="";
                String sql1="INSERT INTO detalle_historia_clinica VALUES(?,?,?,?,?,?,?)";
                try {
                    Class.forName(db.getDriver());
                    conn1 = DriverManager.getConnection(
                            db.getUrl(),
                            db.getUs(),
                            db.getPass());
                    pst1 = conn1.prepareStatement(sql1);

                    pst1.setString(1, detalle.getFecha_historia());
                    pst1.setString(2, detalle.getObservaciones());
                    pst1.setString(3, detalle.getEnfermedad());
                    pst1.setString(4, detalle.getDiagnostico());
                    pst1.setString(5, detalle.getTratamiento());
                    pst1.setString(6, detalle.getId_historial());
                    pst1.setString(7, detalle.getCedula_veterinario());

                    int filas = pst1.executeUpdate();
                    respuesta = "se registro "+filas+" nuevo Detalle de Historia Clinica";
                    System.out.println("registro exitoso ... respuesta:"+ respuesta);
                    conn1.close();
                } catch (Exception e) {
                    System.out.println("error al insertar detalle de Historial..");
                    respuesta="error al insertar detalle de Historial";
                }
                return respuesta;
    }

    
   
}
