package decimal_a_binario.dpc;

import java.util.Scanner;

/**
 *
 * @author Juan Pablo Martinez
 */
public class Decimal_A_binarioDPC {

    public static int binarioADecimal(char[] arreglo) {
        char[] binario = new char[arreglo.length];
        int pos = 0;
        for (int i = arreglo.length-1; i >=0; i--) {
            binario[pos] = arreglo[i];
            pos++;
        }
        return binarioADecimalRec(binario, 0, pos-1, 2);
    }

    private static int binarioADecimalRec(char[] bin, int posInicial, int posFinal, int base) {
        int resultado = 0;
        if (posInicial == posFinal) {
            resultado =+ Integer.parseInt(Character.toString(bin[posInicial])) * (int) Math.pow(base, posInicial);
            return resultado;
        }   
        int mitad = (posInicial + posFinal) / 2;
        int mitadIzquierda = binarioADecimalRec(bin, posInicial, mitad, base);
        int mitadDerecha = binarioADecimalRec(bin, mitad + 1, posFinal, base);
        resultado = mitadIzquierda + mitadDerecha;
        return resultado;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("ingrese numero binario a transformas: ");
        String numero = sc.next();
        char[] arreglo = numero.toCharArray();
        int resultado = binarioADecimal(arreglo);
        System.out.println("Numero resultado es: " + resultado);
    }
}
