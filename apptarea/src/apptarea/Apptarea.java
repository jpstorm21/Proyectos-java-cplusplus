package apptarea;

import ucn.*;

public class Apptarea {

    public static void leerCarreras(ListaAsignaturas la, ListaCarreras lc, ListaParalelos lp, ListaProfesores lpro) {
        StdOut.print("ingrese cantidad de carreras: ");
        int cant = StdIn.readInt();
        for (int i = 0; i < cant; i++) {
            StdOut.print("ingrese nombre de la carrera: ");
            String nombre = StdIn.readString();
            StdOut.print("ingrese codigo de la carrera: ");
            int codigo = StdIn.readInt();
            Carrera C = new Carrera(codigo, nombre);
            lc.ingresarCarrea(C);

        }
    }

    public static void leerProfesores(ListaAsignaturas la, ListaCarreras lc, ListaParalelos lp, ListaProfesores lpro) {
        StdOut.print("ingrese cantidad de profesores: ");
        int cantpro = StdIn.readInt();
        for (int i = 0; i < cantpro; i++) {
            StdOut.print("ingrese rut: ");
            String rut = StdIn.readString();
            StdOut.print("ingrese nombre :");
            String nombre = StdIn.readString();
            StdOut.print("ingrese tipo de profesor[1] profesor jornada completa[2] profesor media jornada o [3] profesor hora: ");
            int tipo = StdIn.readInt();
            if (tipo == 1) {
                StdOut.print("ingrese jerarquia del profesor jornada completa: ");
                String jerarquia = StdIn.readString();
                StdOut.print("ingrese titulo del profesor jornada completa: ");
                String titulo = StdIn.readString();
                Profesor P = new JornadaCompleta(titulo, jerarquia, rut, nombre);
                lpro.ingresarProfesor(P);

            } else if (tipo == 2) {
                StdOut.print("ingrse el grado: ");
                int grado = StdIn.readInt();
                Profesor P = new MediaJornada(grado, rut, nombre);
                lpro.ingresarProfesor(P);

            } else if (tipo == 3) {
                StdOut.print("ingrese valor de hora: ");
                int valorhora = StdIn.readInt();
                StdOut.print("ingrese cantidad de horas: ");
                int canthoras = StdIn.readInt();
                Profesor P = new Hora(canthoras, valorhora, rut, nombre);
                lpro.ingresarProfesor(P);

            } else if (tipo != 1 || tipo != 2 || tipo != 3) {
                StdOut.println("dato no valido ingrese nuevamente");
            }
        }
    }

    public static void leerAsignaturas(ListaAsignaturas la, ListaCarreras lc, ListaParalelos lp, ListaProfesores lpro) {
        StdOut.print("ingrese codigo de la asignatura: ");
        String cod = StdIn.readString();
        while (!cod.equals("xxx")) {
            StdOut.print("nombre de la asignatura: ");
            String nombre = StdIn.readString();
            StdOut.print("ingrese creditos de la asignatura: ");
            int creditos = StdIn.readInt();
            Asignatura A = new Asignatura(cod, nombre, creditos);
            la.ingresarAsignatura(A);

            for (int i = 0; i < lc.cantCarreras(); i++) {
                StdOut.print("codigo de la carrera en que se dicta: ");
                int codigo = StdIn.readInt();
                Carrera C = lc.buscarCarrera(codigo);
                if (C != null) {
                    C.getLa().ingresarAsignatura(A);
                    A.getLc().ingresarCarrea(C);
                }
                StdOut.print("cantidad de paralelos que se dicta la asignatura: ");
                int cantp = StdIn.readInt();
                for (int j = 0; j < cantp; j++) {
                    StdOut.print("numero del  paralelo : ");
                    int numero = StdIn.readInt();
                    StdOut.print("rut del profesor que lo dicta :");
                    String rutp = StdIn.readString();
                    Paralelo PL = new Paralelo(numero);
                    lp.ingresarParalelo(PL);

                }
            }
            StdOut.print("ingrese codigo de la asignatura: ");
            cod = StdIn.readString();
        }
    }

    public static void requerimiento1(ListaAsignaturas la, ListaCarreras lc, ListaParalelos lp, ListaProfesores lpro) {
        StdOut.print("ingrese codigo de la asignatura que desea  buscar: ");
        String codb = StdIn.readString();
        Asignatura A = la.buscarAsignatura(codb);
        if (A != null) {
            for (int i = 0; i < A.getLc().getCantCarreras(); i++) {
                StdOut.println("carreras en que se imparte la asignatura: " + A.getLc().getCarrera(i).getNombre());
                StdOut.println("profesores que dictan la asignatura: " + A.getLp().getParalelo(i).getProfesor().getNombre());
            }
        } else {
            StdOut.println("asignatura no existe");
        }-

    }

    public static void requerimiento2(ListaAsignaturas la, ListaCarreras lc, ListaParalelos lp, ListaProfesores lpro) {
        int cantprofesoresJornadaCompleta = 0;
        for (int i = 0; i < lpro.getCantProfesores(); i++) {
            Profesor P = lpro.getProfesor(i);
            if (P instanceof JornadaCompleta) {
                cantprofesoresJornadaCompleta++;
            }
        }
        StdOut.println("cantidad de profesores joranda completa: " + cantprofesoresJornadaCompleta);
    }

    public static void requerimiento3(ListaAsignaturas la, ListaCarreras lc, ListaParalelos lp, ListaProfesores lpro) {
        StdOut.print("ingrese rut de profesor que desea buscar: ");
        String rutb = StdIn.readString();
        Profesor P = lpro.buscarProfesor(rutb);
        if (P != null) {
            if (P instanceof JornadaCompleta) {
                StdOut.println("rut: " + P.getRut());
                StdOut.println("nombre: " + P.getNombre());
                StdOut.println("tipo : profesor jornada completa");
                StdOut.println("titulo: " + ((JornadaCompleta) P).getTitulo());
                StdOut.println("jerarquia: " + ((JornadaCompleta) P).getJerarquia());
                for (int i = 0; i < P.getLp().getCantParalelos(); i++) {
                    StdOut.println("datos de las asignaturas que dicta: ");
                    StdOut.println("codigo: " + P.getLp().getParalelo(i).getAsignatura().getCodigo());
                    StdOut.println("nombre: " + P.getLp().getParalelo(i).getAsignatura().getNombre());
                    StdOut.println("numero de paralelo: " + P.getLp().getParalelo(i).getNumero());
                }
            } else if (P instanceof MediaJornada) {
                StdOut.println("rut: " + P.getRut());
                StdOut.println("nombre: " + P.getNombre());
                StdOut.println("tipo : profesor media jornada");
                StdOut.println("grado: " + ((MediaJornada) P).getGrado());
                for (int i = 0; i < P.getLp().getCantParalelos(); i++) {
                    StdOut.println("datos de las asignaturas que dicta: ");
                    StdOut.println("codigo: " + P.getLp().getParalelo(i).getAsignatura().getCodigo());
                    StdOut.println("nombre: " + P.getLp().getParalelo(i).getAsignatura().getNombre());
                    StdOut.println("numero de paralelo: " + P.getLp().getParalelo(i).getNumero());
                }
            } else {
                StdOut.println("rut: " + P.getRut());
                StdOut.println("nombre: " + P.getNombre());
                StdOut.println("tipo : profesor hora");
                StdOut.println("cantidad de horas : " + ((Hora) P).getCantidadHoras());
                StdOut.println("valor hora: " + ((Hora) P).getValorHora());
                for (int i = 0; i < P.getLp().getCantParalelos(); i++) {
                    StdOut.println("datos de las asignaturas que dicta: ");
                    StdOut.println("codigo: " + P.getLp().getParalelo(i).getAsignatura().getCodigo());
                    StdOut.println("nombre: " + P.getLp().getParalelo(i).getAsignatura().getNombre());
                    StdOut.println("numero de paralelo: " + P.getLp().getParalelo(i).getNumero());
                }
            }

        }
    }

    public static void requerimiento4(ListaAsignaturas la, ListaCarreras lc, ListaParalelos lp, ListaProfesores lpro) {
        for (int i = 0; i < lpro.getCantProfesores(); i++) {
            Profesor P = lpro.getProfesor(i);
            StdOut.println("nombre: " + P.getNombre());
            StdOut.println("rut: " + P.getRut());
            StdOut.println("sueldo: " + P.calcularSueldo());
        }
    }

    public static void requerimiento5(ListaAsignaturas la, ListaCarreras lc, ListaParalelos lp, ListaProfesores lpro) {
        StdOut.print("ingrese codigo de la asignatura: ");
        String cod = StdIn.readString();
        Asignatura A = la.buscarAsignatura(cod);
        if (A != null) {
            StdOut.print("ingrese numero de paralelo: ");
            int numero = StdIn.readInt();
            Paralelo PL = A.getLp().buscarParalelo(numero);
            if (PL != null) {
                StdOut.println("rut del profesor: " + PL.getProfesor().getRut());
                StdOut.println("nombre del profesor :" + PL.getProfesor().getNombre());
                Profesor P = PL.getProfesor();
                if (P instanceof JornadaCompleta) {
                    StdOut.println("profesor tipo jornada completa");
                } else if (P instanceof MediaJornada) {
                    StdOut.println("profesor tipo media jornada");
                } else {
                    StdOut.println("profesor tipo hora");
                }
            }

        }
    }

    public static void requerimiento6(ListaAsignaturas la, ListaCarreras lc, ListaParalelos lp, ListaProfesores lpro) {
        for (int i = 0; i < lc.getCantCarreras(); i++) {
            Carrera C = lc.getCarrera(i);
            StdOut.println("codigo de la carrera: " + C.getCodigo());
            StdOut.println("nombre de la carrea: " + C.getNombre());
            for (int j = 0; j < C.getLa().getCantAsignaturas(); j++) {
                Asignatura A = C.getLa().getAsignatura(j);
                StdOut.println("codigo de la asignatua : " + A.getCodigo());
                StdOut.println("nombre de la asignatua: " + A.getNombre());
                StdOut.println("cantidad de craditos de la asignatua: " + A.getCreditos());
                StdOut.println("cantidad de paralelos en que se dicta: " + A.getLp().getCantParalelos());
            }
        }
    }

    public static void requerimiento7(ListaAsignaturas la, ListaCarreras lc, ListaParalelos lp, ListaProfesores lpro) {
        StdOut.print("ingrese codigo de la carrea: ");
        int codC = StdIn.readInt();
        StdOut.print("ingrese codigo asignatura: ");
        String codA = StdIn.readString();
        Asignatura A = la.buscarAsignatura(codA);
        Carrera C = lc.buscarCarrera(codC);
        if (A != null && C != null) {
            for (int i = 0; i < A.getLc().getCantCarreras(); i++) {
                if (A.getLc().buscarCarrera(codC) == C) {
                    StdOut.println("asignatura si se dicta en la carrera");
                }
            }
        }
    }

    public static void requerimiento8(ListaAsignaturas la, ListaCarreras lc, ListaParalelos lp, ListaProfesores lpro) {
        StdOut.print("ingrese rut del profesor que desea eliminar: ");
        String rutb = StdIn.readString();
        Profesor P = lpro.buscarProfesor(rutb);
        for (int i = 0; i < 1; i++) {
            Asignatura A = P.getLp().getParalelo(i).getAsignatura();
            if (A != null) {
                StdOut.println("profesor esta dictando un ramo no se puede eliminar");
            } else {
                boolean sepudo = lpro.eliminarProfesor(P);
                if (sepudo == true) {
                    StdOut.println("profesor eliminado");
                }
            }
        }

    }

    public static void menuApp(ListaAsignaturas la, ListaCarreras lc, ListaParalelos lp, ListaProfesores lpro) {
        int opcion = 0;
        while (opcion != 12) {
            StdOut.println("\t [menu]");
            StdOut.println("1-leer carreras:");
            StdOut.println("2-leer profesores : ");
            StdOut.println("3-leer asignaturas:");
            StdOut.println("4-requerimiento 1:");
            StdOut.println("5-requerimiento 2:");
            StdOut.println("6-requerimiento 3:");
            StdOut.println("7-requerimiento 4:");
            StdOut.println("8-requerimiento 5:");
            StdOut.println("9-requerimiento 6:");
            StdOut.println("10-requerimiento 7:");
            StdOut.println("11-requerimiento 8:");
            StdOut.println("12-salir: ");
            StdOut.println("---------------------------------");
            StdOut.print(">");
            opcion = StdIn.readInt();
            switch (opcion) {
                case 1:
                    Apptarea.leerCarreras(la, lc, lp, lpro);
                    break;
                case 2:
                    Apptarea.leerProfesores(la, lc, lp, lpro);
                    break;
                case 3:
                    Apptarea.leerAsignaturas(la, lc, lp, lpro);
                    break;
                case 4:
                    Apptarea.requerimiento1(la, lc, lp, lpro);
                    break;
                case 5:
                    Apptarea.requerimiento2(la, lc, lp, lpro);
                    break;
                case 6:
                    Apptarea.requerimiento3(la, lc, lp, lpro);
                    break;
                case 7:
                    Apptarea.requerimiento4(la, lc, lp, lpro);
                    break;
                case 8:
                    Apptarea.requerimiento5(la, lc, lp, lpro);
                    break;
                case 9:
                    Apptarea.requerimiento6(la, lc, lp, lpro);
                    break;
                case 10:
                    Apptarea.requerimiento7(la, lc, lp, lpro);
                    break;
                case 11:
                    Apptarea.requerimiento8(la, lc, lp, lpro);
                    break;
                default:
                    opcion = 12;
            }

        }
    }

    public static void main(String[] args) {
        ListaAsignaturas la = new ListaAsignaturas(1000);
        ListaCarreras lc = new ListaCarreras(1000);
        ListaParalelos lp = new ListaParalelos(1000);
        ListaProfesores lpro = new ListaProfesores(1000);
        Apptarea.menuApp(la, lc, lp, lpro);
    }

}
