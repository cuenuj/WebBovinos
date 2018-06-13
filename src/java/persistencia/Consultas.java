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
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author cuenu
 */

public class Consultas{
    
    Conexion con = null;
    String Respuesta;
    ConsultasDAO dao = new ConsultasDAO();
    
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
                System.out.println("usuario y contraseña correcto.");
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
        String sql="SELECT * FROM finca,usuario WHERE finca.cedula= usuario.cedula_usuario";
        System.out.println("Consultar ...");
        try {
            con = new Conexion();
            pst = con.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            System.out.println("Consultar ...Lista Fincas..." +rs);
            while (rs.next()) {                
                datos.add(new Finca(rs.getString("id_finca"),
                        rs.getString("nombre_finca"),
                        rs.getString("nombre_usuario"),
                        rs.getString("apellidos_usuario"),
                        rs.getString("cordenada_latitud"),
                        rs.getString("cordenada_longitud"),
                        rs.getString("cedula"),
                        rs.getString("i_lugar")));
                
            }
            System.out.println("lee la BD.. Lista de Fincas de Combita");
            con.getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("NO lee la consulta de BD..");
        }
        return datos;
    }
    public boolean RegistroVeterinario(String contrasenaFunc, String cedula, String nombre,String apellidos,  String telefono ){
        
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
                    con = new Conexion();
                    String Consulta1 = ("INSERT INTO veterinario (cedula_veterinario,nombre_usuario,apellidos_usuario,telefono_usuario) VALUES(?,?,?,?)");
                    pst = con.getConnection().prepareStatement(Consulta1);
                    pst.setString(1, cedula);
                    pst.setString(2, nombre);
                    pst.setString(3, apellidos);
                    pst.setString(4, telefono);
                    
                    if (pst.executeUpdate() == 1) {
                        setRespuesta("Registro veterinario Exitoso!!");
                        return true;
                        
                    }
                } catch (Exception e) {
                    System.err.println("error de inserción ");
                    setRespuesta("Error en la Inserción de veterinario.  verifique los datos e intente de nuevo");
                    e.printStackTrace();
                }  
            }
        }catch (Exception e) {
                    System.err.println("contraseña de administrador incorrecta ");
                    e.printStackTrace();
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
    public List<Finca> filtrarFinca (String nombreFinca){
        List<Finca> datos = new ArrayList();
        PreparedStatement pst;
        ResultSet rs;
        String sql="SELECT * FROM finca,usuario WHERE finca.cedula=usuario.cedula_usuario AND nombre_finca=?";
        System.out.println("Consultar ...");
        try {
            con = new Conexion();
            pst = con.getConnection().prepareStatement(sql);
            pst.setString(1, nombreFinca);
            rs = pst.executeQuery();
            System.out.println("busqueda en la lista de fincas por nombre...resulset..." +rs);
            while (rs.next()) {                
                datos.add(new Finca(rs.getString("id_finca"),
                        rs.getString("nombre_finca"),
                        rs.getString("nombre_usuario"),
                        rs.getString("apellidos_usuario"),
                        rs.getString("cordenada_latitud"),
                        rs.getString("cordenada_longitud"),
                        rs.getString("cedula"),
                        rs.getString("i_lugar")));
                
            }
            System.out.println("filtra la BD..y busca entre las fincas");
            con.getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("NO lee la consulta de BD..");
        }
        return datos;
    }
    public List<Finca> filtrar(String campo) {
   
        List<Finca> datos = new ArrayList();
        PreparedStatement pst;
        ResultSet rs;
        String sql="SELECT * FROM finca,usuario WHERE finca.cedula=usuario.cedula_usuario AND id_finca=?";
        System.out.println("Consultar ...");
        try {
            con = new Conexion();
            pst = con.getConnection().prepareStatement(sql);
            pst.setString(1, campo);
            rs = pst.executeQuery();
            System.out.println("busqueda en la lista de fincas ...resulset..." +rs);
            while (rs.next()) {                
                datos.add(new Finca(rs.getString("id_finca"),
                        rs.getString("nombre_finca"),
                        rs.getString("nombre_usuario"),
                        rs.getString("apellidos_usuario"),
                        rs.getString("cordenada_latitud"),
                        rs.getString("cordenada_longitud"),
                        rs.getString("cedula"),
                        rs.getString("i_lugar")
                        
                ));
                
            }
            System.out.println("filtra la BD..y busca entre las fincas");
            con.getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("NO lee la consulta de BD..");
        }
        return datos;
    }
     public List<Inseminacion> listaInseminacionFuncionario(String nombreFinca){
        List<Inseminacion> datos = new ArrayList();
        PreparedStatement pst;
        ResultSet rs;
        String sql="SELECT * FROM finca,animal,inseminacion "
                + "WHERE inseminacion.id_animal = animal.id_animal\n" +
                    "AND animal.id_finca = finca.id_finca\n" +
                    "AND nombre_finca=?";
                    try {
            con = new Conexion();
            pst = con.getConnection().prepareStatement(sql);
            pst.setString(1,nombreFinca);
            rs = pst.executeQuery();
            while (rs.next()) {                
                datos.add(new Inseminacion(rs.getString("id_inseminacion"),
                        rs.getString("fecha_inseminacion"),
                        rs.getString("raza_pajilla"),
                        rs.getString("sexada"),
                        rs.getString("id_veterinario"),
                        rs.getString("id_animal"),
                        rs.getString("inseminacion_exitosa")));
            }
            System.out.println("filtra inseminacion de la BD..");
            con.getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("NO lee la consulta de BD  cantidad insemincaiones..");
        }
        
        
        return datos;
    }
    public List<Inseminacion> ListarInseminacionFinca(String campo){
        List<Inseminacion> datos = new ArrayList();
        PreparedStatement pst;
        ResultSet rs;
        String sql="SELECT * \n" +
                    "FROM inseminacion, animal, finca, usuario\n" +
                    "WHERE inseminacion.id_animal = animal.id_animal\n" +
                    "AND animal.id_finca = finca.id_finca\n" +
                    "AND finca.cedula = usuario.cedula_usuario\n" +
                    "AND correo_usuario =?";
        try {
            con = new Conexion();
            pst = con.getConnection().prepareStatement(sql);
            pst.setString(1, campo);
            rs = pst.executeQuery();
            while (rs.next()) {                
                datos.add(new Inseminacion(rs.getString("id_inseminacion"),
                        rs.getString("fecha_inseminacion"),
                        rs.getString("raza_pajilla"),
                        rs.getString("sexada"),
                        rs.getString("id_veterinario"),
                        rs.getString("id_animal"),
                        rs.getString("inseminacion_exitosa")));
            }
            System.out.println("filtra inseminacion de la BD..");
            con.getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("NO lee la consulta de BD  cantidad insemincaiones..");
        }
        return datos;
    }
    
 public List<Finca> ListarFincaUsuario(String campo){
        List<Finca> datos = new ArrayList<>();
        PreparedStatement pst;
        ResultSet rs;
        String sql="SELECT * FROM finca,usuario WHERE finca.cedula=usuario.cedula_usuario AND correo_usuario =?";
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
                        rs.getString("nombre_usuario"),
                        rs.getString("apellidos_usuario"),
                        rs.getString("cordenada_latitud"),
                        rs.getString("cordenada_longitud"),
                        rs.getString("cedula"),
                        rs.getString("i_lugar")));
                        
                
            }
            System.out.println("filtra fincaUsuario de la BD..");
            con.getConnection().close();
        } catch (Exception e) {
            System.out.println("NO lee la consulta de BD..");
        }
        return datos;
 }
 public List<Animal> filtraAnimalNombre(String nombreFinca){
     List<Animal> datos = new ArrayList<>();
        PreparedStatement pst;
        ResultSet rs;
        String sql="SELECT * FROM animal,finca WHERE animal.id_finca=finca.id_finca AND nombre_finca =?";
        System.out.println("Consultar ...");
        try {
            con = new Conexion();
            pst = con.getConnection().prepareStatement(sql);
            pst.setString(1,nombreFinca);
            rs = pst.executeQuery();
            System.out.println("Consultar ...resulset..." +rs);
            while (rs.next()) {                
                datos.add(new Animal( 
                        rs.getString("id_animal"), rs.getString("nombre_animal"),
                        rs.getString("fecha_nacimiento"), rs.getString("raza_animal"),
                        rs.getString("genero_animal"), rs.getString("metodo_concepcion"),
                        rs.getString("etapa_animal"), rs.getString("nombre_padre"),
                        rs.getString("nombre_madre"), rs.getString("foto_animal"),
                        rs.getString("observaciones"), rs.getString("id_finca")));
                
            }
            System.out.println("filtra animales la BD..");
            con.getConnection().close();
        } catch (Exception e) {
            System.out.println("NO lee la consulta de BD.. en filtrarAnimal");
        }
        return datos;
 }
    public List<Animal> filtrarAnimal(String campo) {
   
        List<Animal> datos = new ArrayList<>();
        PreparedStatement pst;
        ResultSet rs;
        String sql="SELECT * FROM animal,finca,usuario WHERE animal.id_finca=finca.id_finca AND finca.cedula=usuario.cedula_usuario AND correo_usuario =?";
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
                        rs.getString("etapa_animal"), rs.getString("nombre_padre"),
                        rs.getString("nombre_madre"), rs.getString("foto_animal"),
                        rs.getString("observaciones"), rs.getString("id_finca")));
                
            }
            System.out.println("filtra animales la BD..");
            con.getConnection().close();
        } catch (Exception e) {
            System.out.println("NO lee la consulta de BD.. en filtrarAnimal");
        }
        return datos;
    }
    public int CantidadLitrosLeche(String campo){
        int datoFinal=0;
        PreparedStatement pst;
        ResultSet rs ;
        
        try {
            String sql="SELECT SUM( litros_leche ) AS litros \n" +
                    "FROM leche, animal, finca\n" +
                    "WHERE leche.id_animal = animal.id_animal\n" +
                    "AND animal.id_finca = finca.id_finca\n" +
                    "AND nombre_finca =? \n" +
                    "AND MONTH( fecha_leche ) =01 \n" +
                    "AND YEAR( fecha_leche ) =2018";
            con = new Conexion();
            pst = con.getConnection().prepareStatement(sql);
            pst.setString(1, campo);
            rs = pst.executeQuery(sql);
            datoFinal= rs.getInt("litros") ;
            System.out.println("litros:  "+datoFinal);
            con.getConnection().close();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error contando litros de leche");
        }
        
        return datoFinal;
    }
   public boolean cambiaEtapaAnimal(String id_animal, String etapa){
       
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {
            con = new Conexion();
            String Consul = "SELECT * FROM animal WHERE  id_animal =?";
            pst = con.getConnection().prepareStatement(Consul);
            pst.setString(1, id_animal);
            rs = pst.executeQuery();
            System.err.println("animal existente");
            if (rs.absolute(1)) {
                try {
                    con = new Conexion();
                    String Consulta1 = ("UPDATE animal SET etapa_animal=?  WHERE  id_animal=?");
                    pst = con.getConnection().prepareStatement(Consulta1);
                    pst.setString(1, etapa);
                    pst.setString(2, id_animal);                    
                    if (pst.executeUpdate() == 1) {
                        
                        return true;
                        
                    }
                } catch (Exception e) {
                    System.err.println("error de cambio etapa de animal");
                    setRespuesta("Error !!  cambio etapa de animal!!");
                    e.printStackTrace();
                }  
            }
        }catch (Exception ex) {
                    System.err.println("no existe el codigo de animal ");
                    setRespuesta("Error !!  no existe el código del animal!!");
                    ex.printStackTrace();
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
    public boolean registroInseminacionExitosa(String id_inseminacion, String exito){
        
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {
            con = new Conexion();
            String Consul = "SELECT * FROM inseminacion WHERE  id_inseminacion =?";
            pst = con.getConnection().prepareStatement(Consul);
            pst.setString(1, id_inseminacion);
            rs = pst.executeQuery();
            
            if (rs.absolute(1)) {
                System.err.println("Inseminacion existente");
                try {
                    con = new Conexion();
                    String Consulta1 = ("insert into inseminacion (insemincacion_exitosa)values(?)  WHERE  id_inseminacion =?");
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
    public boolean registrarHistoriaClinica(HistoriaClinica obj){
        ResultSet rs = null;
        PreparedStatement pst = null;
        HistoriaClinica historia = (HistoriaClinica)obj;
        try {
            con = new Conexion();
            String Consul = "SELECT * FROM historia_clinica WHERE id_historia=?";
            pst = con.getConnection().prepareStatement(Consul);
            pst.setString(1, historia.getId_historia());
            rs = pst.executeQuery();
            System.err.println("Historia Clinica existente");
            if (rs.absolute(1)) {
                return true;
            }else{
                PreparedStatement pst1 = null;
                try {
                    con = new Conexion();
                    String sql1="INSERT INTO historia_clinica VALUES(?,?)";
                    pst1 = con.getConnection().prepareStatement(sql1);
                    pst1.setString(1, historia.getId_historia());
                    pst1.setString(2, historia.getId_animal());
                    
                    if(pst1.executeUpdate()==1){
                        return true;
                    }
                    con.getConnection().close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return false;
    }
    public List<DetalleHistorial> listaHistoriaFuncionario(String nombrefinca){
        List<DetalleHistorial> datos = new ArrayList<>();
        PreparedStatement pst;
        ResultSet rs;
        String sql="SELECT * FROM detalle_historia_clinica,historia_clinica,animal,finca"
                + " WHERE detalle_historia_clinica.id_historia=historia_clinica.id_historia "
                + " AND historia_clinica.id_animal=animal.id_animal "
                + " AND animal.id_finca=finca.id_finca "
                + " AND nombre_finca =?";
        System.out.println("Consultar ...");
        try {
            con = new Conexion();
            pst = con.getConnection().prepareStatement(sql);
            pst.setString(1, nombrefinca);
            rs = pst.executeQuery();
            System.out.println("listar historial clinico funcionario..." +rs);
            while (rs.next()){                
                datos.add(new DetalleHistorial( 
                        rs.getString("fecha_historia"), rs.getString("observaciones"),
                        rs.getString("enfermedad"), rs.getString("diagnosticos"),
                        rs.getString("tratamiento"), rs.getString("id_historia"),
                        rs.getString("cedula_veterinario")));
                
            }
            System.out.println("filtra detalle Historial Clinico por fincas Funcionario..");
            con.getConnection().close();
        } catch (Exception e) {
            System.out.println("NO lee la consulta de BD.. listar Historial funcionario");
            e.printStackTrace();
        }
        return datos;
    }
    public List<DetalleHistorial> listaHisto(String campo){
       
        List<DetalleHistorial> datos = new ArrayList<>();
        PreparedStatement pst;
        ResultSet rs;
        String sql="SELECT * FROM detalle_historia_clinica,historia_clinica,animal,finca,usuario"
                + " WHERE detalle_historia_clinica.id_historia=historia_clinica.id_historia "
                + "AND historia_clinica.id_animal=animal.id_animal "
                + "AND animal.id_finca=finca.id_finca "
                + "AND finca.cedula=usuario.cedula_usuario "
                + "AND correo_usuario =?";
        System.out.println("Consultar ...");
        try {
            con = new Conexion();
            pst = con.getConnection().prepareStatement(sql);
            pst.setString(1, campo);
            rs = pst.executeQuery();
            System.out.println("listar historia  ...usuario..." +rs);
            while (rs.next()) {                
                datos.add(new DetalleHistorial( 
                        rs.getString("fecha_historia"), rs.getString("observaciones"),
                        rs.getString("enfermedad"), rs.getString("diagnosticos"),
                        rs.getString("tratamiento"), rs.getString("id_historia"),
                        rs.getString("cedula_veterinario")));
                
            }
            System.out.println("filtra la BD..");
            con.getConnection().close();
        } catch (Exception e) {
            System.out.println("NO lee la consulta de BD.. en filtrar Historial usuario");
        }
        return datos;
    }

    public String buscaUsuario (String finca){
        ResultSet rs ;
        PreparedStatement pst ;
        String usu="";
        try {
            String sql="SELECT correo_usuario FROM usuario,finca WHERE usuario.cedula_usuario=finca.cedula AND id_finca=?";
            con = new Conexion();
            pst = con.getConnection().prepareStatement(sql);
            pst.setString(1,finca);
            rs = pst.executeQuery();
            usu = rs.getString("correo_usuario");
            System.out.println("correo:"+usu);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usu;
    }
    public String getRespuesta() {
        return Respuesta;
    }

    public void setRespuesta(String Respuesta) {
        this.Respuesta = Respuesta;
    }
    public static void main(String[] args) {
        Consultas c= new Consultas();
        c.buscaUsuario("F0001");
    }
    
    
}

