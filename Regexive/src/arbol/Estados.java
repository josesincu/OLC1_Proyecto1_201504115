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
    
    public Estados(String nombre_es)
    {
        this.nombre_estado = nombre_es;
        this.estado = new LinkedList<>();
    
    }
    
    public Estados(String nombre_estad,LinkedList<String> estado)
    {
        this.nombre_estado = nombre_estad;
        this.estado = estado;
        
    }
    
    
    
}
