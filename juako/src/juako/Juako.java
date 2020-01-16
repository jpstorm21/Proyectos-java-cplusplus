/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juako;

import java.util.Scanner;
import ucn.StdIn;
import ucn.StdOut;

/**
 *
 * @author Usuario
 */
public class Juako {
    private static int n = 0;
    private static int [] llena_vector(int [] vector ,int valor){
        int [] saliente = new int[vector.length+1];
        for(int i = 0; i<vector.length;i++){
            saliente[i] = vector[i];
        }
        saliente[saliente.length-1] = valor;
        return saliente;
    }

    public static void main(String args[]) {
        double [] v = new double[10];
        System.out.println("ssda: ");
        String n = StdIn.readString();
    }
}
