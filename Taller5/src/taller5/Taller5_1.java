package taller5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Taller5_1 {

    public static void main(String[] args) {
        String nomArchivo = "";
        try{
            nomArchivo = "abb.txt";
            leerAbb(nomArchivo);
        }catch(FileNotFoundException e){
            System.out.println("Error al leer el archivo: " + nomArchivo);
            System.exit(-1);
        }
    }
    
    public static boolean validarAbb(int[] arbol){
        if (arbol == null || arbol.length < 1){
            throw new IllegalArgumentException("No hay árbol");
        }
        return validarAbb(arbol, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public static boolean validarAbb(int[] arbol, int i, int min, int max){
        if (arbol == null || i < 0){
            throw new IllegalArgumentException("No hay árbol");
        }
        if (i >= arbol.length){
            return true;
        }
        int dato = arbol[i];
        int posIzq = 2*i + 1;
        int posDer = 2*i + 2;
        return dato > min && dato < max && validarAbb(arbol, posIzq, min, dato)
                && validarAbb(arbol, posDer, dato, max);
        
    }
    
    public static int[] minMax(int[] arbol){
        if (arbol == null || arbol.length < 1){
            throw new IllegalArgumentException("No hay árbol");
        }
        int[] minmax = new int[2]; //Acá se almacena mínimo y máximo
        minmax[0] = arbol[0];
        minmax[1] = arbol[0];
        return minMax(arbol, 0, minmax);
    }
    
    private static int[] minMax(int [] arbol, int i, int[] minmax){
        if (arbol == null || i < 0){
            throw new IllegalArgumentException("No hay árbol");
        }
        int posIzqMin = 2*i + 1; 
        int posDerMax = 2*i + 2;
        //Chequea si tiene hijo min
        if (posIzqMin < arbol.length){
            if (minmax[0] > arbol[posIzqMin]){
                minmax[0] = arbol[posIzqMin]; //El menor
            }
            minMax(arbol, posIzqMin, minmax);
        }
        //Chequea si tiene hijo max
        if (posDerMax < arbol.length){
            if (minmax[1] < arbol[posDerMax]){
                minmax[1] = arbol[posDerMax]; //El mayor
            }
            minMax(arbol, posDerMax, minmax);
        }
        return minmax;
    }
    
    public static void leerAbb(String nomArchivo) throws FileNotFoundException{
        int[] arbol;
        int length;
        Scanner archivo = new Scanner(new File(nomArchivo));
        while(archivo.hasNextLine()){
            length = Integer.parseInt(archivo.nextLine());
            arbol = new int[length];
            String[] strData = archivo.nextLine().split(",");
            for(int i = 0; i < length; i++){
                arbol[i] = Integer.parseInt(strData[i]);
            }
            
            imprimirArbol(arbol);
            //Valida:
            boolean valido = validarAbb(arbol);
            System.out.println("\tEs Abb: " + valido);
            if (valido){
                int[] minmax = minMax(arbol);
                System.out.println("\tMínimo: " + minmax[0]);
                System.out.println("\tMáximo: " + minmax[1]);
            }
            System.out.println("");
            
        }
        archivo.close();
    }
    
    /**
     * Imprime el arreglo
     * @param arbol Árbol
     */
    public static void imprimirArbol(int[] arbol){
        for(int dato: arbol){
            System.out.print(dato + " ");
        }
        System.out.println("");
    }
}
