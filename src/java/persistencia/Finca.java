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
public class Finca {
    
    String id_finca;
    String nombre_finca;
    String cordenada_latitud;
    String cordenada_longitud;
    String id_dueno;
    String id_lugar;
    String nombreDueno;
    String apellidoDueno;

    public Finca(){
        
    }

    public Finca(String id_finca, String nombre_finca, String nombreDueno, String apellidoDueno, String cordenada_latitud, String cordenada_longitud, String id_dueno, String id_lugar) {
        this.id_finca = id_finca;
        this.nombre_finca = nombre_finca;
        this.nombreDueno = nombreDueno;
        this.apellidoDueno = apellidoDueno;
        this.cordenada_latitud = cordenada_latitud;
        this.cordenada_longitud = cordenada_longitud;
        this.id_dueno = id_dueno;
        this.id_lugar = id_lugar;
        
    }

    

    public String getCordenada_latitud() {
        return cordenada_latitud;
    }

    public void setCordenada_latitud(String cordenada_latitud) {
        this.cordenada_latitud = cordenada_latitud;
    }

    public String getCordenada_longitud() {
        return cordenada_longitud;
    }

    public void setCordenada_longitud(String cordenada_longitud) {
        this.cordenada_longitud = cordenada_longitud;
    }

    
    public String getId_finca() {
        return id_finca;
    }

    public void setId_finca(String id_finca) {
        this.id_finca = id_finca;
    }

    public String getNombre_finca() {
        return nombre_finca;
    }

    public void setNombre_finca(String nombre_finca) {
        this.nombre_finca = nombre_finca;
    }

    public String getId_dueno() {
        return id_dueno;
    }

    public void setId_dueno(String id_dueno) {
        this.id_dueno = id_dueno;
    }

    public String getId_lugar() {
        return id_lugar;
    }

    public void setId_lugar(String id_lugar) {
        this.id_lugar = id_lugar;
    }
    

    public String getNombreDueno() {
        return nombreDueno;
    }

    public void setNombreDueno(String nombreDueno) {
        this.nombreDueno = nombreDueno;
    }

    public String getApellidoDueno() {
        return apellidoDueno;
    }

    public void setApellidoDueno(String apellidoDueno) {
        this.apellidoDueno = apellidoDueno;
    }
    
}
