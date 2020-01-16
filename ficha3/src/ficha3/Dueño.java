
package ficha3;


public class Dueño {
    private int rut;
    private String nombre;
    private ListaPropiedades lp;

    public Dueño(int rut, String nombre) {
        this.rut = rut;
        this.nombre = nombre;
        lp = new ListaPropiedades(1000);
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaPropiedades getLp() {
        return lp;
    }

    public void setLp(ListaPropiedades lp) {
        this.lp = lp;
    }
    
}
