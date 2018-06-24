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
public class Inseminacion {
    /*Clase Inseminacion, la cual contiene los atributos propios de este objetos según el modelo de negocio planteado
        */
    String id_inseminacion;
    String fecha_inseminacion;
    String raza_pajilla;
    String sexada;
    String id_veterinario;
    String id_animal;
    String inseminacion_exitosa;

    public Inseminacion() {
        /*Constructor de la clase vacio
        */
    }
     public Inseminacion(String id_inseminacion, String fecha_inseminacion, String raza_pajilla, String sexada, String id_veterinario, String id_animal, String inseminacion_exitosa) {
        /*Constructor de la clase con los atributos propios de este objeto.
        */
        this.id_inseminacion = id_inseminacion;
        this.fecha_inseminacion = fecha_inseminacion;
        this.raza_pajilla = raza_pajilla;
        this.sexada = sexada;
        this.id_veterinario = id_veterinario;
        this.id_animal = id_animal;
        this.inseminacion_exitosa = inseminacion_exitosa;
    }
    
    

    public String getId_inseminacion() {
        return id_inseminacion;
    }

    public void setId_inseminacion(String id_inseminacion) {
        this.id_inseminacion = id_inseminacion;
    }

    public String getFecha_inseminacion() {
        return fecha_inseminacion;
    }

    public void setFecha_inseminacion(String fecha_inseminacion) {
        this.fecha_inseminacion = fecha_inseminacion;
    }

    public String getRaza_pajilla() {
        return raza_pajilla;
    }

    public void setRaza_pajilla(String raza_pajilla) {
        this.raza_pajilla = raza_pajilla;
    }

    public String getSexada() {
        return sexada;
    }

    public void setSexada(String sexada) {
        this.sexada = sexada;
    }

    public String getId_veterinario() {
        return id_veterinario;
    }

    public void setId_veterinario(String id_veterinario) {
        this.id_veterinario = id_veterinario;
    }

    public String getId_animal() {
        return id_animal;
    }

    public void setId_animal(String id_animal) {
        this.id_animal = id_animal;
    }

    public String getInseminacion_exitosa() {
        return inseminacion_exitosa;
    }

    public void setInseminacion_exitosa(String inseminacion_exitosa) {
        this.inseminacion_exitosa = inseminacion_exitosa;
    }
    
}
