package taller3;

public class Tecnico extends Persona {

    private int sueldoMensual;
    private int gastoMensual;


    public Tecnico(int codigo, String nombre, String apellido, int edad, String estudios) {
        super(codigo, nombre, apellido, edad, estudios);
        this.sueldoMensual = sueldoMensual;
        this.gastoMensual = gastoMensual;


    }

 

    public int getSueldoMensual() {
        return sueldoMensual;
    }

    public void setSueldoMensual(int sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }

    public int getGastoMensual() {
        return gastoMensual;
    }

    public void setGastoMensual(int gastoMensual) {
        this.gastoMensual = gastoMensual;
    }

    @Override
    public void Calcular() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
