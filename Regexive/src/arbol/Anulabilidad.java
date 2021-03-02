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
public class Anulabilidad {
    
    private int numera_hoja;
    public Anulabilidad()
    {
        numera_hoja = 0;
        System.out.println("");
    
    }
    
   public void llenar_datos_concatenacion(Nodo nuevaConcat,Nodo a,Nodo b)
   {
                  //calcular anulable
                  if(a!=null && b!=null)
                  {
                      if(a.getAnulable().equals("A") && b.getAnulable().equals("A"))
                      {
                          nuevaConcat.setAnulable("A");
                      }
                      else
                      {
                          nuevaConcat.setAnulable("N");
                      }
                      
                  }//fin del if
                  
                      //calcular primeros
                      if(a.getAnulable().equals("A"))
                      {
                          LinkedList<String> temp_primeros_a = a.getPrimeros();
                          LinkedList<String> temp_primeros_b = b.getPrimeros();
                          
                          for (int i = 0; i < temp_primeros_a.size(); i++) {
                              nuevaConcat.addPrimeros(temp_primeros_a.get(i));
                          }
                          
                          for (int i = 0; i <temp_primeros_b.size(); i++) {
                              
                              nuevaConcat.addPrimeros(temp_primeros_b.get(i));
                          }
                          
                      }
                      else{
                          LinkedList<String> temp_primeros_a = a.getPrimeros();
                                                   
                          for (int i = 0; i < temp_primeros_a.size(); i++) {
                              nuevaConcat.addPrimeros(temp_primeros_a.get(i));
                          }   
                      }
                      
                      //calcular ultimos
                      if(b.getAnulable().equals("A"))
                      {
                          LinkedList<String> temp_ultimos_a = a.getUltimos();
                          LinkedList<String> temp_ultimos_b = b.getUltimos();
                          
                          for (int i = 0; i < temp_ultimos_a.size(); i++) {
                              nuevaConcat.addUltimos(temp_ultimos_a.get(i));
                          }
                          
                          for (int i = 0; i <temp_ultimos_b.size(); i++) {
                              
                              nuevaConcat.addUltimos(temp_ultimos_b.get(i));
                          }   
                          
                      }
                      else
                      {
                          LinkedList<String> temp_ultimos_a = b.getUltimos();
                                                   
                          for (int i = 0; i < temp_ultimos_a.size(); i++) {
                              nuevaConcat.addUltimos(temp_ultimos_a.get(i));
                          }   
                      }
                
                
       
   
   }//fin de llenar datos concatenacion
   
   public void llenar_datos_or(Nodo nuevaOr,Nodo a, Nodo b){
       //************
                   //calcular anulabilidad
                  if(a!=null && b!=null)
                  {
                      if(a.getAnulable().equals("A") || b.getAnulable().equals("A"))
                      {
                          nuevaOr.setAnulable("A");
                      }
                      else
                      {
                          nuevaOr.setAnulable("N");
                      }
                      
                      
                  }//fin del if de "\\|" or
                  
                  //calcular primeros
                
                        LinkedList<String> temp_primeros_a = a.getPrimeros();
                        LinkedList<String> temp_primeros_b = b.getPrimeros();
                          
                          for (int i = 0; i < temp_primeros_a.size(); i++) {
                              nuevaOr.addPrimeros(temp_primeros_a.get(i));
                          }
                          
                          for (int i = 0; i <temp_primeros_b.size(); i++) {
                              
                              nuevaOr.addPrimeros(temp_primeros_b.get(i));
                          }
                          


                          //calcular ultimos
                          LinkedList<String> temp_ultimos_a = a.getUltimos();
                          LinkedList<String> temp_ultimos_b = b.getUltimos();
                          
                          for (int i = 0; i < temp_ultimos_a.size(); i++) {
                              nuevaOr.addUltimos(temp_ultimos_a.get(i));
                          }
                          
                          for (int i = 0; i <temp_ultimos_b.size(); i++) {
                              
                              nuevaOr.addUltimos(temp_ultimos_b.get(i));
                          }
                
                    
                //*******************

   
   
   }//fin del metodo llenar datos or
   
   public void llenar_datos_aste_y_interr(Nodo nuevaPor,Nodo a)
   {
                //calculando anulabilidad
                nuevaPor.setAnulable("A");

                //calculando primeros
                LinkedList<String> temp_primero_a = a.getPrimeros();
                       
                for (int i = 0; i < temp_primero_a.size(); i++) {
                         nuevaPor.addPrimeros(temp_primero_a.get(i));
                }

                //calculando ultimos
                LinkedList<String> temp_ultimo_a = a.getUltimos();
                       
                for (int i = 0; i < temp_ultimo_a.size(); i++) {
                         nuevaPor.addUltimos(temp_ultimo_a.get(i));
                }

                //************
   }//fin de llenar datos asterisco y interrogacion
   
   public void llenar_datos_mas(Nodo nuevaMas,Nodo a){
       
        //calcular anulabilidad
        if(a.getAnulable().equals("A"))
        {
            nuevaMas.setAnulable("A");
        }else{
        
            nuevaMas.setAnulable("N");
        }
                
        
        //calcular primeros
        
        LinkedList<String> temp_primero_a = a.getPrimeros();
                       
        for (int i = 0; i < temp_primero_a.size(); i++) {
                  nuevaMas.addPrimeros(temp_primero_a.get(i));
        }
        
        //calcular ultimos
        LinkedList<String> temp_ultimo_a = a.getUltimos();
                       
        for (int i = 0; i < temp_ultimo_a.size(); i++) {
                   nuevaMas.addUltimos(temp_ultimo_a.get(i));
        }
   }
}
