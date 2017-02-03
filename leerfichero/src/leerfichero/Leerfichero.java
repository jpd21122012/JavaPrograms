/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leerfichero;
import java.io.*;
/**
 *
 * @author Rey
 */
public class Leerfichero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File archivo=new File("C:\\Users\\Rey\\Documents/David.txt");
        try{
        FileReader leer=new FileReader(archivo);
        BufferedReader Objetoleer=new BufferedReader(leer);
        String cadena;
        while((cadena=Objetoleer.readLine())!=null){
            System.out.println(cadena);
        }
    }
    catch(IOException e){}
}
}