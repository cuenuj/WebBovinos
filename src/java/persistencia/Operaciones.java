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
    public String eliminar(String obj);
    public List<?> Consultar();
    public List<?> filtrar(String campo);
    
    public String insertarAnimal(Object obj);
    public String modificarAnimal(Object obj);
    public String eliminarAnimal(Object obj);
    public List<?> ConsultarAnimal();
    public List<?> filtrarAnimal(String campo);
    
    public String insertarInseminacion(Object obj);
    public String modificarInseminacion(Object obj);
    public String eliminarInseminacion(Object obj);
    public List<?> ConsultarInseminacion();
    public List<?> filtrarInseminacion(String campo);
    
    public String insertarLeche(Object obj);
    public String modificarLeche(Object obj);
    public List<?> ConsultarLeche();
    
    public boolean insertarHistoria(Object obj);
    public List<?> ConsultarHistoria();
    public String insertarDetalleHistoria(Object obj);
}
