package ejemplosabstrac;

import ucn.*;

public class Ejemplosabstrac {

    public static void menuApp(ListaVehiculos lv) {
        int opcion = 0;
        while (opcion != 6) {
            StdOut.println("\t [menu]");
            StdOut.println("1-leer vehiculos: ");
            StdOut.println("2-lista de vehiculos");
            StdOut.println("3-buscar vehiculo por patente:");
            StdOut.println("4-cantidad de vehiculos: ");
            StdOut.println("5-camioneta con carga mayor");
            StdOut.println("6-salir");
            StdOut.println("---------------------------------");
            StdOut.print(">");
            opcion = StdIn.readInt();
            switch (opcion) {
                case 1:
                    Ejemplosabstrac.leervehiculos(lv);
                    break;
                case 2:
                    Ejemplosabstrac.listaVehiculos(lv);
                    break;
                case 3:
                    Ejemplosabstrac.patenteVehiculo(lv);
                    break;
                case 4:
                    Ejemplosabstrac.cantVehiculos(lv);
                    break;
                case 5:
                    Ejemplosabstrac.camionetaMayorCarga(lv);
                    break;
                default:
                    opcion = 6;
            }

        }
    }

    public static void leervehiculos(ListaVehiculos lv) {
        StdOut.print("ingrese tipo de vehiculo a ingresar [1] auto o [2] camioneta: ");
        int tipo = StdIn.readInt();

        if (tipo == 1) {
            StdOut.print("ingrese patente del auto : ");
            String patente = StdIn.readString();
            StdOut.print("ingrese marca del auto: ");
            String marca = StdIn.readString();
            StdOut.print("ingrese año de fabricacion del auto: ");
            int año = StdIn.readInt();
            StdOut.print("ingrese kilometraje del auto: ");
            int kilometraje = StdIn.readInt();
            StdOut.print("ingrese capacidad de estanque del auto: ");
            int estanque = StdIn.readInt();
            Vehiculo A = new Auto(kilometraje, estanque, patente, marca, año);
            boolean sepudo = lv.ingresarVehiculo(A);
            if (sepudo == true) {
                StdOut.println("se ingreso correctamente el auto");
            } else {

                StdOut.println("lista llena");
            }
        } else if (tipo == 2) {
            StdOut.print("ingrese patente de la camioneta : ");
            String patente = StdIn.readString();
            StdOut.print("ingrese marca de la camioneta : ");
            String marca = StdIn.readString();
            StdOut.print("ingrese año de fabricacion de la camioneta : ");
            int año = StdIn.readInt();
            StdOut.print("ingrese capacidad de carga de la camioneta : ");
            int capacidad = StdIn.readInt();
            Vehiculo C = new Camioneta(capacidad, patente, marca, año);
            boolean sepudo = lv.ingresarVehiculo(C);
            if (sepudo == true) {
                StdOut.println("se ingreso correctamente la camioneta");
            } else {
                StdOut.println("lista llena");
            }
        }

    }

    public static void listaVehiculos(ListaVehiculos lv) {
        for (int i = 0; i < lv.getCantvehiculos(); i++) {
            Vehiculo V = lv.getVehiculo(i);
            if (V instanceof Camioneta) {
                StdOut.println("patente de la camioneta : " + ((Camioneta) V).getPatente());
                StdOut.println("marca de la camioneta: " + ((Camioneta) V).getMarca());
                StdOut.println("año de fabricacion de la camionatea: " + ((Camioneta) V).getAñofabricacion());
                StdOut.println("capacidad de carga de la camioneta: " + ((Camioneta) V).getCapacidadCarga());
            } else if (V instanceof Auto) {
                StdOut.println("patente del auto : " + ((Auto) V).getPatente());
                StdOut.println("marca del auto: " + ((Auto) V).getMarca());
                StdOut.println("año de fabricacion del auto: " + ((Auto) V).getAñofabricacion());
                StdOut.println("kilometraje del auto: " + ((Auto) V).getKilometraje());
                StdOut.println("capacidad de estanque del auto: " + ((Auto) V).getCapacidadEstanque());
            }
        }
    }

    public static void patenteVehiculo(ListaVehiculos lv) {
        StdOut.print("ingrese patente del vehiculo que desea a buscar: ");
        String patenteb = StdIn.readString();
        Vehiculo V = lv.buscarVehiculo(patenteb);
        if (V != null) {
            if (V instanceof Camioneta) {
                StdOut.println("patente de la camioneta : " +  V.getPatente());
                StdOut.println("marca de la camioneta: " +  V.getMarca());
                StdOut.println("año de fabricacion de la camionatea: " +  V.getAñofabricacion());
                StdOut.println("capacidad de carga de la camioneta: " + ((Camioneta) V).getCapacidadCarga());
                StdOut.println("costo de repacion de la camioneta: " + ((Camioneta) V).costoreparacion());
            } else if (V instanceof Auto) {
                StdOut.println("patente del auto : " + ((Auto) V).getPatente());
                StdOut.println("marca del auto: " + ((Auto) V).getMarca());
                StdOut.println("año de fabricacion del auto: " + ((Auto) V).getAñofabricacion());
                StdOut.println("kilometraje del auto: " + ((Auto) V).getKilometraje());
                StdOut.println("capacidad de estanque del auto: " + ((Auto) V).getCapacidadEstanque());
                StdOut.println("costo de repacion del auto: " + ((Auto) V).costoreparacion());
            }
        }else{
            StdOut.println("no se encontro vehiculo");
        }

    }

    public static void cantVehiculos(ListaVehiculos lv) {
        int cantautos = 0;
        int cantcamionetas = 0;
        for (int i = 0; i < lv.getCantvehiculos(); i++) {
            Vehiculo V = lv.getVehiculo(i);
            if (V instanceof Camioneta) {
                cantcamionetas++;
            } else {
                cantautos++;
            }
        }
        StdOut.println("cantidad total de vehiculos: " + lv.getCantvehiculos());
        StdOut.println("cantidad total de autos: " + cantautos);
        StdOut.println("cantidad total de camionetas: " + cantcamionetas);
    }

    public static void camionetaMayorCarga(ListaVehiculos lv) {
        Vehiculo v = null;
        int mayor = 0;
        for (int i = 0; i < lv.getCantvehiculos(); i++) {
            Vehiculo V = lv.getVehiculo(i);
            if (V instanceof Camioneta) {
                if (((Camioneta) V).getCapacidadCarga() > mayor) {
                    mayor = ((Camioneta) V).getCapacidadCarga();
                    v = V;
                }
            }
        }
        StdOut.println("patente de la camioneta : " + ((Camioneta) v).getMarca());
        StdOut.println("marca de la camioneta: " + ((Camioneta) v).getMarca());
        StdOut.println("año de fabricacion de la camionatea: " + ((Camioneta) v).getAñofabricacion());
        StdOut.println("capacidad de carga de la camioneta: " + ((Camioneta) v).getCapacidadCarga());
    }

    public static void main(String[] args) {
        ListaVehiculos lv = new ListaVehiculos(10000);
        Ejemplosabstrac.menuApp(lv);

    }

}
