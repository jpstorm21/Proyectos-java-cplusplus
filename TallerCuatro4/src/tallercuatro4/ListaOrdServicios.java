/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallercuatro4;

/**
 *
 * @author Usuario
 */
public class ListaOrdServicios {

    private NodoServicio first;
    private NodoServicio last;
    private int cant;

    public ListaOrdServicios() {
        this.first = null;
        this.last = null;
this.cant = 0;
    }

    public NodoServicio getFirst() {
        return first;
    }

    public void setFirst(NodoServicio first) {
        this.first = first;
    }

    public NodoServicio getLast() {
        return last;
    }

    public void setLast(NodoServicio last) {
        this.last = last;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public void insertarOrdenadoServicio(Servicio s) {
        NodoServicio nuevo = new NodoServicio(s);
        NodoServicio prev = null;
        NodoServicio auxiliar = first;
        while (auxiliar != null && s.getFechaServicio().compareToIgnoreCase(auxiliar.getServicio().getFechaServicio()) < 0) {
            prev = auxiliar;
            auxiliar = auxiliar.getNext();
        }
        if (prev == null) {
            first = nuevo;
        } else {
            prev.setNext(nuevo);
            nuevo.setPrev(prev);
        }
        nuevo.setNext(auxiliar);
        if (auxiliar != null) {
            auxiliar.setPrev(nuevo);
        } else {
            last = nuevo;
        }
        cant++;

    }

    public Servicio buscarServicio(int codServ) {
        NodoServicio actual = first;
        while (actual != null && actual.getServicio().getCodServicio() != codServ) {
            actual = actual.getNext();
        }

        if (actual != null) {
            return actual.getServicio();
        } else {
            return null;
        }
    }

}
