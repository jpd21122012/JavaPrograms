/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//pruebaBusquedaBinaria.java
//Usa la búsqueda binaria para localizar un elemento en un arreglo
package arreglobinario;
import java.util.Scanner;

/**
 *
 * @author Rey
 */
public class BusquedaBinaria {
    public static void main(String args[]){
        //crea un objeto Scanner para recibir datos de entrada
        Scanner entrada=new Scanner(System.in);
        
        int enteroABuscar;//clave de búsqueda
        int posicion;//ubicación de la clave de búsqueda en el arreglo
        
        //crea un arreglo y lo muestra en pantalla
        ArregloBinarioarregloBusqueda=new ArregloBinario(15);
        System.out.println(arregloBusqueda);
        
        //obtiene la entrada del usuario
        System.out.print("Escriba un valor entero(-1 para salir): ");
        enteroABuscar=entrada.nextInt();//lee un entero del usuario
        System.out.print("");
        
        //recibe un entero como entrada en forma repetida:-1termina el programa
        while(enteroABuscar !=-1){
            
            //usa la búsqueda binaria para tratar de encontrar el entero
            posicion=arregloBusqueda.busquedaBianria(enteroABuscar);
            
            //el valor de retorno -1 indica que no se encontró el entero
            if(posicion==-1)
                System.out.println("El entero"+enteroABuscar+"no se encontró,\n");
            else
                System.out.println("El entero"+enteroABuscar+"se encontró en la posición"+posicion+"\n");
            
            //obtiene entrada del usuario
            System.out.print("Escriba un valor entero(-1 para salir): ");
            enteroABuscar=entrada.nextInt();//lee un entero del usuario
            System.out.println();
        }//fin while
    }//fin de main
}//fin de la clase BusquedaBinaria
