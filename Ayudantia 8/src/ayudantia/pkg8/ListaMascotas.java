
package ayudantia.pkg8;

public class ListaMascotas {
  private int max;
  private int cantmascotas;
  private Mascota [] lm;

    public ListaMascotas(int max) {
        this.max = max;
        this.cantmascotas = cantmascotas;
        lm = new Mascota[max];
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getCantmascotas() {
        return cantmascotas;
    }

    public void setCantmascotas(int cantmascotas) {
        this.cantmascotas = cantmascotas;
    }

    public Mascota getMascota(int i) {
        return lm[i];
    }

    public void setLm(Mascota[] lm) {
        this.lm = lm;
    }
    public boolean ingresarMascota(Mascota M){
        if(cantmascotas < max){
            lm[cantmascotas]= M;
            cantmascotas++;
            return true;
        }else{
            System.out.println("lista llena");
            return false;
        }
    }
  
}
