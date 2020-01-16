/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
import ucn.*;

public class App {
    
    
    public static void ingresarEntrenador(ListaEntrenadores le, ListaPokemones lp) {
        
        System.out.println("Ingrese Nickname del jugador: ");
        String nick = StdIn.readString();
        
        System.out.println("Ingrese nombre real del jugador: ");
        String nombre = StdIn.readString();
        
        System.out.println("Ingrese ID entrenador :");
        int id = StdIn.readInt();
        
        System.out.println("Ingrese sexo del jugador (F o M) :");
        String sexo = StdIn.readString();
        
        System.out.println("Ingrese correo del jugador :");
        String correo = StdIn.readString();
        
        Entrenador E = new Entrenador(nick, nombre, id, sexo, correo);
        le.ingresarEntrenador(E);
        
    }
    public static void capturarPokemon(ListaPokemones lp , ListaEntrenadores le) {
        
        System.out.println("Seleccione entrenador para capturar pokemon: ");
        for(int i=0; i<le.getCantEntrenadores(); i++){
            System.out.println(le.getEntrenador(i).getNombreReal());
        }
        String nom = StdIn.readString();
        Entrenador E = le.buscarEntrenador(nom);
        
        if(E == null) {
            System.out.println("No existe el entrenador");
        } else {
            System.out.println("Ingrese nombre del pokemon: ");
            String nomPoke = StdIn.readString();
            
            System.out.println("Ingrese naturaleza del pokemon :");
            String tipo = StdIn.readString();
            
            System.out.println("Ingrese puntos de ataque del pokemon: ");
            int pa = StdIn.readInt();
            
            System.out.println("Ingrese puntos de defensa del pokemon: ");
            int pd = StdIn.readInt();
            
            System.out.println("Ingrese velocidad del pokemon: ");
            int vel = StdIn.readInt();
            
            System.out.println("Ingrese puntos de vida del pokemon: ");
            int pv = StdIn.readInt();
            
            System.out.println("Ingrese sexo del pokemon :");
            String sexo = StdIn.readString();
            
            System.out.println("Ingrese ataque del pokemon :");
            String ataque = StdIn.readString();
            
            Pokemon P = new Pokemon(tipo,nomPoke,pa, pd, vel, pv, sexo, ataque);
            
            lp.ingresarPokemon(P); // ingreso pokemon a la lista general de pokemones
            
            E.getLp().ingresarPokemon(P); // ingreso pokemon a la lista de pokemones del entrenador buscado
            
            P.setRefEntrenador(E); // pokemon seteado a su entrenador
            
            
        }
        
       
        
    }
    public static void requerimiento_cuatro(ListaPokemones lp, ListaEntrenadores le) { 
        System.out.println("Entrenador que cumple con los requisitos: ");
        for(int i=0; i<le.getCantEntrenadores(); i++) {
            Entrenador E = le.getEntrenador(i); // tomo el primer entrenador de la lista general de entrenadores
            for(int j=0; j<E.getLp().getCantPokemones(); j++) {
                Pokemon P = E.getLp().getPokemon(j); // tomo el primer pokemon de la lista del entrenador de arriba
                if(P.getPuntosAtaque() > P.getPuntosDefensa() || P.getVelocidad() > P.getPuntosAtaque()) {
                    System.out.println(E.getNickname());
                    break; 
                    
                }
        
            }
            
        }
    }
    
    public static void requerimiento_tres(ListaPokemones lp , ListaEntrenadores le) { // buscar por tipo de pokemon
        System.out.println("Ingrese tipo de pokemon a buscar: ");
        String tipo = StdIn.readString();
        
        for(int i=0; i<le.getCantEntrenadores();i++) {
            Entrenador E = le.getEntrenador(i);
            System.out.println("el nickname del entrenador es: ");
            System.out.println(E.getNickname());
            for(int j=0; j<E.getLp().getCantPokemones(); j++) {
                if(E.getLp().getPokemon(j).getTipo().equalsIgnoreCase(tipo)){
                    
                    System.out.println("Pokemones tipo "+tipo + ":");
                    System.out.println(E.getLp().getPokemon(j).getNomPokemon());
                    
                    
                }
            }
        }
    }
    public static void requerimiento_cinco(ListaEntrenadores le , ListaPokemones lp) { // mayor pokemones
        int mayor = -1;
        String nomMayor ="";
        for(int i=0; i<le.getCantEntrenadores();i++) {
            Entrenador E = le.getEntrenador(i);
            if(E.getLp().getCantPokemones() > mayor) {
                mayor = E.getLp().getCantPokemones();
                nomMayor = E.getNickname();
            }
        }
        System.out.println("El entrenador con mayor cantidad de pokemones es: " +nomMayor);
        
    }
    public static void requerimiento_seis(ListaPokemones lp , ListaEntrenadores le) { // igual sexo
        
        for(int i=0; i<le.getCantEntrenadores(); i++) {
            Entrenador E = le.getEntrenador(i);
            System.out.println("Nickname entrenador: " +E.getNickname());
            System.out.println("Pokemones que tienen igual sexo que el entrenador: ");
            for(int j=0; j< E.getLp().getCantPokemones(); j++) {
                Pokemon P = E.getLp().getPokemon(j);
                if(P.getSexoPokemon().equalsIgnoreCase(E.getSexoEntrenador())) {
                    System.out.println(P.getNomPokemon());
                }
            }
            
        }
    }
    public static void menuApp(ListaPokemones lp , ListaEntrenadores le) {
        int opcion=0;
           while(opcion!= 7) {
               System.out.println("--------------------------------------");
               System.out.println("\t[MENU]");
               System.out.println("1. Ingresar un entrenador");
               System.out.println("2. Capturar un pokemon");
               System.out.println("3. Desplegar entrenadores de un determinado tipo de pokemon");
               System.out.println("4. RF4");
               System.out.println("5. Desplegar nickname del entrenador con mas pokemones");
               System.out.println("6. Desplegar nickname de entrenador con igual sexo que pokemon");
               System.out.println("7. Salir ");
               opcion = StdIn.readInt();
               System.out.println("--------------------------------------");
               StdOut.println();
               switch(opcion) {
                   case 1:
                    ingresarEntrenador(le, lp);
                    break;
                   case 2:
                    capturarPokemon(lp, le);
                    break;
                   case 3:
                       requerimiento_tres(lp, le);
                    break;
                   case 4:
                       requerimiento_cuatro(lp, le);
                       break;
                   case 5:
                       requerimiento_cinco(le, lp);
                       break;
                   case 6:
                       requerimiento_seis(lp, le);
                       break;
                       
                   default:
                    opcion=7;
              
               }
           }
    }
    public static void main(String[] args) {
    ListaPokemones lp = new ListaPokemones(1000);
    ListaEntrenadores le = new ListaEntrenadores(1000);
    menuApp(lp, le);
    }
    
}
