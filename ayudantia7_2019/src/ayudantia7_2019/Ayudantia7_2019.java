/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayudantia7_2019;
import java.util.Scanner;
/**
 *
 * @author Juan Pablo Martinez
 */
public class Ayudantia7_2019 {

    public static void leerDatos(ListaMascostas lm, Scanner sc){
        System.out.print("ingrese cantidad de mascotas: ");
        int cant = sc.nextInt();
        for(int i = 0;i<cant;i++){
            System.out.print("ingrese nombre: ");
            String nombre = sc.next();
            System.out.print("ingrese peso: ");
            int peso = sc.nextInt();
            System.out.print("ingrese [1] si es gato o [2] si es perro: ");
            int tipo = sc.nextInt();
            Mascota m = null;
            if(tipo == 1){
                System.out.print("ingrese años que lleva con pedrito: ");
                int year = sc.nextInt();
                m = new Gato(year,nombre,peso);
            }else if(tipo == 2){
                System.out.print("ingrese edad de su perro: ");
                int edad = sc.nextInt();
                m = new Perro(edad,nombre,peso);
            }else{
                System.out.println("tipo de animal invalido");
            }
            lm.ingresarMascota(m);
        }
    }
    
    public static void desplegarMascostas(ListaMascostas lm){
        for(int i = 0; i<lm.getCant();i++){
            Mascota m =lm.getLm(i);
            System.out.println("nombre: " + m.getNombre());
            System.out.println("peso: " + m.getPeso());
            if(m instanceof Gato){
                System.out.println("mascota es gato");
            }else{
                System.out.println("mascosta es perro");
            }
        }
    }
    
    public static void desplegarAlimentos(ListaMascostas lm){
        for(int i = 0; i<lm.getCant();i++){
            Mascota m =lm.getLm(i);
            System.out.println("nombre: " + m.getNombre());
            System.out.println("cantidad de alimento: " + m.calcularAlimento());
        }
    }
    
    public static void main(String[] args) {
        ListaMascostas lm = new ListaMascostas(100);
        Scanner sc = new Scanner(System.in);
        leerDatos(lm, sc);
        System.out.println("-----------------------------------------");
        desplegarMascostas(lm);
        System.out.println("-----------------------------------------");
        desplegarAlimentos(lm);
    }
    
}
