package modelamiento;

import java.io.IOException;
import java.util.Scanner;
import ucn.*;

/**
 *
 * @author Juan Pablo Martinez
 */
public class Modelamiento {

    public static void calcularQ(Scanner sc) {
        System.out.print("ingrese demanda anual(a): ");
        int a = sc.nextInt();
        System.out.print("ingrese costo a emitir orden de compra(k): ");
        int k = sc.nextInt();
        System.out.print("que desea ingresa h[1] o (tasa de interes(i) y costo unitario(c))[2]: ");
        int opcion = sc.nextInt();
        while (opcion != 1 && opcion != 2) {
            System.out.println("ingrese opcion valida");
            System.out.print("que desea ingresa h[1] o (tasa de interes(i) y costo unitario(c))[2]: ");
            opcion = sc.nextInt();
        }
        double Q;
        if (opcion == 1) {
            System.out.print("ingrese costo de mantener inventario(h): ");
            double h = sc.nextDouble();
            Q = Math.sqrt((2 * a * k) / h);
        } else {
            double i;
            double c;
            System.out.print("ingrese tasa de interes(i): ");
            i = sc.nextDouble();
            System.out.print("ingrese costo unitario(c): ");
            c = sc.nextDouble();
            Q = Math.sqrt((2 * a * k) / (c * i));
        }
        System.out.println("--------------------------------------");
        System.out.println(" el valor de Q* es: " + Q);
        System.out.println("--------------------------------------");
    }

    public static void calularCT(Scanner sc) {
        System.out.print("ingrese demanda anual(a): ");
        int a = sc.nextInt();
        System.out.print("ingrese costo a emitir orden de compra(k): ");
        int k = sc.nextInt();
        System.out.print("ingrese costo unitario(c): ");
        double c = sc.nextDouble();
        System.out.print("ingrese costo de mantener inventario(h): ");
        double h = sc.nextDouble();
        System.out.print("ingrese (q): ");
        double q = sc.nextDouble();
        double ct = a * c + ((h * q) / 2) + ((a * k) / q);
        System.out.println("--------------------------------------");
        System.out.println("el valor de CT es: " + ct);
        System.out.println("--------------------------------------");
    }

    public static void menu(Scanner sc) throws IOException {
        try {
            int opcion = 0;
            while (opcion != 5) {
                System.out.println("1.- calcular Q*: ");
                System.out.println("2.- calcular CT: ");
                System.out.println("3.- calcular R: ");
                System.out.println("4.- calcular T: ");
                System.out.println("5.- Cerrar programa");
                System.out.print("ingrese opcion : ");
                opcion = sc.nextInt();
                while (opcion < 1 || opcion > 5) {
                    System.out.println("opcion no valida intente nuevamente");
                    System.out.print("ingrese opcion : ");
                    opcion = sc.nextInt();
                }
                switch (opcion) {
                    case 1:
                        System.out.println("---------------------------------------");
                        calcularQ(sc);
                        System.out.println("---------------------------------------");
                        break;
                    case 2:
                        System.out.println("---------------------------------------");
                        calularCT(sc);
                        System.out.println("---------------------------------------");
                        break;
                     case 3:
                        System.out.println("---------------------------------------");
                        calcularModeloQ();
                        System.out.println("---------------------------------------");
                        break;
                     case 4:
                        System.out.println("---------------------------------------");
                        calcularModeloP();
                        System.out.println("---------------------------------------");
                        break;
                    default:
                        opcion = 5;
                        System.out.println("---------------------------------------");
                        System.out.println("Adios");
                }
            }
        } catch (Exception e) {
            System.out.println("tipo de dato no valido");
        }
    }

    public static void calcularModeloQ() {
        System.out.print("Ingrese demanda diaria promedio(d): ");
        int d = StdIn.readInt();

        System.out.print("Ingrese lead time(L): ");
        int L = StdIn.readInt();

        int parte1 = d * L;

        System.out.print("Ingrese distribución  normal(Z): ");
        double Z = StdIn.readDouble();

        System.out.print("Ingrese desviación estándar de d: ");
        int desv = StdIn.readInt();

        double raiz = Math.sqrt(L);
        double parte2 = Z * desv * raiz;

        double R = parte1 + parte2;
        System.out.println("R = " + R);

    }
    /* Stock prom valor = Valor Unitario * Stock Promedio
        Venta valoriz = Ventas * Valor Unitario
        Peso específico = Venta valoriz/ sumaTotal Venta valoriz
        Peso específico Acum = suma de Peso específico
        Rotación = Ventas/Stock Promedio
        Duración = 365/rotación.
    
        Rotación General = Total Venta Valoriz/ Total Stock prom valor
        Duración General = 365/Rotación General
   */

    public static void calcularModeloP() {

        System.out.print("Ingrese demanda diaria promedio(d): ");
        int d = StdIn.readInt();

        System.out.print("Ingrese lead time(L): ");
        int L = StdIn.readInt();

        System.out.print("Ingrese período de compra(p): ");
        int p = StdIn.readInt();

        int parte1 = d * (L + p);

        System.out.print("Ingrese distribución  normal(Z): ");
        double Z = StdIn.readDouble();

        System.out.print("Ingrese desviación estándar de d: ");
        int desv = StdIn.readInt();

        int suma = L + p;
        double raiz = Math.sqrt(suma);

        double parte2 = Z * desv * raiz;

        double T = parte1 + parte2;

        System.out.println("T = " + T);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        menu(sc);
    }

}
