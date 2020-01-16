/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemaversion2nexos;

/**
 *
 * @author Usuario
 */
public class ListaCarreras {

    private NodoCarrera firstCarrera;
    private NodoCarrera lastCarrera;

    public ListaCarreras() {
        this.firstCarrera = null;
        this.lastCarrera = null;
    }

    public NodoCarrera getFirstCarrera() {
        return firstCarrera;
    }

    public void setFirstCarrera(NodoCarrera firstCarrera) {
        this.firstCarrera = firstCarrera;
    }

    public NodoCarrera getLastCarrera() {
        return lastCarrera;
    }

    public void setLastCarrera(NodoCarrera lastCarrera) {
        this.lastCarrera = lastCarrera;
    }

    public void ingresarCarrera(Carrera C) {
        NodoCarrera nuevo = new NodoCarrera(C);
        if (firstCarrera == null) {
            firstCarrera = nuevo;
            lastCarrera = nuevo;
        } else {
            nuevo.setNextCarrera(firstCarrera);
            firstCarrera.setPrevCarrera(nuevo);
            nuevo.setPrevCarrera(null);
            firstCarrera = nuevo;
        }
    }

    public Carrera buscarCarrera(int codigo) {
        NodoCarrera actual = firstCarrera;
        while (actual != null && actual.getCarrera().getCodigo() != codigo) {
            actual = actual.getNextCarrera();
        }
        if (actual != null) {
            return actual.getCarrera();
        } else {
            return null;
        }
    }

    public boolean eliminarCarrera(int codigo) {
        NodoCarrera actual = firstCarrera;
        while (actual!= null && actual.getCarrera().getCodigo() != codigo) {
            actual = actual.getNextCarrera();
        }
        if (actual != null) {
            if (actual == firstCarrera) {
                firstCarrera = firstCarrera.getNextCarrera();
            } else {
                actual.getPrevCarrera().setNextCarrera(actual.getNextCarrera());
            }
            if (actual == lastCarrera) {
                lastCarrera = lastCarrera.getPrevCarrera();
            } else {
                actual.getNextCarrera().setPrevCarrera(actual.getPrevCarrera());
            }
            return true;
        } else {
            return false;
        }
    }
}
