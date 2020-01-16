package diccionario;

import java.util.Scanner;

public class Diccionario {

    public static void leerDatos(Scanner sc, InterfaceDiccionario diccionario) {
        System.out.print("ingrese palabra: ");
        String nombre = sc.next();
        while (!nombre.equalsIgnoreCase("111")) {
            System.out.print("ingrese su significado: ");
            String significado = sc.next();
            diccionario.insertarPalabra(nombre, significado);
            System.out.print("ingrese palabra: ");
            nombre = sc.next();
        }
    }

    public static void buscarSignificado(Scanner sc, InterfaceDiccionario diccionario) {
        System.out.print("ingrese palabra para encontrar su significado: ");
        String nombre = sc.next();
        String significado = diccionario.buscarSignificado(nombre);
        System.out.println(nombre + " : " + significado);
    }

    public static void listadoPalabras(InterfaceDiccionario diccionario) {
        String[] lista = diccionario.listadoPalabras();
        for (int i = 0; i < lista.length; i++) {
            System.out.print(lista[i]);
        }
        System.out.println(" ");
    }

    public static void listadoPalabrasLetra(Scanner sc, InterfaceDiccionario diccionario) {
        System.out.println("ingrese letra: ");
        String letra = sc.next();
        String[] lista = diccionario.listaPalabrasP(letra);
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                System.out.print(lista[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InterfaceDiccionario diccionario = new SistemaDiccionario();
        leerDatos(sc, diccionario);
        buscarSignificado(sc, diccionario);
        System.out.println("listado de palabras ordenadas alfabeticamente");
        listadoPalabras(diccionario);
        System.out.println("listado de palabras dependiendo de una letra");
        listadoPalabrasLetra(sc, diccionario);
    }
}
