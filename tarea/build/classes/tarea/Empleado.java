
package tarea;

public class Empleado {
    private String nombre;
    private String rut;
    private int sueldo;
    private String codigodepa;
    private Departamento refdepartamento;

    public Empleado(String nombre, String rut,String codigodepa, int sueldo) {
        this.nombre = nombre;
        this.rut = rut;
        this.sueldo = sueldo;
        this.codigodepa = codigodepa;
        
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

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public Departamento getRefdepartamento() {
        return refdepartamento;
    }

    public void setRefdepartamento(Departamento D) {
        refdepartamento = D;
    }

    public String getCodigodepa() {
        return codigodepa;
    }

    public void setCodigodepa(String codigodepa) {
        this.codigodepa = codigodepa;
    }
    
}
