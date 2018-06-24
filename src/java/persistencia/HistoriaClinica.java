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
public class HistoriaClinica {
    /*Clase HistoriaClinica, la cual contiene los datos caracteristicos y propios de la cabecera de un historial clinico según el modelo planteado.
        */
    String id_historia;
    String id_animal;

    public HistoriaClinica() {
        /*Constructor de la clase vacio
        */
    }

    
    public HistoriaClinica(String id_historia, String id_animal) {
        /*Constructor de la clase con los atributos propios de este objeto.
        */
        this.id_historia = id_historia;
        this.id_animal = id_animal;
    }

        
    public String getId_historia() {
        return id_historia;
    }

    public void setId_historia(String id_historia) {
        this.id_historia = id_historia;
    }

    public String getId_animal() {
        return id_animal;
    }

    public void setId_animal(String id_animal) {
        this.id_animal = id_animal;
    }
    
    
}
