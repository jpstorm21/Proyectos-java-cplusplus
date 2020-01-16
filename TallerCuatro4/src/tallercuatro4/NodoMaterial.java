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
public class NodoMaterial {
    private NodoMaterial next;
    private Material material;

    public NodoMaterial(Material material) {
        next=null;
        this.material = material;
    }

    public NodoMaterial getNext() {
        return next;
    }

    public void setNext(NodoMaterial next) {
        this.next = next;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    
    
    
}
