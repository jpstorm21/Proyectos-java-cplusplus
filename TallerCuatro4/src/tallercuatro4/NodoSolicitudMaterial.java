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
public class NodoSolicitudMaterial {
  private NodoSolicitudMaterial Next;
  private SolicitudMaterial solicitudMaterial;

    public NodoSolicitudMaterial(SolicitudMaterial solicitudMaterial) {
    this.Next=null;
    this.solicitudMaterial= solicitudMaterial;
    
    }

    public NodoSolicitudMaterial getNext() {
        return Next;
    }

    public void setNext(NodoSolicitudMaterial Next) {
        this.Next = Next;
    }

    public SolicitudMaterial getSolicitudMaterial() {
        return solicitudMaterial;
    }

    public void setSolicitudMaterial(SolicitudMaterial solicitudMaterial) {
        this.solicitudMaterial = solicitudMaterial;
    }
  
  
}
