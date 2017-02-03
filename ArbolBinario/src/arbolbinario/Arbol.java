
package arbolbinario;

public class Arbol {
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
        ayudantePreorden(nodo.nododerecho); //recorre o subarbol derecho
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


