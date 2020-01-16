
package ayudantia15;

/**
 *
 * @author juan pablo
 */
public class Opciones {
    private video[] datos;
    private int cant;
    private int max;
    
    public Opciones(int max){
        this.max = max;
        this.cant = 0;
        this.datos = new video[max];
    }
    
    public boolean insertar(video dato){
        if (cant < max){
            datos[cant++] = dato;
            return true;
        }
        return false;
    }
    
    public boolean eliminarUltimo(){
        if (cant > 0){
            datos[--cant] = null;
            return true;
        }
        return false;
    }
    
    public boolean estaLleno(){
        return cant == max;
    }
    
    public int suma(){
        int suma = 0;
        for (int i = 0; i < cant; i++) {
            suma += datos[i].getPeso();
        }
        return suma;
    }
    
    public void imprimir(){
        System.out.print("[");
        for (int i = 0; i < cant - 1; i++) {
            System.out.print(datos[i].getPeso() + ", ");
        }
        if (cant > 0){
            System.out.print(datos[cant - 1].getPeso());
        }
        System.out.println("]");
    }
}
