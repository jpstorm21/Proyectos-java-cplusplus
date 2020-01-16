
package apptarea;

public class ListaCarreras {
    private NodoCarrera firstCarrera;
    

    public ListaCarreras(){
        firstCarrera = null;
    }
    public NodoCarrera getFirstCarrera(){
        return firstCarrera;
    }
    public int cantCarreras(){
        int contador =0;
        NodoCarrera actual = firstCarrera;
        while(actual != null){
            actual =actual.getNextCarrea();
            contador++; 
        }
        return contador++;
    }
    public void ingresarCarrea(Carrera C){
        NodoCarrera nuevonodo = new NodoCarrera(C);
        nuevonodo.setNodoCarrea(firstCarrera);
        firstCarrera = nuevonodo;
    }
    public Carrera buscarCarrera(int codigo){
        NodoCarrera actual = firstCarrera;
        while(actual != null && actual.getCarrea().getCodigo() != codigo){
            actual = actual.getNextCarrea();
        }
        if(actual != null){
            return actual.getCarrea();
        }else{
            return null;
        }
    }
    
    
}
