
package ejemplosabstrac;


public abstract class Vehiculo {
    private String patente;
    private String marca;
    private int añofabricacion;

    protected Vehiculo(String patente, String marca, int añofabricacion) {
        this.patente = patente;
        this.marca = marca;
        this.añofabricacion = añofabricacion;
    }

    public String getPatente() {
        return patente;
    }

    public String getMarca() {
        return marca;
    }

    public int getAñofabricacion() {
        return añofabricacion;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setAñofabricacion(int añofabricacion) {
        this.añofabricacion = añofabricacion;
    }
    abstract public int costoreparacion();
}
