/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilaprueba;

import java.util.Scanner;

public class PilaPrueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pila pila = new Pila();
        Scanner sc = new Scanner(System.in);
        int seleccion = 0;
        while (seleccion != 10) {

            System.out.println();
            System.out.println("MENU");
            System.out.println("1. insertar en pila A");
            System.out.println("2. insertar en pila B");
            System.out.println("3. insertar en pila C");
            System.out.println("4. insertar en pila D");
            System.out.println("5. imprimir pila A");
            System.out.println("6. imprimir pila B");
            System.out.println("7. imprimir pila C");
            System.out.println("8. imprimir pila D");
            System.out.println("9. imprimir pila ");
            System.out.println("10. salir");
            System.out.print(">");
            seleccion = sc.nextInt();

            switch (seleccion) {

                case 1:
                    System.out.print(" ingrese dato para insertar en pila A: ");
                    int dato;
                    dato = sc.nextInt();
                    pila.insertarA(dato);
                    System.out.println();
                    break;

                case 2:
                    System.out.print(" ingrese dato para insertar en pila B: ");
                    int dato1;
                    dato1 = sc.nextInt();
                    pila.insertarB(dato1);
                    System.out.println();
                    break;
                case 3:
                    System.out.print(" ingrese dato para insertar en pila C: ");
                    int dato2;
                    dato2 = sc.nextInt();
                    pila.insertarC(dato2);
                    System.out.println();
                    break;
                case 4:
                    System.out.print(" ingrese dato para insertar en pila D: ");
                    int dato3;
                    dato3 = sc.nextInt();
                    pila.insertarD(dato3);
                    System.out.println();
                    break;
                case 5:
                    pila.imprimeA();
                    break;

                case 6:
                    pila.imprimeB();
                    break;

                case 7:
                    pila.imprimeC();
                    break;

                case 8:
                    pila.imprimeD();
                    break;

                case 9:
                    pila.imprimePila();
                    break;

                case 10:
                    System.out.print(" FIN ");

                    break;

            }
        }

    }

}
