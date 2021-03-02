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
public class Siguientes {
    
    private String nombre_hoja;
    private String identificador;
    private LinkedList<String> siguientes;

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
     * @return the identificador
     */
    public String getIdentificador() {
        return identificador;
    }

    /**
     * @param identificador the identificador to set
     */
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    /**
     * @return the siguientes
     */
    public LinkedList<String> getSiguientes() {
        return siguientes;
    }

    /**
     * @param siguientes the siguientes to set
     */
    public void setSiguientes(LinkedList<String> siguientes) {
        this.siguientes = siguientes;
    }
    
    public void addSiguientes(String valor)
    {
    
    
    }
    
}
