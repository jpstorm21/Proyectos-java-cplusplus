package taller5_sgdo_part1;

import ucn.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Taller5_sgdo_PART1 {

    public static void menu(Out salida, Out salidaV) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 3) {
            System.out.println("\t [menu]");
            System.out.println("1-Errores: ");
            System.out.println("2-Textos validos: ");
            System.out.println("3-salir: ");
            System.out.println("---------------------------------");
            System.out.print(">");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    Out salida1 = salida;
                    System.out.println("archivo generado");
                    break;
                case 2:
                    Out salida2 = salidaV;
                    System.out.println("archivo generado");
                    break;
                default:
                    opcion = 3;
            }

        }
    }

    public static void leerTXT1(Out salida, Out salidaV) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("texto1.txt"));
        while (sc.hasNextLine()) {
            String leelinea = sc.nextLine();
            String[] linea = leelinea.split(" ");
            for (int i = 0; i < linea.length; i++) {
                String pos = linea[i];
                String letra1 = "";
                letra1 = letra1 + pos.charAt(0);
                if (Character.isLetter(pos.charAt(0)) || Character.isDigit(pos.charAt(0))) {//evaluo que comienze con una letra o numero
                    if (isNumero(letra1)) {
                        boolean sepudo = validarNumero(pos, salida, salidaV);
                        if (sepudo) {
                            salidaV.print(pos + " ");
                        }
                    } else {
                        boolean sepudo = validarLetra(pos, salida, salidaV);
                        if (sepudo) {
                            salidaV.print(pos + " ");
                        }
                    }
                } else {
                    salida.println("la palabra no valida: " + pos + "(la palabra contiene un caracter no valido en la pisicion " + 0 + ")");
                }
            }
        }
        salidaV.println();
        salidaV.println();
        salidaV.println();
        sc.close();
    }

    public static void leerTXT2(Out salida, Out salidaV) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("texto2.txt"));
        while (sc.hasNextLine()) {
            String leelinea = sc.nextLine();
            String[] linea = leelinea.split(" ");
            for (int i = 0; i < linea.length; i++) {
                String pos = linea[i];
                String letra1 = "";
                letra1 = letra1 + pos.charAt(0);
                if (Character.isLetter(pos.charAt(0)) || Character.isDigit(pos.charAt(0))) {//evaluo que comienze con una letra o numero
                    if (isNumero(letra1)) {
                        boolean sepudo = validarNumero(pos, salida, salidaV);
                        if (sepudo) {
                            salidaV.print(pos + " ");
                        }
                    } else {
                        boolean sepudo = validarLetra(pos, salida, salidaV);
                        if (sepudo) {
                            salidaV.print(pos + " ");
                        }
                    }
                } else {
                    salida.println("la palabra no valida: " + pos + "(la palabra contiene un caracter no valido en la pisicion " + 0 + ")");
                }
            }
        }
        salidaV.println();
        salidaV.println();
        salidaV.println();
        sc.close();
    }

    public static void leerTXT3(Out salida, Out salidaV) throws FileNotFoundException {
        In sc = new In("texto3.txt");
        while (!sc.isEmpty()) {
            String leelinea = sc.readLine();
            String[] linea = leelinea.split(" ");
            for (int i = 0; i < linea.length; i++) {
                String pos = linea[i];
                String letra1 = "";
                letra1 = letra1 + pos.charAt(0);
                if (Character.isLetter(pos.charAt(0)) || Character.isDigit(pos.charAt(0))) {//evaluo que comienze con una letra o numero
                    if (isNumero(letra1)) {
                        boolean sepudo = validarNumero(pos, salida, salidaV);
                        if (sepudo) {
                            salidaV.print(pos + " ");
                        }
                    } else {
                        boolean sepudo = validarLetra(pos, salida, salidaV);
                        if (sepudo) {
                            salidaV.print(pos + " ");
                        }
                    }
                } else {
                    salida.println("la palabra no valida: " + pos + "(la palabra contiene un caracter no valido en la pisicion " + 0 + ")");
                }
            }
        }
        salidaV.println();
        salidaV.println();
        salidaV.println();
        sc.close();
    }

    public static void leerTXT4(Out salida, Out salidaV) throws FileNotFoundException {
        In sc = new In("texto4.txt");
        while (!sc.isEmpty()) {
            String leelinea = sc.readLine();
            String[] linea = leelinea.split(" ");
            for (int i = 0; i < linea.length; i++) {
                String pos = linea[i];
                String letra1 = "";
                letra1 = letra1 + pos.charAt(0);
                if (Character.isLetter(pos.charAt(0)) || Character.isDigit(pos.charAt(0))) {//evaluo que comienze con una letra o numero
                    if (isNumero(letra1)) {
                        boolean sepudo = validarNumero(pos, salida, salidaV);
                        if (sepudo) {
                            salidaV.print(pos + " ");
                        }
                    } else {
                        boolean sepudo = validarLetra(pos, salida, salidaV);
                        if (sepudo) {
                            salidaV.print(pos + " ");
                        }
                    }
                } else {
                    salida.println("la palabra no valida: " + pos + "(la palabra contiene un caracter no valido en la pisicion " + 0 + ")");
                }
            }
        }
        salidaV.println();
        salidaV.println();
        salidaV.println();
        sc.close();
    }

    public static void leerTXT5(Out salida, Out salidaV) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("texto5.txt"));
        while (sc.hasNextLine()) {
            String leelinea = sc.nextLine();
            String[] linea = leelinea.split(" ");
            for (int i = 0; i < linea.length; i++) {
                String pos = linea[i];
                String letra1 = "";
                letra1 = letra1 + pos.charAt(0);
                if (Character.isLetter(pos.charAt(0)) || Character.isDigit(pos.charAt(0))) {//evaluo que comienze con una letra o numero
                    if (isNumero(letra1)) {
                        boolean sepudo = validarNumero(pos, salida, salidaV);
                        if (sepudo) {
                            salidaV.print(pos + " ");
                        }
                    } else {
                        boolean sepudo = validarLetra(pos, salida, salidaV);
                        if (sepudo) {
                            salidaV.print(pos + " ");
                        }
                    }
                } else {
                    salida.println("la palabra no valida: " + pos + "(la palabra contiene un caracter no valido en la pisicion " + 0 + ")");
                }
            }
        }
        salidaV.println();
        salidaV.println();
        salidaV.println();
        sc.close();
    }

    public static void leerTXT6(Out salida, Out salidaV) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("texto6.txt"));
        while (sc.hasNextLine()) {
            String leelinea = sc.nextLine();
            String[] linea = leelinea.split(" ");
            for (int i = 0; i < linea.length; i++) {
                String pos = linea[i];
                String letra1 = "";
                letra1 = letra1 + pos.charAt(0);
                if (Character.isLetter(pos.charAt(0)) || Character.isDigit(pos.charAt(0))) {//evaluo que comienze con una letra o numero
                    if (isNumero(letra1)) {
                        boolean sepudo = validarNumero(pos, salida, salidaV);
                        if (sepudo) {
                            salidaV.print(pos + " ");
                        }
                    } else {
                        boolean sepudo = validarLetra(pos, salida, salidaV);
                        if (sepudo) {
                            salidaV.print(pos + " ");
                        }
                    }
                } else {
                    salida.println("la palabra no valida: " + pos + "(la palabra contiene un caracter no valido en la pisicion " + 0 + ")");
                }
            }
        }
        salidaV.println();
        salidaV.println();
        salidaV.println();
        sc.close();
    }

    public static boolean validarNumero(String cadena, Out salida, Out salidaV) {
        char[] palabra = cadena.toCharArray();
        int pos = 0;
        int posError = 0;
        return validarNumeroRecursivo(palabra, pos, posError, salida, cadena, salidaV);
    }

    private static boolean validarNumeroRecursivo(char[] palabra, int pos, int posError, Out salida, String cadena, Out salidaV) {
        if (pos < palabra.length) {
            String cad = "";
            cad = cad + palabra[pos];
            boolean esNumero = isNumero(cad);
            if (esNumero) {
                pos++;
                return validarNumeroRecursivo(palabra, pos, posError, salida, cadena, salidaV);
            } else {
                if (cad.equals(",")) {
                    pos++;
                    return validarNumeroRecursivo(palabra, pos, posError, salida, cadena, salidaV);
                }
                posError = pos;
                salida.println("la palabra no valida: " + cadena + "(la palabra contiene un caracter no valido en la pisicion " + posError + ")");
                return false;
            }
        } else {
            return true;
        }
    }

    public static boolean validarLetra(String cadena, Out salida, Out salidaV) {
        char[] palabra = cadena.toCharArray();
        int pos = 0;
        int posError = 0;
        return validarLetraRecursivo(palabra, pos, posError, salida, cadena, salidaV);
    }

    private static boolean validarLetraRecursivo(char[] palabra, int pos, int posError, Out salida, String cadena, Out salidaV) {
        if (pos < palabra.length) {
            String cad = "";
            cad = cad + palabra[pos];
            boolean esNumero = isNumero(cad);
            if (esNumero == false) {
                if (cad.equals(",")) {
                    pos++;
                    return validarLetraRecursivo(palabra, pos, posError, salida, cadena, salidaV);
                }
                if (Character.isLetter(cad.charAt(0)) == false) {
                    posError = pos;
                    salida.println("la palabra no valida: " + cadena + "(la palabra contiene un caracter no valido en la pisicion " + posError + ")");
                    return false;
                } else {
                    pos++;
                    return validarLetraRecursivo(palabra, pos, posError, salida, cadena, salidaV);
                }
            } else {
                posError = pos;
                salida.println("la palabra no valida: " + cadena + "(la palabra contiene un caracter no valido en la pisicion " + posError + ")");
                return false;
            }
        } else {
            return true;
        }
    }

    public static boolean isNumero(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        Out salida = new Out("Errores.txt");
        Out salidaV = new Out("TextoValido.txt");
        System.out.print("cuanto txt desea evaluar (1 a 6): ");
        int cantidad = sc.nextInt();
        while (cantidad < 1 || cantidad > 6) {
            System.out.println("ingrese una cantidad valida");
            System.out.print("cuanto txt desea evaluar (1 a 6): ");
            cantidad = sc.nextInt();
        }
        switch (cantidad) {
            case 1:
                leerTXT1(salida, salidaV);
                break;
            case 2:
                leerTXT1(salida, salidaV);
                leerTXT2(salida, salidaV);
                break;
            case 3:
                leerTXT1(salida, salidaV);
                leerTXT2(salida, salidaV);
                leerTXT3(salida, salidaV);
                break;
            case 4:
                leerTXT1(salida, salidaV);
                leerTXT2(salida, salidaV);
                leerTXT3(salida, salidaV);
                leerTXT4(salida, salidaV);
                break;
            case 5:
                leerTXT1(salida, salidaV);
                leerTXT2(salida, salidaV);
                leerTXT3(salida, salidaV);
                leerTXT4(salida, salidaV);
                leerTXT5(salida, salidaV);
                break;
            case 6:
                leerTXT1(salida, salidaV);
                leerTXT2(salida, salidaV);
                leerTXT3(salida, salidaV);
                leerTXT4(salida, salidaV);
                leerTXT5(salida, salidaV);
                leerTXT6(salida, salidaV);
                break;
        }
        menu(salida, salidaV);
    }
}
