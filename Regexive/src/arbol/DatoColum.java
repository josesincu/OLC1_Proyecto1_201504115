/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol;

/**
 *
 * @author dark
 */
public class DatoColum {

    /**
     * @return the fila
     */
    public int getFila() {
        return fila;
    }

    /**
     * @param fila the fila to set
     */
    public void setFila(int fila) {
        this.fila = fila;
    }

    /**
     * @return the Columna
     */
    public int getColumna() {
        return columna;
    }

    /**
     * @param Columna the Columna to set
     */
    public void setColumna(int Columna) {
        this.columna = Columna;
    }

    /**
     * @return the letra
     */
    public String getLetra() {
        return letra;
    }

    /**
     * @param letra the letra to set
     */
    public void setLetra(String letra) {
        this.letra = letra;
    }
    private int fila;
    private int columna;
    private String letra;
    
    public DatoColum(int fila,int columna,String identificador)
    {
        this.fila = fila;
        this.columna = columna;
        this.letra = identificador;
    
    }
}
