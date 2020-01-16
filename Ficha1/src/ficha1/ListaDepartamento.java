package ficha1;

public class ListaDepartamento {
    private NodoDepartamento firstDepartamento;
    
    public ListaDepartamento(){
        firstDepartamento = null;
    }
    public void insertarDepartamento(Departamento D){
        NodoDepartamento nuevoNodo = new NodoDepartamento(D);
        nuevoNodo.setSiguienteDepartamento(firstDepartamento);
        firstDepartamento = nuevoNodo;
    }
    public Departamento encontrarDepartamento(String codigo){
        NodoDepartamento actual = firstDepartamento;
        while(actual != null && !actual.getDepartamento().getCodigo().equalsIgnoreCase(codigo)){
            actual = actual.getSiguienteDepartamento();          
        }
        if(actual != null){
            return actual.getDepartamento();
        }else{
            return null;
        }
    }
    public NodoDepartamento getFirstDepartamento(){
        return firstDepartamento;
    }
    public int cantDepartamentos(){
        NodoDepartamento actual = firstDepartamento;
        int contador = 0;
        while(actual != null){
            actual = actual.getSiguienteDepartamento();
            contador++;           
        }
        return contador;
    }
}
