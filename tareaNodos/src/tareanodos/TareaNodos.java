package tareanodos;

import ucn.*;

public class TareaNodos {

    public static void leerDatos(ListaEmpleados le, ListaTelefonos lt) {
        StdOut.print("ingrese rut del empleado(FIN de datos 111): ");
        String rut = StdIn.readString();
        while (!rut.equals("111")) {
            StdOut.print("ingrese nombre del empleado: ");
            String nombre = StdIn.readString();
            Empleado E = new Empleado(rut, nombre);
            le.ingresarEmpleado(E);
            StdOut.print("ingrese cantidad de telefonos: ");
            int cantTelefonos = StdIn.readInt();
            for (int i = 0; i < cantTelefonos; i++) {
                StdOut.print("ingrese numero de telefono: ");
                int fono = StdIn.readInt();
                Telefono T = new Telefono(fono);
                E.getLt().ingresarTelefono(T);
            }
            StdOut.print("ingrese rut del empleado(FIN de datos 111): ");
            rut = StdIn.readString();
        }
    }

    public static void requerimiento1(ListaEmpleados le, ListaTelefonos lt) {
        StdOut.print("ingrese numero de telefono a registrar : ");
        int fono = StdIn.readInt();
        Telefono T = new Telefono(fono);
        StdOut.print("ingrese rut del empleado al cual se lo va a registrar: ");
        String rut = StdIn.readString();
        Empleado E = le.buscarEmpleado(rut);
        if (E != null) {
            E.getLt().ingresarTelefono(T);
            StdOut.println("telefono ingresado correctamente : ");
        } else {
            StdOut.println("empleado no existe");
        }
    }

    public static void requerimiento2(ListaEmpleados le, ListaTelefonos lt) {
        StdOut.print("ingrese rut del empleado al cual le eliminara un telefono : ");
        String rut = StdIn.readString();
        StdOut.print("ingrese numero de telefono a eliminar : ");
        int fono = StdIn.readInt();
        Empleado E = le.buscarEmpleado(rut);
        if (E != null) {
            boolean eliminar = E.getLt().eliminarTelefono(fono);
            if (eliminar == true) {
                StdOut.println("numero eliminado exitosamente");
            } else {
                StdOut.println("no se puedo eliminar");
            }
        } else {
            StdOut.println("empleado no existe");
        }
    }

    public static void requerimiento3(ListaEmpleados le, ListaTelefonos lt) {
        NodoEmpleado actual = le.getFirstEmpleado();
        int cant = 0;
        do {
            Empleado E = actual.getEmpleado();
            NodoTelefono T = E.getLt().getFirstTelefono();
            if (T == null) {
                boolean eliminar = le.eliminarEmpleado(E.getRut());
                cant++;
            }
            actual = actual.getNextEmpleado();

        } while (actual != le.getFirstEmpleado());
        StdOut.println("se eliminaron : " + cant + " empleados");
    }
    public static void desplegar(ListaEmpleados le, ListaTelefonos lt){
        NodoEmpleado actual = le.getFirstEmpleado();
        do{
            Empleado E = actual.getEmpleado();
            StdOut.println("nombre del empleado : " + E.getNombre());
            StdOut.println("rut del empleado : " + E.getRut());
            NodoTelefono actualT = E.getLt().getFirstTelefono();
            while(actualT != null){
                Telefono T = actualT.getTelefono();
                StdOut.println("numero de telefono : " + T.getFono() );
                actualT = actualT.getNextTelefono();
            }
            actual = actual.getNextEmpleado();
            }while(actual != le.getFirstEmpleado());
            
            
        }
    

    public static void main(String[] args) {
        ListaEmpleados le = new ListaEmpleados();
        ListaTelefonos lt = new ListaTelefonos();
        leerDatos(le, lt);
        StdOut.println("requerimiento 1");
        requerimiento1(le, lt);
        StdOut.println("requerimiento 2");
        requerimiento2(le, lt);
        StdOut.println("requerimiento 3");
        requerimiento3(le, lt);
        desplegar(le,lt);
    }

}
