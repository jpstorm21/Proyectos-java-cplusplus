package ejercicio_dividirparaconquistar_1;

/**
 *
 * @author Cristóbal
 */
public class Ejercicio_DividirParaConquistar_1 {
    //Ejercicio - Buscar mayor y menor de un arreglo.

    public static int[] buscar_Mayor_Menor(int[] arreglo, int mayor, int menor, int posInicial, int posFinal) {
        if (posInicial == posFinal) {//1 sola posición.
            mayor = arreglo[posInicial];
            menor = arreglo[posInicial];
            int[] v = new int[2];
            v[0] = mayor;
            v[1] = menor;
            return v;
        }
        if (posInicial == posFinal - 1) {//2 posiciones. En la posición 0 van los mayores, y en la 1 los menores.
            int[] v2 = new int[2];
            if (arreglo[posInicial] > mayor) {
                mayor = arreglo[posInicial];
                menor = arreglo[posFinal];
                v2[0] = mayor;
                v2[1] = menor;
            } else {
                mayor = arreglo[posFinal];
                menor = arreglo[posInicial];
                v2[0] = mayor;
                v2[1] = menor;
            }
            return v2;
        }
        int mitad = (posInicial + posFinal) / 2;
        int[] mitadIzq = buscar_Mayor_Menor(arreglo, mayor, menor, posInicial, mitad);
        int[] mitadDer = buscar_Mayor_Menor(arreglo, mayor, menor, mitad + 1, posFinal);
        int mayor1 = mitadIzq[0];
        int menor1 = mitadIzq[1];
        int mayor2 = mitadDer[0];
        int menor2 = mitadDer[1];
        int[] vectorResultado = new int[2];
        if (mayor1 > mayor2) {
            vectorResultado[0] = mayor1;
        } else {
            vectorResultado[0] = mayor2;
        }

        if (menor1 < menor2) {
            vectorResultado[1] = menor1;
        } else {
            vectorResultado[1] = menor2;
        }
        return vectorResultado;
    }

    public static void main(String[] args) {
        int[] arreglo = {1000,2,7,6,1,9};
        int mayor = -999;
        int menor = 999;
        int[] vectorMayores = buscar_Mayor_Menor(arreglo, mayor, menor, 0, arreglo.length -1);
        System.out.println("El mayor es: " + vectorMayores[0] + " \nEl menor es: " + vectorMayores[1]);
    }

}
