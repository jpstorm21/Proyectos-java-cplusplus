package ficha1;

public class NodoDepartamento {
    private Departamento departamento;
    private NodoDepartamento siguienteDepartamento;
    
    public NodoDepartamento(Departamento D){
        this.departamento = D;
        siguienteDepartamento = null;
    }
    public Departamento getDepartamento(){
        return departamento;
    }
    public NodoDepartamento getSiguienteDepartamento(){
        return siguienteDepartamento;
    }
    public void setSiguienteDepartamento(NodoDepartamento N){
        this.siguienteDepartamento = N;
    }
}
