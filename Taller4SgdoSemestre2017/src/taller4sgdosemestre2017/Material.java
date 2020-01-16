package taller4sgdosemestre2017;

public class Material {

    private int codigo;
    private String nombre;
    private int stock;
    private String descripcion;
    private int cantidad;
    private ListaServicios ls;
    public Material(int codigo, String nombre, int stock, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = stock;
        this.descripcion = descripcion;
        ls =  new ListaServicios();
    }

    public int getCantidad() {
        return cantidad;
    }

    public ListaServicios getLs() {
        return ls;
    }

    public void setLs(ListaServicios ls) {
        this.ls = ls;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
