
package tarea;


public class ListaEmpleados {
    private int max;
    private int cantemple;
    private Empleado [] le;

    public ListaEmpleados(int max) {
        this.max = max;
        cantemple = 0;
        le = new Empleado[max];
    }

    public int getMax() {
        return max;
    }

    public int getCantemple() {
        return cantemple;
    }

    public Empleado getEmpleado(int i) {
        return le[i];
    }
    public boolean ingresarEmpleado(Empleado E){
        if(cantemple > max){
            System.out.print("excede el maximo");
            return false;
        }else{
            le[cantemple] = E;
            cantemple++;
           return true;
        }
    }
    public Empleado buscarEmpleado(String rut){
        int i= 0;
        for(i = 0;i<cantemple;i++){
            if(le[i].getRut().equalsIgnoreCase(rut)){
                break;
            }
        }
        if( i == cantemple){
            return null;
        }else{
            return le[i];
        }
    }
}
