
package ayudantia.pkg8;


public class Perro extends Mascota {
    private String raza;

    public Perro(String raza, int fecha, int canthoras, String nombre) {
        super(fecha, canthoras, nombre);
        this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
    public int calcularCobro(){
        int cobro = 1000*this.getCanthoras();
        return cobro;
    }
}
