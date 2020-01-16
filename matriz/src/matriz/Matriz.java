package matriz;
import ucn.*;

public class Matriz {
    
    public static int sumaMatriz(int filas,int columnas){
     return sumar(0,0,filas,columnas);
    }
    
    private static int sumar(int filaI,int columnaI,int filaF,int columnaF){
        if
    }

    public static void main(String[] args) {
        StdOut.println("Ingresar número de filas: ");
        int filas = StdIn.readInt();
        StdOut.println("Ingresar número de columnas: ");
        int columnas = StdIn.readInt();
        
        StdOut.println("Matriz de " + filas + "x" + columnas);
        int [][] matriz = new int [filas][columnas];
        for(int i = 0; i < filas; i++){
            for(int j = 0; j < columnas; j++){
                StdOut.println("Ingrese número: ");
                int numero = StdIn.readInt();
                matriz[i][j] = numero;
            }
        }
        int sumaMayor = sumaMatriz(filas,columnas);
        StdOut.println("la suma es:" + sumaMayor);
    }
    
}
