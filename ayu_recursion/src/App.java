
public class App {

    public static void main(String[] args) {
        ArbolABB arbol = new ArbolABB();
        arbol.insertarDato(5);
        arbol.insertarDato(10);
        arbol.insertarDato(1);
        arbol.inOrden(arbol.getRaiz());
        System.out.println("-------------");
        arbol.eliminarDato(5);
        arbol.inOrden(arbol.getRaiz());
        arbol.toString();
       
    }
}
