package taller5_2;

/**
 * Lista que guarda todos los estados del juego en matrices
 * @author JOSE
 */
public class ListaMatrices {
    
    private NodoMatriz first;
    private NodoMatriz last;
    
    public ListaMatrices(){
        this.first = null;
        this.last = null;
    }
    
    //Inserta al final
    public void insertarUltimo(int[][] matriz){
        NodoMatriz nuevo = new NodoMatriz(matriz);
        if (this.first == null){
            this.first = nuevo;
        }else{
            this.last.setNext(nuevo);
            nuevo.setPrev(this.last);
        }
        this.last = nuevo;
    }
    
    public NodoMatriz getFirst(){
        return first;
    }
}
