package problema;

public class MediaJornada extends Profesor{
    private int grado;
    
    public MediaJornada(int grado, String nombre, String rut){
        super(nombre, rut);
        this.grado = grado;
    }
    public int getGrado(){
        return grado;
    }
    public void setGrado(int grado){
        this.grado = grado;
    }
    @Override
    public int calcularSueldo(){
        int sueldo = 0;
        if(grado == 1){
            sueldo = 300000;
        }
        if(grado == 2){
            sueldo = 600000;
        }
        if(grado == 3){
            sueldo = 900000;
        }
        return sueldo;
    }
}
