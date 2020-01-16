package ejerciciosrecursion;

/**
 *
 * @author Fabian
 */
public class ListaDoble {
    Nodo start;
    int tamaño;
    
    public ListaDoble (){
        start = null;
        tamaño = 0;
    }
    
    public void agregar (Numeros n){
        Nodo nn = new Nodo (n);
        if(start == null){
            start = nn;
        }
        else{
            Nodo aux = start;
            while (aux.next != null){
                aux = aux.next;
            }
            aux.next = nn;
            nn.prev = aux;
        }
        tamaño++;
        
    }
    
    
    
    
    
    
    public void imprimir (){
        Nodo aux = start;
        
        do{
            System.out.println (aux.n);
            aux = aux.next;
        }while (aux != null);
    }
    
    
}
