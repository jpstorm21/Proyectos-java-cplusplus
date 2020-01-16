package problema;

public class JornadaCompleta extends Profesor{
    private String titulo;
    private int jerarquia;
    
    public JornadaCompleta(String titulo, int jerarquia, String nombre, String rut){
        super(nombre, rut);
        this.titulo = titulo;
        this.jerarquia = jerarquia;
    }
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public int getJerarquia(){
        return jerarquia;
    }
    public void setJerarquia(int jerarquia){
        this.jerarquia = jerarquia;
    }
    @Override
    public int calcularSueldo(){
        int sueldo = 0;
        if(jerarquia == 1){
            sueldo = 1000000;
        }
        if(jerarquia == 2){
            sueldo = 1300000;
        }
        if(jerarquia == 3){
            sueldo = 1600000;
        }
        if(jerarquia == 4){
            sueldo = 2000000;
        }
        return sueldo;
    }
}
