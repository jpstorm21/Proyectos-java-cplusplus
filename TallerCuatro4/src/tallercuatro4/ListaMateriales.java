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
public class ListaMateriales {

    private NodoMaterial first;

    public ListaMateriales() {
        first = null;
    }

    public NodoMaterial getFirst() {
        return first;
    }

    public void setFirst(NodoMaterial first) {
        this.first = first;
    }

    public void ingresarMaterial(Material M) {//MÉTODO INGRESAR ALfinal
        NodoMaterial nuevo = new NodoMaterial(M);
        if (first == null) {
            first = nuevo;
        } else {
            first.setNext(nuevo);
        }
    }

    public Material buscarMaterial(int cod) {
        NodoMaterial curr = first;

        while (curr != null && curr.getMaterial().getCodMaterial() != cod) {
            curr = curr.getNext();
        }
        if (curr != null) {
            return curr.getMaterial();
        } else {
            return null;
        }
    }

}
