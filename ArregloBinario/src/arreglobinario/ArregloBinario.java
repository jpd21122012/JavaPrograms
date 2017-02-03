/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arreglobinario;
import java.util.Random;
import java.util.Arrays;
/**
 *
 * @author Rey
 */
public class ArregloBinario {
private int []datos;//arreglo de valores
private static Random generator=new Random();

//crea un arreglo de un tamaño dadoy lo llena con enteros aleatorios
public ArregloBinario(int tamanio){
    datos=new int[tamanio];//crea espacio para el arreglo
    
    //llena el arreglo con enteros aleatorios en el rango de 10 a 99
    for(int i=0;i<tamanio;i++)
        datos[i]=10+generator.nextInt(90);
    
    Arrays.sort(datos);
}//fin del constructor de ArregloBinario

//realiza una búsqueda binaria en los datos
public int busquedaBinaria(int elementoBusqueda){
    int inferior=0;//extremo inferior del área de búsqueda
    int superior=datos.length-1;//extremo superior del área de búsqueda
    int medio=(inferior+superior+1)/2;//elemento medio
    int ubicacion=-1;//devuelve el valor,-1 si no lo encontró
    do//ciclo para buscar un elemento
    {
      //imprime el resto de los elementos del arreglo
        System.out.print(elementosRestantes(inferior,superior));
        
        //imprime espacios para alineación
        for(int i=0;i<medio;i++)
            System.out.print("");
        System.out.println("*");//indica el elemento medio actual
        
        //si el elemento se encuentra en medio
        if(elementoBusqueda==datos[medio])
            ubicacion=medio+1;//la ubicación es el elemento medio actual
        
        //el elemento medio es demasiado alto
        else if(elementoBusqueda<datos[medio])
            superior=medio-1;//elimina la mitad superior
        else//el elemento medio es demasiado bajo
            inferior=medio+1;//elimina la mitad inferior
        
        medio=(inferior+superior+1)/2;//recalcula el elemento medio
    }while((inferior<=superior)&&(ubicacion==-1));
    return ubicacion;//devuelve la ubicación de la clave de búsqueda
    }//fin del método busquedaBinaria
//método para imprimir ciertos valores en el arreglo
public String elementosRestantes(int inferior, int superior){
    StringBuilder temporal=new StringBuilder();
    //imprime espacios para alineación
    for(int i=0;i<inferior;i++)
        temporal.append(" ");
    
    //imprime los elementos que quedan en el arreglo
    for(int i=inferior;i<=superior;i++)
        temporal.append(datos[i]+"");
    
    temporal.append("\n" );
    return temporal.toString();
}//fin del método elementosRestantes

//métodos para imprimir los valores en el arreglo
public String toString()
{
    return elementosRestantes(0,datos.length-1);
//fin del método toString
}//fin de la clase ArregloBinario
/**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
