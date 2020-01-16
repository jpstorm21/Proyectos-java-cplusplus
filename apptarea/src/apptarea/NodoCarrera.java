
package apptarea;

public class NodoCarrera {
    private Carrera carrera;
    private NodoCarrera nextCarrera;
    public NodoCarrera(Carrera C){
        this.carrera = C;
        nextCarrera = null;
    }
    public Carrera getCarrea(){
        return carrera;
    }
    public NodoCarrera getNextCarrea(){
        return nextCarrera;
    }
    public void setNodoCarrea(NodoCarrera N){
        this.nextCarrera = N;
    }
}
