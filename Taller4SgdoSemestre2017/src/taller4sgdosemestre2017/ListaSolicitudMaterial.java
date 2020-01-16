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
public class ListaSolicitudMaterial {
    private NodoSolicitudMaterial first;

    public ListaSolicitudMaterial() {
        this.first = null;
    }

    public NodoSolicitudMaterial getFirst() {
        return first;
    }

    public void setFirst(NodoSolicitudMaterial first) {
        this.first = first;
    }
    public void ingresarSolicitudMaterial(SolicitudMaterial sm){
        NodoSolicitudMaterial nuevo = new NodoSolicitudMaterial(sm);
        if(first == null){
            first = nuevo;
        }else{
            nuevo.setNext(first);
            first = nuevo;
        }
    }
    public SolicitudMaterial buscarSolicitudMaterial(int codigo){
        NodoSolicitudMaterial actual = first;
        while(actual != null && actual.getSolicitudMaterial().getCodigo() != codigo){
            actual = actual.getNext();
        }
        if(actual != null){
            return actual.getSolicitudMaterial();
        }else{
            return null;
        }        
    }
    
}
