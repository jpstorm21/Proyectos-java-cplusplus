
package problemaversion2nexos;


public class ListaParalelos {
   private NodoParalelo firstParalelo;
   private NodoParalelo lastParalelo;

    public ListaParalelos() {
        this.firstParalelo = null;
        this.lastParalelo = null;
    }

    public NodoParalelo getFirstParalelo() {
        return firstParalelo;
    }

    public void setFirstParalelo(NodoParalelo firstParalelo) {
        this.firstParalelo = firstParalelo;
    }

    public NodoParalelo getLastParalelo() {
        return lastParalelo;
    }

    public void setLastParalelo(NodoParalelo lastParalelo) {
        this.lastParalelo = lastParalelo;
    }
   public void ingresarParalelo(Paralelo P){
       NodoParalelo nuevo = new NodoParalelo(P);
       if(firstParalelo == null){
           firstParalelo = nuevo;
           lastParalelo = nuevo;
       }else{
           nuevo.setNextParalelo(firstParalelo);
           firstParalelo.setPrevParalelo(nuevo);
           nuevo.setPrevParalelo(null);
           firstParalelo = nuevo;
       }
   }
   public Paralelo buscarParalelo(int numero){
       NodoParalelo actual = firstParalelo;
       while(actual !=null && actual.getParalelo().getNumero() != numero){
           actual =actual.getNextParalelo();
       }
       if(actual !=null){
           return actual.getParalelo();
       }else{
           return null;
       }
   }
}
