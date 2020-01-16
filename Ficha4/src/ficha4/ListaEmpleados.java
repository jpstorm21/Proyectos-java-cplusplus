package ficha4;

public class ListaEmpleados {

    private int max;
    private int cantempleados;
    private Empleado[] le;

    public ListaEmpleados(int max) {
        this.max = max;
        cantempleados = 0;
        le = new Empleado[max];
    }

    public int getMax() {
        return max;
    }

    public int getCantempleados() {
        return cantempleados;
    }

    public Empleado getEmpleado(int i) {
        return le[i];
    }

    public boolean ingresarEmpleado(Empleado E) {
        if (cantempleados < max) {
            le[cantempleados] = E;
            cantempleados++;
            return true;
        } else {
            System.out.print("lista llena");
            return false;
        }
    }

    public Empleado buscarEmpleado(String rut) {
        int i;
        for (i = 0; i < cantempleados; i++) {
            if (le[i].getRut().equalsIgnoreCase(rut)) {
               break;
            }
        }

        if (i == cantempleados) {
            return null;
        } else {
            return le[i];
        }

    }
}
