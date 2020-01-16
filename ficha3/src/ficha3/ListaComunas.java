
package ficha3;


public class ListaComunas {
    private int max;
    private int cantcomunas;
    private Comuna [] lc;

    public ListaComunas(int max) {
        this.max = max;
        cantcomunas = 0;
        lc = new Comuna[max];
    }

    public int getMax() {
        return max;
    }

    public int getCantcomunas() {
        return cantcomunas;
    }

    public Comuna getComuna(int i) {
        return lc[i];
    }
    public boolean ingresarComuna(Comuna C){
        if(cantcomunas> max){
            System.out.print("cantidad execida");
            return false;
        }else{
            lc[cantcomunas]= C;
            cantcomunas++;
            return true;
        }
    }
     public Comuna buscarComuna(int codigo){
         int i=0;
        for(i = 0;i<cantcomunas;i++){
            if(lc[i].getCodigo() == codigo){
                break;
            }
        }
        if( i == cantcomunas){
            return null;
        }else{
            return lc[i];
        }
    }
}
