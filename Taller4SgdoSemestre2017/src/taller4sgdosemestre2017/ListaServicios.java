/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4sgdosemestre2017;

/**
 *
 * @author Usuario
 */
public class ListaServicios {

    private NodoServicio first;
    private NodoServicio last;
    private int cant;
    public ListaServicios() {
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

    public void ingresarServicio(Servicio s) {
        NodoServicio nuevo = new NodoServicio(s);
        NodoServicio prev = null;
        NodoServicio aux = first;
        while (aux != null && s.getFecha().compareToIgnoreCase(aux.getServicio().getFecha()) < 0) {
            prev = aux;
            aux = aux.getNext();
        }
        if (prev == null) {
            first = nuevo;
        } else {
            prev.setNext(nuevo);
            nuevo.setPrev(prev);
        }
        nuevo.setNext(aux);
        if (aux != null) {
            aux.setPrev(nuevo);
        } else {
            last = nuevo;
        }
        cant++;
    }

    public Servicio buscarServicio(int codigo) {
        NodoServicio actual = first;
        while (actual != null && actual.getServicio().getCodigo() != codigo) {
            actual = actual.getNext();
        }
        if (actual != null) {
            return actual.getServicio();
        } else {
            return null;
        }
    }

    public int getCant() {
        return cant;
    }
    
}
