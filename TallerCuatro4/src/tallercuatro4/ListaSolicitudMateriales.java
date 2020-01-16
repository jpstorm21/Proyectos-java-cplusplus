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
public class ListaSolicitudMateriales {
  private NodoSolicitudMaterial first;

    public ListaSolicitudMateriales() {
    this.first=null;
    }

    public NodoSolicitudMaterial getFirst() {
        return first;
    }

    public void setFirst(NodoSolicitudMaterial first) {
        this.first = first;
    }
   public void ingresarSolicitudMaterial(SolicitudMaterial S) {//MÉTODO INGRESAR AL PRINICIPIO.
             NodoSolicitudMaterial nuevo = new NodoSolicitudMaterial(S);
        if (first == null) {
            first = nuevo;
        } else {
            first.setNext(nuevo);
        }}
    
        
    public SolicitudMaterial buscarSolicitudMaterial(int cod) {
        NodoSolicitudMaterial curr = first;
        
        while( curr != null && curr.getSolicitudMaterial().getCodSolicitud()!=cod) {
            curr = curr.getNext();
        }
        if ( curr != null){
           return curr.getSolicitudMaterial();
        } else {
            return null;
        }
    }
}
