/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanoi;
import ucn.*;
/**
 *
 * @author Usuario
 */
public class Hanoi {

    public static void main(String[] args) {
        StdOut.println("Ingrese el nro de discos :");
        int n = StdIn.readInt();
        Hanoi(n, "A", "B", "C"); //1:origen 2:auxiliar 3:destino
    }

    public static void Hanoi(int n, String origen, String auxiliar, String destino) {
        if (n == 1) {
            StdOut.println("mover disco de " + origen + " a " + destino);
        } else {
            Hanoi(n - 1, origen, destino, auxiliar);
            StdOut.println("mover disco de " + origen + " a " + destino);
            Hanoi(n - 1, auxiliar, origen, destino);
        }
    }
}
