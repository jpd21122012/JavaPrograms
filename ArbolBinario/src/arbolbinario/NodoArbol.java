
package arbolbinario;


public class NodoArbol {
        //miembros de acceso
    NodoArbol nodoizquierdo;
    int datos;
    NodoArbol nododerecho;
    //iniciar dato y hacer de este nodo un nodo hoja
    public NodoArbol(int datosNodo){
        datos=datosNodo;
        nodoizquierdo=nododerecho=null;//el nodo no tiene hijos
    }
    //buscar punto de inserción e insertar nodo nuevo
    public synchronized void insertar (int valorInsertar){
        //insertar en subarbolizquierdo
        if(valorInsertar<datos){
            //inserta nuevo nodoarbol
            if(nodoizquierdo==null)
                nodoizquierdo=new NodoArbol(valorInsertar);
            else//continua recorriendo subarbol izquierdo
                nodoizquierdo.insertar(valorInsertar);
        }
        //insertar nodo derecho
        else if(valorInsertar>datos){
            //Insertar nuevo nodoarbol
            if(nododerecho==null)
                nododerecho=new NodoArbol(valorInsertar);
            else//continua recorriendo subarbol derecho
                nododerecho.insertar(valorInsertar);
        }
    }//fin del metodo insertar
}
    


