package taller3;

public class Profesional extends Persona {

    private int sueldoMensual;
    private int añosTrabajo;

    public Profesional(int codigo, String nombre, String apellido, int edad, String estudios) {
        super(codigo, nombre, apellido, edad, estudios);
        this.añosTrabajo = añosTrabajo;
        this.sueldoMensual = sueldoMensual;

    }

    public int getSueldoMensual() {
        return sueldoMensual;
    }

    public void setSueldoMensual(int sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }

    public int getAñosTrabajo() {
        return añosTrabajo;
    }

    public void setAñosTrabajo(int añosTrabajo) {
        this.añosTrabajo = añosTrabajo;
    }

    @Override
    public void Calcular() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
