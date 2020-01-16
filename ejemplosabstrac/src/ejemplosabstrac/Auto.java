
package ejemplosabstrac;


public class Auto extends Vehiculo {
    private int kilometraje;
    private int capacidadEstanque;

    public Auto(int kilometraje, int capacidadEstanque, String patente, String marca, int añofabricacion) {
        super(patente, marca, añofabricacion);
        this.kilometraje = kilometraje;
        this.capacidadEstanque = capacidadEstanque;
    }
    public int getKilometraje() {
        return kilometraje;
    }
    public int getCapacidadEstanque() {
        return capacidadEstanque;
    }
    public int costoreparacion(){
        return(capacidadEstanque * 20000);
    }

  
}
