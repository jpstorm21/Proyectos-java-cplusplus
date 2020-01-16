package taller5;

/**
 * Nodo que contiene la matriz
 * @author JOSE
 */
public class NodoMatriz {
    
    private char[][] matriz;
    private NodoMatriz prev;
    private NodoMatriz next;
    
    public NodoMatriz(char[][] matriz){
        this.matriz = matriz;
        this.next = null;
        this.prev = null;
    }

    public char[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(char[][] matriz) {
        this.matriz = matriz;
    }

    public NodoMatriz getNext() {
        return next;
    }

    public void setNext(NodoMatriz next) {
        this.next = next;
    }

    public NodoMatriz getPrev() {
        return prev;
    }

    public void setPrev(NodoMatriz prev) {
        this.prev = prev;
    }

}
