/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayudantia5.pkg2019;

import java.util.Scanner;

/**
 *
 * @author Juan Pablo Martinez
 */
public class Ayudantia52019 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaEquipos le = new ListaEquipos(100);
        Scanner sc= new Scanner(System.in);
        System.out.print("ingrese cantidad de equipos: ");
        int cant = sc.nextInt();
        for(int i = 0; i<cant;i++){
            System.out.print("Ingrese nombre del equipo " +(i+1)+" : ");
            String nombreEquipo = sc.next();
            Equipo e = new Equipo(nombreEquipo);
            System.out.print("Ingrese nombre de su mejor jugador: ");
            String nombre = sc.next();
            System.out.print("Ingrese posicion del jugador: ");
            String posicion = sc.next();
            System.out.print("Ingrese puntuación: ");
            int puntuacion = sc.nextInt();
            Jugador j = new Jugador(nombre,posicion,puntuacion);
            e.setJugador(j);
            if(!le.insertEquipo(e)){
                System.out.println("equipo no se pudo ingresar");   
            }
        }
        
        int mayor = -99;
        String nombreMayor ="";
        for(int i = 0; i <le.getCant();i++){
            Equipo e = le.getEquipo(i);
            System.out.println("Nombre del equipo: " + e.getNombre());
            System.out.println("Nombre del mejor jugador de "+e.getNombre()+" es : " + e.getJugador().getNombre());
            if(e.getJugador().getPuntacion() > mayor){
                mayor = e.getJugador().getPuntacion();
                nombreMayor = e.getJugador().getNombre();
            }
        }
        
        System.out.println("El jugador con la mayor puntuacion es: " + nombreMayor);
        
    }
    
}
