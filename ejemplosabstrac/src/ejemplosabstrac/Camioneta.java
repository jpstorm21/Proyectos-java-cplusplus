
package ejemplosabstrac;


public class Camioneta extends Vehiculo {
    private int capacidadCarga;

    public Camioneta(int capacidadCarga, String patente, String marca, int añofabricacion) {
        super(patente, marca, añofabricacion);
        this.capacidadCarga = capacidadCarga;
    }

    public int getCapacidadCarga() {
        return capacidadCarga;
    }
    public int costoreparacion(){
        return(capacidadCarga * 100000);
    }
}
