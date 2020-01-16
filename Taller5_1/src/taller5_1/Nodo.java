package taller5_1;

public class Nodo {
    private int numero;
    private Nodo hijoIzq;
    private Nodo hijoDer;

    public Nodo(int numero) {
        this.numero = numero;
        this.hijoIzq = null;
        this.hijoDer = null;
    }

    public Nodo getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(Nodo hijoDer) {
        this.hijoDer = hijoDer;
    }

    public Nodo getHijoIzq() {
        return hijoIzq;
    }

    public int getNumero() {
        return numero;
    }

    public void setHijoIzq(Nodo hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
}
