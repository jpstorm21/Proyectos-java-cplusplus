package taller3;

public abstract class Persona {

    private int codigo;
    private String nombre;
    private String apellido;
    private int edad;
    private String estudios;
    private ListaCreditos LCred;

    protected Persona(int codigo, String nombre, String apellido, int edad, String estudios) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.estudios = estudios;
        this.LCred = LCred;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

    public ListaCreditos getLCred() {
        return LCred;
    }

    public void setLCred(ListaCreditos LCred) {
        this.LCred = LCred;
    }

    public abstract void Calcular();

}
