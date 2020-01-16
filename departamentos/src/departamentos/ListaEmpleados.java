
package departamentos;

public class ListaEmpleados {
    private int max;
    private int cantEmple;
    private Empleado [] le;

    public ListaEmpleados(int max) {
        this.max = max;
        this.cantEmple = 0;
        le = new Empleado[max];
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getCantEmple() {
        return cantEmple;
    }

    public void setCantEmple(int cantEmple) {
        this.cantEmple = cantEmple;
    }

    public Empleado getEmpleado(int i) {
        return le[i];
    }

    public void setEmpleado(Empleado E) {
        this.le = le;
    }
    public boolean ingresarEmpleado(Empleado E){
        if(cantEmple< max){
            le[cantEmple] = E;
            cantEmple++;
            return true;
        }else{
            return false;
        }
    }
    public Empleado buscarEmpleado(String rut){
        int i;
        for(i=0;i<cantEmple;i++){
            if(le[i].getRut().equalsIgnoreCase(rut)){
                break;
            }
        }
        if(i==cantEmple){
            return null;
        }else{
            return le[i];
        }
    }
    
    
}
