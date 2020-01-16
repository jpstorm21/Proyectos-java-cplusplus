
package ficha4;


public class JornadaCompleta extends Empleado {
    private int sueldobase;

    public JornadaCompleta(int sueldobase, String nombre, String rut) {
        super(nombre, rut);
        this.sueldobase = sueldobase;
    }

    public int getSueldobase() {
        return sueldobase;
    }

    public void setSueldobase(int sueldobase) {
        this.sueldobase = sueldobase;
    }
    
    public int calcularSueldo(){
        return(sueldobase);
    }
  

   

    
    
    
}
