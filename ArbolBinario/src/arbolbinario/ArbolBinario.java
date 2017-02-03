
package arbolbinario;

public class ArbolBinario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
 Arbol arbol = new Arbol();
        int valor;
        System.out.println("Insertando los siguientes valores: ");
        //Insertando 10 números aleatorios del 0 al 99en el árbol
        for(int i=1;i<=10;i++)
        {
            valor=(int)(Math.random()*100);
            System.out.print(valor+" ");
            arbol.insertarNodo(valor);
        }
        System.out.println("\n\nRecorrido preorden");
        arbol.recorridoPreorden();
        System.out.println("\n\nRecorrido inorden");
        arbol.recorridoInorden();
        System.out.println("\n\nRecorrido posorden");
        arbol.recorridoPosorden();
    }
    

    }
