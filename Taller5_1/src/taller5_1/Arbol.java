package taller5_1;

public class Arbol {
    private Nodo raiz;

    public Arbol() {
        raiz= new Nodo(0);
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
    
}