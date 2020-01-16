package ejemplenodo;

public class ListaDosNexos {

    private Nodo first;
    private Nodo last;

    public ListaDosNexos() {
        first = null;
        last = null;
    }

    public Nodo getFirst() {
        return first;
    }

    public void setFirst(Nodo first) {
        this.first = first;
    }

    public Nodo getLast() {
        return last;
    }

    public void setLast(Nodo last) {
        this.last = last;
    }

    public void insertar(int d) { // aqui pueden jugar con insertar al principio o al ultimo ya que tienen un first  y un last
        Nodo nuevo = new Nodo(d);
        if (first == null) {
            first = nuevo;
            last = nuevo;
        } else {
            nuevo.setNext(first);
            first.setPrev(nuevo);
            nuevo.setPrev(null);
            first = nuevo;
        }
    }

    public boolean buscar(int d) {
        Nodo actual = first;
        while (actual != null && actual.getDato() != d) {
            actual = actual.getNext();
        }
        if (actual != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminar(int d) {
        Nodo actual = first;
        while (actual != null && actual.getDato() != d) {
            actual = actual.getNext();

        }
        if (actual != null) {
            if (actual == first) {
                first = first.getNext();
            } else {
                actual.getPrev().setNext(actual.getNext());
            }
            if (actual == last) {
                last = last.getPrev();
            } else {
                actual.getNext().setPrev(actual.getPrev());
            }
            return true;
        } else {
            return false;
        }
    }
}
