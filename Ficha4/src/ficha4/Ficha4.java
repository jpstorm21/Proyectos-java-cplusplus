package ficha4;

import ucn.*;

public class Ficha4 {

    public static void leerDeptos(ListaEmpleados le, ListaDepartamentos ld) {
        StdOut.print("ingrese codigo del departamento: ");
        int codigo = StdIn.readInt();
        while (codigo != 999) {
            StdOut.print("ingrese nombre del departamento: ");
            String nombre = StdIn.readString();
            StdOut.print("ingrese presuspuesto del departamento: ");
            int presupuesto = StdIn.readInt();
            Departamento D = new Departamento(codigo, nombre, presupuesto);
            boolean sepudo = ld.ingresarDepartamento(D);
            if (sepudo == true) {
                StdOut.println("se ingreso departamento correctamente");
            } else {
                StdOut.println("lista llena");
            }
            StdOut.print("ingrese codigo del departamento: ");
            codigo = StdIn.readInt();
        }
    }

    public static void leerEmpleados(ListaEmpleados le, ListaDepartamentos ld) {
        StdOut.print("ingrese valor por hora :");
        int valorhora = StdIn.readInt();
        StdOut.print("ingrese rut: ");
        String rut = StdIn.readString();
        while (!rut.equals("111")) {
            StdOut.print("ingrese nombre: ");
            String nombre = StdIn.readString();
            StdOut.print("ingrese codigo de departamento: ");
            int codigo = StdIn.readInt();
            StdOut.print("ingrese tipo de empleado [1] jornada completa o [2] honorario: ");
            int tipo = StdIn.readInt();
            Departamento D = ld.buscarDepartamento(codigo);
            if (D != null) {
                if (tipo == 1) {
                    StdOut.print("ingrese sueldo base: ");
                    int sueldobase = StdIn.readInt();
                    Empleado E = new JornadaCompleta(sueldobase, nombre, rut);
                    boolean sepudo = le.ingresarEmpleado(E);
                    if (sepudo == true) {
                        StdOut.println("se ingreso empleado correctamente");
                        E.setDepartamento(D);
                        D.getLe().ingresarEmpleado(E);
                    } else {
                        StdOut.println("lista llena");
                    }
                } else if (tipo == 2) {
                    StdOut.print("ingrese cantidad de horas: ");
                    int canthoras = StdIn.readInt();
                    Empleado E = new Honorario(canthoras, nombre, rut);
                    ((Honorario) E).setValorhora(valorhora);
                    boolean sepudo = le.ingresarEmpleado(E);
                    if (sepudo == true) {
                        StdOut.println("se ingreso empleado correctamente");
                        E.setDepartamento(D);
                        D.getLe().ingresarEmpleado(E);
                    } else {
                        StdOut.println("lista llena");
                    }
                } else if (tipo != 1 || tipo != 2) {
                    StdOut.println("dato no valido, empieze nuevamente");

                }

            }
            StdOut.print("ingrese rut: ");
            rut = StdIn.readString();

        }

    }

    public static void desplegarDatosDepartamentos(ListaEmpleados le, ListaDepartamentos ld) {
        int cantEmpleadosJornada = 0;
        int cantEmpleadosHonorario = 0;
        for (int i = 0; i < ld.getCantdptos(); i++) {
            Departamento D = ld.getDepartamento(i);
            StdOut.println("nombre del departamento " + (i + 1) + " : " + D.getNombre());
            for (int j = 0; j < D.getLe().getCantempleados(); j++) {
                Empleado E = D.getLe().getEmpleado(j);
                if (E instanceof JornadaCompleta) {
                    cantEmpleadosJornada++;
                } else {
                    cantEmpleadosHonorario++;
                }
            }
            StdOut.println("cantidad de empleados jornada completa : " + cantEmpleadosJornada);
            StdOut.println("cantidad de empleados honorarios  : " + cantEmpleadosHonorario);
        }
    }

    public static void desplegarEmpleado(ListaEmpleados le, ListaDepartamentos ld) {
        StdOut.print("ingrese rut del empleado que desea buscar: ");
        String rutb = StdIn.readString();
        Empleado E = le.buscarEmpleado(rutb);
        StdOut.println("nombre del empleado : " + E.getNombre());
        StdOut.println("nombre del departamento al cual pertenece : " + E.getDepartamento().getNombre());
        if (E instanceof JornadaCompleta) {
            StdOut.println("el tipo de empleado es : jornada completa ");
            StdOut.println("su sueldo es : " + ((((JornadaCompleta) E).getSueldobase()) + (E.getDepartamento().getPresupuesto() * 0.01)));
        } else {
            StdOut.println("el tipo de empleado es : honorario ");
            StdOut.println("su sueldo es: " + ((Honorario) E).calcularSueldo());
        }

    }

    public static void menuApp(ListaEmpleados le, ListaDepartamentos ld) {
        int opcion = 0;
        while (opcion != 5) {
            StdOut.println("\t [menu]");
            StdOut.println("1-leer departamentos: ");
            StdOut.println("2-leer empleados");
            StdOut.println("3-desplegarDatosDepartamentos:");
            StdOut.println("4-desplegarEmpleado: ");
            StdOut.println("5-salir");
            StdOut.println("---------------------------------");
            StdOut.print(">");
            opcion = StdIn.readInt();
            switch (opcion) {
                case 1:
                    Ficha4.leerDeptos(le, ld);
                    break;
                case 2:
                    Ficha4.leerEmpleados(le, ld);
                    break;
                case 3:
                    Ficha4.desplegarDatosDepartamentos(le, ld);
                    break;
                case 4:
                    Ficha4.desplegarEmpleado(le, ld);
                    break;

                default:
                    opcion = 5;
            }

        }
    }

    public static void main(String[] args) {
        ListaEmpleados le = new ListaEmpleados(1000);
        ListaDepartamentos ld = new ListaDepartamentos(1000);
        Ficha4.menuApp(le, ld);

    }

}
