package cine;

public abstract class Persona {
    private String nombre;
    private int rut;
    private String apellido;

    public Persona(String nombre, int rut, String apellido) {
        this.nombre = nombre;
        this.rut = rut;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
}
