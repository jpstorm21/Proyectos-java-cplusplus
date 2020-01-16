
public class App {

    public static String decimalAoctal(int numero) {
        if (numero / 8 != 0) {
            return decimalAoctal(numero / 8) + Integer.toString(numero % 8);
        }
        return Integer.toString(numero % 8);
    }

    public static int octalAdecimal(String numero) {
        int sum = 0;
        int j = 0;
        for (int i = numero.length() - 1; i > -1; i--) {
            sum = sum + Integer.parseInt(String.valueOf(numero.charAt(j))) * ((int) Math.pow(8, i));
            j++;
        }
        return sum;
    }

    public static int binarioAdecimal(String binario) {
        int sum = 0;
        int j = 0;
        for (int i = binario.length() - 1; i > -1; i--) {
            sum = sum + Integer.parseInt(String.valueOf(binario.charAt(j))) * ((int) Math.pow(2, i));
            j++;
        }
        return sum;
    }

    public static String decimalAbinario(int numero) {
        if (numero / 2 >= 1) {
            if (numero % 2 == 0) {
                return decimalAbinario(numero / 2) + "0";
            } else {
                return decimalAbinario(numero / 2) + "1";
            }
        } else if (numero % 2 == 1) {
            return "1";
        } else {
            return "0";
        }
    }

    private static String decimalAhexadecimal(int numero) {
        String[] digito = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        int valor = numero / 16;
        int resto = numero % 16;

        if (numero < 16) {
            return digito[resto];

        } else {
            return decimalAhexadecimal(valor) + digito[resto];
        }
    }

    private static int hexadecimalAdecimal(String numero) {
        int suma = 0;
        int j = 0;

        for (int i = numero.length() - 1; i > -1; i--) {
            if (numero.charAt(j) == 'A' || numero.charAt(j) == 'a') {
                suma = suma + 10 * (int) Math.pow(16, i);
            } else if (numero.charAt(j) == 'B' || numero.charAt(j) == 'b') {
                suma = suma + 11 * (int) Math.pow(16, i);
            } else if (numero.charAt(j) == 'C' || numero.charAt(j) == 'c') {
                suma = suma + 12 * (int) Math.pow(16, i);
            } else if (numero.charAt(j) == 'D' || numero.charAt(j) == 'd') {
                suma = suma + 13 * (int) Math.pow(16, i);
            } else if (numero.charAt(j) == 'E' || numero.charAt(j) == 'e') {
                suma = suma + 14 * (int) Math.pow(16, i);
            } else if (numero.charAt(j) == 'F' || numero.charAt(j) == 'f') {
                suma = suma + 15 * (int) Math.pow(16, i);
            } else {
                suma = suma + Integer.parseInt(String.valueOf(numero.charAt(j))) * (int) Math.pow(16, i);
            }
            j++;
        }
        return suma;
    }

    public static void main(String[] args) {
        Interfaz.main(args);
    }
}
