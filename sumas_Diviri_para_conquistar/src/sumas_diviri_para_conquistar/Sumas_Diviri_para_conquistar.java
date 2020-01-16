/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sumas_diviri_para_conquistar;

/**
 *
 * @author Usuario
 */
public class Sumas_Diviri_para_conquistar {

    public static int sumas(int [] arreglo,int posInicial,int posFinal){
        int suma;
        if(posInicial == posFinal){
            suma = arreglo[posInicial];
            return suma;
        }
        if(posInicial == posFinal-1){
            suma = arreglo[posInicial] + arreglo[posFinal];
            return suma;
        }
        int mitad = (posInicial+posFinal)/2;
        int suma1 = sumas(arreglo, posInicial, mitad);
        int suma2 = sumas(arreglo, mitad+1, posFinal);
        suma = suma1 +suma2;
        return suma;
        
        
    }
    public static void main(String[] args) {
        int [] arreglo = {3,5};
        int suma = sumas(arreglo, 0, arreglo.length-1);
        System.out.println("la suma es: " + suma);
    }
    
}
