package problema;

public class ListaParalelos {
    private NodoParalelo primerParalelo;
    private NodoParalelo lastParalelo;
    public ListaParalelos(){
        primerParalelo = null;
        lastParalelo= null;
    }
    public NodoParalelo getPrimerParalelo(){
        return primerParalelo;
    }
    public void setPrimerParalelo(NodoParalelo N){
        this.primerParalelo = N;
    }
    public void insertarParalelo(Paralelo P){
        NodoParalelo nuevoNodo = new NodoParalelo(P);
        if(primerParalelo == null){
            primerParalelo = nuevoNodo;
            lastParalelo = nuevoNodo;
        }else{
            nuevoNodo.setSiguienteParalelo(primerParalelo);
            primerParalelo.setPrevioParalelo(nuevoNodo);
            nuevoNodo.setPrevioParalelo(null);
            primerParalelo = nuevoNodo;
        }
    }
    public Paralelo buscarParalelo(int numero){
        NodoParalelo actual = primerParalelo;
        while(actual != null && actual.getParalelo().getNumero() != numero){
            actual = actual.getSiguienteParalelo();
        }
        if(actual != null){
            return actual.getParalelo();
        }else{
            return null;
        }       
    }
  
}
