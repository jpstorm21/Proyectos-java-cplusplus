
package taller2;


public class Cliente {
  private String rut;
  private String nombre;
  private String apellido;
  private String sexo;
  private int telefono;
  private String email;
  private Tienda reftienda;
  private ListaOrdenCompra lo;

    public Cliente(String rut, String nombre, String apellido, String sexo, int telefono, String email) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.telefono = telefono;
        this.email = email;
        
        lo = new ListaOrdenCompra(1000);
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Tienda getReftienda() {
        return reftienda;
    }

    public void setReftienda(Tienda T) {
        reftienda = T;
    }

    public ListaOrdenCompra getLo() {
        return lo;
    }

    public void setLo(ListaOrdenCompra lo) {
        this.lo = lo;
    }
    
  
}
