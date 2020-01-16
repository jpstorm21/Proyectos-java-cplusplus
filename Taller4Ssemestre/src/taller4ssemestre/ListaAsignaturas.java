
package taller4ssemestre;
import java.util.LinkedList;

public class ListaAsignaturas {
    private LinkedList <Asignatura> la;
    private int contador;

    public ListaAsignaturas() {
         la = new LinkedList<Asignatura>();
         this.contador=0;
    }
    public void ingresarAsignatura(Asignatura A){
        la.add(A);
        contador++;
    }
    public Asignatura buscarAsignatura(String cod){
        Asignatura A = null;
        for (Asignatura iterador : la) {
            if (iterador.getCodigo().equalsIgnoreCase(cod)) {
                A = iterador;
                break;
            }
        }
        return A;
    }
    public boolean eliminarAsignatura(String cod){
        boolean eliminar=  la.remove(cod);
        if(eliminar ){
            contador--;
            return true;
        }else{
            return false;
        }
        
    }
       public boolean repetido(String codigo) {
        boolean estado = false;
        for (Asignatura iterador : la) {
            if (iterador.getCodigo().equalsIgnoreCase(codigo)) {
                estado = true;
                break;
            } else {
                return false;
            }
        }
        return estado;
    }

    public int getContador() {
        return contador;
    }

       
    
}
