package taller4_s1_2018;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import ucn.In;
import ucn.Out;

public class Taller4_s1_2018 {

    public static void leerInstrumentos(IBlueSky sistema) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("instrumentos.txt"));
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] linesplit = line.split(",");
            String id = linesplit[0];
            String marca = linesplit[1];
            boolean disponible = Boolean.valueOf(linesplit[2]);
            String tipo = linesplit[3];
            Instrumento I;
            if (tipo.equalsIgnoreCase("T")) {
                String tipoTelescopio = linesplit[4];
                String montura = linesplit[5];
                I = new Telescopio(tipoTelescopio, montura, id, disponible, marca);
            } else {
                String tipoPrisma = linesplit[4];
                int aumento = Integer.parseInt(linesplit[5]);
                int diametro = Integer.parseInt(linesplit[6]);
                I = new Binocular(tipoPrisma, aumento, diametro, id, disponible, marca);
            }
            sistema.IngresarInstrumento(I);
        }
        sc.close();
    }

    public static void leerSocios(IBlueSky sistema) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("socios.txt"));
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] linesplit = line.split(",");
            String rut = linesplit[0];
            String nombre = linesplit[1];
            boolean admin = Boolean.valueOf(linesplit[2]);
            int cuota = Integer.parseInt(linesplit[3]);
            /*  SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            String sfecha = linesplit[4];
            Date fecha = formato.parse(sfecha);*/
            String clave = linesplit[4];
            Socio s = new Socio(rut, clave, nombre, cuota, admin);
            sistema.IngresarSocio(s);
        }
        sc.close();
    }

    public static void leerPrestamos(IBlueSky sistema) throws FileNotFoundException, ParseException {
        In entrada = new In("prestamos.txt");
        while (!entrada.isEmpty()) {
            String line = entrada.readLine();
            String[] linesplit = line.split(",");
            String rut = linesplit[0];
            String id = linesplit[1];
            String idInstrumento = linesplit[2];
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            String sfecha = linesplit[3];
            Date fecha = formato.parse(sfecha);
            String estado = linesplit[4];
            Socio s = sistema.buscarSocio(rut);
            Instrumento i = sistema.buscarInstrumento(idInstrumento);
            Prestamo p = new Prestamo(id, fecha, estado);
            p.setInstrumento(i);
            p.setSocio(s);
            s.getLp().ingresar(p);
            sistema.IngresarPrestamo(p);
        }
        entrada.close();
    }

    public static void leerEventos(IBlueSky sistema) throws FileNotFoundException, ParseException {
        In entrada = new In("eventos.txt");
        while (!entrada.isEmpty()) {
            String line = entrada.readLine();
            String[] linesplit = line.split(",");
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            String sfecha = linesplit[0];
            Date fecha = formato.parse(sfecha);
            String descripcion = linesplit[1];
            FiestaEstelar fe = new FiestaEstelar(fecha, descripcion);
            sistema.IngresarFiestaEstelar(fe);
        }
        entrada.close();
    }

    public static void leerEventos_Socio(IBlueSky sistema) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("evento_socio.txt"));
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] linesplit = line.split(",");
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            String sfecha = linesplit[0];
            Date fecha = formato.parse(sfecha);
            String rutSocio = linesplit[1];
            Socio s = sistema.buscarSocio(rutSocio);
            FiestaEstelar fe = sistema.buscarFiestaEstelar(fecha);
            fe.getListaAsistentes().add(s);
        }
        sc.close();
    }

    public static void guardarDatos(IBlueSky sistema) throws IOException {
        Out salida = new Out("instrumentos.txt");
        Iterator<Instrumento> it = sistema.getListaInstrumentos().iterator();
        while (it.hasNext()) {
            Instrumento I = it.next();
            if (I instanceof Telescopio) {
                salida.print(I.getIdIntrumento() + "," + I.getMarca() + "," + I.isDisponible() + ",T," + ((Telescopio) I).getTipo() + "," + ((Telescopio) I).getMontura());
            } else {
                salida.print(I.getIdIntrumento() + "," + I.getMarca() + "," + I.isDisponible() + ",B," + ((Binocular) I).getTipoPrisma() + "," + ((Binocular) I).getAumentos() + "," + ((Binocular) I).getDiametroApertura());
            }
            if (it.hasNext()) {
                salida.println();
            }
        }
        //--------------------------------------
        Out salida2 = new Out("socios.txt");
        Iterator<Socio> it2 = sistema.getListaSocios().iterator();
        while (it2.hasNext()) {
            Socio s = it2.next();
            salida2.print(s.getRut() + "," + s.getNombreCompleto() + "," + s.isAdministradir() + "," + s.getCuotaMensual() + "," + s.getPassword());
            if (it2.hasNext()) {
                salida2.println();
            }
        }
        //--------------------------------------
        Out salida3 = new Out("prestamos.txt");
        NodoPrestamo actual = sistema.getListaPrestamos().getFirst();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        while (actual != null) {
            Prestamo p = actual.getPrestamo();
            salida3.print(p.getSocio().getRut() + "," + p.getIdprestamo() + "," + p.getInstrumento().getIdIntrumento() + "," + formato.format(p.getFechaSolicitud()) + "," + p.getEstado());
            if (actual.getNext() != null) {
                salida3.println();
            }

            actual = actual.getNext();
        }
        //--------------------------------------
        Out salida4 = new Out("eventos.txt");
        Out salida5 = new Out("evento_socio.txt");
        Iterator<FiestaEstelar> it3 = sistema.getListaFiestaEstelares().iterator();
        while (it3.hasNext()) {
            FiestaEstelar fe = it3.next();
            salida4.print(formato.format(fe.getFechaEvento()) + "," + fe.getDescripcion());
            if (it3.hasNext()) {
                salida4.println();
            }
            Iterator<Socio> it4 = fe.getListaAsistentes().iterator();
            while (it4.hasNext()) {
                Socio s = it4.next();
                salida5.print(formato.format(fe.getFechaEvento()) + "," + s.getRut());
                if (it3.hasNext()) {
                    salida5.println();
                }
            }
        }
    }

    public static void menuSesion(IBlueSky sistema, Scanner sc) throws IOException {
        try {
            int opcion = 0;
            while (opcion != 3) {
                System.out.println("1.- Registrarse en la plataforma");
                System.out.println("2.- Iniciar sesión");
                System.out.println("3.- Cerrar programa");
                System.out.print("ingrese opcion : ");
                opcion = sc.nextInt();
                while (opcion < 1 || opcion > 3) {
                    System.out.println("opcion no valida intente nuevamente");
                    System.out.print("ingrese opcion : ");
                    opcion = sc.nextInt();
                }
                switch (opcion) {
                    case 1:
                        System.out.println("---------------------------------------");
                        ingresarSocio(sistema, sc);
                        System.out.println("---------------------------------------");
                        break;
                    case 2:
                        System.out.println("---------------------------------------");
                        iniciarSesion(sistema, sc);
                        System.out.println("---------------------------------------");
                        break;
                    default:
                        opcion = 3;
                        guardarDatos(sistema);
                        System.out.println("---------------------------------------");
                        System.out.println("Adios");
                }
            }
        } catch (Exception e) {
            System.out.println("tipo de dato no valido");
        }
    }

    public static void menuLoegeado(IBlueSky sistema, Scanner sc) {
        try {
            int opcion = 0;
            while (opcion != 4) {
                System.out.println("Datos del socio :");
                System.out.println("--------------------------------------------------------------------");
                System.out.println("Nombre: " + sistema.getUsuario().getNombreCompleto() + " Cuota Mensual: " + sistema.getUsuario().getCuotaMensual());
                System.out.println("--------------------------------------------------------------------");
                System.out.println("1.- Inscribirse a un evento");
                System.out.println("2.- Pedir prestamo");
                System.out.println("3.- Devolver instrumento prestado");
                System.out.println("4.- Cerrar sesion");
                System.out.print("ingrese opcion : ");
                opcion = sc.nextInt();
                while (opcion < 1 || opcion > 4) {
                    System.out.println("opcion no valida intente nuevamente");
                    System.out.print("ingrese opcion : ");
                    opcion = sc.nextInt();
                }
                switch (opcion) {
                    case 1:
                        System.out.println("---------------------------------------");
                        Inscribir_A_Evento(sistema, sc);
                        System.out.println("---------------------------------------");
                        break;
                    case 2:
                        System.out.println("---------------------------------------");
                        PedirPrestamo(sistema, sc);
                        System.out.println("---------------------------------------");
                        break;
                    case 3:
                        System.out.println("---------------------------------------");
                        devolverInstrumento(sistema, sc);
                        System.out.println("---------------------------------------");
                        break;
                    default:
                        opcion = 4;
                        sistema.setUsuario(null);
                        System.out.println("---------------------------------------");
                        System.out.println("Sesion cerrada");
                }
            }
        } catch (Exception e) {
            System.out.println("---------------------------------------");
            System.out.println("tipo de dato invalido");
        }
    }

    public static void menuLoegeadoAdmin(IBlueSky sistema, Scanner sc) {
        try {
            int opcion = 0;
            while (opcion != 11) {
                System.out.println("Datos del socio :");
                System.out.println("--------------------------------------------------------------------");
                System.out.println("Nombre: " + sistema.getUsuario().getNombreCompleto() + " Cuota Mensual: " + sistema.getUsuario().getCuotaMensual());
                System.out.println("--------------------------------------------------------------------");
                System.out.println("1.- Inscribirse a un evento");
                System.out.println("2.- Pedir prestamo");
                System.out.println("3.- Devolver instrumento prestado");
                System.out.println("4.- Revisar solicitudes de préstamos");
                System.out.println("5.- Inscribir nuevo socio");
                System.out.println("6.- Convertir socio en administrador");
                System.out.println("7.- Ingresar nuevo instrumento");
                System.out.println("8.- Organizar evento");
                System.out.println("9.- Consultar informacion evento");
                System.out.println("10.- Cancelar un evento");
                System.out.println("11.- Cerrar sesion");
                System.out.print("ingrese opcion : ");
                opcion = sc.nextInt();
                while (opcion < 1 || opcion > 11) {
                    System.out.println("opcion no valida intente nuevamente");
                    System.out.print("ingrese opcion : ");
                    opcion = sc.nextInt();
                }
                switch (opcion) {
                    case 1:
                        System.out.println("---------------------------------------");
                        Inscribir_A_Evento(sistema, sc);
                        System.out.println("---------------------------------------");
                        break;
                    case 2:
                        System.out.println("---------------------------------------");
                        PedirPrestamo(sistema, sc);
                        System.out.println("---------------------------------------");
                        break;
                    case 3:
                        System.out.println("---------------------------------------");
                        devolverInstrumento(sistema, sc);
                        System.out.println("---------------------------------------");
                        break;
                    case 4:
                        System.out.println("---------------------------------------");
                        revisarEstadoPrestamos(sistema, sc);
                        System.out.println("---------------------------------------");
                        break;
                    case 5:
                        System.out.println("---------------------------------------");
                        ingresarSocio(sistema, sc);
                        System.out.println("---------------------------------------");
                        break;
                    case 6:
                        System.out.println("---------------------------------------");
                        volverAdmin(sistema, sc);
                        System.out.println("---------------------------------------");
                        break;
                    case 7:
                        System.out.println("---------------------------------------");

                        System.out.println("---------------------------------------");
                        break;
                    case 8:
                        System.out.println("---------------------------------------");

                        System.out.println("---------------------------------------");
                        break;
                    case 9:
                        System.out.println("---------------------------------------");

                        System.out.println("---------------------------------------");
                        break;
                    case 10:
                        System.out.println("---------------------------------------");

                        System.out.println("---------------------------------------");
                        break;
                    default:
                        opcion = 11;
                        sistema.setUsuario(null);
                        System.out.println("---------------------------------------");
                        System.out.println("Sesion cerrada");
                }
            }
        } catch (Exception e) {
            System.out.println("---------------------------------------");
            System.out.println("tipo de dato invalido");
        }
    }

    public static void iniciarSesion(IBlueSky sistema, Scanner sc) {
        try {
            System.out.print("ingrese rut: ");
            String rut = sc.next();
            Socio s = sistema.buscarSocio(rut);
            if (s != null) {
                System.out.print("ingrese contraseña: ");
                String pw = sc.next();
                while (!s.getPassword().equalsIgnoreCase(pw)) {
                    System.out.println("contraseña incorrecta");
                    System.out.print("ingrese contraseña: ");
                    pw = sc.next();
                }
                System.out.println("inicio de sesion correctamente");
                System.out.println("----------------------------------------");
                sistema.setUsuario(s);
                if (s.isAdministradir()) {
                    menuLoegeadoAdmin(sistema, sc);
                } else {
                    menuLoegeado(sistema, sc);
                }
            } else {
                System.out.println("socio no registrado");
            }
        } catch (Exception e) {
            System.out.println("tipo de dato no valido");
        }
    }

    public static void PedirPrestamo(IBlueSky sistema, Scanner sc) {
        try {
            System.out.print("ingrese tipo de prestamos [1] Telescopio o [2] Binocular: ");
            int tipo = sc.nextInt();
            while (tipo < 1 || tipo > 2) {
                System.out.println("tipo invalido");
                System.out.print("ingrese tipo de prestamos [1] Telescopi o [2] Binocular: ");
                tipo = sc.nextInt();
            }
            if (tipo == 1) {
                try {
                    System.out.print("ingrese tipo de telescopio [G] galileano o [N] newtoniano o [C] catadióptrico: ");
                    String tipotele = sc.next();
                    while (!tipotele.equals("G") && !tipotele.equals("N") && !tipotele.equals("C")) {
                        System.out.println("tipo invalido");
                        System.out.print("ingrese tipo de telescopio [G] galileano o [N] newtoniano o [C] catadióptrico: ");
                        tipotele = sc.next();
                    }
                    System.out.print("ingrese tipo de montura [A] altacimutal o [E] ecuatorial o [-] otro: ");
                    String tipoMon = sc.next();
                    while (!tipoMon.equals("A") && !tipoMon.equals("E") && !tipoMon.equals("-")) {
                        System.out.println("tipo invalido");
                        System.out.print("ingrese tipo de montura [A] altacimutal o [E] ecuatorial o [-] otro: ");
                        tipoMon = sc.next();
                    }
                    Collections.sort(sistema.getListaInstrumentos());
                    Iterator<Instrumento> it = sistema.getListaInstrumentos().iterator();
                    System.out.println("Lista de Instrumentos disponibles");
                    int cant = 0;
                    while (it.hasNext()) {
                        Instrumento i = it.next();
                        if (i instanceof Telescopio) {
                            if (((Telescopio) i).getTipo().equals(tipotele) && ((Telescopio) i).getMontura().endsWith(tipoMon)) {
                                if (i.isDisponible()) {
                                    System.out.println((cant + 1) + ".- " + i.getIdIntrumento());
                                    cant++;
                                }
                            }
                        }
                    }
                    if (cant != 0) {
                        try {
                            System.out.print("ingrese id del instrumento a solicitar: ");
                            String id = sc.next();
                            Instrumento i = sistema.buscarInstrumento(id);
                            while (i == null) {
                                System.out.println("id invalida");
                                System.out.print("ingrese id del instrumento a solicitar: ");
                                id = sc.next();
                                i = sistema.buscarInstrumento(id);
                            }
                            String idprestamo = "";
                            int idaux = Integer.parseInt(sistema.getListaPrestamos().getFirst().getPrestamo().getIdprestamo()) + 1;
                            idprestamo = String.valueOf(idaux);
                            Prestamo p = new Prestamo(idprestamo, sistema.getFecha(), "pendiente");
                            i.setDisponible(false);
                            p.setInstrumento(i);
                            p.setSocio(sistema.getUsuario());
                            sistema.getUsuario().getLp().ingresar(p);
                            sistema.IngresarPrestamo(p);
                            System.out.println("prestamo solicitado exitosamente");
                        } catch (Exception e) {
                            System.out.println("dato no valido");
                        }
                    } else {
                        System.out.println("no hay telescopio disponible con sus caracteristicas");
                    }
                } catch (Exception e) {
                    System.out.println("dato no valido");
                }
            } else {
                try {
                    System.out.print("ingrese tipo de prisma [P] porro o [R] roof");
                    String tipoPrisma = sc.next();
                    while (!tipoPrisma.equals("P") && !tipoPrisma.equals("R")) {
                        System.out.println("tipo invalido");
                        System.out.print("ingrese tipo de prisma [P] porro o [R] roof");
                        tipoPrisma = sc.next();
                    }
                    Collections.sort(sistema.getListaInstrumentos());
                    Iterator<Instrumento> it = sistema.getListaInstrumentos().iterator();
                    System.out.println("Lista de Instrumentos disponibles");
                    int cant = 0;
                    while (it.hasNext()) {
                        Instrumento i = it.next();
                        if (i instanceof Binocular) {
                            if (((Binocular) i).getTipoPrisma().equals(tipoPrisma)) {
                                if (i.isDisponible()) {
                                    System.out.println((cant + 1) + ".- " + i.getIdIntrumento());
                                    cant++;
                                }
                            }
                        }
                    }
                    if (cant != 0) {
                        try {
                            System.out.print("ingrese id del isntrumento a solicitar: ");
                            String id = sc.next();
                            Instrumento i = sistema.buscarInstrumento(id);
                            while (i == null) {
                                System.out.println("id invalida");
                                System.out.print("ingrese id del isntrumento a solicitar: ");
                                id = sc.next();
                                i = sistema.buscarInstrumento(id);
                            }
                            String idprestamo = "";
                            int idaux = Integer.parseInt(sistema.getListaPrestamos().getFirst().getPrestamo().getIdprestamo()) + 1;
                            idprestamo = String.valueOf(idaux);
                            Prestamo p = new Prestamo(idprestamo, sistema.getFecha(), "pendiente");
                            i.setDisponible(false);
                            p.setInstrumento(i);
                            p.setSocio(sistema.getUsuario());
                            sistema.getUsuario().getLp().ingresar(p);
                            sistema.IngresarPrestamo(p);
                            System.out.println("prestamo solicitado exitosamente");
                        } catch (Exception e) {
                            System.out.println("dato no valido");
                        }
                    } else {
                        System.out.println("no hay binoculares disponible con sus caracteristicas");
                    }
                } catch (Exception e) {
                    System.out.println("dato no valido");
                }
            }
        } catch (Exception e) {
            System.out.println("tipo de dato invalido");
        }
    }

    public static void revisarEstadoPrestamos(IBlueSky sistema, Scanner sc) {
        try {
            System.out.println("Lista de Prestamos pendientes: ");
            NodoPrestamo actual = sistema.getListaPrestamos().getFirst();
            int cant = 0;
            if (actual != null) {
                while (actual != null) {
                    Prestamo p = actual.getPrestamo();
                    if (p.getEstado().equalsIgnoreCase("pendiente")) {
                        System.out.println("id.- " + p.getIdprestamo());
                        cant++;
                    }
                    actual = actual.getNext();
                }
                if (cant != 0) {
                    System.out.print("ingrese id del prestamo: ");
                    String id = sc.next();
                    Prestamo p = sistema.buscarPrestamo(id);
                    if (p != null) {
                        System.out.print("ingrese [1] aceptar o [2] rechazar: ");
                        int opc = sc.nextInt();
                        while (opc < 1 || opc > 2) {
                            System.out.println("opcion invalida");
                            System.out.print("ingrese [1] aceptar o [2] rechazar: ");
                            opc = sc.nextInt();
                        }
                        if (opc == 1) {
                            p.setEstado("aceptado");
                            System.out.println("prestamo aceptado");
                        } else {
                            p.setEstado("rechazado");
                            p.getInstrumento().setDisponible(true);
                            System.out.println("prestamo rechazado");
                        }
                    } else {
                        System.out.println("id invalida");
                    }
                } else {
                    System.out.println("no hay prestamos pendientes");
                }
            } else {
                System.out.println("no hay prestamos registrado");
            }
        } catch (Exception e) {
            System.out.println("tipo de dato invalido");
        }
    }

    public static void devolverInstrumento(IBlueSky sistema, Scanner sc) {
        try {
            NodoPrestamo actual = sistema.getUsuario().getLp().getFirst();
            if (actual != null) {
                System.out.println("instrumentos conseguidos por el Socio: " + sistema.getUsuario().getNombreCompleto());
                int i = 0;
                while (actual != null) {
                    if (actual.getPrestamo().getEstado().equalsIgnoreCase("aceptado") && actual.getPrestamo().getInstrumento().isDisponible() == false) {
                        System.out.println((i + 1) + ".- " + actual.getPrestamo().getInstrumento().getIdIntrumento());
                    }
                    actual = actual.getNext();
                }
                if (i != 0) {
                    System.out.print("ingrese id del instrumento a devolver: ");
                    String id = sc.next();
                    Instrumento ins = sistema.buscarInstrumento(id);
                    if (ins != null) {
                        ins.setDisponible(true);
                        NodoPrestamo actual2 = sistema.getUsuario().getLp().getFirst();
                        Instrumento i2 = null;
                        while (actual2 != null) {
                            if (actual2.getPrestamo().getInstrumento().getIdIntrumento().equalsIgnoreCase(id)) {
                                i2 = actual2.getPrestamo().getInstrumento();
                                break;
                            }
                            actual2 = actual2.getNext();
                        }
                        i2.setDisponible(true);
                        System.out.println("instrumento devuelto");
                    } else {
                        System.out.println("id invalida");
                    }
                }else{
                    System.out.println("no tiene prestamos pendientes");
                }
            } else {
                System.out.println("socio no tiene prestamos registrado");
            }
        } catch (Exception e) {
            System.out.println("tipo de dato invalido");
        }
    }

    public static void Inscribir_A_Evento(IBlueSky sistema, Scanner sc) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Iterator<FiestaEstelar> it = sistema.getListaFiestaEstelares().iterator();
            if (it != null) {
                int cant = 0;
                System.out.println("Lista de eventos disponibles: ");
                while (it.hasNext()) {
                    FiestaEstelar fe = it.next();
                    if (fe.getFechaEvento().compareTo(sistema.getFecha()) > 0) {
                        System.out.println("fecha: " + formato.format(fe.getFechaEvento()) + fe.getDescripcion());
                        cant++;
                    }
                }
                if (cant != 0) {
                    System.out.print("ingrese fecha (dd/MM/yyyy): ");
                    String f = sc.next();
                    Date d = formato.parse(f);
                    if (d.compareTo(sistema.getFecha()) > 0) {
                        FiestaEstelar fe = sistema.buscarFiestaEstelar(d);
                        if (fe != null) {
                            fe.getListaAsistentes().add(sistema.getUsuario());
                            System.out.println("registrado en evento exitosamente");
                        } else {
                            System.out.println("fecha no valida");
                        }
                    } else {
                        System.out.println("fecha anterior a la actual no se puede registrar");
                    }
                } else {
                    System.out.println("no hay eventos disponibles");
                }
            } else {
                System.out.println("no hay eventos registrados");
            }
        } catch (Exception e) {
            System.out.println("tipo de dato invalido");
        }
    }

    public static void ingresarSocio(IBlueSky sistema, Scanner sc) {
        try {
            System.out.print("ingrese rut: ");
            String rut = sc.next();
            Socio s = sistema.buscarSocio(rut);
            if (s == null) {
                sc.nextLine();
                System.out.print("ingrese nombre completo : ");
                String nombre = sc.nextLine();
                System.out.print("ingrese cuota mensual: ");
                int cuota = sc.nextInt();
                while (cuota < 30000 || cuota > 500000) {
                    System.out.println("cuota fuera de rango");
                    System.out.print("ingrese cuota mensual: ");
                    cuota = sc.nextInt();
                }
                System.out.print("ingrese contraseña: ");
                String psw = sc.next();
                Socio so = new Socio(rut, psw, nombre, cuota, false);
                sistema.IngresarSocio(so);
                System.out.println("socio registrado exitosamente");
            } else {
                System.out.println("rut ya registrado");
            }
        } catch (Exception e) {
            System.out.println("tipo de dato no valido");
        }
    }

    public static void volverAdmin(IBlueSky sistema, Scanner sc) {
        try {
            System.out.print("ingrese rut: ");
            String rut = sc.next();
            Socio s = sistema.buscarSocio(rut);
            if (s != null) {
                if (s.isAdministradir()) {
                    System.out.println("socio ya es administrador");
                } else {
                    s.setAdministradir(true);
                    System.out.println("socio ahora es administrador");
                }
            } else {
                System.out.println("socio no encontrado");
            }
        } catch (Exception e) {
            System.out.println("tipo de dato no valido");
        }
    }

    public static void main(String[] args) throws ParseException, FileNotFoundException, IOException {
        System.out.println("BIENVENIDO");
        Date d = new Date();
        String fecha = new SimpleDateFormat("dd/MM/yyyy").format(d);
        System.out.println("La Fecha de hoy es: " + fecha);
        IBlueSky sistema = new BlueSky(fecha);
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------------------");
        leerInstrumentos(sistema);
        leerSocios(sistema);
        leerPrestamos(sistema);
        leerEventos(sistema);
        leerEventos_Socio(sistema);
        menuSesion(sistema, sc);
    }
}
