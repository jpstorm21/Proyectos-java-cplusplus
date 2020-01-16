package taller2sgosmestre;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import ucn.*;

public class Taller2SGOSmestre {

    public static void leerClientes(ListaClientes lc, Scanner sc) throws FileNotFoundException {
        sc = new Scanner(new File("clientes.txt"));
        while (sc.hasNextLine()) {
            String leelinea = sc.nextLine();
            String[] linea = leelinea.split(",");
            String rut = linea[0];
            String nombre = linea[1];
            String apellido = linea[2];
            int numero = Integer.parseInt(linea[3]);
            String correo = linea[4];
            Cliente C = new Cliente(rut, nombre, apellido, numero, correo);
            lc.ingresar(C);
        }
        sc.close();
    }

    public static void leerLibros(ListaLibros lb, Scanner sc) throws FileNotFoundException {
        sc = new Scanner(new File("libros.txt"));
        while (sc.hasNextLine()) {
            String leelinea = sc.nextLine();
            String[] linea = leelinea.split(",");
            String identificador = linea[0];
            String titulo = linea[1];
            String autor = linea[2];
            int año = Integer.parseInt(linea[3]);
            Libro L = new Libro(identificador, titulo, autor, año);
            lb.ingresar(L);
        }
        sc.close();
    }

    public static void leerPrestamos(ListaPrestamos lp, Scanner sc, ListaClientes lc, ListaLibros lb) throws FileNotFoundException {
        sc = new Scanner(new File("prestamos.txt"));
        while (sc.hasNextLine()) {
            String leelinea = sc.nextLine();
            String[] linea = leelinea.split(",");
            String codigo = linea[0];
            String rut = linea[1];
            Cliente C = lc.buscarCliente(rut);
            String identificador = linea[2];
            Libro L = lb.buscarLibro(identificador);
            String fechaPrestado = linea[3];
            String[] linea2 = fechaPrestado.split("-");
            int fechaPrestadoDia = Integer.parseInt(linea2[0]);
            int fechaPrestadoMes = Integer.parseInt(linea2[1]);
            int fechaPrestadoAño = Integer.parseInt(linea2[2]);
            Fecha Fprestado = new Fecha(fechaPrestadoDia, fechaPrestadoMes, fechaPrestadoAño);
            String fechaEstimada = linea[4];
            String[] linea3 = fechaEstimada.split("-");
            int fechaEstimadaDia = Integer.parseInt(linea3[0]);
            int fechaEstimadaMes = Integer.parseInt(linea3[1]);
            int fechaEstimadaAño = Integer.parseInt(linea3[2]);
            Fecha Festimado = new Fecha(fechaEstimadaDia, fechaEstimadaMes, fechaEstimadaAño);
            String fechaDevuleto = linea[5];
            Fecha Fdevuelto = null;
            if (!fechaDevuleto.equalsIgnoreCase("0")) {
                String[] linea4 = fechaDevuleto.split("-");
                int fechaDevuletoDia = Integer.parseInt(linea4[0]);
                int fechaDevuletoMes = Integer.parseInt(linea4[1]);
                int fechaDevuletoAño = Integer.parseInt(linea4[2]);
                Fdevuelto = new Fecha(fechaDevuletoDia, fechaDevuletoMes, fechaDevuletoAño);
            } else {
                Fdevuelto = new Fecha(0, 0, 0);
            }
            Prestamo P = new Prestamo(codigo);
            P.setFechaPrestamo(Fprestado);
            P.setFechaDevolucion(Festimado);
            P.setFechaDevuelto(Fdevuelto);
            P.setCliente(C);
            P.setLibro(L);
            Festimado.setPrestamo(P);
            C.getLp().ingresar(P);
            L.getLp().ingresar(P);
            lp.ingresar(P);
        }
        sc.close();
    }

    public static void menuApp(ListaPrestamos lp, Scanner sc, ListaClientes lc, ListaLibros lb) {
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("\t [menu]");
            System.out.println("bienvenidos al Sistem Bibliotecario");
            System.out.println("1-RF1: ");
            System.out.println("2-RF2");
            System.out.println("3-RF3:");
            System.out.println("4-salir: ");
            System.out.println("---------------------------------");
            System.out.print(">");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    RF1(lc, sc);
                    break;
                case 2:
                    RF2(sc, lp);
                    break;
                case 3:
                    RF3(lp);
                    break;
                default:
                    opcion = 4;
            }
        }
    }

    public static void RF1(ListaClientes lc, Scanner sc) {
        System.out.print("ingrese rut del cliente: ");
        String rut = sc.next();
        Cliente C = lc.buscarCliente(rut);
        int deudaTotal = 0;
        if (C != null) {
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < C.getLp().getCant(); i++) {
                Prestamo P = C.getLp().getPrestamo(i);
                int deuda = P.Deuda();
                deudaTotal = deudaTotal + deuda;
                if (deuda > 0) {
                    System.out.println("codigo : " + P.getCodigo());
                    System.out.println("fecha del prestamo: " + P.getFechaPrestamo().getDia() + "-" + P.getFechaPrestamo().getMes() + "-" + P.getFechaPrestamo().getAño());
                    System.out.println("fecha de la devolucion estimada: " + P.getFechaDevolucion().getDia() + "-" + P.getFechaDevolucion().getMes() + "-" + P.getFechaDevolucion().getAño());
                    System.out.println("fecha de la devolucion real: " + P.getFechaDevuelto().getDia() + "-" + P.getFechaDevuelto().getMes() + "-" + P.getFechaDevuelto().getAño());
                    int diasDevoReal = P.getFechaDevuelto().getDia() + P.getFechaDevuelto().getMes() * 31 + P.getFechaDevuelto().getAño() * 365;
                    int diasDevolucion = P.getFechaDevolucion().getDia() + P.getFechaDevolucion().getMes() * 31 + P.getFechaDevolucion().getAño() * 365;
                    int dias = diasDevoReal - diasDevolucion;
                    System.out.println("diferencia entre dias de devolucion real con la devolucion estimada es: " + dias);
                    System.out.println("deuda: " + deuda);
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
                }
            }
            System.out.println("su deuda total es: " + deudaTotal);
        } else {
            System.out.println("cliente no existe");
        }
    }

    public static void RF2(Scanner sc, ListaPrestamos lp) {
        int mayor = -1;
        Libro Lmayor = null;
        System.out.println("ingrese primera fecha");
        System.out.print("ingrese dia :");
        int diaI = sc.nextInt();
        while (diaI < 1 || diaI > 31) {
            System.out.print("dia fuera de rango");
            System.out.print("ingrese dia :");
            diaI = sc.nextInt();
        }
        System.out.print("ingrese mes :");
        int mesI = sc.nextInt();
        while (mesI < 1 || mesI > 12) {
            System.out.print("mes fuera de rango");
            System.out.print("ingrese mes:");
            mesI = sc.nextInt();
        }
        System.out.print("ingrese año :");
        int añoI = sc.nextInt();
        Fecha FI = new Fecha(diaI, mesI, añoI);
        long CantDiasInicio = FI.getAño() * 365 + FI.getMes() * 31 + FI.getDia();
        System.out.println("ingrese segunda fecha");
        System.out.print("ingrese dia :");
        int diaF = sc.nextInt();
        while (diaF < 1 || diaF > 31) {
            System.out.print("dia fuera de rango");
            System.out.print("ingrese dia :");
            diaF = sc.nextInt();
        }
        System.out.print("ingrese mes :");
        int mesF = sc.nextInt();
        while (mesF < 1 || mesF > 12) {
            System.out.print("mes fuera de rango");
            System.out.print("ingrese mes:");
            mesF = sc.nextInt();
        }
        System.out.print("ingrese año :");
        int añoF = sc.nextInt();
        Fecha FT = new Fecha(diaF, mesF, añoF);
        long CantDiasTermino = FT.getAño() * 365 + FT.getMes() * 31 + FT.getDia();
        for (int i = 0; i < lp.getCant(); i++) {
            Prestamo P = lp.getPrestamo(i);
            Fecha FIP = P.getFechaPrestamo();
            long CantDiasPrestamo = FIP.getAño() * 365 + FIP.getMes() * 31 + FIP.getDia();
            if (CantDiasInicio <= CantDiasPrestamo || CantDiasPrestamo <= CantDiasTermino) {
                Libro L = P.getLibro();
                if (L.getLp().getCant() > mayor) {
                    Lmayor = L;
                    mayor = L.getLp().getCant();
                }
            }
        }
        if (Lmayor != null) {
            System.out.println("El libro mas solicitado en ese rango es: ");
            System.out.println("ISNB: " + Lmayor.getIdentificador());
            System.out.println("titulo: " + Lmayor.getTitulo());
            System.out.println("nombre de autor: " + Lmayor.getAutor());
            System.out.println("año de publicacion: " + Lmayor.getAñoPublicacion());
            System.out.println("cantidad de veces solicitadis: " + mayor);
        } else {
            System.out.println("no hay libro dentro de ese rango");
        }
    }

    public static void RF3(ListaPrestamos lp) {
        Out salida = new Out("devoluciones_pendientes.txt");
        Fecha[] fechitas = new Fecha[1000];
        int cant = 0;
        for (int i = 0; i < lp.getCant(); i++) {
            Prestamo P = lp.getPrestamo(i);
            if (P.getFechaDevuelto().getDia() == 0) {
                fechitas[cant] = P.getFechaDevolucion();
                cant++;
            }
        }
        ordenar(fechitas, cant);
        salida.println("----------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < cant; i++) {
            Prestamo P = fechitas[i].getPrestamo();
            salida.println("codigo unico: " + P.getCodigo());
            salida.println("fecha prestamo " + P.getFechaPrestamo().getDia() + "-" + P.getFechaPrestamo().getMes() + "-" + P.getFechaPrestamo().getAño());
            salida.println("fecha de la devolucion estimada: " + P.getFechaDevolucion().getDia() + "-" + P.getFechaDevolucion().getMes() + "-" + P.getFechaDevolucion().getAño());
            salida.println("apellido del cliente : " + P.getCliente().getApellido());
            salida.println("nombre del cliente: " + P.getCliente().getNombre());
            salida.println("numero de celular: " + P.getCliente().getNumero());
            salida.println("correo: " + P.getCliente().getCorreo());
            salida.println("titulo del libro: " + P.getLibro().getTitulo());
            salida.println("----------------------------------------------------------------------------------------------------------------------------------------------");

        }
        System.out.println("archivo generado");

    }
    public static void ordenar(Fecha[] arreglo, int cant) {
        for (int i = 0; i < cant - 1; i++) {
            for (int j = 0; j < cant - 1; j++) {
                Fecha f = arreglo[j];
                int dias1 = f.getAño() * 365 + f.getDia() + f.getMes() * 31;
                Fecha f1 = arreglo[j + 1];
                int dias2 = f1.getAño() * 365 + f1.getDia() + f1.getMes() * 31;
                if (dias1 > dias2) {
                    Fecha tmp = f1;
                    arreglo[j + 1] = f;
                    arreglo[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        ListaPrestamos lp = new ListaPrestamos(1000);
        ListaClientes lc = new ListaClientes(1000);
        ListaLibros lb = new ListaLibros(1000);
        Scanner sc = new Scanner(System.in);
        leerClientes(lc, sc);
        leerLibros(lb, sc);
        leerPrestamos(lp, sc, lc, lb);
        menuApp(lp, sc, lc, lb);
    }

}
