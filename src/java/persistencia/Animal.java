/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

/**
 *
 * @author cuenu
 * clase Animal, contiene la estructura con los atributos propios de un animal en este caso Vaca, para el sistema desarrollado.
 */
public class Animal {
    String id_animal;
    String nombre_animal;
    String fecha_nacimiento;
    String raza_animal;
    String genero_animal;
    String metodo_concepcion;
    String etapa_vida;
    String nombrePadre;
    String nombreMadre;
    String observaciones;
    String id_finca;

    public Animal() {
        /*Constructor vacio de la Clase Animal
        */
    }

    public Animal(String id_animal, String nombre_animal, String fecha_nacimiento, String raza_animal, String genero_animal, String metodo_concepcion, String etapa_vida, String nombrePadre, String nombreMadre, String observaciones, String id_finca) {
        /*Constructor con los atributos propios de la Clase Animal
        */
        this.id_animal = id_animal;
        this.nombre_animal = nombre_animal;
        this.fecha_nacimiento = fecha_nacimiento;
        this.raza_animal = raza_animal;
        this.genero_animal = genero_animal;
        this.metodo_concepcion = metodo_concepcion;
        this.etapa_vida = etapa_vida;
        this.nombrePadre = nombrePadre;
        this.nombreMadre = nombreMadre;
        this.observaciones = observaciones;
        this.id_finca = id_finca;
    }

    

    public String getId_animal() {
        return id_animal;
    }

    public void setId_animal(String id_animal) {
        this.id_animal = id_animal;
    }

    public String getNombre_animal() {
        return nombre_animal;
    }

    public void setNombre_animal(String nombre_animal) {
        this.nombre_animal = nombre_animal;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getRaza_animal() {
        return raza_animal;
    }

    public void setRaza_animal(String raza_animal) {
        this.raza_animal = raza_animal;
    }

    public String getGenero_animal() {
        return genero_animal;
    }

    public void setGenero_animal(String genero_animal) {
        this.genero_animal = genero_animal;
    }

    public String getMetodo_concepcion() {
        return metodo_concepcion;
    }

    public void setMetodo_concepcion(String metodo_concepcion) {
        this.metodo_concepcion = metodo_concepcion;
    }
    
    
    public String getEtapa_vida() {
        return etapa_vida;
    }

    public void setEtapa_vida(String etapa_vida) {
        this.etapa_vida = etapa_vida;
    }

    public String getNombrePadre() {
        return nombrePadre;
    }

    public void setNombrePadre(String nombrePadre) {
        this.nombrePadre = nombrePadre;
    }

    public String getNombreMadre() {
        return nombreMadre;
    }

    public void setNombreMadre(String nombreMadre) {
        this.nombreMadre = nombreMadre;
    }
    
    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getId_finca() {
        return id_finca;
    }

    public void setId_finca(String id_finca) {
        this.id_finca = id_finca;
    }
    
    
    
    
}
