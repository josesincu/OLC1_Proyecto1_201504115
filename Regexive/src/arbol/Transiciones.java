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
public class Transiciones {
    private String matrix[][];
    
    /**
     * @return the matrix
     */
    public String[][] getMatrix() {
        return matrix;
    }

    /**
     * @param matrix the matrix to set
     */
    public void setMatrix(String[][] matrix) {
        this.matrix = matrix;
    }
    
    
    public Transiciones()
    {
       
    }
    
    public void tabla_transiciones(int tam,LinkedList<Siguientes> lista_sig,LinkedList<String> primeros){
        //inicializadno matrix
         matrix = new String[tam][tam];
        for (int i = 0; i <tam; i++) {
            for (int j = 0; j <tam; j++) {
                matrix[i][j]= "-1";//-1 indica que no tiene nada
            }
        }
        matrix[0][0] = "Estados";
        
        //llenando los encabezados de la matrix
        for (int i = 0; i <lista_sig.size(); i++) {
            if(!(lista_sig.get(i).getNombre_hoja().equals(matrix[0][i+1]))){
                matrix[0][i+1]=lista_sig.get(i).getNombre_hoja();
            } 
        }
        
        //imprimiendo valores 
        for (int i = 0; i <matrix.length; i++) {
            System.out.print("\t"+matrix[0][i]);
        }
        
    }
    
    
}
