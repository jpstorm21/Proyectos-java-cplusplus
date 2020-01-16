
package ayudantia.pkg8;

public abstract class Mascota {
    private int fecha;
    private int canthoras;
    private String nombre;
    private Cliente cliente;

    protected Mascota(int fecha, int canthoras, String nombre) {
        this.fecha = fecha;
        this.canthoras = canthoras;
        this.nombre = nombre;
        
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public int getCanthoras() {
        return canthoras;
    }

    public void setCanthoras(int canthoras) {
        this.canthoras = canthoras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    abstract public int calcularCobro();
    
    
    
}
