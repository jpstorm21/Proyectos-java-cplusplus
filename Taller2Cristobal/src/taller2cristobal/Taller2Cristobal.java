package taller2cristobal;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Taller2Cristobal {

    public static void leerComunas(ListaComunas lc) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("Comunas.txt"));
        while (sc.hasNextLine()) {
            String leelinea = sc.nextLine();
            String[] linea = leelinea.split(",");
            int codigo = Integer.parseInt(linea[0]);
            String nombre = linea[1];
            int nCensista = Integer.parseInt(linea[2]);
            int cantHabitantes = Integer.parseInt(linea[3]);
            Comuna C = new Comuna(codigo, nombre, cantHabitantes, nCensista);
            lc.ingresarComuna(C);
        }
        sc.close();
    }

    public static void leerCensistas(ListaCensistas lce, ListaComunas lc) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("Censistas.txt"));
        while (sc.hasNextLine()) {
            String leelinea = sc.nextLine();
            String[] linea = leelinea.split(",");
            int codigo = Integer.parseInt(linea[0]);
            String nombre = linea[1];
            String nomComuna = linea[2];
            Censista Ce = new Censista(codigo, nombre);
            Comuna C = lc.buscarComunaXnombre(nomComuna);
            C.getLce().ingresarCensista(Ce);
            Ce.setRefComuna(C);
            lce.ingresarCensista(Ce);
        }
        sc.close();
    }

    public static void leerPersonas(ListaPersonas lp, ListaCensistas lce) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("Personas.txt"));
        while (sc.hasNextLine()) {
            String leelinea = sc.nextLine();
            String[] linea = leelinea.split(",");
            String nombre = linea[0];
            int edad = Integer.parseInt(linea[1]);
            String Comuna = linea[2];
            String ocupacion = linea[3];
            int cantFamilia = Integer.parseInt(linea[4]);
            String censista = linea[5];
            Persona P = new Persona(nombre, edad, Comuna, ocupacion, cantFamilia, censista);
            Censista Ce = lce.buscarCensistaXnombre(censista);
            Ce.getLp().ingresarPersona(P);
            lp.ingresarPersona(P);
        }
        sc.close();
    }

    public static void menu(ListaPersonas lp, ListaCensistas lce, ListaComunas lc, Scanner sc) throws IOException { 
        int opcionmenu = 0;       
        while (opcionmenu != 5) {
            System.out.println("menu: ");
            System.out.println("RF1(opcion 1)");
            System.out.println("RF2(opcion 2)");
            System.out.println("RF3(opcion 3)");
            System.out.println("RF4(opcion 4)");
            System.out.println("salir opcion 5");
            System.out.println("------------------");
            System.out.print(">");
            opcionmenu = sc.nextInt();
            switch (opcionmenu) {
                case 1:
                    Taller2Cristobal.RF1(lc);
                    break;
                case 2:
                    Taller2Cristobal.RF2(lce);
                    break;
                case 3:
                    Taller2Cristobal.RF3(lce, sc);
                    break;
                case 4:
                    Taller2Cristobal.RF4(lc, sc);
                    break;
                default:
                    opcionmenu = 5;
            }
        }
        
    }

    public static void RF1(ListaComunas lc) throws IOException {
        File archivo = new File("censo.txt");
        FileWriter escribir = new FileWriter(archivo);
        BufferedWriter bw = new BufferedWriter(escribir);
        PrintWriter salida = new PrintWriter(bw);
        for (int i = 0; i < lc.getCantComunas(); i++) {
            Comuna C = lc.getComuna(i);
            salida.write("----------------------------");
            bw.newLine();
            salida.write("Comuna : " + C.getNombre());
            bw.newLine();
            salida.write("----------------------------");
            bw.newLine();
            for (int j = 0; j < C.getLce().getCantCensistas(); j++) {
                Censista Ce = C.getLce().getCensista(j);
                salida.write("----------------------------");
                bw.newLine();
                salida.write("Censista: " + Ce.getNombre());
                bw.newLine();
                for (int w = 0; w < Ce.getLp().getCantPersonas(); w++) {
                    Persona P = Ce.getLp().getPersona(w);
                    salida.write("----------------------------");
                    bw.newLine();
                    salida.write("Persona " + (w + 1) + ":");
                    bw.newLine();
                    salida.write("nombre : " + P.getNombre());
                    bw.newLine();
                    salida.write("edad : " + P.getEdad());
                    bw.newLine();
                    salida.write("ocupacion : " + P.getOcupacion());
                    bw.newLine();
                    salida.write("cantidad de familia : " + P.getFamilia());
                    bw.newLine();
                }
            }
        }
        bw.close();
        System.out.println("archivo Censo.txt generado exitosamente");
    }

    public static void RF2(ListaCensistas lce) throws IOException {
        File archivo = new File("DatosCensistas.txt");
        FileWriter escribir = new FileWriter(archivo);
        BufferedWriter bw = new BufferedWriter(escribir);
        PrintWriter salida = new PrintWriter(bw);
        int suma = 0;
        double contador = 0;
        double porcentaje = 0;
        double cantFamilia = 0;
        for (int i = 0; i < lce.getCantCensistas(); i++) {
            Censista Ce = lce.getCensista(i);
            salida.write("------------------------------------------------------");
            bw.newLine();
            salida.write("Personas que censo el censista: " + Ce.getNombre());
            bw.newLine();
            salida.write("-------------------------------------------------------");
            bw.newLine();
            for (int j = 0; j < Ce.getLp().getCantPersonas(); j++) {
                Persona P = Ce.getLp().getPersona(j);
                salida.write("-------------------------------------------------------");
                bw.newLine();
                salida.write("nombre : " + P.getNombre());
                bw.newLine();
                salida.write("edad: " + P.getEdad());
                bw.newLine();
                cantFamilia++;
                suma = suma + P.getFamilia();
                if (P.getFamilia() > 3) {
                    contador++;
                }
            }
        }
        porcentaje = (contador / cantFamilia) * 100;
        salida.write("-------------------------------------------------------");
        bw.newLine();
        salida.write("suma de cada integrantes de cada familia censada: " + suma);
        bw.newLine();
        salida.write("-------------------------------------------------------");
        bw.newLine();
        salida.write("porcentaje de familias que superan los 3 integrantes: " + porcentaje + "%");
        bw.newLine();
        bw.close();
        System.out.println("archivo DatosCensistas.txt generado exitosamente");
    }

    public static void RF3(ListaCensistas lce, Scanner sc) {

        System.out.print("ingrese codigo del censista a buscar: ");
        int cod = sc.nextInt();
        Censista Ce = lce.buscarCensistaXcodigo(cod);
        if (Ce != null) {
            double cantTotal = Ce.getRefComuna().getHabitantes();
            double cant = 0;
            double porcentaje = 0;
            for (int i = 0; i < Ce.getLp().getCantPersonas(); i++) {
                Persona P = Ce.getLp().getPersona(i);
                System.out.println("----------------------------");
                System.out.println("Persona " + (i + 1) + ":");
                System.out.println("nombre : " + P.getNombre());
                System.out.println("edad : " + P.getEdad());
                System.out.println("ocupacion : " + P.getOcupacion());
                System.out.println("cantidad de familia : " + P.getFamilia());
                System.out.println("----------------------------");
                cant++;
            }
            porcentaje = (cant / cantTotal) * 100;
            System.out.println("porcentaje con respecto al total de personas de la comuna es: " + porcentaje + "%");
        } else {
            System.out.println("censista no existe");
        }

    }

    public static void RF4(ListaComunas lc, Scanner sc) throws IOException {
            System.out.print("ingrese codigo de la comuna a buscar: ");
            int cod = sc.nextInt();
            Comuna C = lc.buscarComunaXcodigo(cod);
            if (C != null) {
                int personasCensadas = 0;
                System.out.println("nombre : " + C.getNombre());
                System.out.println("codigo : " + C.getCodigo());
                System.out.println("cantidad de habitantes : " + C.getHabitantes());
                for (int i = 0; i < C.getLce().getCantCensistas(); i++) {
                    Censista Ce = C.getLce().getCensista(i);
                    for (int j = 0; j < Ce.getLp().getCantPersonas(); j++) {
                        Persona P = Ce.getLp().getPersona(j);
                        personasCensadas = personasCensadas + P.getFamilia();
                    }
                }
                if (personasCensadas == C.getHabitantes()) {
                    System.out.println("el censo fue un exito");
                } else {
                    System.out.println("el censo no se realizo correctamente");
                }
            } else {
                System.out.println("comuna no existe");
            }
    
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);
        ListaPersonas lp = new ListaPersonas(1000);
        ListaCensistas lce = new ListaCensistas(1000);
        ListaComunas lc = new ListaComunas(1000);
        Taller2Cristobal.leerComunas(lc);
        Taller2Cristobal.leerCensistas(lce, lc);
        Taller2Cristobal.leerPersonas(lp, lce);
        Taller2Cristobal.menu(lp, lce, lc, sc);
    }

}
