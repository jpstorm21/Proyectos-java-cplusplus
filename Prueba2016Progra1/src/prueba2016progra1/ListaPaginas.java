/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba2016progra1;

/**
 *
 * @author Usuario
 */
public class ListaPaginas {

    private NodoPagina first;
    private NodoPagina last;
    private int cant;

    public ListaPaginas() {
        this.first = null;
        this.last = null;
        cant = 0;
    }

    public NodoPagina getFirst() {
        return first;
    }

    public void setFirst(NodoPagina first) {
        this.first = first;
    }

    public NodoPagina getLast() {
        return last;
    }

    public void setLast(NodoPagina last) {
        this.last = last;
    }

    public void ingresarUltimo(Pagina P) {
        NodoPagina nuevo = new NodoPagina(P);
        if (last == null) {
            last = nuevo;
            first = nuevo;
        } else {
            last.setNext(nuevo);
            nuevo.setPrev(last);
            nuevo.setNext(null);
            last = nuevo;
        }
        cant++;
    }

    public Pagina buscar(String url) {
        NodoPagina actual = first;
        while (actual != null && !actual.getPagina().getUrl().equalsIgnoreCase(url)) {
            actual = actual.getNext();
        }
        if (actual != null) {
            return actual.getPagina();
        } else {
            return null;
        }

    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }
    
}
