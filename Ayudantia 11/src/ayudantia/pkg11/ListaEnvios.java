package ayudantia.pkg11;

/**
 *
 * @author Cristóbal
 */
public class ListaEnvios {//DOBLE NEXO CIRCULAR

    private NodoEnvio first;
    private NodoEnvio last;

    public ListaEnvios() {
        this.first = null;
        this.last = null;
    }

    public NodoEnvio getFirst() {
        return first;
    }

    public void setFirst(NodoEnvio first) {
        this.first = first;
    }

    public NodoEnvio getLast() {
        return last;
    }

    public void setLast(NodoEnvio last) {
        this.last = last;
    }

    public void ingresarEnvio(Envio E) {
        NodoEnvio nuevo = new NodoEnvio(E);
        if (first == null) {
            first = nuevo;
            last = nuevo;
        } else {
            nuevo.setNext(first);
            first.setPrev(nuevo);
            nuevo.setPrev(last);
            last.setNext(nuevo);
            first = nuevo;
        }
    }

    public Envio buscarEnvio(String estado) {
        NodoEnvio actual = first;
        while (actual.getNext() != first && !actual.getEnvio().getEstado().equalsIgnoreCase(estado)) {
            actual = actual.getNext();
        }

        if (actual != first) {
            return actual.getEnvio();
        } else {
            return null;
        }
    }

    public boolean eliminarEnvio(String estado) {
        NodoEnvio actual = first;
        while (actual.getNext() != first && !actual.getEnvio().getEstado().equalsIgnoreCase(estado)) {
            actual = actual.getNext();
        }

        if (actual.getEnvio().getEstado().equalsIgnoreCase(estado)) {
            if (actual == first) {
                first = first.getNext();
                first.setPrev(last);
                last.setNext(first);
            } else {
                actual.getPrev().setNext(actual.getNext());
            }
            if (actual == last) {
                last = last.getPrev();
                first.setPrev(last);
                last.setNext(first);
            } else {
                actual.getNext().setPrev(actual.getPrev());
            }
            return true;
        } else {
            return false;
        }
    }
}
