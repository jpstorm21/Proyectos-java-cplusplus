
package ayudantia.pkg8;


public class Gato extends Mascota {
   private String marca;

    public Gato(String marca, int fecha, int canthoras, String nombre) {
        super(fecha, canthoras, nombre);
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
   public int calcularCobro(){
       int cobro = 800*this.getCanthoras();
       return cobro;
   }
}
