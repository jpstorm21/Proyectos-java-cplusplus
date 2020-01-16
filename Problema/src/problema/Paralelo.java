package problema;

public class Paralelo {
    private int numero;
    private Profesor profesor;
    private Asignatura asignatura;
    
    public Paralelo(int numero){
        this.numero = numero;
    }
    public int getNumero(){
        return numero;
    }
    public void setNumero(int numero){
        this.numero = numero;
    }
    public Profesor getProfesor(){
        return profesor;
    }
    public void setProfesor(Profesor P){
        this.profesor = P;
    }
    public Asignatura getAsignatura(){
        return asignatura;
    }
    public void setAsignatura(Asignatura A){
        this.asignatura = A;
    }
}
