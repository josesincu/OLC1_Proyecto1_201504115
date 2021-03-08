/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author dark
 */
public class Graficas {
    public static void graficarSiguientes(int fila,int columna,Estados [][]matrix, String nombre){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("//home//dark//A_Entradas_Proyecto2//Compi_Proyecto1//" + nombre + ".dot");
            pw = new PrintWriter(fichero);
            pw.println("digraph G{");
            pw.println("rankdir=LR");
            pw.println("node[shape=plaintext]");
            //******
            pw.println("b[ label = <<TABLE BORDER=\"0\" "
                    + "CELLBORDER=\"1\" CELLSPACING=\"0\""
                    + " CELLPADDING=\"4\" BGCOLOR=\"green\">"
                    + "<TR>"
                    + "<TD COLSPAN=\"2\">Hoja</TD>"
                    + " <TD >Siguientes</TD>"
                    + "</TR> ");
            
            for(int i=0; i<fila;i++)
            {
                pw.println("<TR>");
                for (int j = 0; j <columna; j++) {
                    
                    pw.println("\n"+
                    "<TD>"+matrix[i][j].getNombre_estado()+"</TD>"+"\n");
                }
                pw.println("</TR>");
            
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
            String fileInputPath = "//home/dark//A_Entradas_Proyecto2//Compi_Proyecto1//"+ nombre + ".dot";
            //dirección donde se creara la magen
            String fileOutputPath = "//home//dark//A_Entradas_Proyecto2//Compi_Proyecto1//" +nombre+ ".jpg";
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

}
