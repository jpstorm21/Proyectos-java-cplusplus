
package taller3;


public class ListaReservaciones {
   private int max;
   private int cantreservaciones;
   private Reservacion [] lr;

    public ListaReservaciones(int max) {
        this.max = max;
        cantreservaciones = 0;
        lr = new Reservacion[max];
    }

    public int getMax() {
        return max;
    }

    public int getCantreservaciones() {
        return cantreservaciones;
    }

    public Reservacion getReservacion(int i) {
        return lr[i];
    }
    public boolean ingresarReservacion(Reservacion R){
        if(cantreservaciones < max){
            lr[cantreservaciones] = R;
            cantreservaciones++;
            return true;
        }else{
            System.out.println("lista llena");
            return false;
        }
    }
    public Reservacion buscarReservacion(int codigo){
        int i;
        for(i=0;i<cantreservaciones;i++){
            if(lr[i].getCodigo()== codigo){
                break;
            }
        }
        if(i==cantreservaciones){
            return null;
        }else{
            return lr[i];
        }
    }
   
}
