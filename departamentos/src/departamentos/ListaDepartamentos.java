
package departamentos;

public class ListaDepartamentos {
    private int max;
    private int cantDeptos;
    private Departamento [] ld;

    public ListaDepartamentos(int max) {
        this.max = max;
        cantDeptos = 0;
        ld =  new Departamento [max];
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getCantDeptos() {
        return cantDeptos;
    }

    public void setCantDeptos(int cantDeptos) {
        this.cantDeptos = cantDeptos;
    }

    public Departamento getDepartamento(int i) {
        return ld[i];
    }

    public void setLd(Departamento[] ld) {
        this.ld = ld;
    }
    public boolean ingresarDepartamento(Departamento D){
        if(cantDeptos < max){
            ld[cantDeptos] = D;
            cantDeptos++;
            return true;
        }else{
            return false;
        }
    }
    public Departamento BuscarDepartamento(String codigo){
        int i;
        for(i=0;i<cantDeptos;i++){
            if(ld[i].getCodigo().equalsIgnoreCase(codigo)){
                break;
            }
        }
        if(i== cantDeptos){
            return null;
        }else{
            return ld[i];
        }
    }
    
    
}
