/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;

/**
 *
 * @author cuenu
 */
public interface Operaciones {
    /*clase Operaciones, la cual inicializa los metodos de la clase ConsultasDAO.
        */
    public String insertar(Object obj);
    public String modificar(Object obj);
    public String eliminar(String obj);
    
    public String insertarAnimal(Object obj);
    
    public String insertarInseminacion(Object obj);
    
    public String insertarLeche(Object obj);;
    
    public boolean insertarHistoria(Object obj);
    public String insertarDetalleHistoria(Object obj);
}
