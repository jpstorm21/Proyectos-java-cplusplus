package ficha3;

import ucn.*;

public class Ficha3 {

    public static void menu(ListaPropiedades lp, ListaDueños ld, ListaComunas lc) {
        int opcionmenu = 0;
        while (opcionmenu != 6) {
            StdOut.println("menu: ");
            StdOut.println("1-leer datos(opcion 1)");
            StdOut.println("2-requerimiento 1(opcion 2)");
            StdOut.println("3-requerimiento 2(opcion 3)");
            StdOut.println("4-requerimiento 3(opcion 4)");
            StdOut.println("5-requerimiento 4(opcion 5)");
            StdOut.println("opcion 6(salir)");
            StdOut.println("------------------");
            StdOut.println("ingrese opcion: ");
            opcionmenu = StdIn.readInt();
            if (opcionmenu == 1) {
                Ficha3.leerdatos(lp, ld, lc);
            }
            if (opcionmenu == 2) {
                Ficha3.requerimiento1(lp, ld, lc);
            }
            if (opcionmenu == 3) {
                Ficha3.requerimiento2(lp, ld, lc);
            }
            if (opcionmenu == 4) {
                Ficha3.requerimiento3(lp, ld, lc);
            }
            if (opcionmenu == 5) {
                Ficha3.requerimiento4(lp, ld, lc);
            }

        }
    }

    public static void leerdatos(ListaPropiedades lp, ListaDueños ld, ListaComunas lc) {
        StdOut.print("ingrese cantidad de comunas: ");
        int cantc = StdIn.readInt();
        for (int i = 0; i < cantc; i++) {
            StdOut.print("ingrese codigo de la comuna: ");
            int codc = StdIn.readInt();
            Comuna C = new Comuna(codc);
            lc.ingresarComuna(C);
        }
        StdOut.print("ingrese rut del dueño : ");
        int rut = StdIn.readInt();

        while (rut != 111) {
            StdOut.print("ingrese nombre del dueño: ");
            String nombred = StdIn.readString();
            Dueño D = new Dueño(rut, nombred);
            ld.ingresarDueño(D);

            StdOut.print("ingrese direccion de su propiedad: ");
            String direccion = StdIn.readString();
            while (!direccion.equals("xxx")) {
                StdOut.print("ingrese metros cuadrados de la propiedad: ");
                int metros = StdIn.readInt();
                StdOut.println("Seleccione comuna para ingresar propiedad: ");
                for (int i = 0; i < lc.getCantcomunas(); i++) {
                    System.out.println(lc.getComuna(i).getCodigo());
                }
                int cod = StdIn.readInt();
                Comuna C = lc.buscarComuna(cod);
                int vpropiedad = 10000 + (8000 * metros);
                int contri = (50000 * cod) + vpropiedad;
                Propiedad P = new Propiedad(direccion, metros, rut, contri);
                lp.ingresarPropiedad(P);
                D.getLp().ingresarPropiedad(P);
                P.setRefdueño(D);
                P.setRefcomuna(C);
                C.getLp().ingresarPropiedad(P);

                StdOut.print("ingrese direccion de la propiedad: ");
                direccion = StdIn.readString();

            }
            StdOut.print("ingrese rut del dueño : ");
            rut = StdIn.readInt();
        }
    }

    public static void requerimiento1(ListaPropiedades lp, ListaDueños ld, ListaComunas lc) {
        for (int i = 0; i < lp.getCantpro(); i++) {
            StdOut.println("datos de la propiedad " + (i + 1) + ":");
            StdOut.println("direccion: " + lp.getPropiedad(i).getDireccion());
            StdOut.println("rut del dueño: " + lp.getPropiedad(i).getRefdueño().getRut());
            StdOut.println("valor de contribuciones: " + lp.getPropiedad(i).getContribuciones());
        }
    }

    public static void requerimiento2(ListaPropiedades lp, ListaDueños ld, ListaComunas lc) {
        StdOut.print("ingrese codigo del cual va a buscar: ");
        int codb = StdIn.readInt();
        Comuna C = lc.buscarComuna(codb);
        for (int i = 0; i < C.getLp().getCantpro(); i++) {
            StdOut.println("la direccion de la propiedad " + (i + 1) + " es :" + C.getLp().getPropiedad(i).getDireccion());

        }
    }

    public static void requerimiento3(ListaPropiedades lp, ListaDueños ld, ListaComunas lc) {
        int mayor = 0;
        int cant = 0;
        String nomMayor = "";
        for (int i = 0; i < ld.getCantdueños(); i++) {
            Dueño D = ld.getDueño(i);
            for (int j = 0; j < D.getLp().getCantpro(); j++) {
                Propiedad P = D.getLp().getPropiedad(j);
                if (P.getRefcomuna().getCodigo() == 1) {
                    cant++;
                }
            }
            if (cant > mayor) {
                mayor = cant;
                nomMayor = D.getNombre();
            }
        }
        StdOut.println("el propietario con mayor propiedades en la comuna 1 es: " + nomMayor);
    }

    public static void requerimiento4(ListaPropiedades lp, ListaDueños ld, ListaComunas lc) {
        for (int i = 0; i < lc.getCantcomunas(); i++) {
            Comuna C = lc.getComuna(i);
            StdOut.println("el codigo de la comuna es : " + C.getCodigo());
            for (int j = 0; j < C.getLp().getCantpro(); j++) {
                StdOut.println("direccion de la propiedad " + (1 + j) + " de la comuna " + lc.getComuna(i).getCodigo() + C.getLp().getPropiedad(j).getDireccion());
                StdOut.println("nombre del dueño de la propiedad " + (1 + j) + " " + C.getLp().getPropiedad(j).getRefdueño().getNombre());
            }
        }
    }

    public static void main(String[] args) {
        ListaPropiedades lp = new ListaPropiedades(1000);
        ListaDueños ld = new ListaDueños(1000);
        ListaComunas lc = new ListaComunas(1000);
        menu(lp, ld, lc);
    }

}
