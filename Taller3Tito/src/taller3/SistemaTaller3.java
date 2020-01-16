package taller3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class SistemaTaller3 implements Interface {

    private ListaPersonas lp;
    private ListaCreditos lc;

    public SistemaTaller3() {
        lp = new ListaPersonas(100);
        lc = new ListaCreditos(1000);
    }

    @Override
    public void leerPersonas() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("personas.txt"));
        while (sc.hasNextLine()) {
            String leelinea = sc.nextLine();
            String[] linea = leelinea.split(",");
            int codigo = Integer.parseInt(linea[0]);
            String nombre = linea[1];
            String apellido = linea[2];
            int edad = Integer.parseInt(linea[3]);
            String tipo = linea[4];
            if (tipo.equalsIgnoreCase("estudiante")) {
                int añoActual = Integer.parseInt(linea[5]);
                int añoCarrera = Integer.parseInt(linea[6]);
                Persona P = new Estudiante(añoActual, añoCarrera, codigo, nombre, apellido, edad, tipo);
                ingresarPersona(P);
            } else if (tipo.equalsIgnoreCase("tecnico")) {
                int sueldo = Integer.parseInt(linea[5]);
                int gasto = Integer.parseInt(linea[6]);
                Persona P = new Tecnico(sueldo, gasto, codigo, nombre, apellido, edad, tipo);
                ingresarPersona(P);
            } else {
                int sueldo = Integer.parseInt(linea[6]);
                int añosTrabajo = Integer.parseInt(linea[6]);
                Persona P = new Profesional(sueldo, añosTrabajo, codigo, nombre, apellido, edad, tipo);
                ingresarPersona(P);
            }
        }

        sc.close();

    }

    @Override
    public void leerCreditos() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("creditos.txt"));
        while (sc.hasNextLine()) {
            String leelinea = sc.nextLine();
            String[] linea = leelinea.split(";");
            int codigo = Integer.parseInt(linea[0]);
            Double monto = Double.parseDouble(linea[1]);
            int codPerson = Integer.parseInt(linea[2]);
            Persona P = buscarPersona(codPerson);
            String[] t = linea[3].split(",");
            Double tasa;
            if (t.length == 2) {
                tasa = Double.parseDouble(t[0]) + (Double.parseDouble(t[1]) / 10);
            } else {
                tasa = Double.parseDouble(t[0]);
            }
            Double cantCuotas = Double.parseDouble(linea[4]);
            Double x = (monto / cantCuotas);
            Double valorCuota = x + (x * tasa);
            Credito C = new Credito(codigo, monto, tasa, valorCuota, cantCuotas);
            boolean aprobado = P.calcular(monto);
            if (aprobado) {
                C.setEstado("aprobado");
            } else {
                C.setEstado("rechazado");
            }
            P.getLc().ingresarCredito(C);
            C.setRefPersona(P);
            ingresarCredito(C);
        }
        sc.close();
    }

    public void ingresarPersona(Persona P) {
        boolean sepudo = lp.ingresarPersona(P);
        if (sepudo) {
        } else {
            System.out.println("no se pudo ingresar Persona");
        }
    }

    public void ingresarCredito(Credito C) {
        boolean sepudo = lc.ingresarCredito(C);
        if (sepudo) {
        } else {
            System.out.println("no se pudo ingresar Credito");
        }
    }

    public Persona buscarPersona(int codigo) {
        Persona P = lp.buscarPersona(codigo);
        return P;
    }

    public Credito buscarCredito(int codigo) {
        Credito C = lc.buscarCredito(codigo);
        return C;
    }

    public void eliminarPersona(Persona P) {
        boolean sepudo = lp.eliminarPersona(P);
        if (sepudo) {
            System.out.println("persona eliminada");
        } else {
            System.out.println("no se pudo eliminar Persona");
        }
    }

    public void RF1() {
        for (int i = 0; i < lp.getCantPersonas(); i++) {
            Persona P = lp.getPersona(i);
            System.out.println("--------------------------------------------------------------------");
            System.out.println("codigo : " + P.getCodigo());
            System.out.println("nombre : " + P.getNomhre());
            System.out.println("apellido : " + P.getApellido());
            System.out.println("edad : " + P.getEdad());
            System.out.println("estudios : " + P.getEstudio());
            if (P instanceof Estudiante) {
                System.out.println("año actual : " + ((Estudiante) P).getAñoActual());
                System.out.println("año de la carrera : " + ((Estudiante) P).getAñosCarrera());
            } else if (P instanceof Tecnico) {
                System.out.println("sueldo: " + ((Tecnico) P).getSueldoMes());
                System.out.println("gasto mensual : " + ((Tecnico) P).getGastoMes());
            } else {
                System.out.println("años de trabajo: " + ((Profesional) P).getAñosTrabajo());
                System.out.println("sueldo : " + ((Profesional) P).getSueldoMes());
            }
            System.out.println("--------------------------------------------------------------------");
            for (int j = 0; j < P.getLc().getCantCreditos(); j++) {
                Credito C = P.getLc().getCredito(j);
                if (C.getEstado().equalsIgnoreCase("aprobado")) {
                    System.out.println("estado: " + C.getEstado());
                    System.out.println("codigo: " + C.getCodigo());
                    System.out.println("monto : " + C.getMonto());
                    System.out.println("valor de la cuota: " + C.getCuotaMensual());
                    System.out.println("tasa : " + C.getTasa());
                    System.out.println("cantidad de cuotas : " + C.getCantCuotas());
                } else {
                    System.out.println("credito de codigo: " + C.getCodigo() + " no esta aprobado");
                }

            }
        }
    }

    public void RF2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ingrese Codigo de la persona a buscar: ");
        int cod = sc.nextInt();
        Persona P = buscarPersona(cod);
        if (P != null) {
            System.out.println("nombre : " + P.getNomhre());
            System.out.println("apellido : " + P.getApellido());
            System.out.println("edad: " + P.getEdad());
            if (P.getLc().getCantCreditos() == 0) {
                System.out.println("persona no posee creditos");
            } else {
                System.out.println("Lista de creditos: ");
                for (int i = 0; i < P.getLc().getCantCreditos(); i++) {
                    Credito C = P.getLc().getCredito(i);
                    System.out.println("------------------------------------------------");
                    System.out.println("estado: " + C.getEstado());
                    System.out.println("codigo: " + C.getCodigo());
                    System.out.println("monto : " + C.getMonto());
                    System.out.println("valor de la cuota: " + C.getCuotaMensual());
                    System.out.println("tasa : " + C.getTasa());
                    System.out.println("cantidad de cuotas : " + C.getCantCuotas());
                    System.out.println("--------------------------------------------------");
                }
            }
        } else {
            System.out.println("persona no existe");
        }
    }

    public void RF3() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ingrese codigo del credito a buscar : ");
        int cod = sc.nextInt();
        Credito C = buscarCredito(cod);
        if (C != null) {
            System.out.println("nombre : " + C.getRefPersona().getNomhre());
            System.out.println("apellido : " + C.getRefPersona().getApellido());
            System.out.println("estado : " + C.getEstado());
        }
    }

    public void RF4() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ingrese Codigo de la persona a buscar: ");
        int cod = sc.nextInt();
        Persona P = buscarPersona(cod);
        if (P != null) {
            eliminarPersona(P);
        } else {
            System.out.println("persona no existe");
        }
    }

    public void RF5() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ingrese codigo del credito: ");
        int cod = sc.nextInt();
        Credito C = buscarCredito(cod);
        if (C != null) {
            for (int i = 0; i < lp.getCantPersonas(); i++) {
                Persona P = lp.getPersona(i);
                for (int j = 0; j < P.getLc().getCantCreditos(); j++) {
                    Credito C2 = P.getLc().getCredito(j);
                    if (C.getCodigo() == C2.getCodigo()) {
                        boolean eliminar = P.getLc().eliminarPersona(C);
                        eliminarCredito(C);
                    }
                }
                int cant = P.getLc().getCantCreditos();
                if (cant == 0) {
                    eliminarPersona(P);
                }
            }
        } else {
            System.out.println("credito no existe");
        }
    }

    public void RF6() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ingrese codigo de la persona que solicitara el credito : ");
        int cod = sc.nextInt();
        Persona P = buscarPersona(cod);
        if (P != null) {
            if (P.getLc().getCantCreditos() == 10) {
                System.out.println("persona ya posee 10 creditos");
                return;
            } else {
                int nCredito = lc.getCantCreditos();
                int codigo = (nCredito + 1);
                System.out.print("ingrese monto solicitdado: ");
                double monto = sc.nextDouble();
                System.out.print("ingrese cantidad de cuotas: ");
                double cuotas = sc.nextDouble();
                System.out.print("ingrese tasa de interes: ");
                double tasa = sc.nextDouble();
                double interes = monto * 0.30;
                if (interes < tasa) {
                    System.out.println("tasa mayor al 30% no se puede ingresar credito");
                    return;
                } else {
                    double x = (monto / cuotas);
                    double valorCuota = x + (x * tasa);
                    Credito C = new Credito(codigo, monto, tasa, valorCuota, cuotas);
                    boolean aprobado = P.calcular(monto);
                    if (aprobado) {
                        System.out.println("credito aprobado y ingresado");
                        P.getLc().ingresarCredito(C);
                        ingresarCredito(C);
                    } else {
                        System.out.println("credito rechazado no se ingresara credito");
                    }
                }
            }
        } else {
            System.out.println("persona no existe");
        }

    }

    public void RF7() {
        Scanner sc = new Scanner(System.in);
        if (lp.getCantPersonas() != 100) {
            int codigo = (lp.getCantPersonas() + 1);
            System.out.print("ingrese su nombre: ");
            String nombre = sc.next();
            System.out.print("ingrese su apellido: ");
            String apellido = sc.next();
            System.out.print("ingrese edad: ");
            int edad = sc.nextInt();
            System.out.print("ingrese tipo de persona estudiante,tecnico o profesional: ");
            String tipo = sc.next();
            while (!tipo.equalsIgnoreCase("estudiante") && !tipo.equalsIgnoreCase("tecnico") && !tipo.equalsIgnoreCase("profesional")) {
                System.out.println("tipo ingresado no valido ingrese nuevamente");
                System.out.print("ingrese tipo de persona estudiante,tecnico o profesional: ");
                tipo = sc.next();
            }
            if (tipo.equalsIgnoreCase("estudiante")) {
                System.out.print("ingrese año actual de su carrera: ");
                int añoActual = sc.nextInt();
                System.out.print("ingrese año de duracion de su carrera: ");
                int años = sc.nextInt();
                Persona P = new Estudiante(añoActual, años, codigo, nombre, apellido, edad, tipo);
                ingresarPersona(P);
            } else if (tipo.equalsIgnoreCase("tecnico")) {
                System.out.print("ingrese su sueldo: ");
                int sueldo = sc.nextInt();
                System.out.print("ingrese su gasto mensual: ");
                int gasto = sc.nextInt();
                Persona P = new Tecnico(sueldo, gasto, codigo, nombre, apellido, edad, tipo);
                ingresarPersona(P);
            } else {
                System.out.print("ingrese sueldo: ");
                int sueldo = sc.nextInt();
                System.out.print("ingrese sus años de trabajo: ");
                int años = sc.nextInt();
                Persona P = new Profesional(sueldo, años, codigo, nombre, apellido, edad, tipo);
                ingresarPersona(P);
            }
            System.out.println("persona ingresada exitosmente");
        } else {
            System.out.println("banco ya posee 100 clientes no se pueden ingresar mas");
        }
    }

    @Override
    public void menu() {
        Scanner sc = new Scanner(System.in);
        int opcionmenu = 0;
        while (opcionmenu != 8) {
            System.out.println("menu: ");
            System.out.println("RF1(opcion 1)");
            System.out.println("RF2(opcion 2)");
            System.out.println("RF3(opcion 3)");
            System.out.println("RF4(opcion 4)");
            System.out.println("RF5(opcion 5)");
            System.out.println("RF6(opcion 6)");
            System.out.println("RF7(opcion 7)");
            System.out.println("salir opcion 8");
            System.out.println("------------------");
            System.out.print(">");
            opcionmenu = sc.nextInt();
            switch (opcionmenu) {
                case 1:
                    RF1();
                    break;
                case 2:
                    RF2();
                    break;
                case 3:
                    RF3();
                    break;
                case 4:
                    RF4();
                    break;
                case 5:
                    RF5();
                    break;
                case 6:
                    RF6();
                    break;
                case 7:
                    RF7();
                    break;
                default:
                    opcionmenu = 8;
            }
        }
    }

    @Override
    public void ordenarPersonas() {
        lp.ordenar();
    }

    @Override
    public void ordenarCreditos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarCredito(Credito C) {
        boolean sepudo = lc.eliminarPersona(C);
        if (sepudo) {
            System.out.println("credito eliminado");
        } else {
            System.out.println("no se pudo eliminar credito");
        }
    }

}
