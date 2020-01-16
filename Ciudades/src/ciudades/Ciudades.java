package ciudades;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Ciudades {

    public static void leerComunas(ListaComunas lc, Scanner sc) {

        System.out.println("Ingrese cantidad de comunas: ");
        int cant = sc.nextInt();
        for (int i = 0; i < cant; i++) {
            System.out.println("Ingrese codigo: ");
            String codigo = sc.next();
            System.out.println("Ingrese nombre: ");
            String nombre = sc.next();
            Comuna C = new Comuna(nombre, codigo);
            lc.ingresarComuna(C);
        }
    }

    public static void leerPersonas(ListaDueños ld, ListaPropiedades lp, ListaComunas lc, Scanner sc) {
        System.out.println("Ingrese rut(Fin de datos 111): ");
        String rut = sc.next();
        while (!rut.equalsIgnoreCase("111")) {
            System.out.println("Ingrese nombre: ");
            String nombre = sc.next();
            Dueño D = new Dueño(rut, nombre);
            System.out.println("Ingrese cantidad de propiedades del dueño: ");
            int cant = sc.nextInt();
            for (int i = 0; i < cant; i++) {
                System.out.println("Ingrese nombre de la propiedad: ");
                String prop = sc.next();
                System.out.println("Ingrese precio de la propiedad: ");
                int precio = sc.nextInt();
                System.out.println("Ingrese código comuna: ");
                String codigo = sc.next();
                Comuna C = lc.buscarComuna(codigo);
                if (C != null) {
                    Propiedad P = new Propiedad(nombre, precio);
                    C.getLp().ingresarPropiedad(P);
                    P.setPersona(D);
                    D.getLp().ingresarPropiedad(P);
                    lp.ingresarPropiedad(P);
                    ld.ingresarDueño(D);
                } else {
                    System.out.println("no existe");
                }
            }
            System.out.println("Ingrese rut(Fin de datos 111): ");
            rut = sc.next();
        }
    }

    public static void RF1(ListaDueños ld) {
        int mayor = -999;
        Dueño d = null;

        for (int i = 0; i < ld.getCantidadDueños(); i++) {
            Dueño D = ld.getDueño(i);
            if (D.getLp().getCantidadPropiedades() > mayor) {
                mayor = D.getLp().getCantidadPropiedades();
                d = D;
            }

        }
        System.out.println("El dueño con màs propiedades es: " + d.getNombre() + "con una cantidad de propiedades de: " + mayor);

    }

    public static void RF2(ListaDueños ld) {
        Dueño d = null;
        int mayor = -999;

        for (int i = 0; i < ld.getCantidadDueños(); i++) {
            Dueño D = ld.getDueño(i);
            int sumador = 0;
            for (int j = 0; j < D.getLp().getCantidadPropiedades(); j++) {
                Propiedad P = D.getLp().getPropiedad(j);
                sumador = sumador + P.getPrecio();

            }
            if (sumador > mayor) {
                mayor = sumador;
                d = D;
            }
        }
        System.out.println("El dueño con más dinero en propiedades es: " + d.getNombre() + "Con un total de: " + mayor);

    }

    public static void RF3(ListaDueños ld, ListaComunas lc, ListaPropiedades lp) {
        for (int i = 0; i < lc.getCantidadComunas(); i++) {
            Comuna C = lc.getComuna(i);
            System.out.println("Nombre: " + C.getNombre() + "Codigo: " + C.getCodigo());
            for (int j = 0; j < C.getLp().getCantidadPropiedades(); j++) {
                Propiedad P = C.getLp().getPropiedad(j);
                System.out.println("Nombre: " + P.getNombre() + "Precio: " + P.getPrecio() + "Dueño: " + P.getPersona().getNombre());
            }
        }

    }

    public static void main(String[] args) {
        ListaPropiedades lp = new ListaPropiedades(1000);
        ListaComunas lc = new ListaComunas(1000);
        ListaDueños ld = new ListaDueños(1000);
        Scanner sc = new Scanner(System.in);
        leerComunas(lc, sc);
        leerPersonas(ld, lp, lc, sc);
        RF1(ld);
        RF2(ld);
        RF3(ld, lc, lp);

    }

}
