
package ayudantia.pkg8;

public class Animal extends Mascota {
    private String tipo;

    public Animal(String tipo, int fecha, int canthoras, String nombre) {
        super(fecha, canthoras, nombre);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int calcularCobro(){
        int cobro = 1200 * this.getCanthoras();
        return cobro;
    }
}
