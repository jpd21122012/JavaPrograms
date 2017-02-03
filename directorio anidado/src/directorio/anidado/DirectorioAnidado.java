/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package directorio.anidado;
import java.io.*;
/**
 *
 * @author Rey
 */
public class DirectorioAnidado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File directorios=new File("C:\\Users\\Rey\\Documents\\Directorio/Mi directorio");
        if(directorios.mkdirs()){
            System.out.println("se han creado los directorios");
        }
        else{
            System.out.println("No se han podido crear los directorios");
        }
    }
}
