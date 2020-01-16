/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba2016progra1;

/**
 *
 * @author Usuario
 */
public class NodoPagina {
   private NodoPagina next;
   private NodoPagina prev;
   private Pagina pagina;

    public NodoPagina(Pagina pagina) {
        this.next = null;
        this.prev = null;
        this.pagina = pagina;
    }

    public NodoPagina getNext() {
        return next;
    }

    public void setNext(NodoPagina next) {
        this.next = next;
    }

    public NodoPagina getPrev() {
        return prev;
    }

    public void setPrev(NodoPagina prev) {
        this.prev = prev;
    }

    public Pagina getPagina() {
        return pagina;
    }

    public void setPagina(Pagina pagina) {
        this.pagina = pagina;
    }
    
   
}
