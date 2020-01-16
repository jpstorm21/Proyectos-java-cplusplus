package ejemploarboles;
import ucn.*;

/**
 *
 * @author Ichiix
 */
public class EjemploArboles {

    
    public static void main(String[] args) {
        Arbol ar=new Arbol();
        
        Nodo n1=new Nodo(1);
        Nodo n2=new Nodo(2);
        Nodo n3=new Nodo(3);
        Nodo n4=new Nodo(4);
        Nodo n5=new Nodo(5);
        Nodo n6=new Nodo(6);
        Nodo n7=new Nodo(7);
        Nodo n8=new Nodo(8);
        Nodo n9=new Nodo(9);
        Nodo n10=new Nodo(54);
        Nodo n11=new Nodo(13);
        
        n11.setHijoIzq(n10);
        n9.setHijoIzq(n11);
        n7.setHijoIzq(n9);
        n7.setHijoDer(n8);
        n5.setHijoIzq(n6);
        n5.setHijoDer(n7);
        n2.setHijoIzq(n4);
        n2.setHijoDer(n5);
        n1.setHijoIzq(n2);
        n1.setHijoDer(n3);
        ar.setRaiz(n1);
        
        StdOut.println(ar.preOrden());
        StdOut.println(ar.postOrden());
        StdOut.println(ar.inOrden());
        StdOut.println(ar.buscar(4));
        StdOut.println(ar.buscar(98));
        StdOut.println(ar.contar());
        StdOut.println(ar.sumar());
        StdOut.println(ar.altura());
        StdOut.println(ar.mayorValor());
        StdOut.println(ar.menorValor());
        
    }
}
