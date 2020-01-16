/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4_s1_2018;

/**
 *
 * @author Juan Pablo Martinez
 */
public class ListaPrestamos {

    private NodoPrestamo first;
    private int cant = 0;

    public ListaPrestamos() {
        this.first = null;
    }

    public NodoPrestamo getFirst() {
        return first;
    }

    public void setFirst(NodoPrestamo first) {
        this.first = first;
    }

    public void ingresar(Prestamo p) {
        NodoPrestamo nuevo = new NodoPrestamo(p);
        NodoPrestamo prev = null;
        NodoPrestamo aux = first;
        while (aux != null && p.getFechaSolicitud().compareTo(aux.getPrestamo().getFechaSolicitud()) < 0) {
            prev = aux;
            aux = aux.getNext();
        }
        if (prev == null) {
            first = nuevo;
        } else {
            prev.setNext(nuevo);
        }
        nuevo.setNext(aux);
        cant++;
    }

    public Prestamo buscarPrestamo(String id) {
        NodoPrestamo actual = first;
        while (actual != null && !actual.getPrestamo().getIdprestamo().equalsIgnoreCase(id)) {
            actual = actual.getNext();
        }
        if (actual != null) {
            return actual.getPrestamo();
        } else {
            return null;
        }
    }

    public void ordenarXid() {
        NodoPrestamo actual = first;
        Prestamo[] arreglo = new Prestamo[cant];
        int pos = 0;
        while (actual != null) {
            arreglo[pos] = actual.getPrestamo();
            pos++;
            actual = actual.getNext();
        }
        first = null;
        cant = 0;
        for (int i = 0; i < pos - 1; i++) {
            for (int j = 0; j < pos - 1; j++) {
                if (arreglo[j].getIdprestamo().compareToIgnoreCase(arreglo[j + 1].getIdprestamo()) > 0) {
                    Prestamo tmp = arreglo[j + 1];
                    arreglo[j + 1] = arreglo[j];
                    arreglo[j] = tmp;
                }
            }
        }
        for (int i = 0; i < pos; i++) {
            ingresar(arreglo[i]);
            cant++;
        }
    }

    public void ordenarXFecha() {
        NodoPrestamo actual = first;
        Prestamo[] arreglo = new Prestamo[cant];
        int pos = 0;
        while (actual != null) {
            arreglo[pos] = actual.getPrestamo();
            pos++;
            actual = actual.getNext();
        }
        first = null;
        cant = 0;
        for (int i = 0; i < pos - 1; i++) {
            for (int j = 0; j < pos - 1; j++) {
                if (arreglo[j].getFechaSolicitud().compareTo(arreglo[j + 1].getFechaSolicitud()) > 0) {
                    Prestamo tmp = arreglo[j + 1];
                    arreglo[j + 1] = arreglo[j];
                    arreglo[j] = tmp;
                }
            }
        }
        for (int i = 0; i < pos; i++) {
            ingresar(arreglo[i]);
            cant++;
        }
    }
}
