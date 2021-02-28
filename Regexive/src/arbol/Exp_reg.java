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
public class Exp_reg {
   private String id_expresion;
    private LinkedList simbolos;
    private LinkedList primeros;
    private LinkedList ultimos;

    /**
     * @return the id_expresion
     */
    public String getId_expresion() {
        return id_expresion;
    }

    /**
     * @param id_expresion the id_expresion to set
     */
    public void setId_expresion(String id_expresion) {
        this.id_expresion = id_expresion;
    }

    /**
     * @return the simbolos
     */
    public LinkedList getSimbolos() {
        return simbolos;
    }

    /**
     * @param simbolos the simbolos to set
     */
    public void setSimbolos(LinkedList simbolos) {
        this.simbolos = simbolos;
    }

    /**
     * @return the primeros
     */
    public LinkedList getPrimeros() {
        return primeros;
    }

    /**
     * @param primeros the primeros to set
     */
    public void setPrimeros(LinkedList primeros) {
        this.primeros = primeros;
    }

    /**
     * @return the ultimos
     */
    public LinkedList getUltimos() {
        return ultimos;
    }

    /**
     * @param ultimos the ultimos to set
     */
    public void setUltimos(LinkedList ultimos) {
        this.ultimos = ultimos;
    }
    
    public Exp_reg()
    {
    
    }
    
}
