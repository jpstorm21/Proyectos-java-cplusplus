
package ficha3;


public class ListaPropiedades {
    private int max;
    private int cantpro;
    private Propiedad [] lp;

    public ListaPropiedades(int max) {
        this.max = max;
        cantpro = 0;
        lp = new Propiedad[max];
    }

    public int getMax() {
        return max;
    }

    public int getCantpro() {
        return cantpro;
    }

    public Propiedad getPropiedad(int i) {
        return lp[i];
    }
    public boolean ingresarPropiedad(Propiedad P){
        if(cantpro > max){
            System.out.print("cantidad execida");
            return false;
        }else{
            lp[cantpro]= P;
            cantpro++;
            return true;
        }
    }
            
}
