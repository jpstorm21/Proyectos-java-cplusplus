
package taller3;


public class ListaHabitaciones {
    private int max;
    private int canthabitaciones;
    private Habitacion [] lh;

    public ListaHabitaciones(int max) {
        this.max = max;
        canthabitaciones = 0;
        lh = new Habitacion [max];
    }

    public int getMax() {
        return max;
    }

    public int getCanthabitaciones() {
        return canthabitaciones;
    }

    public Habitacion getHabitacion(int i) {
        return lh[i];
    }
    public boolean ingreasarHabitacion(Habitacion H){
        if(canthabitaciones < max){
            lh[canthabitaciones]= H;
            canthabitaciones++;
            return true;
        }else{
            System.out.println("lista llena");
            return false;
        }
    }
    public Habitacion buscarHabitacion(int numero){
        int i;
        for(i = 0;i<canthabitaciones;i++){
            if(lh[i].getNumero() == numero){
                break;
            }
        }
        if(i==canthabitaciones){
            return null;
        }else{
            return lh[i];
        }
        
    }
}
