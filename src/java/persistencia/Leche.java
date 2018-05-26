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
    String fecha_leche;
    String litros_leche;
    String id_animal;

    public Leche() {
    }

    public Leche(String fecha_leche, String litros_leche, String id_animal) {
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

    public String getLitros_leche() {
        return litros_leche;
    }

    public void setLitros_leche(String litros_leche) {
        this.litros_leche = litros_leche;
    }

    public String getId_animal() {
        return id_animal;
    }

    public void setId_animal(String id_animal) {
        this.id_animal = id_animal;
    }
    
    
}
