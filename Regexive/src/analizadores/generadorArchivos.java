/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadores;

import java.io.IOException;


/**
 *
 * @author dark
 */
public class generadorArchivos {
    
    public static void main(String[] args)
    {
     /* try{
       Runtime rt = Runtime.getRuntime();
       rt.exec("src//analizadores//compilar.sh");
      }
      catch(Exception e){
      }
*/
        try {
            String ruta = "src//analizadores//";
            String opcFlex[] = {ruta +"Lexico.jlex", "-d", ruta};
            jflex.Main.generate(opcFlex);
            
            
            String opcCUP[] = {"-destdir", ruta, "-parser", "Sintactico", ruta + "Sintactico.cup"};
            java_cup.Main.main(opcCUP);
        
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        //generarCompilador();
    }
    private static void generarCompilador() 
    {
        try {
            String ruta = "src//analizadores//";
            String opcFlex[] = {ruta +"Lexico.jflex", "-d", ruta};
            jflex.Main.generate(opcFlex);
            
            
            String opcCUP[] = {"-destdir", ruta, "-parser", "parser", ruta + "Sintactico.cup"};
            java_cup.Main.main(opcCUP);
        
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
}
