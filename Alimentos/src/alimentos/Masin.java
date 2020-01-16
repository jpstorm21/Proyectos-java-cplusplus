/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alimentos;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Masin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("ingrese cantidad mininas de calorias: ");
        int min = sc.nextInt();
        System.out.print("ingrese cantidad maxima de calorias: ");
        int max =sc.nextInt();
        int cantGrupos = 7;
        Alimento A1 = new Alimento("pollo",40,3);
        Alimento A2 = new Alimento("leche",12,4);
        Alimento A3 = new Alimento("naranja",15,7);
        Alimento A4 = new Alimento("cereales",28,6);
        Alimento A5 = new Alimento("lechuga",10,1);
        Alimento A6 = new Alimento("papas",30,2);
        Alimento A7 = new Alimento("porcion de aceite",35,5);
        Alimento [] listaAlimentos = new Alimento[100];
        listaAlimentos[0] = A1; 
        listaAlimentos[1] = A2; 
        listaAlimentos[2] = A3; 
        listaAlimentos[3] = A4; 
        listaAlimentos[4] = A5; 
        listaAlimentos[5] = A6; 
        listaAlimentos[6] = A7; 
        Backtraking_alimentos bA = new Backtraking_alimentos(cantGrupos,min,max,listaAlimentos,listaAlimentos.length);
        boolean sepudo = bA.intentar(0);
        if(sepudo){
            bA.desplegarSolucion();
        }else{
            System.out.println("no tiene solucion");
        }
    }
    
}
