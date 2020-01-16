/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayudantia9_2019;

import ucn.*;

/**
 *
 * @author Juan Pablo Martinez
 */
public class Ayudantia9_2019 {

    public static void ingresarEntrenador(ListaEntrenadores le) {

        System.out.print("Ingrese Nickname del jugador: ");
        String nick = StdIn.readString();

        System.out.print("Ingrese nombre real del jugador: ");
        String nombre = StdIn.readString();

        System.out.print("Ingrese ID entrenador :");
        int id = StdIn.readInt();

        System.out.print("Ingrese sexo del jugador (F o M) :");
        String sexo = StdIn.readString();

        System.out.print("Ingrese correo del jugador :");
        String correo = StdIn.readString();

        Entrenador E = new Entrenador(nick, nombre, id, sexo, correo);
        le.ingresar(E);

    }

    public static void capturarPokemon(ListaPokemones lp, ListaEntrenadores le) {

        System.out.print("ingrese id del entrenador: ");
        int id = StdIn.readInt();
        Entrenador E = le.buscarEntrenador(id);

        if (E == null) {
            System.out.println("No existe el entrenador");
        } else {
            System.out.print("Ingrese nombre del pokemon: ");
            String nomPoke = StdIn.readString();

            System.out.print("Ingrese naturaleza del pokemon :");
            String tipo = StdIn.readString();

            System.out.print("Ingrese puntos de ataque del pokemon: ");
            int pa = StdIn.readInt();

            System.out.print("Ingrese puntos de defensa del pokemon: ");
            int pd = StdIn.readInt();

            System.out.print("Ingrese velocidad del pokemon: ");
            int vel = StdIn.readInt();

            System.out.print("Ingrese puntos de vida del pokemon: ");
            int pv = StdIn.readInt();

            System.out.print("Ingrese sexo del pokemon :");
            String sexo = StdIn.readString();

            System.out.print("Ingrese ataque del pokemon :");
            String ataque = StdIn.readString();

            Pokemon P = new Pokemon(tipo, nomPoke, pa, pd, vel, pv, sexo, ataque);

            lp.ingresar(P); // ingreso pokemon a la lista general de pokemones

            E.getLp().ingresar(P); // ingreso pokemon a la lista de pokemones del entrenador buscado

            P.setRefEntrenador(E); // pokemon seteado a su entrenador

        }

    }

    public static void requerimiento_cuatro(ListaPokemones lp, ListaEntrenadores le) {
        System.out.println("Entrenador que cumple con los requisitos: ");
        NodoEntrenador current = le.getFirst();
        while (current != null) {
            Entrenador E = current.getEntrenador();
            NodoPokemon currret2 = E.getLp().getFirst();
            while (currret2 != null) {
                Pokemon P = currret2.getPokemon();
                if (P.getPuntosAtaque() > P.getPuntosDefensa() || P.getVelocidad() > P.getPuntosAtaque()) {
                    System.out.println(E.getNickname());
                    break;
                }
                currret2 = currret2.getNext();
            }
            current = current.getNext();
        }
    }

    public static void requerimiento_tres(ListaPokemones lp, ListaEntrenadores le) { // buscar por tipo de pokemon
        System.out.print("Ingrese tipo de pokemon a buscar: ");
        String tipo = StdIn.readString();
        NodoEntrenador current = le.getFirst();
        while (current != null) {
            Entrenador E = current.getEntrenador();
            NodoPokemon currret2 = E.getLp().getFirst();
            System.out.println("pokemones del entrador " + E.getNickname() + " que coinciden con el tipo");
            int cant = 0;
            while (currret2 != null) {
                Pokemon P = currret2.getPokemon();
                if (P.getTipo().equalsIgnoreCase(tipo)) {
                    cant++;
                    System.out.println(P.getNomPokemon());
                }
                currret2 = currret2.getNext();
            }
            if (cant == 0) {
                System.out.println("entrenador no poseia pokemones del tipo ingresado");
            }
            current = current.getNext();
        }
    }

    public static void requerimiento_cinco(ListaEntrenadores le, ListaPokemones lp) { // mayor pokemones
        int mayor = -1;
        String nomMayor = "";
        NodoEntrenador current = le.getFirst();
        while (current != null) {
            Entrenador E = current.getEntrenador();
            NodoPokemon currret2 = E.getLp().getFirst();
            int cant = 0;
            while (currret2 != null) {
                cant++;
                currret2 = currret2.getNext();
            }
            if(cant > mayor){
                mayor = cant;
                nomMayor = E.getNickname();
            }
            current = current.getNext();
        }
        System.out.println("El entrenador con mayor cantidad de pokemones es: " + nomMayor);

    }

    public static void requerimiento_seis(ListaPokemones lp, ListaEntrenadores le) { // igual sexo
        System.out.println("lista de entrenadores");
        NodoEntrenador current = le.getFirst();
        while (current != null) {
            Entrenador E = current.getEntrenador();
            NodoPokemon currret2 = E.getLp().getFirst();
            System.out.println("nickame: " + E.getNickname());
            System.out.println("pokemones de poseen el mismo sexo que el entrenador: ");
            while (currret2 != null) {
                Pokemon P = currret2.getPokemon();
                if (P.getSexoPokemon().equalsIgnoreCase(E.getSexoEntrenador())) {
                    System.out.println("pokemon: " + P.getNomPokemon());
                }
                currret2 = currret2.getNext();
            }
            current = current.getNext();
        }
    }

    public static void menuApp(ListaPokemones lp, ListaEntrenadores le) {
        int opcion = 0;
        while (opcion != 7) {
            System.out.println("--------------------------------------");
            System.out.println("\t[MENU]");
            System.out.println("1. Ingresar un entrenador");
            System.out.println("2. Capturar un pokemon");
            System.out.println("3. Desplegar entrenadores de un determinado tipo de pokemon");
            System.out.println("4. RF4");
            System.out.println("5. Desplegar nickname del entrenador con mas pokemones");
            System.out.println("6. Desplegar nickname de entrenador con igual sexo que pokemon");
            System.out.println("7. Salir ");
            System.out.println("--------------------------------------");
            System.out.print("ingrese opcion: ");
            opcion = StdIn.readInt();
            StdOut.println();
            switch (opcion) {
                case 1:
                    ingresarEntrenador(le);
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
                    opcion = 7;
            }
        }
    }

    public static void main(String[] args) {
        ListaPokemones lp = new ListaPokemones();
        ListaEntrenadores le = new ListaEntrenadores();
        menuApp(lp, le);
    }
}
