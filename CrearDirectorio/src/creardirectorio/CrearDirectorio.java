/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package creardirectorio;
import java.io.*;
/**
 *
 * @author Rey
 */
public class CrearDirectorio {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File directorio=new File("C:\\Users\\Rey\\Documents/Directorio");
        if(directorio.mkdir()){
        System.out.println("Se creó un archivo");
    }
        else{
    System.out.println("Se creó el directorio");
        }
    }
}
