/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheros;
import java.io.*;
/**
 *
 * @author Rey
 */
public class Ficheros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File archivo=new File("C:\\Users\\Rey\\Documents/David.txt");
   try {
        if(archivo.createNewFile())
            System.out.println("El Fichero se a creado correctamene");
        else
        System.out.println("No se a podido crear el Fichero");
       
    } catch (IOException ioe){
        ioe.printStackTrace();
    }
    }
}
