
package tarea;

public class ListaDepartamentos {
    private int max;
    private int cantdpto;
    private Departamento[] ld;

    public ListaDepartamentos(int max) {
        this.max = max;
        cantdpto = 0;
        ld = new Departamento[max];
    }

    public int getMax() {
        return max;
    }

    public int getCantdpto() {
        return cantdpto;
    }

    public Departamento getDepartamento(int i) {
        return ld[i];
    }
    public boolean ingresarDepto(Departamento D){
        if(cantdpto > max){
            System.out.print("cantidad excedida");
            return false;
        }else{
            ld[cantdpto] = D;
            cantdpto++;
            return true;
        }
    }
    public Departamento buscarDepto(String codigo){
        int i=0;
        for(i = 0;i<cantdpto;i++){
            if(ld[i].getCodigo().equalsIgnoreCase(codigo)){
                break;
            }
                
        }
        if(i == cantdpto){
            return null;
        }else{
            return ld[i];
        }
    }
}
