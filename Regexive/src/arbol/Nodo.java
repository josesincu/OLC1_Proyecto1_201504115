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
public class Nodo {

    private int numera_hoja;
    private Nodo hizq;
    private Nodo hder;
    
    private String valor;
    private int id;
    
    private int id_hoja;
    private String anulable;
    private LinkedList<String> primeros;
    private LinkedList<String> ultimos;
    private LinkedList<String> siguientes;
    
    
    public Nodo(Nodo hizq, Nodo hder, String valor, int id) {
        this.numera_hoja =0;
        this.hizq = hizq;
        this.hder = hder;
        this.valor = valor;
        this.id = id;
        
        this.id_hoja =0;
        this.anulable ="";
        this.primeros = new LinkedList<String>();
        this.ultimos = new LinkedList<String>();
        this.siguientes = new LinkedList<String>();
        
    }
    
    public Nodo(Nodo hizq, Nodo hder, String valor, int id,int id_hoja,String anulable) {
        this.numera_hoja =0;
        this.hizq = hizq;
        this.hder = hder;
        this.valor = valor;
        this.id = id;
        
        this.id_hoja = id_hoja;
        this.anulable = anulable;
        this.primeros = new LinkedList<String>();
        this.primeros.add(String.valueOf(id_hoja));
        
        this.ultimos = new LinkedList<String>();
        this.ultimos.add(String.valueOf(id_hoja));
        
        this.siguientes = new LinkedList<String>();
        
    }

    public Nodo getHizq() {
        return hizq;
    }

    public void setHizq(Nodo hizq) {
        this.hizq = hizq;
    }

    public Nodo getHder() {
        return hder;
    }

    public void setHder(Nodo hder) {
        this.hder = hder;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the id_hoja
     */
    public int getId_hoja() {
        return id_hoja;
    }

    /**
     * @param id_hoja the id_hoja to set
     */
    public void setId_hoja(int id_hoja) {
        this.id_hoja = id_hoja;
    }

    /**
     * @return the anulable
     */
    public String getAnulable() {
        return anulable;
    }

    /**
     * @param anulable the anulable to set
     */
    public void setAnulable(String anulable) {
        this.anulable = anulable;
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
    
    public void addPrimeros(String valor)
    {
    
        this.primeros.add(valor);
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
    
    public void addUltimos(String valor)
    {
    
        this.ultimos.add(valor);
    }

    /**
     * @return the siguientes
     */
    public LinkedList getSiguientes() {
        return siguientes;
    }

    /**
     * @param siguientes the siguientes to set
     */
    public void setSiguientes(LinkedList siguientes) {
        this.siguientes = siguientes;
    }
    
    public void addSiguientes(String valor)
    {
    
        this.siguientes.add(valor);
    }
    
    public String getCodigoInterno() {
        String etiqueta;
        if (hizq == null && hder == null) {
            etiqueta = "nodo" + id + " [ label =\""+this.getPrimeros()+"|{"+ this.getAnulable()+"|"+this.getValor()+"|"+"id: "+this.getId_hoja() +"}|"+this.getUltimos()+"\"];\n";
        } else {
            etiqueta = "nodo" + id + " [ label =\"" +this.getPrimeros()+"|{"+ this.getAnulable()+"|"+this.getValor()+"|"+"id: "+this.getId_hoja() +"}|"+getUltimos()+"\"];\n";
        }
        if (hizq != null) {
            etiqueta = etiqueta + hizq.getCodigoInterno()
                    + "nodo" + id + "->nodo" + hizq.id + "\n";
        }
        if (hder != null) {
            etiqueta = etiqueta + hder.getCodigoInterno()
                    + "nodo" + id + "->nodo" + hder.id + "\n";
        }
        return etiqueta;
    }
    
    public  void recorridoPreorden(Nodo raiz)
    {
        System.out.println("\n");
        System.out.println("############ INICIO #######################");
        System.out.println("\n");
        ayudantePreorden(raiz);
        System.out.println("\n");
         System.out.println("############## FIN #####################");
    }
    //meoto recursivo para recorrido en preorden
    
    private void ayudantePreorden(Nodo nodo)
    {
        if(nodo == null)
            return;
       
        System.out.print(nodo.getId_hoja() + " ");     //mostrar datos del nodo
        
        ayudantePreorden(nodo.getHder());   //recorre subarbol izquierdo
        ayudantePreorden(nodo.getHizq());     //recorre subarbol derecho
    }
   
    
    //#####################################################################################
     public  void llenar_datos(Nodo raiz)
    {
        this.ayudant_llenar_datos(raiz);   
    }
    //meoto recursivo para recorrido en preorden
    
    private void ayudant_llenar_datos(Nodo nodo)
    {
        if(nodo == null)
            return;
       
        //System.out.print(nodo.getId() + " "+nodo.getValor()+ "  ");     //mostrar datos del nodo
        //numera_hoja++;
        System.out.println("Valor:"+numera_hoja);
        this.numerar_hoja(nodo);
        this.ayudant_llenar_datos(nodo.getHder());   //recorre subarbol izquierdo
        this.ayudant_llenar_datos(nodo.getHizq());     //recorre subarbol derecho
    }
    
    
    public void verificar_anulabilidad(Nodo raiz)
    {
        String ji="+";
      if(raiz.getHizq()!=null || raiz.getHizq()!=null)
      switch(ji){
          case ".":
                  break;
          case "|":
              break;
          case "+":
              break;
          case "?":
              break;
          default:
              System.out.println("Ninguna de las opciones es correcta");
              break;
              
      }else if(raiz.getHizq()==null && raiz.getHizq()==null)
      {
          //numera_hoja++;
          //numerar_hoja(raiz, numera_hoja);
      }
      
       
    }//fin methodo verificar anulabilidad;
    
    public void numerar_hoja(Nodo raiz){
        
        if(raiz.getHizq()==null && raiz.getHizq()==null)
        {   
            numera_hoja++;
            raiz.id_hoja = numera_hoja;
            //raiz.setId_hoja(numera_hoja);
        }
    }
    

    
}
