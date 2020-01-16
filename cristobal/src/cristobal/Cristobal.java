package cristobal;

import ucn.*;

public class Cristobal {

    public static int leerTxT(String[][] matriz) {
        int pos = 0;
        In entrada = new In("proyectos.txt");
        while (!entrada.isEmpty()) {
            String leelinea = entrada.readLine();
            String[] linea = leelinea.split(",");
            matriz[pos][0] = linea[0];
            matriz[pos][1] = linea[1];
            matriz[pos][2] = linea[2];
            pos++;
        }
        entrada.close();
        return pos;
    }

    public static void imprimirMatriz(String[][] matriz) {

        for (int i = 0; i < 5; i++) {
            System.out.println("-------------");
            for (int j = 0; j < 3; j++) {
                System.out.println(matriz[i][j]);
            }
        }

    }

    public static void pregunta1(String nombre, String[][] matriz) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (matriz[i][1].equals(nombre)) {
                    StdOut.println("porcentaje del projecto " + matriz[i][0] + " : " + matriz[i][2]);
                    break;
                }
            }
        }
    }

    public static void pregunta2(String nombre, String[][] matriz) {
        int mayor = -1;
        String trabajador = "";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (Integer.parseInt(matriz[i][2]) > mayor) {
                    mayor = Integer.parseInt(matriz[i][2]);
                    trabajador = matriz[i][1];
                }
            }
        }
        StdOut.println("el trabajador mas ocupado es : " + trabajador);

    }

    public static void pregunta3(String[][] matriz) {
        int cant = 0;
        String[] proyectos = new String[5];
        String[] resultado = new String[5];
        for (int i = 0; i < 5; i++) {
            proyectos[i] = matriz[i][0];
        }
        for (int i = 0; i < 5; i++) {
            String aux = proyectos[i];
            boolean si = Cristobal.buscar(resultado, aux);
            if (si == true) {
            } else {
                resultado[i] = aux;
                cant++;
            }
        }
        StdOut.println("la cantidad de proyectos es : " + cant);
    }

    public static boolean buscar(String[] vector, String dato) {
        boolean encontrado = false;
        for (int i = 0; i < vector.length; i++) {
            if (dato.equals(vector[i])) {
                encontrado = true;
                break;
            }
        }
        if (encontrado == true) {
            return true;
        } else {
            return false;
        }
    }
    public static void pregunta4(String[][] matriz) {
        int cant = 0;
        String[] trabajadores = new String[5];
        String[] resultado = new String[5];
        for (int i = 0; i < 5; i++) {
            trabajadores[i] = matriz[i][1];
        }
        for (int i = 0; i < 5; i++) {
            String aux = trabajadores[i];
            boolean si = Cristobal.buscar(resultado, aux);
            if (si == true) {
            } else {
                resultado[i] = aux;
                cant++;
            }
        }
        StdOut.println("la cantidad de trabajadores es : " + cant);
    }
    

    public static void main(String[] args) {
        String[][] matriz = new String[5][3];
        int pos = Cristobal.leerTxT(matriz);
        Cristobal.imprimirMatriz(matriz);
        StdOut.print("ingrese nombre a buscar : ");
        String nombre = StdIn.readString();
        Cristobal.pregunta1(nombre, matriz);
        Cristobal.pregunta2(nombre, matriz);
        Cristobal.pregunta3(matriz);
        Cristobal.pregunta4(matriz);

    }

}
