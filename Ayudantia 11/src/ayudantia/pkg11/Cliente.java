package ayudantia.pkg11;

/**
 *
 * @author Cristóbal
 */
public class Cliente {
    
    private String nombre;
    private String rut;
    private ListaEnvios listaEnvios;
    private ListaProductos listaProductos;

    public Cliente(String nombre, String rut) {
        this.nombre = nombre;
        this.rut = rut;
        listaEnvios = new ListaEnvios();
        listaProductos = new ListaProductos();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaProductos getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ListaProductos listaProductos) {
        this.listaProductos = listaProductos;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public ListaEnvios getListaEnvios() {
        return listaEnvios;
    }

    public void setListaEnvios(ListaEnvios listaEnvios) {
        this.listaEnvios = listaEnvios;
    }
    
    
    
    
    
    
    
    
    
    
    
}
