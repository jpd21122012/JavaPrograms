/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package escribirfichero;
import java.io.*;
/**
 *
 * @author Rey
 */
public class EscribirFichero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         File archivo=new File("C:\\Users\\Rey\\Documents/David.txt");
    try{
        FileWriter escribir=new FileWriter(archivo);
        BufferedWriter objetoarchivo=new BufferedWriter(escribir);
       PrintWriter frase=new PrintWriter(objetoarchivo);
        frase.write("Esta es una línea de código");
       frase.append( "_y aqui continúa");
       frase.close();
       objetoarchivo.close();
    } catch(IOException ioe){
    ioe.printStackTrace();
    }    
    }
}
