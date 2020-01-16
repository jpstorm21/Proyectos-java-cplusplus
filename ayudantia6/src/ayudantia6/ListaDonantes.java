
package ayudantia6;


public class ListaDonantes {
    private int max;
    private int cantDonantes;
    private Donante [] ld;
    
    public ListaDonantes (int max) {
        this.max = max;
        cantDonantes =0;
        ld = new Donante[max];
    }

    public int getMax() {
        return max;
    }

    public int getCantDonantes() {
        return cantDonantes;
    }

    public Donante getDonante(int i) {
        return ld[i];
    }
    
    public boolean ingresarDonante(Donante D) {
        if(cantDonantes < max) {
            ld[cantDonantes] = D;
            cantDonantes++;
            return true;
        } else {
            return false;
        }
    }
    
    
}
