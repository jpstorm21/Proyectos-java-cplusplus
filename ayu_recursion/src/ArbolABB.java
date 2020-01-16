/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eduardo
 */
public class ArbolABB {
    private NodoABB raiz;
    
    public ArbolABB() {
        raiz = null;
    }

    public NodoABB getRaiz() {
        return raiz;
    }
    public boolean esVacio(NodoABB r) {
        return r==null;
    }
    public void setRaiz(NodoABB raiz) {
        this.raiz = raiz;
    }
    
    public void preOrden() {
        preOrden(raiz);
    }
    private void preOrden(NodoABB r) {
        if(!esVacio(r)) {
            System.out.println(r.getDato());
            preOrden(r.getHijoIzq());
            preOrden(r.getHijoDer());
        }
    }
    public void inOrden(NodoABB r) {
        if( !esVacio(r)) {
            inOrden(r.getHijoIzq());
            System.out.println(r.getDato());
            inOrden(r.getHijoDer());
        }
    }
    
    public void postOrden(NodoABB r) {
        if(!esVacio(r)) {
            postOrden(r.getHijoIzq());
            postOrden(r.getHijoDer());
            System.out.println(r.getDato());
        }
    }
    
    
    /* aqui la tecnica de usar privado y publico para que el usuario simplemente ingrese un dato y no tenga que ingresar la raiz
    si te fijas yo le doy el this.raiz para que al insertar SIEMPRE empieza de arriba, la recursion es una mentira de la raiz, cuando hace
    recursion la raiz cambia pero eso es un estado del programa, cuando la recursion termine ira subiendo hasta que llegue a la raiz.*/
    public void insertarDato(int dato) {
        raiz = insertarDato(dato, raiz);
    }
    
    private NodoABB insertarDato(int dato,NodoABB r) {
        if( r == null ) { // si la raiz es nula , agregamos el nodo
            r = new NodoABB(dato);
        } else {
            if( dato < r.getDato()) { // tipico de ABB menor, nodo a la izquierda
                NodoABB izq =insertarDato(dato , r.getHijoIzq());
                /* lo de arriba es la recursion , veamoslo por partes:
                1 ) el dato es el mismo, no tiene por que cambiar. es el que estamos ingresando
                2) si es menor yo quiero agregar el nodo a la izquierda, propiedad de ABB , entonces al hacer recursion abro una nueva 
                "ventana" por decirlo asi y la raiz ya no es this.raiz es la nueva raiz para la recursion ( esto seria para nosotros el sub arbol izquierdo ) 
                entonces que es lo que pasa, el subarbol izquierdo en este momento no existe por que solo tenemos la raiz por la operacion hecha anteriormente
                entonces entra al primer if ya que el subarbol izquierdo es NULL , y si es nulo lo crea con el dato. ver que si entra al primer if despues al final
                del codigo dice "return r" esto retorna el nodo que queremos ingresar, si no, no podriamos seguir haciendo recursion hacia abajo.*/
                r.setHijoIzq(izq);
                /* que quiere decir esto. quiere decir this.raiz.setHijoIzq(izq) , le seteamos el enlace al nodo que anteriormente agregamos por la recursion*/
            } else {
                /* aqui hace absolutamente lo mismo que antes, solo que con derecho*/
                NodoABB der = insertarDato(dato, r.getHijoDer());
                r.setHijoDer(der);
            }
        }
        /* segun yo la mejor forma de entender la recursion es hacer un arbol de 8 o mas niveles, rutealo con este codigo y fijate como va avanzando
        y cuando retorna r significa que se esta devolviendo un paso atras en la recursion, te esta devolviendo el nodo que esta "adelante" por decirlo asi
        */
        return r;
    }
    public NodoABB buscarDato(int dato) {
        return buscarDato(dato, raiz);
    }
    private NodoABB buscarDato(int dato, NodoABB nodo) {
        if ( !esVacio(nodo)) {
            if ( dato == nodo.getDato()) {
                return nodo;
            } else {
                if( dato < nodo.getDato() ) {
                    return buscarDato(dato,nodo.getHijoIzq());
                } else {
                    if( dato > nodo.getDato()) {
                        return buscarDato(dato, nodo.getHijoDer());
                    }
                }
            }
        } else {
            return null;
        }
        return nodo;
    }
    
    public void eliminarDato(int dato) {
        raiz = eliminarDato(dato,raiz);
    }
    
    private NodoABB eliminarDato(int dato, NodoABB nodo) {
       if(esVacio(nodo)) {
           System.out.println("No se encontro el dato");
       } else if(dato<nodo.getDato()) {
           NodoABB izq = eliminarDato(dato, nodo.getHijoIzq());
           nodo.setHijoIzq(izq);
       } else if(dato > nodo.getDato()) {
           NodoABB der = eliminarDato(dato, nodo.getHijoDer());
           nodo.setHijoDer(der);
       } else {
           NodoABB paraEliminar = nodo;
           if( paraEliminar.getHijoIzq() == null) { // solo tiene hijo der
               nodo = paraEliminar.getHijoDer();
           } else if(paraEliminar.getHijoDer() == null) { // solo tiene hijo izq
               nodo = paraEliminar.getHijoIzq();
           } else { // tiene dos hijos
               paraEliminar = reemplazar(paraEliminar);
           }
           paraEliminar = null;
       }
       return nodo;
    }
    
    public NodoABB reemplazar(NodoABB actual) {
        NodoABB a,p;
        p = actual;
        a = actual.getHijoIzq();
        while ( a.getHijoDer() != null) {
            p = a;
            a = a.getHijoDer();
        }
        actual.setDato(a.getDato());
        if( p==actual) { // a es el hijo izq de actual
            p.setHijoIzq(a.getHijoIzq()); // by pass
        } else {
            p.setHijoDer(a.getHijoDer()); // bypass
        }
        return a;
        
    }

    
    
}
