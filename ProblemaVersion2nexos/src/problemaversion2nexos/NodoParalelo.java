
package problemaversion2nexos;

public class NodoParalelo {
    private NodoParalelo nextParalelo;
    private NodoParalelo prevParalelo;
    private Paralelo  paralelo;

    public NodoParalelo(Paralelo P) {
        this.nextParalelo = null;
        this.prevParalelo = null;
        this.paralelo = P;
    }

    public NodoParalelo getNextParalelo() {
        return nextParalelo;
    }

    public void setNextParalelo(NodoParalelo nextParalelo) {
        this.nextParalelo = nextParalelo;
    }

    public NodoParalelo getPrevParalelo() {
        return prevParalelo;
    }

    public void setPrevParalelo(NodoParalelo prevParalelo) {
        this.prevParalelo = prevParalelo;
    }

    public Paralelo getParalelo() {
        return paralelo;
    }

    public void setParalelo(Paralelo paralelo) {
        this.paralelo = paralelo;
    }
    
}
