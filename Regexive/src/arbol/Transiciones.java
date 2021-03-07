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
    private Estados matrix[][];
    private LinkedList<Siguientes> lista_siguientes;
    private LinkedList<DatoColum> temp_encabezado;
    private LinkedList<Estados> lista_estado;
    private int contar_estado;
    private int cont_fila;
    private int fila ;
    private int columna;
    
    public Transiciones()
    {
        this.lista_siguientes = new LinkedList<>();
        this.temp_encabezado = new LinkedList<>();
        this.lista_estado = new LinkedList<>();
        this.temp_encabezado.add(new DatoColum(0,0,"Estado"));
        contar_estado=0;
        cont_fila = 1;
        fila = 0;
        columna =0;
       
    }
    
    
    
   
   
    public void tabla_transiciones(LinkedList<Siguientes> lista_sig,LinkedList<String> primeros){
        //le asigno el valor de los siguientes a la nueva lista
        lista_siguientes = lista_sig;
        int temp_colum = 1;
        
        //agregrar a encabezado no repetidos
        for (int i = 0; i <lista_sig.size(); i++) {
            if(!(estaRepetido(lista_sig.get(i).getNombre_hoja(),temp_encabezado)))
            {
                temp_encabezado.add(new DatoColum(0,temp_colum,lista_sig.get(i).getNombre_hoja()));
                temp_colum++;
            }
        }
        
        //creamos el tamanio correcto de la matrix
        fila = temp_encabezado.size()*2;
        columna = temp_encabezado.size();
        
        //creamos la matriz con los tamanios idicados
        matrix =  new Estados[fila][columna];
        
        for (int i = 0; i <fila; i++) {
            
            for (int j = 0; j <columna; j++) {
                matrix[i][j]= new Estados("-1");//indica que la matrix esta vacia
            }
        }
        
        //encabezados
        for (int i = 0; i <temp_encabezado.size(); i++) {
            matrix[0][i].setNombre_estado(temp_encabezado.get(i).getLetra());
        }
        
        //se le asigna el estado incial de la matriz
        matrix[1][0].setNombre_estado("S"+contar_estado);
        matrix[1][0].setEstado(primeros);
        lista_estado.add(new Estados("S"+contar_estado,primeros));
        
        //llamando  al metod para trabajr con los estado
        llenarTransiciones(matrix);
        verificar_estadoNuevos();
        imprimirValores();
        //imprimirTablaSiguientes();
        System.out.println("");
            
                 
    }//fin de tabla transiciones
    
    //verificar valores repetidos no agregar
    public boolean estaRepetido(String valor, LinkedList<DatoColum> sig)
    {
        boolean encontrado = false;
        
        for (int i = 0; i <sig.size(); i++) {
            if(sig.get(i).getLetra().equals(valor))
            {
               encontrado = true;
            }
        }
            
    return encontrado;
    }//fin de metodo estaRepetido
    
    public void llenarTransiciones(Estados matrix[][])
    {
        
                //crear_estados(matrix[1][0].getEstado());
                crear_estados(matrix[1][0]);
                
               
    }//fin de metodo llenar transiciones
    
    public void crear_estados(Estados estad)
    {
        //recibio como parametro (LinkedList<String> recorrerEstado)
        //ver datos
        LinkedList<String> recorrerEstado = estad.getEstado();
        String nombreEstado = estad.getNombre_estado();
        
        
        //for funcional
        for (int i = 0; i <recorrerEstado.size(); i++) {
            //EstadoS1 [2,3,4,5]
            System.out.println("Follow: "+recorrerEstado.get(i));
            
            for (int j = 0; j <lista_siguientes.size(); j++) {
                  
                
                if(recorrerEstado.get(i).equals(lista_siguientes.get(j).getId_hoja()) )
                {
                    System.out.print("\tEstado: "+recorrerEstado.get(i)+"->"+lista_siguientes.get(j).getId_hoja()+
                            "\tCaracter: "+lista_siguientes.get(j).getNombre_hoja()
                    +"\tSinguientes:"+lista_siguientes.get(j).getSiguientes());
                    System.out.println("");
                    
                    if(!(lista_siguientes.get(j).getSiguientes().isEmpty()))
                    {
                        llenar_EstadoColum(lista_siguientes.get(j).getNombre_hoja(),lista_siguientes.get(j).getSiguientes(),nombreEstado);
                    }
                    break;//veficar aqui dudas
                }
                
            }
            //System.out.println("");
        }
        //aumentar columna aqui porque termina la lectura de column
        cont_fila++;
    }//fin de verificar objeto
    
    public void llenar_EstadoColum(String valor,LinkedList<String> estad_transi,String nombreEst)
    {
        int fila =0;
        int columna = 0;
        boolean encontrado = false;
        
        for (int i = 0; i <temp_encabezado.size(); i++) {
            System.out.println("");
            System.out.print("\tFila:"+temp_encabezado.get(i).getFila());
            System.out.print("\tColumna:"+temp_encabezado.get(i).getColumna());
            System.out.print("\tLetra:"+temp_encabezado.get(i).getLetra());
            
        }
        
        for (int i = 0; i <temp_encabezado.size(); i++) {
            
            if(temp_encabezado.get(i).getLetra().equals(valor))
            {
                
                fila = temp_encabezado.get(i).getFila()+cont_fila;
                columna = temp_encabezado.get(i).getColumna();
                
                System.out.print("\tFila: "+fila);
                System.out.print("\tColumna: "+columna);
                System.out.println("");
                encontrado = true;
                break;
            }
        }
       
     
        boolean asignado = false;
        
        if(encontrado == true){
              
                    if(asignado == false){
                     if(matrix[fila][columna].getNombre_estado().equals("-1") && !(verificarEstado(estad_transi)))
                        {
                            //!verdadero  falso
                            //!falso      verdadero
                            
                        contar_estado++;
                        matrix[fila][columna].setNombre_estado("S"+contar_estado);
                        matrix[fila][columna].setEstado(estad_transi);
                        
                        lista_estado.add(new Estados("S"+contar_estado,estad_transi));
                        
                        System.out.println("\t["+fila+"]["+columna+"]: "+matrix[fila][columna].getNombre_estado());
                        //return;
                        asignado = true;
                        //break;
                        return;
                        }else
                        {
                         //simplemente asignarle el estado
                            //System.out.println("\tQuiere datos aquiiiiii!!");
                            if(matrix[fila][columna].getNombre_estado().equals("-1"))
                            {
                                
                                matrix[fila][columna].setNombre_estado(nombreEst);
                                matrix[fila][columna].setEstado(estad_transi);
                                System.out.println("\t["+fila+"]["+columna+"]: "+matrix[fila][columna].getNombre_estado());
                                return;
                            }
                            
                            
                        }
                     
                    }//fin de if
               
        
            
        }
        //metdo imprimir
        imprimirValores();
        
    }//fin fde metodo llenar columna
    
    //si el estado exist o no
    public boolean verificarEstado(LinkedList<String> estadoVerfi)
    {
        boolean encontroEstado = false;
        for (int i = 0; i <lista_estado.size(); i++) {
            if(estadoVerfi.equals(lista_estado.get(i).getEstado()))
            {
                encontroEstado = true;
                break;
            }
        }
        return encontroEstado;
    }//fin de metodo verificar estado
        
        //verifcar si existe en columna o no ...sino agregarla y ejecutarla
    public void verificar_estadoNuevos(){
       
        for (int i = 2; i <lista_estado.size()+1; i++) {
            if(matrix[i][0].getNombre_estado().equals("-1"))
            {
                matrix[i][0].setEstado(lista_estado.get(i-1).getEstado());
                matrix[i][0].setNombre_estado(lista_estado.get(i-1).getNombre_estado());
                // borrar aqui si no funcion //crear_estados(lista_estado.get(i-1).getEstado());
                crear_estados(matrix[i][0]);
            }
               
        }
        
    }//fin de metodo verificar_estadosNuevos
    
    
    public void imprimirValores()
    {
        //imprimiendo la matrix
        for (int i = 0; i <fila; i++) {
            for (int j = 0; j <columna; j++) {
                System.out.print("\t"+matrix[i][j].getNombre_estado());
            }
            System.out.println("");
        }
        System.out.println("\n\n");
        
    }
    
    public void imprimirTablaSiguientes()
    {
        for (int i = 0; i <lista_siguientes.size(); i++) {
            System.out.println("");
            System.out.print("\tHoja:"+lista_siguientes.get(i).getNombre_hoja());
            System.out.print("\tId_Hoja:"+lista_siguientes.get(i).getId_hoja());
            System.out.print("\tList_Siguientes:"+lista_siguientes.get(i).getSiguientes());
        }
    }
}
