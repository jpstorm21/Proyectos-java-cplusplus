package problema;

public class NodoParalelo {
    private Paralelo paralelo;
    private NodoParalelo siguienteParalelo;
    private NodoParalelo previoParalelo;
    
    public NodoParalelo(Paralelo P){
        this.paralelo = P;
        siguienteParalelo = null;
        previoParalelo = null;
    }
    public NodoParalelo getSiguienteParalelo(){
        return siguienteParalelo;
    }
    public void setSiguienteParalelo(NodoParalelo N){
        this.siguienteParalelo = N;
    }
    public Paralelo getParalelo(){
        return paralelo;
    }
    public void setParalelo(Paralelo P){
        this.paralelo = P;
    }

    public NodoParalelo getPrevioParalelo() {
        return previoParalelo;
    }

    public void setPrevioParalelo(NodoParalelo previoParalelo) {
        this.previoParalelo = previoParalelo;
    }
    
}
