package binario;

import java.util.Scanner;

public class Binario {

    public static void binario(Scanner sc, String transformacion, int numero) {
        String binario = "";
        if (numero > 0) {
            while (numero > 0) {
                if (numero % 2 == 0) {
                    binario = "0" + binario;
                } else {
                    binario = "1" + binario;
                }
                numero = (int) numero / 2;
            }
        } else if (numero == 0) {
            binario = "0";
        } else {
            binario = "No se pudo convertir el numero. Ingrese solo números positivos";
        }
        System.out.println("El número en binario es: " + binario);

    }

    public static void decimal(Scanner sc, String transformacion, int numero) {
        int decimal = 0;
        int e = 1;
        if (numero == 0) {
            decimal = 0;
        } else {
            while (numero > 0) {
                int y = numero % 10;
                numero = numero / 10;
                decimal = decimal + (y * e);
                e = e * 2;
            }
        }
        System.out.println("el numero en decimal es : " + decimal);
    }

    public static void octal(Scanner sc, String transformacion, int numero) {
        int[] octal = new int[1000];
        int cant = 0;
        if (numero < 8) {
            octal[cant] = numero;
            cant++;
        } else {
            octal(sc, transformacion, numero / 8);
            octal[cant] = numero % 8;
            cant++;
        }
        for (int i = 0; i < cant; i++) {
            System.out.print(octal[i] + "");
        }
    }

    public static void hexadecimal(Scanner sc, String transformacion, int numero) {
        if (numero< 10) {
            System.out.print(numero);
        } else {
            if (numero / 16 > 0) {
                hexadecimal(sc,transformacion,numero / 16);
            }
            if (numero% 16 == 10) {
                System.out.print("A");
            } else if (numero % 16 == 11) {
                System.out.print("B");
            } else if (numero % 16 == 12) {
                System.out.print("C");
            } else if (numero % 16 == 13) {
                System.out.print("D");
            } else if (numero% 16 == 14) {
                System.out.print("E");
            } else if (numero% 16 == 15) {
                System.out.print("F");
            } else {
                System.out.print(numero % 16);
            }
        }
    }


public static void octaldecimal(Scanner sc, String transformacion, int numero) {
        int decimal = 0;
        int e = 1;
        if (numero == 0) {
            decimal = 0;
        } else {
            while (numero > 0) {
                int y = numero % 10;
                decimal = decimal + (y * e);
                numero = numero / 10;
                e = e * 8;
            }
        }
        System.out.println("el numero en decimal es : " + decimal);
    }
    public static void hexaAdecimal(Scanner sc, String transformacion, int numero){
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);     
        ventana v = new ventana();
        v.setVisible(true);
        /*System.out.print("ingrese numero a transformar : ");
        int num = sc.nextInt();
        System.out.print("a que desea tranformar Binario-decimal-octal-hexadecimal : ");
        String transformacion = sc.next();
        if (transformacion.equals("binario")) {
            Binario.binario(sc, transformacion, num);
        } else if (transformacion.equals("octal")) {
            System.out.print("El numero en octal es: ");
            Binario.octal(sc, transformacion, num);
        } else if (transformacion.equals("hexadecimal")) {
            Binario.hexadecimal(sc, transformacion, num);
        } else if (transformacion.equals("decimal")) {
            System.out.print("tipo de numero el cual ingreso binario-octal-hexadecimal que desea pasar a deciamal : ");
            String tipo = sc.next();
            if (tipo.equals("binario")) {
                Binario.decimal(sc, transformacion, num);
            } else if (tipo.equals("octal")) {
                Binario.octaldecimal(sc, transformacion, num);
            } else {
               Binario.hexaAdecimal(sc, transformacion, num);
            }
        }*/
    }
}
