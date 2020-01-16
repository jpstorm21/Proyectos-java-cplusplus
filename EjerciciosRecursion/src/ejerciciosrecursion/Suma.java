package ejerciciosrecursion;

/**
 *
 * @author Fabian
 */
public class Suma {
    
    ListaDoble l;
    Numeros n;
    Numeros m;
    Nodo aux;
    
    public Suma (){
        l = new ListaDoble();
        
        
            n = new Numeros (1, 2, 3, 5);
            m = new Numeros (2, 3, 4, 1);
        
        
        l.agregar(n);
        l.agregar (m);
        aux = l.start;
    }
    
    
    
    public int sumaNormal (ListaDoble l){
        int suma=0;
        
        Nodo aux = l.start;
        
        do{
            suma += aux.n.numero1 + aux.n.numero2 + aux.n.numero3 + aux.n.numero4;
            aux = aux.next;
        }while (aux!= null);
        
        
        
        return suma;
    }
    
    
    public int sumaRecursiva (ListaDoble l, int sumador){

        if(aux == null){
            return sumador;
        }
        else{ 
            sumador += aux.n.numero1 + aux.n.numero2 + aux.n.numero3 + aux.n.numero4;
            
            aux = aux.next;

            sumador = sumaRecursiva(l, sumador);
            
            return sumador;
        }
        
        
        
    }
    
    
    
    
    
    
}
