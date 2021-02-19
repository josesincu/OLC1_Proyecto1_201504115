/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regexive;
import arbol.*;

/**
 *
 * @author dark
 */
public class Regexive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Conjunto_Simbolos conj = new Conjunto_Simbolos("letra",'a','z');
        conj.imprimir();
        System.out.println("///////////////////////////////////////");
        char a = 'a';
        char z = 'z';
        int valor_a = (int)a;
        int valor_z = (int)z;
        System.out.println(valor_a+"->"+valor_z);
        
        //Grafica graf= null;
        //graf = new Grafica();
        //graf.show();
        //System.out.println("Hola mundo");
    }
    
}
