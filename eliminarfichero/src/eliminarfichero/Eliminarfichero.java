/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eliminarfichero;
import java.io.*;
/**
 *
 * @author Rey
 */
public class Eliminarfichero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File archivo=new File("C:\\Users\\Rey\\Documents/David.txt");
        if (archivo.delete())
            System.out.println("El archivo ha sido eliminado satisfactoriamente");
        else
            System.out.println("El archivo no se pudo eliminar");
    }
}
