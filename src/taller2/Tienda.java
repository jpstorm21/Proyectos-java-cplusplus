
package taller2;


public class Tienda {
    private int codtienda;
    private String direccion;
    private ListaClientes lc;

    public Tienda(int codtienda, String direccion) {
        this.codtienda = codtienda;
        this.direccion = direccion;
        lc = new ListaClientes(1000);
    }

    public int getCodtienda() {
        return codtienda;
    }

    public void setCodtienda(int codtienda) {
        this.codtienda = codtienda;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ListaClientes getLc() {
        return lc;
    }

    public void setLc(ListaClientes lc) {
        this.lc = lc;
    }
    
}
