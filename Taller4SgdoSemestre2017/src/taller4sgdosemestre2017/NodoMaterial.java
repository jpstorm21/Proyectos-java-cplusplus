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
public class NodoMaterial {
    private Material material;
    private NodoMaterial next;

    public NodoMaterial(Material material) {
        this.material = material;
        this.next = null;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public NodoMaterial getNext() {
        return next;
    }

    public void setNext(NodoMaterial next) {
        this.next = next;
    }
}
