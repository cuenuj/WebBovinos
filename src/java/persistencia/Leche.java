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
public class Leche {
    /*Clase Leche, la cual contiene los atributos propios de este objeto para la finalidad del modelo de negocio.
        */
    String fecha_leche;
    int litros_leche;
    String id_animal;

    public Leche() {
        /*Constructor de la clase vacio
        */
    }

    public Leche(String fecha_leche, int litros_leche, String id_animal) {
        /*Constructor de la clase con todos los atributos propios de este objeto.
        */
        this.fecha_leche = fecha_leche;
        this.litros_leche = litros_leche;
        this.id_animal = id_animal;
    }

    
    
    public String getFecha_leche() {
        return fecha_leche;
    }

    public void setFecha_leche(String fecha_leche) {
        this.fecha_leche = fecha_leche;
    }

    public int getLitros_leche() {
        return litros_leche;
    }

    public void setLitros_leche(int litros_leche) {
        this.litros_leche = litros_leche;
    }

    public String getId_animal() {
        return id_animal;
    }

    public void setId_animal(String id_animal) {
        this.id_animal = id_animal;
    }
    
    
}
