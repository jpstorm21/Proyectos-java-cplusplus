package problema;

public class Hora extends Profesor {
    private int cantHoras;
    public int valorHora;
    
    public Hora(int cantHoras, int valorHora, String nombre, String rut){
        super(nombre, rut);
        this.cantHoras = cantHoras;
        this.valorHora = valorHora;
    }
    public int getCantHoras(){
        return cantHoras;
    }
    public void setCantHoras(int cantHoras){
        this.cantHoras = cantHoras;
    }
    public int getValorHora() {
        return valorHora;
    }
    public void setValorHora(int valorHora) {
        this.valorHora = valorHora;
    }
    
    @Override
    public int calcularSueldo(){
        int sueldo = cantHoras * valorHora;
        return sueldo;
    }
}
