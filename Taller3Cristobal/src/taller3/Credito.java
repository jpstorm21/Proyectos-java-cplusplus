package taller3;

public class Credito {

    private int codigoCred;
    private int monto;
    private double tasaInteres;
    private int cuotaMensual;
    private int cantCoutas;
    private String estado;
    private Persona persona;

    public Credito(int codigoCred, int monto, double tasaInteres, int cuotaMensual, int cantCoutas, String estado, Persona persona) {
        this.codigoCred = codigoCred;
        this.monto = monto;
        this.tasaInteres = tasaInteres;
        this.cuotaMensual = cuotaMensual;
        this.cantCoutas = cantCoutas;
        this.estado = estado;
        this.persona = persona;
    }

    public int getCodigoCred() {
        return codigoCred;
    }

    public void setCodigoCred(int codigoCred) {
        this.codigoCred = codigoCred;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public int getCuotaMensual() {
        return cuotaMensual;
    }

    public void setCuotaMensual(int cuotaMensual) {
        this.cuotaMensual = cuotaMensual;
    }

    public int getCantCoutas() {
        return cantCoutas;
    }

    public void setCantCoutas(int cantCoutas) {
        this.cantCoutas = cantCoutas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

}
