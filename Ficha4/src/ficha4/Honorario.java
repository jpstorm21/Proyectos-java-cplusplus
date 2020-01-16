
package ficha4;


public class Honorario  extends Empleado{
    private int horas;
    private static int valorhora;

    public Honorario(int horas, String nombre, String rut) {
        super(nombre, rut);
        this.horas = horas;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public static int getValorhora() {
        return valorhora;
    }

    public void setValorhora(int valorhora) {
        Honorario.valorhora = valorhora;
    }
    public int calcularSueldo(){
        return(horas * valorhora);
    }
    
}
