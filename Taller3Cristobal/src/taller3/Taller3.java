package taller3;

import ucn.*;

public class Taller3 {

    public static void LeerPersonas(ListaPersonas LPers) {

        In entrada = new In("personas.txt");
        while (!entrada.isEmpty()) {
            String leerlinea = entrada.readLine();
            String[] linea = leerlinea.split(",");
            int codiP = Integer.parseInt(linea[0]);
            String nomb = linea[1];
            String apell = linea[2];
            int edad = Integer.parseInt(linea[3]);
            String estud = linea[4];

            if (estud.equalsIgnoreCase("tecnico")) {
                int sueldoT = Integer.parseInt(linea[5]);
                int gasto = Integer.parseInt(linea[6]);
                Persona P = new Tecnico(sueldoT, gasto, codiP, nomb, apell, edad, estud);
                LPers.IngresarPersona(P);

            } else if (estud.equalsIgnoreCase("profesional")) {
                int sueldoP = Integer.parseInt(linea[5]);
                int añostrabajo = Integer.parseInt(linea[6]);
                Persona P = new Profesional(sueldoP, añostrabajo, codiP, nomb, apell, edad, estud);
                LPers.IngresarPersona(P);

            } else {
                int añoActual = Integer.parseInt(linea[5]);
                int añosTotal = Integer.parseInt(linea[6]);
                Persona P = new Estudiante(añoActual, añosTotal, codiP, nomb, apell, edad, estud);
                LPers.IngresarPersona(P);
            }

        }
        entrada.close();
    }

    public static void LeerCreditos(ListaCreditos LCre) {

        In entrada = new In("creditos.txt");
        while (!entrada.isEmpty()) {
            String leerlinea = entrada.readLine();
            String[] linea = leerlinea.split(";");
            String[] linea2 = leerlinea.split(",");
            int codiC = Integer.parseInt(linea[0]);
            int montoSoli = Integer.parseInt(linea[1]);
            String codperso = linea[2];
            double tasa = Integer.parseInt(linea2[3]);
            int cantcuotas = Integer.parseInt(linea[4]);

        }
        entrada.close();
    }

    public static void main(String[] args) {
        ListaCreditos[] LCre = new ListaCreditos[1000];
        ListaPersonas[] LPers = new ListaPersonas[1000];
    }

}
