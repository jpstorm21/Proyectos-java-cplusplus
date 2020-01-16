package ejemploarboles;
import ucn.*;

/**
 *
 * @author Ichiix
 */
public class Arbol {
    Nodo raiz;
    
    public Arbol(){
        this.raiz=null;
    }
    
    //PREORDEN
    public String preOrden(){
        return "PREORDEN: "+preOrden(this.raiz,"");
    }
    
    private String preOrden(Nodo n,String s){
        
        if(n!=null){
            s +=" "+ n.getDato();
            s = preOrden(n.getHijoIzq(), s);
            s = preOrden(n.getHijoDer(), s);
        }return s;
    }
    
    
    //POSTORDEN
    public String postOrden(){
        return "POSTORDEN: "+postOrden(this.raiz, "");
    }
    
    public String postOrden(Nodo n, String s){
        if(n!=null){
            s = postOrden(n.getHijoIzq(), s);
            s = postOrden(n.getHijoDer(), s);
            s +=" "+ n.getDato();
        }return s;
    }
    
    
    //INORDEN
    public String inOrden(){
        return "INORDEN: "+inOrden(this.raiz,"");
    }
    
    public String inOrden(Nodo n,String s){
        if(n!=null){
            s = inOrden(n.getHijoIzq(), s);
            s +=" "+ n.getDato();
            s = inOrden(n.getHijoDer(), s);
        }return s;
    }
    
    
    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
    //BUSCAR UN NODO
    public String buscar(int num){
        if(buscar(this.raiz, num))
            return "El numero "+num +": Encontrado";
        return "El numero "+num+": No encontrado";
    }
    
    private boolean buscar(Nodo n, int num){
        if(n!=null){
            if(n.getDato()==num) return true;
            boolean ok1 = buscar(n.getHijoIzq(),num);
            boolean ok2 = buscar(n.getHijoDer(),num);
            if(ok1 || ok2) return true;
        }
        return false;
    }
    //CONTAR LOS NODOS
    public String contar(){
        int cant=contar(this.raiz);
        return "El arbol tiene "+cant+" nodos."; 
    }
    
    private int contar(Nodo n){
        if(n==null)
            return 0;
        int c1=contar(n.getHijoIzq());
        int c2=contar(n.getHijoDer());
        int c3=c1+c2+1;//se agrega +1 para contar al padre
        return c3;
            
    }
    
    public String sumar(){
        int cant=sumar(this.raiz);
        return "La suma de los nodos es "+cant;
    }
    
    private int sumar(Nodo n){
        if(n==null)
            return 0;
        int s1=sumar(n.getHijoIzq());
        int s2=sumar(n.getHijoDer());
        int s3=s1+s2+n.getDato();
        return s3;
    }
    
    //DETERMINAR ALTURA DEL ARBOL
    public String altura(){
        int alt=altura(this.raiz);
        return "La altura del árbol es: "+alt;
    }
    
    private int altura(Nodo n){
        if(n==null){
            return 0;
        }
        int h1=altura(n.getHijoIzq());
        int h2=altura(n.getHijoDer());
        if(h1>h2)
            return h1+1;//se agrega +1 para sumar la raiz
        return h2+1;//se agrega +1 para sumar la raiz
    }
    //BUSCAR EL NODO DE MAYOR VALOR
    public String mayorValor(){
        int mayor=mayorValor(this.raiz);
        return "El mayor valor es: "+mayor;
    }
    
    private int mayorValor(Nodo n){
        if(n==null)
            return 0;
        int m1=mayorValor(n.getHijoIzq());
        int m2=mayorValor(n.getHijoDer());
        int m3=n.getDato();
        if(m1>=m2 && m1>=m3)return m1;
        if(m2>=m1 && m2>=m3)
            return m2;
        return m3;
    }
    //BUSCAR EL NODO DE MENOR VALOR
    public String menorValor(){
        int menor=menorValor(this.raiz);
        return "El mayor valor es: "+menor;
    }
    
    private int menorValor(Nodo n){
        if(n==null)
            return 0;
        int men1=menorValor(n.getHijoIzq());
        int men2=menorValor(n.getHijoDer());
        int men3=n.getDato();
        if(men1<men2 && men1<men3)return men1;
        if(men2<men1 && men2<men3)
            return men2;
        return men3;
        
        
    }
}
