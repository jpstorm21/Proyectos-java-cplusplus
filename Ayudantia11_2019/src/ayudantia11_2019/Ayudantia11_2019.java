/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayudantia11_2019;

import ucn.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Juan Pablo Martinez
 */
public class Ayudantia11_2019 {

    public static void ingresarAnime(ArrayList<Anime> listaAnimesVistos) {
        StdOut.println("Ingrese el nombre del anime: ");
        String nombre = StdIn.readString();
        StdOut.println("Ingrese el genero del anime: ");
        String genero = StdIn.readString();
        StdOut.println("Ingrese la cantidad de temporadas que posee: ");
        int temp = StdIn.readInt();
        StdOut.println("Ingrese el total de capitulos que posee el anime: ");
        int cap = StdIn.readInt();
        Anime a = new Anime(nombre, cap, temp, genero);
        listaAnimesVistos.add(a);
    }

    public static void ingresarAnimeRecomendado(LinkedList<Anime> listaAnimePorVer) {
        StdOut.println("Ingrese el nombre del anime: ");
        String nombre = StdIn.readString();
        StdOut.println("Ingrese el genero del anime: ");
        String genero = StdIn.readString();
        StdOut.println("Ingrese la cantidad de temporadas que posee: ");
        int temp = StdIn.readInt();
        StdOut.println("Ingrese el total de capitulos que posee el anime: ");
        int cap = StdIn.readInt();
        Anime a = new Anime(nombre, cap, temp, genero);
        listaAnimePorVer.add(a);
    }

    public static void eliminarAnimeVisto(ArrayList<Anime> listaAnimesVistos) {
        System.out.println("ingrese nombre de una anime: ");
        String nombre = StdIn.readString();
        boolean esta = false;
        int tam = listaAnimesVistos.size();
        for (int i = 0; i < tam; i++) {
            Anime a = listaAnimesVistos.get(i);
            if (a.getNombre().equalsIgnoreCase(nombre)) {
                listaAnimesVistos.remove(i);
                esta = true;
            }
        }
        if (esta) {
            System.out.println("anime eliminado");
        } else {
            System.out.println("anime no encontrado");
        }

    }

    public static void pasarAnimeComoVisto(ArrayList<Anime> listaAnimesVistos, LinkedList<Anime> listaAnimePorVer) {
        System.out.println("ingrese nombre de una anime: ");
        String nombre = StdIn.readString();

        boolean esta = false;
        Anime aux = null;
        int tam = listaAnimePorVer.size();

        for (int i = 0; i < tam; i++) {
            Anime a = listaAnimePorVer.get(i);
            if (a.getNombre().equalsIgnoreCase(nombre)) {
                aux = listaAnimePorVer.get(i);
                listaAnimePorVer.remove(i);
                listaAnimesVistos.add(aux);
                esta = true;
            }
        }
        if (esta) {
            System.out.println("anime movido exitosamente");
        } else {
            System.out.println("anime no encontrado");
        }
    }

    public static void desplegarVisto(ArrayList<Anime> listaAnimesVistos) {
        int tam = listaAnimesVistos.size();
        if (tam != 0) {
            for (int i = 0; i < tam; i++) {
                Anime a = listaAnimesVistos.get(i);
                System.out.println("Nombre: " + a.getNombre());
            }
        } else {
            System.out.println("lista vacia");
        }
    }

    public static void desplegarNoVisto(LinkedList<Anime> listaAnimePorVer) {
        int tam = listaAnimePorVer.size();
        if (tam != 0) {
            for (int i = 0; i < tam; i++) {
                Anime a = listaAnimePorVer.get(i);
                System.out.println("Nombre: " + a.getNombre());
            }
        } else {
            System.out.println("lista vacia");
        }

    }

    public static void main(String[] args) {
        ArrayList<Anime> listaAnimesVistos = new ArrayList<Anime>();
        LinkedList<Anime> listaAnimePorVer = new LinkedList<Anime>();
        StdOut.println("-----Menú-----"
                + "\n1)registrar anime ya visto"
                + "\n2)Registrar anime recomendado"
                + "\n3)Eliminar anime recomendado"
                + "\n4)Cambiar anime recomendado a 'ya visto'"
                + "\n5)Mostrar animes vistos"
                + "\n6)Mostrar animes recomendados"
                + "\n7)Salir");
        StdOut.println("ingrese una opción: ");
        int opcion = StdIn.readInt();
        while (opcion != 7) {
            if (opcion == 1) {
                ingresarAnime(listaAnimesVistos);
            } else if (opcion == 2) {
                ingresarAnimeRecomendado(listaAnimePorVer);
            } else if (opcion == 3) {
                eliminarAnimeVisto(listaAnimesVistos);
            } else if (opcion == 4) {
                pasarAnimeComoVisto(listaAnimesVistos, listaAnimePorVer);
            } else if (opcion == 5) {
                desplegarVisto(listaAnimesVistos);
            } else if (opcion == 6) {
                desplegarNoVisto(listaAnimePorVer);
            } else {
                StdOut.println("opción no valida");
            }
            StdOut.println("-----Menú-----"
                    + "\n1)registrar anime ya visto"
                    + "\n2)Registrar anime recomendado"
                    + "\n3)Eliminar anime recomendado"
                    + "\n4)Cambiar anime recomendado a 'ya visto'"
                    + "\n5)Mostrar animes vistos"
                    + "\n6)Mostrar animes recomendados"
                    + "\n7)Salir");
            StdOut.println("ingrese una opción: ");
            opcion = StdIn.readInt();
        }
    }
}
