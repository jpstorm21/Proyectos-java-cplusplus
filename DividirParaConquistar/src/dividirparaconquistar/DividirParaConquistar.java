package dividirparaconquistar;

public class DividirParaConquistar {

    public static int[] mayor(int cant, int[] vector) {
        return recmayor(0, cant, vector);
    }

    private static int[] recmayor(int inicio, int fin, int[] vector) {
        if (inicio == fin) {//un solo elemento
            int[] sol = new int[2];
            sol[0] = vector[inicio];
            sol[1] = vector[inicio];
            return sol;
        } else {
            if (inicio == fin - 1) {//dos elementos
                int[] sol = new int[2];
                if (vector[inicio] > vector[fin]) {
                    sol[0] = vector[inicio];
                    sol[1] = vector[fin];
                    return sol;
                } else {
                    sol[0] = vector[fin];
                    sol[1] = vector[inicio];
                    return sol;
                }
            } else {
                int mitad = (inicio + fin) / 2;
                int [] mayor1 = recmayor(inicio, mitad, vector);
                int [] mayor2 = recmayor(mitad + 1, fin, vector);
                int[] sol = new int[2];
                if (mayor1[0] > mayor2[0]) {
                    sol[0]= mayor1[0];
                } else {
                    sol[0]= mayor2[0];
                }              
                if(mayor1[1] < mayor2[1]){
                    sol[1]= mayor1[1];
                }else{
                    sol[1]= mayor2[1];
                }
                return sol;
            }
        }
    }

    public static void main(String[] args) {
        int[] vector = {1, 1000, 6, 3, 0, 100, 200000};
        int [] resultado = mayor(vector.length - 1, vector);
        System.out.println("el numero mayor es: " + resultado[0]);
        System.out.println("el numero menor es: " + resultado[1]);

    }

}
