
package taller3;

public class Cliente extends Persona {
    private ListaReservaciones lr;

    public Cliente(String codigo, String nombre, String apellido, int telefono) {
        super(codigo, nombre, apellido, telefono);
        lr = new ListaReservaciones(1000);
    }

    public ListaReservaciones getLr() {
        return lr;
    }

    public void setLr(ListaReservaciones lr) {
        this.lr = lr;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    

    
    
}
