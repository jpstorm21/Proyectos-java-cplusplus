package taller3;

public class Estudiante extends Persona {

    private int añoActual;
    private int añosDeCarrera;

    public Estudiante(int codigo, String nombre, String apellido, int edad, String estudios) {
        super(codigo, nombre, apellido, edad, estudios);
        this.añosDeCarrera = añosDeCarrera;
        this.añoActual = añoActual;
    }

    public int getAñoActual() {
        return añoActual;
    }

    public void setAñoActual(int añoActual) {
        this.añoActual = añoActual;
    }

    public int getAñosDeCarrera() {
        return añosDeCarrera;
    }

    public void setAñosDeCarrera(int añosDeCarrera) {
        this.añosDeCarrera = añosDeCarrera;
    }

    @Override
    public void Calcular() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
