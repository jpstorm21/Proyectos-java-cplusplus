package ficha1;

public class Empleado {
    private String nombre;
    private String rut;
    private int sueldo;
    private Departamento departamento;
    
    public Empleado(String nombre, String rut, int sueldo){
        this.nombre = nombre;
        this.rut = rut;
        this.sueldo = sueldo;      
    }
    
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getRut(){
        return rut;
    }
    public void setRut(String rut){
        this.rut = rut;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
    
    public Departamento getDepartamento(){
        return departamento;
    }
    public void setDepartamento(Departamento D){
        departamento = D;
    }
}
