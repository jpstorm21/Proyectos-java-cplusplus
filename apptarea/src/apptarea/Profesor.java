
package apptarea;


public abstract class Profesor {
    
   private String rut;
   private String nombre;
   private ListaParalelos lp;

    protected Profesor(String rut, String nombre) {
        this.rut = rut;
        this.nombre = nombre;
        lp = new ListaParalelos();
        
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaParalelos getLp() {
        return lp;
    }

    public void setLp(ListaParalelos lp) {
        this.lp = lp;
    }
    
    abstract public int calcularSueldo();
   
   
    
}
