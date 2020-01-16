
package taller4;

public class NodoContenedor {
    private Contenedor contenedor;
    private NodoContenedor nextContenedor;
    private NodoContenedor prevContenedor;

    public NodoContenedor(Contenedor C) {
        contenedor = C;
        nextContenedor = null;
        prevContenedor = null;
    }

    public Contenedor getContenedor() {
        return contenedor;
    }

    public void setContenedor(Contenedor contenedor) {
        this.contenedor = contenedor;
    }

    public NodoContenedor getNextContenedor() {
        return nextContenedor;
    }

    public void setNextContenedor(NodoContenedor nextContenedor) {
        this.nextContenedor = nextContenedor;
    }

    public NodoContenedor getPrevContenedor() {
        return prevContenedor;
    }

    public void setPrevContenedor(NodoContenedor prevContenedor) {
        this.prevContenedor = prevContenedor;
    }
    
}
