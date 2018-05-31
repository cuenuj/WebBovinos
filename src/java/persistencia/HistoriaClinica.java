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
    
    String id_historia;
    String id_animal;

    public HistoriaClinica() {
    }

    
    public HistoriaClinica(String id_historia, String id_animal) {
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
