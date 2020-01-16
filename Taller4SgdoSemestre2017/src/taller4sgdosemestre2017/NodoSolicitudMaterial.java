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
public class NodoSolicitudMaterial {
    private NodoSolicitudMaterial next;
    private SolicitudMaterial solicitudMaterial;

    public NodoSolicitudMaterial(SolicitudMaterial solicitudMaterial) {
        this.next = null;
        this.solicitudMaterial = solicitudMaterial;
    }

    public NodoSolicitudMaterial getNext() {
        return next;
    }

    public void setNext(NodoSolicitudMaterial next) {
        this.next = next;
    }

    public SolicitudMaterial getSolicitudMaterial() {
        return solicitudMaterial;
    }

    public void setSolicitudMaterial(SolicitudMaterial solicitudMaterial) {
        this.solicitudMaterial = solicitudMaterial;
    }
    
}
