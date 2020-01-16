
package ficha4;


public class ListaDepartamentos {
    private int max;
    private int cantdptos;
    private Departamento [] ld;

    public ListaDepartamentos(int max) {
        this.max = max;
        cantdptos = 0;
        ld = new Departamento[max];
    }

    public int getMax() {
        return max;
    }

    public int getCantdptos() {
        return cantdptos;
    }

    public Departamento getDepartamento(int i) {
        return ld[i];
    }
    public boolean ingresarDepartamento(Departamento D){
        if(cantdptos < max){
            ld[cantdptos] = D;
            cantdptos++;
            return true;
        }else{
            System.out.print("lista llena");
            return false;
        }
    }
    public Departamento buscarDepartamento(int codigo){
        int i ;
        for(i = 0; i<cantdptos;i++){
            if(ld[i].getCodigo() == codigo){
                break;
            }
        }
        if(i == cantdptos){
            return null;
        }else{
            return ld[i];
        }
    }
    
}
