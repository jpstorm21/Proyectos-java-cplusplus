package ayudantia.pkg8;

import ucn.*;

public class Ayudantia8 {

    public static void menuApp(ListaClientes lc, ListaMascotas lm) {
        int opcion = 0;
        while (opcion != 8) {
            StdOut.println("\t [menu]");
            StdOut.println("1-leer guarderia y clientes:");
            StdOut.println("2-leer mascotas : ");
            StdOut.println("3-requerimiento 1:");
            StdOut.println("4-requerimiento 2:");
            StdOut.println("5-requerimiento 3:");
            StdOut.println("6-requerimiento 4:");
            StdOut.println("7-requerimiento 5:");
            StdOut.println("8-salir: ");
            StdOut.println("---------------------------------");
            StdOut.print(">");
            opcion = StdIn.readInt();
            switch (opcion) {
                case 1:
                    Ayudantia8.leerClienteyGuarderia(lc);
                    break;
                case 2:
                    Ayudantia8.leerMascotas(lc, lm);
                    break;
                case 3:
                    Ayudantia8.requerimiento1(lc);
                    break;
                case 4:
                    Ayudantia8.requerimiento2(lc, lm);
                    break;
                case 5:
                    Ayudantia8.requerimiento3(lc);
                    break;
                case 6:
                    Ayudantia8.requerimiento4(lm);
                    break;
                case 7:
                    Ayudantia8.requerimiento5(lm);
                    break;
                default:
                    opcion = 8;
            }

        }
    }

    public static void leerMascotas(ListaClientes lc, ListaMascotas lm) {
        StdOut.print("ingrese cantidad de mascoatas: ");
        int cant = StdIn.readInt();
        for (int i = 0; i < cant; i++) {
            StdOut.print("ingrese tipo de mascoata [1] gato o [2} perro [3] otro: ");
            int tipo = StdIn.readInt();
            if (tipo == 1) {
                StdOut.print("ingrese fecha: ");
                int fecha = StdIn.readInt();
                StdOut.print("ingrese cantidad de horas que estara la mascota: ");
                int horas = StdIn.readInt();
                StdOut.print("ingrese nombre de la mascota: ");
                String nombre = StdIn.readString();
                StdOut.print("ingres nombre del dueño: ");
                String nombreD = StdIn.readString();
                StdOut.print("ingrese marca de comida: ");
                String marca = StdIn.readString();
                Cliente C = lc.buscarClienteXnombre(nombreD);
                Mascota M = new Gato(marca, fecha, horas, nombre);
                boolean sepudo = lm.ingresarMascota(M);
                if (sepudo == true) {
                    StdOut.println("mascota ingresada correctamente");
                    M.setCliente(C);
                    C.getLm().ingresarMascota(M);
                } else {
                    StdOut.println("lista llena");
                }

            } else if (tipo == 2) {
                StdOut.print("ingrese fecha: ");
                int fecha = StdIn.readInt();
                StdOut.print("ingrese cantidad de horas que estara la mascota: ");
                int horas = StdIn.readInt();
                StdOut.print("ingrese nombre de la mascota: ");
                String nombre = StdIn.readString();
                StdOut.print("ingres nombre del dueño: ");
                String nombreD = StdIn.readString();
                StdOut.print("ingrese raza: ");
                String raza = StdIn.readString();
                Cliente C = lc.buscarClienteXnombre(nombreD);
                Mascota M = new Perro(raza, fecha, horas, nombre);
                boolean sepudo = lm.ingresarMascota(M);
                if (sepudo == true) {
                    StdOut.println("mascota ingresada correctamente");
                    M.setCliente(C);
                    C.getLm().ingresarMascota(M);
                } else {
                    StdOut.println("lista llena");
                }

            } else {
                StdOut.print("ingrese fecha: ");
                int fecha = StdIn.readInt();
                StdOut.print("ingrese cantidad de horas que estara la mascota: ");
                int horas = StdIn.readInt();
                StdOut.print("ingrese nombre de la mascota: ");
                String nombre = StdIn.readString();
                StdOut.print("ingres nombre del dueño: ");
                String nombreD = StdIn.readString();
                StdOut.print("ingrese tipo: ");
                String tipomascota = StdIn.readString();
                Cliente C = lc.buscarClienteXnombre(nombreD);
                Mascota M = new Animal(tipomascota, fecha, horas, nombre);
                boolean sepudo = lm.ingresarMascota(M);
                if (sepudo == true) {
                    StdOut.println("mascota ingresada correctamente");
                    M.setCliente(C);
                    C.getLm().ingresarMascota(M);
                } else {
                    StdOut.println("lista llena");
                }

            }
        }
    }

    public static void leerClienteyGuarderia(ListaClientes lc) {
        StdOut.print("ingrese nombre de la guarderia: ");
        String nombreG = StdIn.readString();
        StdOut.print("ingrese direccion: ");
        String direccion = StdIn.readString();
        Guarderia G = new Guarderia(nombreG, direccion);
        StdOut.print("ingrese cantidad de clientes:");
        int cant = StdIn.readInt();
        for (int i = 0; i < cant; i++) {
            StdOut.print("ingrese nombre del Cliente: ");
            String nombre = StdIn.readString();
            StdOut.print("ingrese rut: ");
            String rut = StdIn.readString();
            Cliente C = new Cliente(nombre, rut);
            boolean sepudo = lc.ingresarCliente(C);
            if (sepudo == true) {
                StdOut.println("cliente ingresaso exitosamente");
                G.getLc().ingresarCliente(C);
            } else {
                StdOut.println("lista llena");
            }
        }
    }

    public static void requerimiento1(ListaClientes lc) {
        StdOut.print("ingrese rut del cliente que desea buscar: ");
        String rutb = StdIn.readString();
        Cliente C = lc.buscarClienteXrut(rutb);
        int cantpagar = 0;
        for (int i = 0; i < C.getLm().getCantmascotas(); i++) {
            Mascota M = C.getLm().getMascota(i);
            cantpagar = cantpagar + M.calcularCobro();
        }
        StdOut.println("la cantidad total a pagar es : " + cantpagar);

    }

    public static void requerimiento2(ListaClientes lc, ListaMascotas lm) {
        int saldototal = 0;
        for (int i = 0; i < lc.getCantClientes(); i++) {
            Cliente C = lc.getCliente(i);
            for (int j = 0; j < C.getLm().getCantmascotas(); j++) {
                Mascota M = C.getLm().getMascota(j);
                saldototal = saldototal + M.calcularCobro();
            }
        }
        StdOut.println("el saldo total es : " + saldototal);
    }

    public static void requerimiento3(ListaClientes lc) {
        StdOut.print("ingrese nombre del cliente que desee buscar: ");
        String nombreb = StdIn.readString();
        Cliente C = lc.buscarClienteXnombre(nombreb);
        StdOut.println("nombre de sus mascotas");
        for (int i = 0; i < C.getLm().getCantmascotas(); i++) {
            Mascota M = C.getLm().getMascota(i);
            StdOut.println(M.getNombre());
        }

    }

    public static void requerimiento4(ListaMascotas lm) {
        int cantperros = 0;
        int cantgatos = 0;
        int cantotros = 0;
        int mayor = -1;
        int totalmascotas = 0;
        for (int i = 0; i < lm.getCantmascotas(); i++) {
            Mascota M = lm.getMascota(i);
            if (M instanceof Gato) {
                cantgatos++;
            } else if (M instanceof Perro) {
                cantperros++;
            } else {
                cantotros++;
            }
        }
        if (cantgatos > cantperros && cantgatos > cantotros) {
            mayor = cantgatos;
            StdOut.println("la cantidad de gatos es mayor con : " + mayor);
        }
        if (cantperros > cantgatos && cantperros > cantotros) {
            mayor = cantperros;
            StdOut.println("la cantidad de perros es mayor con: " + mayor);
        }
        if (cantotros > cantgatos && cantotros > cantperros) {
            mayor = cantotros;
            StdOut.println("la cantidad de otros animales es mayor con: " + mayor);
        }
        totalmascotas = cantgatos + cantperros + cantotros;
        StdOut.println("la cantidad total de mascotas es : " + totalmascotas);
    }

    public static void requerimiento5(ListaMascotas lm) {
        int gananciaperros = 0;
        int gananciagatos = 0;
        int gananciaotros = 0;
        int mayor = 0;
        for (int i = 0; i < lm.getCantmascotas(); i++) {
            Mascota M = lm.getMascota(i);
            if (M instanceof Gato) {
                gananciagatos = gananciagatos + ((Gato) M).calcularCobro();
            } else if (M instanceof Perro) {
                gananciaperros = gananciaperros + ((Perro) M).calcularCobro();
            } else {
                gananciaotros = gananciaotros + ((Animal) M).calcularCobro();
            }
        }
        if (gananciagatos > gananciaperros && gananciagatos > gananciaotros) {
            mayor = gananciagatos;
            StdOut.println("la ganancia de los gatos es mayor con : " + mayor);
        }
        if (gananciaperros > gananciagatos && gananciaperros > gananciaotros) {
            mayor = gananciaperros;
            StdOut.println("la ganancia de los perros es mayor con: " + mayor);
        }
        if (gananciaotros > gananciagatos && gananciaotros > gananciaperros) {
            mayor = gananciaotros;
            StdOut.println("la ganancia de  los otros animales es mayor con: " + mayor);
        }

    }

    public static void main(String[] args) {
        ListaClientes lc = new ListaClientes(1000);
        ListaMascotas lm = new ListaMascotas(1000);
        Ayudantia8.menuApp(lc, lm);
    }

}
