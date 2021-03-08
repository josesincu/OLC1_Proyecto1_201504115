/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol;

import java.util.LinkedList;

/**
 *
 * @author dark
 */
public class Estados {

    /**
     * @return the nombre_hoja
     */
    public String getNombre_hoja() {
        return nombre_hoja;
    }

    /**
     * @param nombre_hoja the nombre_hoja to set
     */
    public void setNombre_hoja(String nombre_hoja) {
        this.nombre_hoja = nombre_hoja;
    }

    /**
     * @return the estadoAceptacion
     */
    public String getEstadoAceptacion() {
        return estadoAceptacion;
    }

    /**
     * @param estadoAceptacion the estadoAceptacion to set
     */
    public void setEstadoAceptacion(String estadoAceptacion) {
        this.estadoAceptacion = estadoAceptacion;
    }

    /**
     * @return the nombre_estado
     */
    public String getNombre_estado() {
        return nombre_estado;
    }

    /**
     * @param nombre_estado the nombre_estado to set
     */
    public void setNombre_estado(String nombre_estado) {
        this.nombre_estado = nombre_estado;
    }

    /**
     * @return the estado
     */
    public LinkedList<String> getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(LinkedList<String> estado) {
        this.estado = estado;
    }
    
    public void addEstado_nuevo(String valor)
    {
        this.estado.add(valor);
    }
    private String nombre_estado;
    private LinkedList<String> estado;
    private String nombre_hoja;
    private String estadoAceptacion;
    
    public Estados(String nombre_es,String nombr_hoj, String estaAcep)
    {
        this.nombre_estado = nombre_es;
        this.estado = new LinkedList<>();
        this.nombre_hoja = nombr_hoj;
        this.estadoAceptacion = estaAcep;
    
    }
    
    public Estados(String nombre_estad,LinkedList<String> estado,String nombr_hoj, String estaAcep)
    {
        this.nombre_estado = nombre_estad;
        this.estado = estado;
        this.nombre_hoja = nombr_hoj;
        this.estadoAceptacion = estaAcep;
        
    }
    
    
    
}
