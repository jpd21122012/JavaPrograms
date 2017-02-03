/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinario;

/**
 *
 * @author Rey
 */
public class Arbolbinario {

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
            valor=(int) (Math.random()*100);
            System.out.print(valor+"");
            arbol.insertarNodo(valor);
        }
        System.out.println("n\nRecorrido preorden");
        arbol.recorridoPreorden();
        System.out.println("n\nRecorrido inorden");
        arbol.recorridoInorden();
        System.out.println("n\nRecorrido posorden");
        arbol.recorridoPosorden();
    }
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
public class Arbol{
    private NodoArbol raiz;
    //construir un arbol vacío
    public Arbol()
    {
        raiz=null;
    }
    //insertar un nuevo nodo en el arbol de búsqueda binaria
    public synchronized void insertarNodo(int valorInsertar)
    {
        if(raiz==null)
                raiz=new NodoArbol(valorInsertar); //crea nodo raíz
                else
    raiz.insertar(valorInsertar); //llama al método insertar
    }
    //---------------EMPEZAR EL RECORRIDO EN PREORDEN------------------------
    public synchronized void recorridoPreorden(){
        ayudantePreorden(raiz);
    }
//método recursivo para recorrido en preorden
    private void ayudantePreorden (NodoArbol nodo)
    {
        if(nodo==null)
            return;
        System.out.print(nodo.datos+""); //mostrar datos del nodo
        ayudantePreorden(nodo.nodoizquierdo); //recorre subarbol izquierdo
        ayudantePreorden(nodo.nododerecho); //recorreo subarbol derecho
    }
    //----------------EMPEZAR CON EL RECORRIDO INORDEN--------------------------
    public synchronized void recorridoInorden()
    {
        ayudanteInorden(raiz);
    }
    //método recursivo para recorrido inorden
    private void ayudanteInorden(NodoArbol nodo)
    {
        if(nodo==null)
            return;
        ayudanteInorden(nodo.nodoizquierdo);
        System.out.print(nodo.datos+"");
        ayudanteInorden(nodo.nododerecho);
    }
    //---------------------EMPEZAR EL RECORRIDO POSORDEN--------------------------
    public synchronized void recorridoPosorden()
    {
        ayudantePosorden(raiz);
    }
    //método recursivo para recorrido posorden
    private void ayudantePosorden(NodoArbol nodo)
    {
        if (nodo==null)
            return;
        ayudantePosorden(nodo.nodoizquierdo);
        ayudantePosorden(nodo.nododerecho);
        System.out.print(nodo.datos+ "");
    }
}
}
