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
    String extencion_finca;
    String id_dueno;
    String id_lugar;

    public Finca(){
        
    }

    public Finca(String id_finca, String nombre_finca, String extencion_finca, String id_dueno, String id_lugar) {
        this.id_finca = id_finca;
        this.nombre_finca = nombre_finca;
        this.extencion_finca = extencion_finca;
        this.id_dueno = id_dueno;
        this.id_lugar = id_lugar;
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

    public String getExtencion_finca() {
        return extencion_finca;
    }

    public void setExtencion_finca(String extencion_finca) {
        this.extencion_finca = extencion_finca;
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
    

    
}
