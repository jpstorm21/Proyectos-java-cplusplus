package ejercicio_recursividad_5;

/**
 *
 * @author Cristóbal
 */
public class Ejercicio_Recursividad_5 {
    //EJERCICIO - Buscar el mayor y menor en un arreglo.
    
    public static void buscar_Mayor_Menor (int[] arreglo, int pos, int mayor, int menor){     
        if(pos > arreglo.length-1){//tamañ0 = 4
            System.out.println("El mayor es: " + mayor);
            System.out.println("El menor es: " + menor);
        }else{
            if(arreglo[pos] > mayor){
                mayor = arreglo[pos];
            }
            
            if(arreglo[pos]< menor){
                menor = arreglo[pos];
            }
            buscar_Mayor_Menor(arreglo, pos + 1, mayor, menor);
        }
    }
    
    public static void main(String[] args) {
        int[] arreglo = {1,4,5,2,6};
        int mayor = -999;
        int menor = 999;
        buscar_Mayor_Menor(arreglo,0, mayor, menor);
    }
    
}
