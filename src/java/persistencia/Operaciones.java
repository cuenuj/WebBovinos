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
    public String insertar(Object obj);
    public String modificar(Object obj);
    public String eliminar(Object obj);
    public List<?> Consultar();
    public List<?> filtrar(String campo);
    
    public String insertarAnimal(Object obj);
    public String modificarAnimal(Object obj);
    public String eliminarAnimal(Object obj);
    public List<?> ConsultarAnimal();
    public List<?> filtrarAnimal(String campo);
}
