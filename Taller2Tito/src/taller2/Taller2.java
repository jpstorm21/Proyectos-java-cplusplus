/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2;

import java.io.IOException;
import ucn.*;

/**
 *
 * @author Victor Huerta
 */
public class Taller2 {
    
    public static void menu() {
        int opcionmenu = 0;
        while (opcionmenu != 5) {
            StdOut.println("A continuacion se le mostrara las opciones que quiera realizar:");
            StdOut.println("//////////////////////////////////////////////////////////////");
            StdOut.println("1.- RF1");
            StdOut.println("2.- RF2");
            StdOut.println("3.- RF3");
            StdOut.println("4.- RF4");
            StdOut.println("5.- Salir");
            StdOut.println("///////////////");
            StdOut.println("Ingrese opcion: ");
            opcionmenu = StdIn.readInt();
            
            if (opcionmenu == 1) {
                Taller2.RF1();
            }
            if (opcionmenu == 2) {
                Taller2.RF2();

            }
            if (opcionmenu == 3) {
                Taller2.RF3();
            }
            if (opcionmenu == 4) {
                Taller2.RF4();

            }
            if (opcionmenu == 5) {
                StdOut.println("///////////////");
                StdOut.println("Se ha finalizado el programa");

            }

        }
    }
    public static void leerCensistas(ListaCensistas lce,ListaComunas lc){
        In censistas = new In("censistas.txt");
        while(!censistas.isEmpty()){
            String leelinea = censistas.readLine();
            String[] linea = leelinea.split(",");
            int codigo = Integer.parseInt(linea[0]);
            String nombre= linea[2];
            int codComuna = Integer.parseInt(linea[3]);
            Censista Ce =new Censista(codigo,nombre);
            Comuna C = lc.buscarComuna(codComuna);
            Ce.setRefComuna(C);
            lce.ingresarCensista(Ce);
        }
        censistas.close();
    }
    public static void leerComunas(ListaComunas lc,ListaCensistas lce){
        In comunas = new In("comunas.txt");
        while(!comunas.isEmpty()){
            String leelinea = comunas.readLine();
            String[] linea = leelinea.split(",");
            int codigo = Integer.parseInt(linea[0]);
            String nombre = linea[1];
            int codigoCensista = Integer.parseInt(linea[2]);
            Censista Ce = lce.buscarCensistaXcodigo(codigoCensista);
            int cantHabitantes = Integer.parseInt(linea[3]);
            Comuna C = new Comuna(codigo,nombre,cantHabitantes);
            C.getLc().ingresarCensista(Ce);
            lc.ingresarComuna(C);
        }
        comunas.close();
        
    }
    public static void leerPersonas(ListaPersonas lp,ListaCensistas lce){
        In personas = new In("personas.txt");
        while(!personas.isEmpty()){
            String leelinea = personas.readLine();
            String[] linea = leelinea.split(",");
            String nombre = linea[0];
            int edad = Integer.parseInt(linea[1]);
            String comuna = linea[2];
            String ocupacion = linea[3];
            int cantFamilia = Integer.parseInt(linea[4]);
            String nomCensista = linea[5];
            Persona P = new Persona(nombre,edad,comuna,ocupacion,cantFamilia);
            Censista Ce = lce.buscarCensistaXnombre(nombre);
            P.setRefCensista(Ce);
            Ce.getLp().ingresarPersona(P);
            lp.ingresarPersona(P);
        }
        personas.close();
    }
    
    

    
    
    public static void main(String[] args) throws IOException {
       ListaCensistas lce = new ListaCensistas(1000);
       ListaComunas lc = new ListaComunas(1000);
       ListaPersonas lp = new ListaPersonas(1000);
        
        
        
        

    }
    
}
