/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol;
//import analizadores.*;

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
    
   public void llenar_datos_concatenacion(LinkedList<Siguientes> lista_siguientes,Nodo nuevaConcat,Nodo a,Nodo b)
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
                
                 //posee singuente
                //Para cada elemento en UltimaPos del nodo a, agregar PrimeraPos del nodo b a su SiguientePos
                LinkedList<String> temp_prim = b.getPrimeros();
                LinkedList<String> temp_ultimo_a = a.getUltimos();
                
                for (int i = 0; i <a.getUltimos().size(); i++) {
                    
                    
                    for (int j = 0; j <b.getPrimeros().size(); j++) {
                       
                        for (int k = 0; k <lista_siguientes.size(); k++) {
                            
                            if(temp_ultimo_a.get(i).equals(lista_siguientes.get(k).getId_hoja()))
                            {
                                lista_siguientes.get(k).addSiguientes(temp_prim.get(j));
                                System.out.println("");
                            }
                    
                    }
                    }
                    //}
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
   
   public void llenar_datos_aste(LinkedList<Siguientes> lista_siguientes,Nodo nuevaPor,Nodo a)
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
                
                //calculando siguientes
                //posee siguiente
                //Para cada elemento en UltimaPos del nodo a, agregar PrimeraPos del nodo a a su SiguientePos
                LinkedList<String> temp_prim = a.getPrimeros();
                for (int i = 0; i <a.getUltimos().size(); i++) {
            
                     for (int j = 0; j <a.getPrimeros().size(); j++) {
                         
                         for (int k = 0; k <lista_siguientes.size(); k++) {
                            
                            if(temp_ultimo_a.get(i).equals(lista_siguientes.get(k).getId_hoja()))
                            {
                                lista_siguientes.get(k).addSiguientes(temp_prim.get(j));
                            }
                    
                        }
                     }
                }
                
                //************
   }//fin de llenar datos asterisco y interrogacion
   
   public void llenar_datos_interr(Nodo nuevaInter,Nodo a)
   {
        //calculando anulabilidad
                nuevaInter.setAnulable("A");

                //calculando primeros
                LinkedList<String> temp_primero_a = a.getPrimeros();
                       
                for (int i = 0; i < temp_primero_a.size(); i++) {
                         nuevaInter.addPrimeros(temp_primero_a.get(i));
                }

                //calculando ultimos
                LinkedList<String> temp_ultimo_a = a.getUltimos();
                       
                for (int i = 0; i < temp_ultimo_a.size(); i++) {
                         nuevaInter.addUltimos(temp_ultimo_a.get(i));
                }

   }   
       
   public void llenar_datos_mas(LinkedList<Siguientes> lista_siguientes,Nodo nuevaMas,Nodo a){
       
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
        
        
        //calculando siguientes
        //posee siguiente
        //Para cada elemento en UltimaPos del nodo a, agregar PrimeraPos del nodo a a su SiguientePos
        for (int i = 0; i <a.getUltimos().size(); i++) {
            
            for (int j = 0; j <a.getPrimeros().size(); j++) {
            
                 
                    for (int k = 0; k <lista_siguientes.size(); k++) {
                        if(temp_ultimo_a.get(i).equals(lista_siguientes.get(k).getId_hoja()))
                        {
                            lista_siguientes.get(k).addSiguientes(temp_primero_a.get(j));
                        }
                    
                    }
             
            }
            
       }
                
   }
}
