
package ficha4;


public abstract class Empleado {
    private String nombre;
    private String rut;
    private Departamento departamento;
    
    protected Empleado(String nombre, String rut) {
        this.nombre = nombre;
        this.rut = rut;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento D) {
        this.departamento = D;
    }
    abstract public int calcularSueldo();
        
    
}
