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
public class Conjunto_Simbolos {
    private String id;
    private LinkedList<Integer> letra_conjunto;
    
    
    public Conjunto_Simbolos()
    {
        id = "";
        letra_conjunto = new LinkedList<>();
    }
    public Conjunto_Simbolos(String id,char inicio, char fin)
    {
        this.id = id;
        this.letra_conjunto = new LinkedList<>();
        this.conjunto_letra(inicio,fin);
    }
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the letra_conjunto
     */
    public LinkedList<Integer> getLetra_conjunto() {
        return letra_conjunto;
    }

    /**
     * @param letra_conjunto the letra_conjunto to set
     */
    public void setLetra_conjunto(LinkedList<Integer> letra_conjunto) {
        this.letra_conjunto = letra_conjunto;
    }
    
    
    public int get_tamanio_conjunto()
    {
        return letra_conjunto.size();
    }
    public void conjunto_letra(char inicio, char fin)
    {
        //int ini = (int)inicio;
        //int finn = (int)fin;
        
        for (int i =(int)inicio; i <=(int)fin; i++) {
            
            letra_conjunto.add(i);
            System.out.println(i);
        }
    }
    
    public void imprimir()
    {
        //int inici=(int)letra_conjunto.get(0);
        
        
        for(int valor : letra_conjunto)
        {
            System.out.println("dato: "+((char)valor));
        }
    }

    
    
    
}
