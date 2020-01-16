
package ayudantia.pkg8;


public class Cliente {
    private String nombre;
    private String rut;
    private ListaMascotas lm;

    public Cliente(String nombre, String rut) {
        this.nombre = nombre;
        this.rut = rut;
        lm  = new ListaMascotas(1000);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public ListaMascotas getLm() {
        return lm;
    }

    public void setLm(ListaMascotas lm) {
        this.lm = lm;
    }
    
}
