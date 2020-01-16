package taller4ssemestre;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import java.util.regex.Pattern;
import ucn.*;

public class SistemaMensajeria implements Interface {

    private ListaPersonas lp;
    private ListaMensajes lm;
    private ListaAsignaturas la;
    private Out salida;

    public SistemaMensajeria() {
        lp = new ListaPersonas();
        lm = new ListaMensajes();
        la = new ListaAsignaturas();
        salida = new Out("ErroresDeRegistro.txt");

    }

    @Override
    public void leerAsignatuas() throws FileNotFoundException {
        salida.println("-------------------------------------------------------------------");
        salida.println("                      errores de registro                          ");
        salida.println("-------------------------------------------------------------------");
        salida.println("Categoria   Campo no valido    valor del campo    error encontrado ");
        salida.println("-------------------------------------------------------------------");
        Scanner sc = new Scanner(new File("asignaturas.txt"));
        while (sc.hasNextLine()) {
            String leelinea = sc.nextLine();
            String[] linea = leelinea.split(Pattern.quote("."));
            String codigo = linea[0];
            boolean validar1 = EsNumerico(codigo);
            if (validar1) {
                boolean validar2 = la.repetido(codigo);
                if (validar2 == false) {
                    String nombre = linea[1];
                    int cantPersonas = Integer.parseInt(linea[2]);
                    Asignatura A = new Asignatura(codigo, nombre, cantPersonas);
                    ingresarAsignatura(A);
                } else {
                    salida.println("Asignatura  codigo   " + codigo + " codigo repetido ");
                }
            } else {
                salida.println("Asignatura  codigo   " + codigo + " codigo no es numerico ");
            }
        }
        sc.close();
    }

    @Override
    public void leerPersonas() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("personas.txt"));
        while (sc.hasNextLine()) {
            String leelinea = sc.nextLine();
            String[] linea = leelinea.split(Pattern.quote("\\"));
            String rut = linea[0];
            boolean validar1 = validarRut(rut);
            if (validar1) {
                String nombre = linea[1];
                String apellido = linea[2];
                String correo = linea[3];
                boolean validar2 = validarCorreo(correo);
                if (validar2) {
                    String tipo = linea[4];
                    String alias = sacarAlias(correo);
                    if (tipo.equalsIgnoreCase("Alumno")) {
                        int cantMensajes = Integer.parseInt(linea[5]);
                        int cantAsignaturas = Integer.parseInt(linea[6]);
                        Persona P = new Alumno(cantAsignaturas, cantMensajes, rut, nombre, apellido, correo, alias);
                        ingresarPersona(P);
                    } else {
                        int cantEnviados = Integer.parseInt(linea[5]);
                        int cantResividos = Integer.parseInt(linea[6]);
                        Persona P = new Profesor(cantEnviados, cantResividos, rut, nombre, apellido, correo, alias);
                        ingresarPersona(P);
                    }
                } else {
                    salida.println("Persona  correo   " + correo + " correo no valido ");
                }
            } else {
                salida.println("Persona  rut   " + rut + " rut no valido ");
            }
        }
        sc.close();
    }

    @Override
    public void leerInscripciones() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("inscripciones.txt"));
        while (sc.hasNextLine()) {
            String leelinea = sc.nextLine();
            String[] linea = leelinea.split(",");
            String alias = linea[0];
            String cod = linea[1];
            Persona P = buscarPersonaXalias(alias);
            Asignatura A = buscarAsignatura(cod);
            P.getLa().ingresarAsignatura(A);
            A.getLp().ingresarPersona(P);
        }
        sc.close();
    }

    @Override
    public void ingresarPersona(Persona P) {
        lp.ingresarPersona(P);
    }

    @Override
    public void ingresarMensaje(Mensaje M) {
        lm.ingresarMensaje(M);
    }

    @Override
    public void ingresarAsignatura(Asignatura A) {
        la.ingresarAsignatura(A);
    }

    @Override
    public Persona buscarPersonaXrut(String rut) {
        Persona P = lp.buscarPersonaXrut(rut);
        return P;
    }

    @Override
    public Persona buscarPersonaXalias(String alias) {
        Persona P = lp.buscarPersonaXalias(alias);
        return P;
    }

    @Override
    public Asignatura buscarAsignatura(String codigo) {
        Asignatura A = la.buscarAsignatura(codigo);
        return A;
    }

    @Override
    public void menu() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 7) {
            System.out.println("\t [menu]");
            System.out.println("bienvenidos al sistema de mensajeria");
            System.out.println("1-Errores de registro");
            System.out.println("2-Desplegar personas por Asignatura");
            System.out.println("3-Enviar un mensaje");
            System.out.println("4-Registrar una nueva persona");
            System.out.println("5-Eliminar una persona de una asignatura");
            System.out.println("6-Acceder al registro de mensaje de una persona");
            System.out.println("7-salir: ");
            System.out.println("---------------------------------");
            System.out.print(">");
            opcion = sc.nextInt();
            switch (opcion) {
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
                default:
                    opcion = 7;
            }

        }
    }

    @Override
    public void RF1() {
        Out salida1 = salida;
        System.out.println("archivo generado");
    }

    @Override
    public void RF2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ingrese codigo de la asignatura: ");
        String cod = sc.next();
        Asignatura A = buscarAsignatura(cod);
        if (A != null) {
            NodoPersona actual = A.getLp().getFirst();
            System.out.println("-----------------------------------------------------");
            while (actual != null) {
                Persona P = actual.getPersona();
                System.out.println("rut: " + P.getRut());
                System.out.println("nombre: " + P.getNombre());
                System.out.println("apellido: " + P.getApellido());
                System.out.println("correo: " + P.getCorreo());
                System.out.println("alias: " + P.getAlias());
                if (P instanceof Alumno) {
                    System.out.println("cantidad de asignaturas inscrita: " + ((Alumno) P).getAsignaturasInscritas());
                    System.out.println("cantidad de mensajes enviados: " + ((Alumno) P).getMensajesEnviados());
                    System.out.println("-----------------------------------------------------");
                } else {
                    System.out.println("cantidad de mensajes enviados: " + ((Profesor) P).getMensajesEnviados());
                    System.out.println("cantidad de mensajes recibidos: " + ((Profesor) P).getMensajesRecibidos());
                    System.out.println("-----------------------------------------------------");
                }
                actual = actual.getNext();
            }
        } else {
            System.out.println("asignatura no existe");
        }
    }

    @Override
    public void RF3() {
        Date fecha = new Date();
        String f = String.valueOf(fecha.toLocaleString());
        Scanner sc = new Scanner(System.in);
        System.out.print("ingrese su alias: ");
        String alias = sc.next();
        Persona P = buscarPersonaXalias(alias);
        if (P != null) {
            System.out.print("ingrese codigo de la asignatura a la cual enviara el mensaje: ");
            String cod = sc.next();
            Asignatura A = P.getLa().buscarAsignatura(cod);
            if (A != null) {
                System.out.println("----------------------------");
                System.out.println("seleccione destinatario ");
                System.out.println("----------------------------");
                NodoPersona actual = A.getLp().getFirst();
                int i = 1;
                while (actual != null) {
                    Persona destinatario = actual.getPersona();
                    if (!destinatario.getAlias().equalsIgnoreCase(alias)) {
                        System.out.println("[" + i + "]" + destinatario.getAlias());
                        i++;
                    }
                    actual = actual.getNext();
                }
                System.out.print("ingrese alias del destinatario o 0 para cancelar: ");
                String opcion = sc.next();
                if (opcion.equalsIgnoreCase("0")) {
                    System.out.println("mensaje cancelado");
                    return;
                }
                Persona P2 = buscarPersonaXalias(opcion);
                if (P2 != null) {
                    System.out.println("ingrese mensaje para " + opcion + ":");
                    String mensaje = sc.nextLine();
                    boolean validar = validarMensaje(mensaje);
                    if (validar) {
                        System.out.print("asunto: ");
                        String asunto = sc.next();
                        Mensaje M = new Mensaje(f, asunto, alias, opcion, mensaje);
                        P2.getLm().ingresarMensaje(M);
                        P.getLm().ingresarMensaje(M);
                        ingresarMensaje(M);
                        System.out.println("---------------------------------");
                        System.out.println("mensaje enviado con exito");
                    } else {
                        System.out.println("mensaje tiene mas de 100 caracteres");
                    }
                } else {
                    System.out.println("alias ingresado no valido");
                }
            } else {
                System.out.println("asignatura no existe");
            }
        } else {
            System.out.println("persona no existe");
        }
    }

    @Override
    public void RF4() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(new File("asignaturas.txt"));
        System.out.print("ingrese rut: ");
        String rut = sc.next();
        boolean Vrut = validarRut(rut);
        if (Vrut) {
            System.out.print("ingrese nombre: ");
            String nombre = sc.next();
            System.out.print("ingrese apellido: ");
            String apellido = sc.next();
            System.out.print("ingres su correo: ");
            String correo = sc.next();
            boolean Vcorreo = validarCorreo(correo);
            if (Vcorreo) {
                String alias = sacarAlias(correo);
                System.out.print("ingrese tipo de persona [1]Profesor o [2]Alumno: ");
                int tipo = sc.nextInt();
                if (tipo == 2) {
                    System.out.print("ingrese cantidad de asignaturas inscritas: ");
                    int cantAsig = sc.nextInt();
                    System.out.print("ingrese cantidad de mensajes enviados: ");
                    int cantMen = sc.nextInt();
                    Persona P = new Alumno(cantAsig, cantMen, rut, nombre, apellido, correo, alias);
                    ingresarPersona(P);
                    System.out.println("persona ingresada exitosamente");
                } else {
                    System.out.print("ingrese cantidad de mensajes enviados: ");
                    int enviados = sc.nextInt();
                    System.out.print("ingrese cantidad de mensajes recibidos: ");
                    int recibidos = sc.nextInt();
                    Persona P = new Profesor(enviados, recibidos, rut, nombre, apellido, correo, alias);
                    ingresarPersona(P);
                    System.out.println("persona ingresada exitosamente");
                }
            } else {
                salida.println("Persona  correo   " + correo + " correo no valido ");
                System.out.println("persona no registrada correo no valido");
            }
        } else {
            salida.println("Persona  rut   " + rut + " rut no valido ");
            System.out.println("persona no registrada rut invalido");
        }

    }

    @Override
    public void RF5() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ingrese codigo de la asignatura: ");
        String cod = sc.next();
        Asignatura A = buscarAsignatura(cod);
        if (A != null) {
            System.out.print("ingrese alias de la persona: ");
            String alias = sc.next();
            Persona P = A.getLp().buscarPersonaXalias(alias);
            if (P != null) {
                if (P instanceof Alumno) {
                    if (((Alumno) P).getAsignaturasInscritas() == 1) {
                        System.out.println("persona tiene una sola asignatura no se puede eliminar");
                    } else {
                        A.getLp().eliminarPersona(P.getRut());
                        P.getLa().eliminarAsignatura(cod);
                        ((Alumno) P).setAsignaturasInscritas(((Alumno) P).getAsignaturasInscritas()-1);
                        System.out.println("persona eliminada");
                    }
                } else {
                    System.out.println("persona es un profesor");
                }
            } else {
                System.out.println("persona no existe");
            }
        } else {
            System.out.println("asignatura no existe");
        }
    }

    @Override
    public void RF6() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ingrese alias de la persona: ");
        String alias = sc.next();
        Persona P = buscarPersonaXalias(alias);
        int i = 1;
        if (P != null) {
            NodoMensaje actual = P.getLm().getFirst();
            if (actual != null) {
                System.out.println("---------------------------------------------------");
                System.out.println("Lista de mensajes enviados y recibidos por: " + P.getAlias());
                System.out.println("---------------------------------------------------");
                do {
                    Mensaje M = actual.getMensaje();
                    System.out.println("mensaje " + i);
                    System.out.println("------------------------------------------------");
                    System.out.println("fecha y hora: " + M.getFecha());
                    Persona P2 = buscarPersonaXalias(M.getEmisor());
                    Persona P3 = buscarPersonaXalias(M.getDestinatario());
                    if (M.getEmisor().equalsIgnoreCase(P2.getAlias())) {
                        System.out.println("emisor: " + M.getEmisor() + "(" + P2.getNombre() + ")");
                    } else {
                        System.out.println("emisor: " + M.getEmisor() + "(" + P.getNombre() + ")");
                    }
                    if (M.getDestinatario().equalsIgnoreCase(P3.getAlias())) {
                        System.out.println("receptor : " + M.getDestinatario() + "(" + P3.getNombre() + ")");
                    } else {
                        System.out.println("receptor : " + M.getDestinatario() + "(" + P.getNombre() + ")");
                    }
                    System.out.println("asunto: " + M.getAsunto());
                    System.out.println("mensaje: " + M.getTexto());
                    actual = actual.getNext();
                } while (actual != P.getLm().getFirst());
            } else {
                System.out.println("persona no tiene mensajes");
            }
        } else {
            System.out.println("persona no existe");
        }
    }

    @Override
    public boolean validarRut(String rut) {
        boolean validacion = false;
        try {
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }

    @Override
    public String sacarAlias(String correo) {
        String alias;
        StringBuilder sb = new StringBuilder();
        char[] frase = correo.toCharArray();
        int i = 0;
        while (frase[i] != '@') {
            sb.append(frase[i]);
            i++;
        }
        alias = sb.toString();
        return alias;
    }

    @Override
    public boolean validarCorreo(String correo) {
        String extension;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        char[] frase = correo.toCharArray();
        int i = 0;
        sb2.append(frase[i]);
        String primera = sb2.toString();
        boolean numero = EsNumerico(primera);
        if (numero) {
            return false;
        } else {
            int tamaño = 0;
            while (i < frase.length) {
                if (frase[i] == '@') {
                    tamaño = 10;
                }
                if (tamaño == 10) {
                    sb.append(frase[i]);
                }
                i++;
            }
            extension = sb.toString();
            if (extension.equalsIgnoreCase("@gmail.com")) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public boolean EsNumerico(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    @Override
    public boolean validarCodigo(String codigo) {
        boolean valido = EsNumerico(codigo);
        if (valido) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean validarMensaje(String texto) {
        StringBuilder sb = new StringBuilder();
        char[] frase = texto.toCharArray();
        int pos = 0;
        while (pos < frase.length) {
            if (frase[pos] == ' ') {
            } else {
                sb.append(frase[pos]);
            }
            pos++;
        }
        if (sb.length() > 100) {
            return false;
        } else {
            return true;
        }

    }

}
