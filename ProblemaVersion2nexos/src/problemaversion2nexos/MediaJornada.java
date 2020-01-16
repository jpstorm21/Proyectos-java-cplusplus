
package problemaversion2nexos;

public class MediaJornada extends Profesor{
   private int grado;

    public MediaJornada(int grado, String rut, String nombre) {
        super(rut, nombre);
        this.grado = grado;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }
   public int calcularSueldo(){
       int sueldo =0;
       if(grado == 1){
           sueldo = grado*300000;
       }else if(grado == 2){
           sueldo = grado * 300000;
       }else if(grado ==3 ){
           sueldo = grado *300000;
       }
       return sueldo;
   }
}
