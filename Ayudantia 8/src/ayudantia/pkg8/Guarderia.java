
package ayudantia.pkg8;

public class Guarderia {
    private String nombre;
    private String direccion;
    private ListaClientes lc;

    public Guarderia(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        lc = new ListaClientes(1000); 
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
