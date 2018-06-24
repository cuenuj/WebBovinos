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
public class DetalleHistorial {
    /*clase DetalleHistorial, la cual contiene el cuerpo o datos que detallan el historial clínico de un animal.
        */
    String fecha_historia;
    String observaciones;
    String enfermedad;
    String Diagnostico;
    String tratamiento;
    String id_historial;
    String cedula_veterinario;

    public DetalleHistorial() {
        /*Contructor de la clase vacio.
        */
    }

    
    
    public DetalleHistorial(String fecha_historia, String observaciones, String enfermedad, String Diagnostico, String tratamiento, String id_historial, String cedula_veterinario) {
        /*constructor de la clase con los datos propios del detalle del historial clínico, según el modelo del negocio
        */
        this.fecha_historia = fecha_historia;
        this.observaciones = observaciones;
        this.enfermedad = enfermedad;
        this.Diagnostico = Diagnostico;
        this.tratamiento = tratamiento;
        this.id_historial = id_historial;
        this.cedula_veterinario = cedula_veterinario;
    }

    
    
    public String getFecha_historia() {
        return fecha_historia;
    }

    public void setFecha_historia(String fecha_historia) {
        this.fecha_historia = fecha_historia;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getDiagnostico() {
        return Diagnostico;
    }

    public void setDiagnostico(String Diagnostico) {
        this.Diagnostico = Diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getId_historial() {
        return id_historial;
    }

    public void setId_historial(String id_historial) {
        this.id_historial = id_historial;
    }

    public String getCedula_veterinario() {
        return cedula_veterinario;
    }

    public void setCedula_veterinario(String cedula_veterinario) {
        this.cedula_veterinario = cedula_veterinario;
    }
    
    
}
