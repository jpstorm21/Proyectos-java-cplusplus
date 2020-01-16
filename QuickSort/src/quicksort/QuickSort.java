package quicksort;

public class QuickSort {

    public static int cont = 0;
    
    public static int randomWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

    public static void quickSort(int[] arreglo, int inicio, int fin) {
        if (inicio < fin) {
            int pos = dividirArreglo(arreglo, inicio, fin);
            quickSort(arreglo, inicio, pos - 1);
            quickSort(arreglo, pos + 1, fin);
        }
    }

    private static int dividirArreglo(int[] arreglo, int inicio, int fin) {
        int pivot = arreglo[fin];
        int i = (inicio - 1);

        for (int j = inicio; j < fin; j++) {
            if (arreglo[j] <= pivot) {
                cont++;
                i++;
                int aux = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = aux;
            }
        }

        int aux = arreglo[i + 1];
        arreglo[i + 1] = arreglo[fin];
        arreglo[fin] = aux;

        return i + 1;
    }
    
    

    public static void main(String[] args) {
        int[] arreglo = new int[randomWithRange(1, 100)];
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = randomWithRange(1, 100);
        }
        System.out.println("Arreglo original");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.print("\n");
        System.out.println("--------------------------------------");
        quickSort(arreglo, 0, arreglo.length - 1);
        System.out.println("Arreglo luego de haber aplicado QuickSort");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.print("\n");
        System.out.println("--------------------------------------");
        System.out.println(cont);
    }
}
