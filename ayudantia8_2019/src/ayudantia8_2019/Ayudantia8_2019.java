/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayudantia8_2019;

import ucn.*;

/**
 *
 * @author Juan Pablo Martinez
 */
public class Ayudantia8_2019 {

    public static void leerDatos(ListaJuegos lj) {
        System.out.print("ingrese cantidad de juegos: ");
        int cant = StdIn.readInt();

        for (int i = 0; i < cant; i++) {
            System.out.print("ingrese nombre: ");
            String nombre = StdIn.readString();
            System.out.print("ingrese consola a la cual pertence el juego: ");
            String consola = StdIn.readString();
            System.out.print("ingrese tipo de juego: ");
            String tipo = StdIn.readString();
            System.out.print("ingrese [1] si es digital o [2] si es fisico: ");
            int opcion = StdIn.readInt();
            while (opcion != 1 && opcion != 2) {
                System.out.println("ingrese un tipo valido");
                System.out.print("ingrese [1] si es digital o [2] si es fisico: ");
                opcion = StdIn.readInt();
            }
            if (opcion == 1) {
                System.out.print("ingrese peso: ");
                int peso = StdIn.readInt();
                Juego j = new Digital(peso, nombre, consola, tipo);
                if (!lj.ingresarJuego(j)) {
                    System.out.println("no se pudo ingresar el juego");
                }
            } else {
                System.out.print("ingrese estado [1] si esta bueno o [2] si esta malo: ");
                int x = StdIn.readInt();
                while (x != 1 && x != 2) {
                    System.out.println("ingrese un estado valido");
                    System.out.print("ingrese estado [1] si esta bueno o [2] si esta malo: ");
                    x = StdIn.readInt();
                }
                boolean estado = false;
                if (x == 1) {
                    estado = true;
                }
                Juego j = new Fisico(estado, nombre, consola, tipo);
                if (!lj.ingresarJuego(j)) {
                    System.out.println("no se pudo ingresar el juego");
                }
            }
        }
    }

    public static void desplegarJuegos(ListaJuegos lj) {
        System.out.println("-------------------------------------");
        for (int i = 0; i < lj.getCant(); i++) {
            Juego j = lj.getJuego(i);
            System.out.println("nombre: " + j.getNombre());
            System.out.println("consola: " + j.getConsola());
            System.out.println("tipo: " + j.getTipo());
            if (j instanceof Digital) {
                System.out.println("peso: " + ((Digital) j).getPeso());
            }else{
                System.out.println("estado: " + ((Fisico) j).isEstado());
            }
            System.out.println("-------------------------------------");
        }
    }
    
    public static void rf3(ListaJuegos lj){
        int cantDigitales = 0;
        int cantFisicos = 0;
        int mayor = 0;
        Juego mayorJ = null;
        for (int i = 0; i < lj.getCant(); i++) {
            Juego j = lj.getJuego(i);
            if (j instanceof Digital) {
                cantDigitales++;
                if(((Digital) j).getPeso() > mayor){
                    mayor = ((Digital) j).getPeso();
                    mayorJ = j;
                }
            }else{
                cantFisicos++;
            }
        }
        
        if(cantDigitales >cantFisicos){
            System.out.println("hay mas juegos digitales que fisico");
        }else{
            System.out.println("hay mas juegos fisicos que digitales");
        }
        System.out.println("el juego con el mayor peso es: " + mayorJ.getNombre());
    }

    public static void main(String[] args) {
        ListaJuegos lj = new ListaJuegos(100);
        leerDatos(lj);
        System.out.println("-------------------------------------");
        desplegarJuegos(lj);
        System.out.println("-------------------------------------");
        rf3(lj);
        System.out.println("-------------------------------------");
    }

}
