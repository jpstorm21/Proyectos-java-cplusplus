/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayudantia10;

import ucn.StdIn;

/**
 *
 * @author Usuario
 */
public class Ayudantia10 {

    public static void main(String[] args) {
        /*int [] vector2 = {1,4,2,1,4,6,7,5,3,1,3};
        int [] vector = {1,4,2,1,4,6,7,5,3,1,3};
        
        int total = sumaVector(vector);
        System.out.println(total);
        
        int fibo = calcularFibo(5);
        System.out.println(fibo);
        
        
        int fact = factorial(10);
        System.out.println(fact);
        
        boolean sonIguales = iguales(vector, vector2);
        System.out.println(sonIguales);*/
        System.out.print("ingrese algo: ");
        String d = StdIn.readLine();
        System.out.println(d);
        
    }
    
    
    // esto es totalmente opcional, lo hice para ahorrarme un parametro (el del tamaño) asi el usuario simplemente ingresa el vector
    // que quiere sumar
    public static int sumaVector(int [] vector) {

        return sumaVector(vector, vector.length);
    }
    
    private static int sumaVector(int vector [], int largoDelVector)
    {
	if (largoDelVector == 0)
	    return vector [largoDelVector];
	else
	    return sumaVector(vector, largoDelVector - 1) + vector [largoDelVector];
    }
    
    
    
    public static int calcularFibo(int n){
        if(n==1 || n==2){
            return 1;
        } else {
          return calcularFibo(n-1) + calcularFibo(n-2);
        }
     
    }  
    
    
    
    public static int factorial(int n) {
        if( n==0 ) {
            return 1;
        } else {
            return n*factorial(n-1);
        }
    }
    
    
    // ver si dos vectores son iguales
    public static boolean iguales(int [] v1 , int[] v2) {
        if(v1.length != v2.length) { // si el tamaño es diferente, obviamente son diferentes
            return false;
        } else {
            return iguales(v1,v2 , 0 ,v1.length);
        }
       
    }
    private static boolean iguales(int[] v1, int[] v2, int i, int length) {
     
        if( v1[i] == v2[i]) { // mientras los valores sean iguales que siga.. 
            if(i+1 == length) { // como i empieza en 0 hay que ver si es igual al largo por eso le sumo 1
                return true;
            } else {
                i++; // sumo posicion del vector para la recursion
                return iguales(v1,v2,i,length);
            }
        } else {
            return false;
        }
    }
    
}

