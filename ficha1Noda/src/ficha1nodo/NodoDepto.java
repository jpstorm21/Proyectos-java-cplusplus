
package ficha1nodo;


public class NodoDepto {
   private Departamento departamento;
   private NodoDepto nextDepto;

    public NodoDepto(Departamento D) {
        this.departamento = D;
        nextDepto = null;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public NodoDepto getNextDepto() {
        return nextDepto;
    }

    public void setNextDepto(NodoDepto n) {
        this.nextDepto = n;
    }
    
   
}
