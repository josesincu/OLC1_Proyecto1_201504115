/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol;
import regexive.*;

import java.io.FileWriter;
import java.io.PrintWriter;
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
        fila = temp_encabezado.size()*7;
        columna = temp_encabezado.size();
        
        //creamos la matriz con los tamanios idicados
        matrix =  new Estados[fila][columna];
        
        for (int i = 0; i <fila; i++) {
            
            for (int j = 0; j <columna; j++) {
                matrix[i][j]= new Estados("-1","-1","-1");//indica que la matrix esta vacia
            }
        }
        
        //encabezados
        for (int i = 0; i <temp_encabezado.size(); i++) {
            matrix[0][i].setNombre_estado(temp_encabezado.get(i).getLetra());
        }
        
        //se le asigna el estado incial de la matriz
        matrix[1][0].setNombre_estado("S"+contar_estado);
        matrix[1][0].setEstado(primeros);
        
        lista_estado.add(new Estados("S"+contar_estado,primeros,lista_siguientes.getFirst().getNombre_hoja(),estadoAceptacion(primeros)));
        
        //llamando  al metod para trabajr con los estado
        llenarTransiciones(matrix);
        verificar_estadoNuevos();
        imprimirValores();
        verListaEstado();
        
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
    
    public void llenar_EstadoColum(String nombre_hoja,LinkedList<String> estad_transi,String nombreEst)
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
            
            if(temp_encabezado.get(i).getLetra().equals(nombre_hoja))
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
                        matrix[fila][columna].setNombre_hoja(nombre_hoja);
                        matrix[fila][columna].setEstadoAceptacion(estadoAceptacion(estad_transi));
                        
                        lista_estado.add(new Estados("S"+contar_estado,estad_transi,nombre_hoja,estadoAceptacion(estad_transi)));
                        
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
                                matrix[fila][columna].setNombre_hoja(nombre_hoja);
                                matrix[fila][columna].setEstadoAceptacion(estadoAceptacion(estad_transi));
                                
                               
                                
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
                
                matrix[i][0].setNombre_estado(lista_estado.get(i-1).getNombre_estado());
                matrix[i][0].setEstado(lista_estado.get(i-1).getEstado());
                matrix[i][0].setNombre_hoja(lista_estado.get(i-1).getNombre_hoja());
                matrix[i][0].setEstadoAceptacion(lista_estado.get(i-1).getEstadoAceptacion());
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
                //System.out.print("\tEstado"+matrix[i][j].getEstado());
                //System.out.print("\tNombre_Hoja:"+matrix[i][j].getNombre_hoja());
                //System.out.print("\tEstadoAceptacion:"+matrix[i][j].getEstadoAceptacion());
                //System.out.println("");
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
    
    
    public String estadoAceptacion(LinkedList<String> estado_actual)
    {
        String temp = "NO";
        
             
                if(estado_actual.getLast().equals(lista_siguientes.getLast().getId_hoja()) &&lista_siguientes.getLast().getNombre_hoja().equals("#"))
                {
                    temp = "SI";
                    
                    
                 }
            
                  // System.out.println("ESTO_ACEPTACION: "+temp); 
   
        return temp;
    }
    
    
    public int contarFilasUsadas()
    {
        int filas_usadas =0;
        
        for (int i = 0; i<fila; i++) {
            if(!(matrix[i][0].getNombre_estado().equals("-1")))
            {
                filas_usadas++;
                //System.out.println("ContarUsado:"+filas_usadas);
            }
        }
        return fila-filas_usadas;
    }
    
    public  void graficarTransiciones(String nombre){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("//home//dark//A_Entradas_Proyecto2//Compi_Proyecto1//"+Grafica.nombre_carpeta+"//Transiciones//" + nombre + ".dot");
            pw = new PrintWriter(fichero);
            pw.println("digraph G{");
            pw.println("rankdir=LR");
            pw.println("node[shape=plaintext]");
            //******
            pw.println("b[ label = <<TABLE BORDER=\"0\" "
                    + "CELLBORDER=\"1\" CELLSPACING=\"0\""
                    + " CELLPADDING=\"4\" BGCOLOR=\"green\">"
                    );
            
            //para encabezados
            pw.println("<TR>");
            for (int i = 0; i <columna-1; i++) {
                    pw.println("\n"+
                            "<TD>"+matrix[0][i].getNombre_estado()+"</TD>"+"\n");
                }
            pw.println("</TR>");
            
            int temp_column = 0;
            
            for(int i=1; i<fila-contarFilasUsadas();i++)
            {
                    
                    pw.println("<TR>");
                    for (int j = 0; j <columna-1; j++) {
                    
                       
                        if(!(matrix[i][j].getNombre_estado().equals("-1")))
                        {
                            pw.println("\n"+
                            "<TD>"+matrix[i][j].getNombre_estado()+matrix[i][j].getEstado()+"</TD>"+"\n");
                        }else
                        {
                             pw.println("\n"+
                            "<TD>"+"----"+"</TD>"+"\n");
                        }
                        
                    
                    }
                    pw.println("</TR>");
               
               // temp_column++;
            
            }
            pw.println("</TABLE> >]");
            //*********
            pw.println("}");

        } catch (Exception e) {
            System.out.println("error, no se realizo el archivo");
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        //para compilar el archivo dot y obtener la imagen
        try {
            //dirección doonde se ecnuentra el compilador de graphviz
          
            String dotPath="dot";
            //dirección del archivo dot
            String fileInputPath = "//home/dark//A_Entradas_Proyecto2//Compi_Proyecto1//"+Grafica.nombre_carpeta+"//Transiciones//" + nombre + ".dot";
            //dirección donde se creara la magen
            String fileOutputPath = "//home//dark//A_Entradas_Proyecto2//Compi_Proyecto1//"+Grafica.nombre_carpeta+"//Transiciones//"+nombre+ ".jpg";
            //tipo de conversón
            String tParam = "-Tjpg";
            String tOParam = "-o";

            //dot -Tjpg filename.dot -o outfile.jpg


            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;

            Runtime rt = Runtime.getRuntime();

            rt.exec(cmd);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
        
        
    } //fin de metodo Graficar
    
          public  void graficarAFN(String nombre){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("//home//dark//A_Entradas_Proyecto2//Compi_Proyecto1//" +Grafica.nombre_carpeta+"//AFD//" + nombre + ".dot");
            pw = new PrintWriter(fichero);
            pw.println("digraph G{");
            pw.println("rankdir=LR");
            pw.println("node[shape=circle]");
            //******
            
            int temp_col = 0;
            boolean color_estado;
            
            for (int i = 1; i <fila-contarFilasUsadas(); i++) {
                //S3[style=filled,	fillcolor = "green"]
                
                color_estado = false;
                
                for (int j = 1; j <columna; j++) {
                    
                    if(!matrix[i][temp_col].getNombre_estado().equals("-1"))
                    {
                        if(matrix[i][temp_col].getEstadoAceptacion().equals("SI") && color_estado == false)
                        {
                        //S3[style=filled,	fillcolor = "green"]
                            pw.println(matrix[i][temp_col].getNombre_estado()+"[style=filled,  fillcolor = \"green\"]");
                            color_estado = true;
                        }
                
                        if(!(matrix[i][j].getNombre_estado().equals("-1")))
                        {
                            pw.println(matrix[i][temp_col].getNombre_estado()+"->"+matrix[i][j].getNombre_estado()+"[label=\""+matrix[i][j].getNombre_hoja()+"\"]");
                        }
                
                    }
                }
               
                
            }
            
            
            //*********
            //cerrar archivo
            pw.println("}");

        } catch (Exception e) {
            System.out.println("error, no se realizo el archivo");
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        //para compilar el archivo dot y obtener la imagen
        try {
            //dirección doonde se ecnuentra el compilador de graphviz
          
            String dotPath="dot";
            //dirección del archivo dot
            String fileInputPath = "//home/dark//A_Entradas_Proyecto2//Compi_Proyecto1//"+Grafica.nombre_carpeta+"//AFD//" + nombre + ".dot";
            //dirección donde se creara la magen
            String fileOutputPath = "//home//dark//A_Entradas_Proyecto2//Compi_Proyecto1//" +Grafica.nombre_carpeta+"//AFD//" +nombre+ ".jpg";
            //tipo de conversón
            String tParam = "-Tjpg";
            String tOParam = "-o";

            //dot -Tjpg filename.dot -o outfile.jpg


            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;

            Runtime rt = Runtime.getRuntime();

            rt.exec(cmd);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
    } //fin de metetodo graficar AFN
          
          
          public void verListaEstado(){
              for (Estados est : lista_estado) {
                  
                  System.out.print("\tNombre_Estado:"+est.getNombre_estado());
                  System.out.print("\tEstado:"+est.getEstado());
                  System.out.print("\tNombre_Hoja:"+est.getNombre_hoja());
                  System.out.print("\tEstadoAceptacion:"+est.getEstadoAceptacion());
                  System.out.println("");
              }
          
          }
          
}//fin de clase transiciones
