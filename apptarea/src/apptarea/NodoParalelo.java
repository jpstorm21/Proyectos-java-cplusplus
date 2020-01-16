
package apptarea;


public class NodoParalelo {
    private Paralelo paralelo;
    private NodoParalelo nextParalelo;
    public NodoParalelo(Paralelo PL){
        this.paralelo = PL;
        nextParalelo = null;
    }
    public Paralelo getParalelo(){
        return paralelo;
    }
    public NodoParalelo getNextParalelo(){
        return nextParalelo;
    }
    public void setNextParalelo(NodoParalelo N){
        this.nextParalelo = N;
    }
}
