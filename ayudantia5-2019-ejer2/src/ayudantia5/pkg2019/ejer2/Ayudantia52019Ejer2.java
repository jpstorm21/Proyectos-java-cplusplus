/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayudantia5.pkg2019.ejer2;

import java.util.Scanner;

/**
 *
 * @author Juan Pablo Martinez
 */
public class Ayudantia52019Ejer2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaConfenrencia lc = new ListaConfenrencia(100);
        Scanner sc= new Scanner(System.in);
        System.out.print("ingrese cantidad de conferencias: ");
        int cant = sc.nextInt();
        for(int i = 0 ;i< cant;i++){
            System.out.print("ingrese nombre de la conferencia: ");
            String nombre= sc.next();
            System.out.print("ingrese cantidad de equipos de la conferencia del "+nombre+" : ");
            int cantEquipos = sc.nextInt();
            conferencia c = new conferencia(nombre);
            for(int j = 0; j< cantEquipos;j++){
                System.out.print("ingrese nombre del equipo: ");
                String nomEquipo = sc.next();
                System.out.print("ingrese cantidad de victorias: ");
                int victorias = sc.nextInt();
                Equipo e = new Equipo(nomEquipo,victorias);
                c.getLe().insertEquipo(e);
                e.setConferencia(c);
            }
            lc.insertConferencia(c);
        }
        
        for(int i = 0; i<lc.getCant();i++){
            conferencia c = lc.getConferencia(i);
            System.out.println("Nombre de la conferencia: " + c.getNombre());
            System.out.println("lista de sus equipos");
            for(int j = 0; j< c.getLe().getCant();j++){
                Equipo e = c.getLe().getEquipo(j);
                System.out.println("nombre del equipo: " + e.getNombre());
            }
        }
        int mayorTotal = -99;
        String nomMayorTotal = "";
        for(int i = 0; i<lc.getCant();i++){
            conferencia c = lc.getConferencia(i);
            int mayorConferencia = -99;
            String mayorConferenciaNombre = "";
            for(int j = 0; j< c.getLe().getCant();j++){
                Equipo e = c.getLe().getEquipo(j);
                if(e.getVictorias()>mayorConferencia){
                    mayorConferencia = e.getVictorias();
                    mayorConferenciaNombre = e.getNombre();
                }
            }
            System.out.println("El equipo con mayor victorias en la conferencia del " + c.getNombre() + " es: " + mayorConferenciaNombre);
            if(mayorConferencia > mayorTotal){
                mayorTotal =mayorConferencia;
                nomMayorTotal = mayorConferenciaNombre;
            }
        }
        System.out.println("el equipo con mayor victoria de la NBA es : " +  nomMayorTotal);
        
    }
    
}
