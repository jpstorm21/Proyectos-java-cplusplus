package taller4sgdosemestre2017;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Juan Pablo Martinez Romero
 */
public class APP {

    public static void leerPersonas(Ireparadores sistema) throws FileNotFoundException {//ok
        Scanner sc = new Scanner(new File("personas.txt"));
        while (sc.hasNextLine()) {
            String leelinea = sc.nextLine();
            String[] linea = leelinea.split(",");
            String rut = linea[0];
            String nombres = linea[1];
            String apellidos = linea[2];
            int edad = Integer.parseInt(linea[3]);
            int telefono = Integer.parseInt(linea[4]);
            String mail = linea[5];
            String tipo = linea[6];
            if (tipo.equalsIgnoreCase("T")) {
                String cargo = linea[7];
                Persona P = new Trabajador(cargo, rut, nombres, apellidos, edad, telefono, mail);
                sistema.ingresarPersona(P);
            } else if (tipo.equalsIgnoreCase("TS")) {
                String cargo = linea[7];
                Persona P = new TrabajadorServicio(cargo, rut, nombres, apellidos, edad, telefono, mail);
                sistema.ingresarPersona(P);
            } else if (tipo.equalsIgnoreCase("C")) {
                int tieneOrg = Integer.parseInt(linea[7]);
                if (tieneOrg == 1) {
                    String rutOrg = linea[8];
                    String nombreOrg = linea[9];
                    String direccionOrg = linea[10];
                    Persona P = new Cliente(rut, nombres, apellidos, edad, telefono, mail);
                    Organizacion org = new Organizacion(rutOrg, nombreOrg, direccionOrg);
                    ((Cliente) P).setOrganizacion(org);
                    sistema.ingresarPersona(P);
                } else {
                    Persona P = new Cliente(rut, nombres, apellidos, edad, telefono, mail);
                    ((Cliente) P).setOrganizacion(null);
                    sistema.ingresarPersona(P);
                }
            }
        }
        sc.close();
    }

    public static void leerServicios(Ireparadores sistema) throws FileNotFoundException {//ok
        Scanner sc = new Scanner(new File("servicios.txt"));
        while (sc.hasNextLine()) {
            String leelinea = sc.nextLine();
            String[] linea = leelinea.split(",");
            int codigo = Integer.parseInt(linea[0]);
            String fecha = linea[1];
            String hora = linea[2];
            String rutCliente = linea[3];
            Persona P = sistema.buscarPersona(rutCliente);
            String rutT1 = linea[4];
            Persona T1 = sistema.buscarPersona(rutT1);
            String rutT2 = linea[5];
            Persona T2 = sistema.buscarPersona(rutT2);
            int codCertificacion = Integer.parseInt(linea[6]);
            Certificacion c = sistema.buscarCertificacion(codCertificacion);
            Servicio s = new Servicio(codigo, fecha, hora);
            s.setCertificacion(c);
            s.setCliente(((Cliente) P));
            s.setTrabajador1(((TrabajadorServicio) T1));
            if (rutT2.equalsIgnoreCase("0")) {
                s.setTrabajador2(null);
                ((Cliente) P).getLs().ingresarServicio(s);
                ((TrabajadorServicio) T1).getLs().ingresarServicio(s);
                sistema.ingresarServicio(s);
            } else {
                s.setTrabajador2(((TrabajadorServicio) T2));
                ((Cliente) P).getLs().ingresarServicio(s);
                ((TrabajadorServicio) T1).getLs().ingresarServicio(s);
                ((TrabajadorServicio) T2).getLs().ingresarServicio(s);
                sistema.ingresarServicio(s);
            }
        }
        sc.close();
    }

    public static void leerMateriales(Ireparadores sistema) throws FileNotFoundException {//ok
        Scanner sc = new Scanner(new File("materiales.txt"));
        while (sc.hasNextLine()) {
            String leelinea = sc.nextLine();
            String[] linea = leelinea.split(",");
            int codigo = Integer.parseInt(linea[0]);
            String nombre = linea[1];
            int stock = Integer.parseInt(linea[2]);
            String descripcion = linea[3];
            Material M = new Material(codigo, nombre, stock, descripcion);
            sistema.ingresarMaterial(M);
        }
        sc.close();
    }

    public static void leerCertificaciones(Ireparadores sistema) throws FileNotFoundException {//ok
        Scanner sc = new Scanner(new File("certificaciones.txt"));
        while (sc.hasNextLine()) {
            String leelinea = sc.nextLine();
            String[] linea = leelinea.split(",");
            int codigo = Integer.parseInt(linea[0]);
            String tipo = linea[1];
            Certificacion c = new Certificacion(codigo, tipo);
            sistema.ingresarCertificacione(c);
        }
        sc.close();
    }

    public static void leerHistoricoCertificaciones(Ireparadores sistema) throws FileNotFoundException {//ok
        Scanner sc = new Scanner(new File("historico_certificado.txt"));
        while (sc.hasNextLine()) {
            String leelinea = sc.nextLine();
            String[] linea = leelinea.split(",");
            String fecha = linea[0];
            int puntaje = Integer.parseInt(linea[1]);
            int codigoCertificacion = Integer.parseInt(linea[2]);
            Certificacion c = sistema.buscarCertificacion(codigoCertificacion);
            String rutTrabajadorServicio = linea[3];
            Persona P = sistema.buscarPersona(rutTrabajadorServicio);
            HistoricoCertificado hc = new HistoricoCertificado(fecha, puntaje);
            hc.setCertificacion(c);
            hc.setTrabajador(((TrabajadorServicio) P));
            ((TrabajadorServicio) P).getLhc().ingresarHistoricoCertificado(hc);
            ((TrabajadorServicio) P).getLc().ingresarCertificaion(c);
            sistema.ingresarHistoricoCertificacion(hc);
        }
        sc.close();
    }

    public static void leerServicioMaterial(Ireparadores sistema) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("servicio_material.txt"));
        while (sc.hasNextLine()) {
            String leelinea = sc.nextLine();
            String[] linea = leelinea.split(",");
            int codigoServicio = Integer.parseInt(linea[0]);
            Servicio s = sistema.buscarServicio(codigoServicio);
            int codigoMaterial = Integer.parseInt(linea[1]);
            Material M = sistema.buscarMaterial(codigoMaterial);
            int cantidadMaterial = Integer.parseInt(linea[2]);
            s.setCantidadMaterialUsado(cantidadMaterial);
            sistema.ingresarMaterialAServicio(s, M);
        }
        sc.close();
    }

    public static void leerSolicitudMaterial(Ireparadores sistema) throws FileNotFoundException {//ok
        Scanner sc = new Scanner(new File("solicitud_material.txt"));
        while (sc.hasNextLine()) {
            String leelinea = sc.nextLine();
            String[] linea = leelinea.split(",");
            int codigo = Integer.parseInt(linea[0]);
            String fecha = linea[1];
            String hora = linea[2];
            String rutTrabajadorServicio = linea[3];
            Persona T = sistema.buscarPersona(rutTrabajadorServicio);
            String rutJefeAdmi = linea[4];
            Persona Jadmi = sistema.buscarPersona(rutJefeAdmi);
            String rutJefeFinanzas = linea[5];
            Persona Jfinanzas = sistema.buscarPersona(rutJefeFinanzas);
            SolicitudMaterial sm = new SolicitudMaterial(codigo, fecha, hora);
            sm.setTrabajadorServicio(((TrabajadorServicio) T));
            sm.setJefeAdmin(((Trabajador) Jadmi));
            sm.setJefeFinanza(((Trabajador) Jfinanzas));
            ((TrabajadorServicio) T).getLsm().ingresarSolicitudMaterial(sm);
            sistema.ingresarSolicitudMaterial(sm);
        }
        sc.close();
    }

    public static void leerSolicitud_Material_Material(Ireparadores sistema) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("solicitud_material_material.txt"));
        while (sc.hasNextLine()) {
            String leelinea = sc.nextLine();
            String[] linea = leelinea.split(",");
            int codigoSM = Integer.parseInt(linea[0]);
            SolicitudMaterial sm = sistema.buscarSolicitudMaterial(codigoSM);
            int codigoMaterial = Integer.parseInt(linea[1]);
            Material M = sistema.buscarMaterial(codigoMaterial);
            int cantidadPedida = Integer.parseInt(linea[2]);
            sistema.ingresarMaterialASolicitudMaterial(sm, M);
            Material M2 = sm.getLm().buscarMaterial(codigoMaterial);
            M2.setCantidad(cantidadPedida);
            sm.cantTotalPedida(cantidadPedida);
        }
        sc.close();
    }

    public static void MaterialesTodosServicios(Ireparadores sistema) {//listo
        ListaMateriales lm = sistema.MaterialesTodosServicios();
        NodoMaterial actual = lm.getFirst();
        System.out.println("-------------------------------------------------------------");
        while (actual != null) {
            Material M = actual.getMaterial();
            System.out.println("codigo : " + M.getCodigo());
            System.out.println("nombre: " + M.getNombre());
            System.out.println("stock: " + M.getStock());
            System.out.println("descripcion: " + M.getDescripcion());
            System.out.println("-------------------------------------------------------------");
            actual = actual.getNext();
        }

    }

    public static void MaterialesNingunServicios(Ireparadores sistema) {//listo
        ListaMateriales lm1 = sistema.MaterialesNingunServicios();
        NodoMaterial actual = lm1.getFirst();
        if (actual == null) {
            System.out.println("todos los materiales se han usado en almenos un servicio");
        } else {
            System.out.println("-------------------------------------------------------------");
            while (actual != null) {
                Material M = actual.getMaterial();
                System.out.println("codigo : " + M.getCodigo());
                System.out.println("nombre: " + M.getNombre());
                System.out.println("stock: " + M.getStock());
                System.out.println("descripcion: " + M.getDescripcion());
                System.out.println("-------------------------------------------------------------");
                actual = actual.getNext();
            }
        }
    }

    public static void ServicioUnTrabajadorServicio_organizacion(Ireparadores sistema) {//listo
        ListaServicios ls = sistema.ServicioUnTrabajadorServicio_organizacion();
        NodoServicio actual = ls.getFirst();
        System.out.println("-------------------------------------------------------------");
        while (actual != null) {
            Servicio s = actual.getServicio();
            System.out.println("codigo: " + s.getCodigo());
            System.out.println("fecha: " + s.getFecha());
            System.out.println("hora: " + s.getHora());
            System.out.println("Nombre del cliente : " + s.getCliente().getNombre());
            System.out.println("nombre del trabajador : " + s.getTrabajador1().getNombre());
            System.out.println("certificacion : " + s.getCertificacion().getTipo());
            System.out.println("-------------------------------------------------------------");
            actual = actual.getNext();
        }
    }

    public static void solMateriales(Ireparadores sistema) {//lista solo arreglar las cantidades
        ListaSolicitudMaterial lsm = sistema.solMateriales();
        NodoSolicitudMaterial actual = lsm.getFirst();
        System.out.println("-------------------------------------------------------------");
        while (actual != null) {
            SolicitudMaterial sm = actual.getSolicitudMaterial();
            System.out.println("codigo: " + sm.getCodigo());
            System.out.println("fecha: " + sm.getFecha());
            System.out.println("hora: " + sm.getHora());
            System.out.println("nombre del jefe de administracion : " + sm.getJefeAdmin().getNombre());
            System.out.println("nombre del jefe de finanzas : " + sm.getJefeFinanza().getNombre());
            System.out.println("nombre del trabajador que la solicito: " + sm.getTrabajadorServicio().getNombre());
            System.out.println("-------------------------------------------------------------");
            NodoMaterial actualM = sm.getLm().getFirst();
            System.out.println("ListaMateriales de la solicitud : " + sm.getCodigo());
            while (actualM != null) {
                Material m = actualM.getMaterial();
                System.out.println("nombre del material: " + m.getNombre());
                System.out.println("cantidad: " + m.getCantidad());
                System.out.println("-------------------------------------------------------------");
                actualM = actualM.getNext();
            }
            actual = actual.getNext();
        }
    }

    public static void trabajadorConMasServicio(Ireparadores sistema) {//Listo
        TrabajadorServicio T = sistema.trabajadorConMasServicio();
        System.out.println("nombres: " + T.getNombre());
        System.out.println("apellido : " + T.getApellido());
        System.out.println("cantidad max: " + T.getLs().getCant());
        System.out.println("--------------------------------------------------------");
        System.out.println("informacion de los historicos certificados");
        for (int i = 0; i < T.getLhc().getContador(); i++) {
            HistoricoCertificado hc = T.getLhc().getHistoricoCertificado(i);
            System.out.println("fecha: " + hc.getFecha());
            System.out.println("puntaje: " + hc.getPuntaje());
            System.out.println("codigo del certificado: " + hc.getCertificacion().getCodigo());
            System.out.println("tipo: " + hc.getCertificacion().getTipo());
            if (hc.getPuntaje() >= 80) {
                System.out.println("aprobo el examen");
            } else {
                System.out.println("reprobo el examen");
            }
            System.out.println("--------------------------------------------------------");
        }
    }

    public static void menu(Ireparadores sistema) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 6) {
            System.out.println("\t [menu]");
            System.out.println("bienvenidos al sistema de los Reparadores");
            System.out.println("1-Leer registros");
            System.out.println("2-RF2");
            System.out.println("3-RF3");
            System.out.println("4-RF4");
            System.out.println("5-RF5");
            System.out.println("6-Salir");
            System.out.println("---------------------------------");
            System.out.print(">");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    leerPersonas(sistema);
                    leerCertificaciones(sistema);
                    leerServicios(sistema);
                    leerMateriales(sistema);
                    leerHistoricoCertificaciones(sistema);
                    leerServicioMaterial(sistema);
                    leerSolicitudMaterial(sistema);
                    leerSolicitud_Material_Material(sistema);
                    System.out.println("archivos leidos exitosamente");
                    break;
                case 2:
                    System.out.println("RF2 PARTE A");
                    MaterialesTodosServicios(sistema);
                    System.out.println("--------------------------------------------------------");
                    System.out.println("RF2 PARTE B");
                    MaterialesNingunServicios(sistema);
                    break;
                case 3:
                    ServicioUnTrabajadorServicio_organizacion(sistema);
                    break;
                case 4:
                    solMateriales(sistema);
                    break;
                case 5:
                    trabajadorConMasServicio(sistema);
                    break;
                default:
                    opcion = 6;
            }

        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Ireparadores sistema = new Reparadores();
        menu(sistema);
    }

}
