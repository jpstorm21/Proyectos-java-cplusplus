package taller4;

public class ListaContenedores {

    private NodoContenedor firstContenedor;
    private NodoContenedor lastContenedor;

    public ListaContenedores() {
        firstContenedor = null;
        lastContenedor = null;
    }

    public NodoContenedor getFirstContenedor() {
        return firstContenedor;
    }

    public void setFirstContenedor(NodoContenedor firstContenedor) {
        this.firstContenedor = firstContenedor;
    }

    public NodoContenedor getLastContenedor() {
        return lastContenedor;
    }

    public void setLastContenedor(NodoContenedor lastContenedor) {
        this.lastContenedor = lastContenedor;
    }

    public void ingresarContenedor(Contenedor C) {
        NodoContenedor nuevo = new NodoContenedor(C);
        if (firstContenedor == null) {
            firstContenedor = nuevo;
            lastContenedor = nuevo;
        } else {
            nuevo.setPrevContenedor(lastContenedor);
            lastContenedor.setNextContenedor(nuevo);
            nuevo.setNextContenedor(null);
            lastContenedor = nuevo;
        }
    }

    public Contenedor buscarContenedor(String nombre) {
        NodoContenedor actual = firstContenedor;
        while (actual != null && !actual.getContenedor().getNombre().equalsIgnoreCase(nombre)) {
            actual = actual.getNextContenedor();
        }
        if (actual != null) {
            return actual.getContenedor();
        } else {
            return null;
        }
    }

    public boolean eliminarContenedor(String nombre) {
        NodoContenedor actual = firstContenedor;
        while (actual != null && !actual.getContenedor().getNombre().equalsIgnoreCase(nombre)) {
            actual = actual.getNextContenedor();
        }
        if (actual != null) {
            if (actual == firstContenedor) {
                firstContenedor = firstContenedor.getNextContenedor();
            } else {
                actual.getPrevContenedor().setNextContenedor(actual.getNextContenedor());
            }
            if (actual == lastContenedor) {
                lastContenedor = lastContenedor.getPrevContenedor();
            } else {
                actual.getNextContenedor().setPrevContenedor(actual.getPrevContenedor());
            }
            return true;
        } else {
            return false;
        }
    }

}
