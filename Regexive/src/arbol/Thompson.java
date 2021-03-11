/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol;

import java.io.FileWriter;
import java.io.PrintWriter;
import regexive.Grafica;

/**
 *
 * @author dark
 */
public class Thompson {
    private String valor_Graficar;
    private int s;
    private Nodo raiz;
    
    
    public Thompson()
    {
        valor_Graficar = "";
        s = 0;
        
    
    }
    
    public void llenarDato(Nodo padre,Nodo a, Nodo b)
    {
        this.raiz = padre;
        //recorridoPosorden();
        
    }
    
    public void Or(Nodo padre,Nodo a, Nodo b)
    { 
        String temp =""; 
        
        /*
        S0->S1[label ="&epsilon;"]
        S1->S2[label = "letra"]
        S0->S3[label = "&epsilon;"]
        S3->S4[label = "numero"]
        S2->S5[label = "&epsilon;"]
        S4->S5[label = "&epsilon;"]
        */
        
         temp = "S"+(s)+"->S"+(s+1)+"[label =\"&epsilon;\"]\n" +
                         "S"+(s+1)+"->S"+(s+2)+"[label = \""+a.getValor()+"\"]\n" +
                         "S"+(s)+"->S"+(s+3)+"[label = \"&epsilon;\"]\n" +
                         "S"+(s+3)+"->S"+(s+4)+"[label = \""+b.getValor()+"\"]\n" +
                         "S"+(s+2)+"->S"+(s+5)+"[label = \"&epsilon;\"]\n" +
                         "S"+(s+4)+"->S"+(s+5)+"[label = \"&epsilon;\"]";
         
        // valor_Graficar +=temp;
        
        s +=5;
    }
    
    public void Concatenacion(Nodo padre,Nodo a, Nodo b)
    { 
        String temp =""; 
        //Concatenacion
        /*
        S0->S1[label ="numero"]
        S1->S2[label = "letra"]
        
        */
        
         temp =          "S"+(s)+"->S"+(s+1)+"[label = \""+a.getValor()+"\"]\n" + 
                         "S"+(s+1)+"->S"+(s+2)+"[label = \""+b.getValor()+"\"]\n";
                         
         //valor_Graficar +=temp;
         
        s+=1;
        
    }
    
    public void Asterisco(Nodo padre,Nodo a)
    { 
        String temp =""; 
        //a*
        /*
        
                "S0->S1[label =\"&epsilon;\"]\n" +
                "S1->S2[label = \"letra\"]\n" +
                "S2->S1[label =\"&epsilon;\"]\n" +
                "S2->S3[label =\"&epsilon;\"]\n" +
                "S0->S3[label =\"&epsilon;\"]";
        
        */
            //a*
         temp = "S"+(s)+"->S"+(s+1)+"[label =\"&epsilon;\"]\n" +
                "S"+(s+1)+"->S"+(s+2)+"[label = \""+a.getValor()+"\"]\n" +
                "S"+(s+2)+"->S"+(s+1)+"[label =\"&epsilon;\"]\n" +
                "S"+(s+2)+"->S"+(s+3)+"[label =\"&epsilon;\"]\n" +
                "S"+(s)+"->S"+(s+3)+"[label =\"&epsilon;\"]";
                         
        // valor_Graficar +=temp;
        
         s+=3;
    }
    
    public void Mas(Nodo padre,Nodo a)
    { 
        String temp =""; 
        //a+
        /*
                S0->S1[label ="&epsilon;"]
                S1->S2[label = "letra"]
                S2->S1[label ="&epsilon;"]
                S2->S3[label ="&epsilon;"]
        
        */
            //a+
         temp = "S"+(s)+"->S"+(s+1)+"[label =\"&epsilon;\"]\n" +
                "S"+(s+1)+"->S"+(s+2)+"[label = \""+a.getValor()+"\"]\n" +
                "S"+(s+2)+"->S"+(s+1)+"[label =\"&epsilon;\"]\n" +
                "S"+(s+2)+"->S"+(s+3)+"[label =\"&epsilon;\"]";
         
         //valor_Graficar +=temp;
         
         s+=3;
    }
    
    public void unaVez(Nodo padre, Nodo a)
    { 
        String temp =""; 
        //a?
        /*
                "S0->S1[label =\"&epsilon;\"]\n" +
                "S1->S2[label = \"letra\"]\n" +
                "S2->S3[label =\"&epsilon;\"]\n" +
                "S0->S3[label =\"&epsilon;\" ]\n";
        
        */
            //a?
         temp = "S"+(s)+"->S"+(s+1)+"[label =\"&epsilon;\"]\n" +
                "S"+(s+1)+"->S"+(s+2)+"[label = \""+a.getValor()+"\"]\n" +
                "S"+(s+2)+"->S"+(s+3)+"[label =\"&epsilon;\"]\n" +
                "S"+(s)+"->S"+(s+3)+"[label =\"&epsilon;\" ]\n";
         //valor_Graficar +=temp;
         
         s+=3;
         
    }
    
    public void graficarAFND(String nombre)
    {
        
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("//home//dark//A_Entradas_Proyecto2//Compi_Proyecto1//" +Grafica.nombre_carpeta+"//AFND//" + nombre + ".dot");
            pw = new PrintWriter(fichero);
            pw.println("digraph G{");
            pw.println("rankdir=LR");
            pw.println("node[shape=circle]");
            //******
            pw.println(valor_Graficar);
            pw.println("S"+(s)+"[style=filled,  fillcolor = \"green\"]");
            
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
            String fileInputPath = "//home/dark//A_Entradas_Proyecto2//Compi_Proyecto1//"+Grafica.nombre_carpeta+"//AFND//" + nombre + ".dot";
            //dirección donde se creara la magen
            String fileOutputPath = "//home//dark//A_Entradas_Proyecto2//Compi_Proyecto1//" +Grafica.nombre_carpeta+"//AFND//" +nombre+ ".jpg";
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
        
    }
    
    
    public  void recorridoPosorden(Nodo nodo)
    {
        ayudantePosorden(nodo);
    }

//metodo recursivo para recorrido posorden

    private void ayudantePosorden(Nodo nodo)
    {
        if (nodo == null)
        return;

        ayudantePosorden(nodo.getHizq());
        ayudantePosorden(nodo.getHder());
        System.out.print("\t"+nodo.getValor()+" ");
        
    }
    
}
