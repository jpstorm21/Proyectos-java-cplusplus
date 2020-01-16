package ejemplosabstrac;

import ucn.StdOut;

public class ListaVehiculos {

    private int max;
    private int cantvehiculos;
    private Vehiculo[] lv;

    public ListaVehiculos(int max) {
        this.max = max;
        cantvehiculos = 0;
        lv = new Vehiculo[max];
    }

    public int getMax() {
        return max;
    }

    public int getCantvehiculos() {
        return cantvehiculos;
    }

    public Vehiculo getVehiculo(int i) {
        return lv[i];
    }

    public boolean ingresarVehiculo(Vehiculo V) {
        if (cantvehiculos >= max) {
            StdOut.print("lista llena");
            return false;
        } else {
            lv[cantvehiculos] = V;
            cantvehiculos++;
            return true;
        }
    }

    public Vehiculo buscarVehiculo(String patente) {
        int i;
        for (i = 0; i < cantvehiculos; i++) {
            if (lv[i].getPatente().equalsIgnoreCase(patente)) {
                break;
            }
        }
        if (i == cantvehiculos) {
            return null;
        } else {
            return lv[i];
        }
    }

    
}
