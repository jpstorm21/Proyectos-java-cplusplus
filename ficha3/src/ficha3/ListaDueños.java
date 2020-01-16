
package ficha3;


public class ListaDueños {
   private int max;
   private int cantdueños; 
   private Dueño [] ld;

    public ListaDueños(int max) {
        this.max = max;
        cantdueños = 0;
        ld = new Dueño[max];
    }

    public int getMax() {
        return max;
    }

    public int getCantdueños() {
        return cantdueños;
    }

    public Dueño getDueño(int i) {
        return ld[i];
    }
   public boolean ingresarDueño(Dueño D){
        if(cantdueños> max){
            System.out.print("cantidad execida");
            return false;
        }else{
            ld[cantdueños]= D;
            cantdueños++;
            return true;
        }
    }
}
