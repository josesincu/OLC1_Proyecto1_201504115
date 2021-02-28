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
public class Tabla_Conjunto extends LinkedList<Conjunto_Simbolos>{
    private LinkedList<Integer> conjunto_dato= null;
    
    public Tabla_Conjunto()
    {
        super();
    }

    /**
     * @return the conjunto_dato
     */
    public LinkedList<Integer> getConjunto_dato(String id) {
        for(Conjunto_Simbolos s:this){
            if(s.getId().equals(id)){
                return s.getLetra_conjunto();
            }
        }
        System.out.println("La variable "+id+" no existe en este ámbito.");
        
        return null;
    }

    /**
     * @param conjunto_dato the conjunto_dato to set
     */
    public void setConjunto_dato(String id,int valor) {
        
         for(Conjunto_Simbolos s:this){
            if(s.getId().equals(id)){
                s.agregar_nueva(valor);
                return;
            }
        }
        System.out.println("La variable "+id+" no existe en este ámbito, por lo "
                + "que no puede asignársele un valor.");
    }


}

