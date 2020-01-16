package problemaversion2nexos;

import java.util.Scanner;

public class ProblemaVersion2nexos {

    public static void leerCarreras(ListaCarreras lc, Scanner sc) {
        System.out.print("ingrese cantidad de carreras : ");
        int cant = sc.nextInt();
        for (int i = 0; i < cant; i++) {
            System.out.print("ingrese codigo de la carrera: ");
            int cod = sc.nextInt();
            System.out.print("ingrese nombre de la carrera: ");
            String nombre = sc.next();
            Carrera C = new Carrera(cod, nombre);
            lc.ingresarCarrera(C);
        }
        System.out.println("carrera(s) ingresadas correctamente");
    }

    public static void leerProfesores(ListaProfesores lpro, Scanner sc) {
        System.out.print("ingrese cantidad de profesores: ");
        int cant = sc.nextInt();
        for (int i = 0; i < cant; i++) {
            System.out.print("ingrese rut del profesor : ");
            String rut = sc.next();
            System.out.print("ingrese nombre del profesor: ");
            String nombre = sc.next();
            System.out.print("ingrese tipo de profesor [1]Jornada completa [2]media jornada [3]profesor hora: ");
            int tipo = sc.nextInt();
            if (tipo == 1) {
                System.out.print("ingrese titulo : ");
                String titulo = sc.next();
                System.out.print("ingrese jerarquia[titular] [asociado] [asistente] [instructor]: ");
                String jerarquia = sc.next();
                Profesor P = new JornadaCompleta(titulo, jerarquia, rut, nombre);
                lpro.ingresarProfesor(P);
            } else if (tipo == 2) {
                System.out.print("ingrese su grado 1[licenciado] 2[magister] 3[doctor]: ");
                int grado = sc.nextInt();
                Profesor P = new MediaJornada(grado, rut, nombre);
                lpro.ingresarProfesor(P);
            } else if (tipo == 3) {
                System.out.print("ingrese el valor de hora: ");
                int valorhora = sc.nextInt();
                System.out.print("ingrese cantidad de horas: ");
                int canthoras = sc.nextInt();
                Profesor P = new Hora(valorhora, canthoras, rut, nombre);
                lpro.ingresarProfesor(P);
            } else if (tipo != 1 || tipo != 2 || tipo != 3) {
                System.out.println("dato no valido");
            }
        }
        System.out.println("profesor(s) ingresados correctamente");
    }

    public static void leerAsignaturas(ListaAsignaturas la, ListaParalelos lp, Scanner sc, ListaCarreras lc, ListaProfesores lpro) {
        System.out.print("ingrese codigo de la asignatura(FIN xxx): ");
        String cod = sc.next();
        while (!cod.equals("xxx")) {
            System.out.print("ingrese nombre de la asignatura: ");
            String nombre = sc.next();
            System.out.print("ingrese creditos de la asignatura : ");
            int creditos = sc.nextInt();
            Asignatura A = new Asignatura(cod, nombre, creditos);
            la.ingresarAsignatura(A);
            NodoCarrera actual = lc.getFirstCarrera();
            while (actual != null) {
                System.out.print("ingrese codigo de la carrera en que se dicta: ");
                int codigo = sc.nextInt();
                Carrera C = lc.buscarCarrera(codigo);
                C.getLa().ingresarAsignatura(A);
                A.getLc().ingresarCarrera(C);
                actual = actual.getNextCarrera();
            }
            System.out.print("cantidad de paralelos en que se dicta la asignatura: ");
            int cant = sc.nextInt();
            for (int i = 0; i < cant; i++) {
                System.out.print("ingrese numero del paralelo: ");
                int numero = sc.nextInt();
                Paralelo PA = new Paralelo(numero);
                lp.ingresarParalelo(PA);
                System.out.print("ingrese rut del profesor que la dicta: ");
                String rut = sc.next();
                Profesor P = lpro.buscarProfesor(rut);
                P.getLp().ingresarParalelo(PA);
                PA.setProfesor(P);
                PA.setAsignatura(A);
                A.getLp().ingresarParalelo(PA);
            }
            System.out.print("ingrese codigo de la asignatura(FIN xxx): ");
            cod = sc.next();
        }
        System.out.println("asignaturas ingresadas correctamente");
    }

    public static void menuApp(ListaAsignaturas la, ListaCarreras lc, ListaParalelos lp, ListaProfesores lpro, Scanner sc) {
        int opcion = 0;
        while (opcion != 12) {
            System.out.println("\t [menu]");
            System.out.println("1-leer carreras:");
            System.out.println("2-leer profesores : ");
            System.out.println("3-leer asignaturas:");
            System.out.println("4-requerimiento 1:");
            System.out.println("5-requerimiento 2:");
            System.out.println("6-requerimiento 3:");
            System.out.println("7-requerimiento 4:");
            System.out.println("8-requerimiento 5:");
            System.out.println("9-requerimiento 6:");
            System.out.println("10-requerimiento 7:");
            System.out.println("11-requerimiento 8:");
            System.out.println("12-salir: ");
            System.out.println("---------------------------------");
            System.out.print(">");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    leerCarreras(lc, sc);
                    break;
                case 2:
                    leerProfesores(lpro, sc);
                    break;
                case 3:
                    leerAsignaturas(la, lp, sc, lc, lpro);
                    break;
                case 4:
                    requerimiento1(la, sc);
                    break;
                case 5:
                    requerimiento2(lpro, sc);
                    break;
                case 6:
                    requerimiento3(sc, lpro);
                    break;
                case 7:
                    requerimiento4(sc, lpro);
                    break;
                case 8:
                    ProblemaVersion2nexos.requerimiento5(sc, la, lp);
                    break;
                case 9:
                    ProblemaVersion2nexos.requerimiento6(sc, lc);
                    break;
                case 10:
                    ProblemaVersion2nexos.requerimiento7(sc, lc, la);
                    break;
                case 11:
                    ProblemaVersion2nexos.requerimiento8(sc, lpro);
                    break;
                default:
                    opcion = 12;
            }

        }
    }

    public static void requerimiento1(ListaAsignaturas la, Scanner sc) {
        System.out.print("ingrese codigo de la asignatura que desea buscar: ");
        String cod = sc.next();
        Asignatura A = la.buscarAsignatura(cod);
        if (A != null) {
            NodoCarrera actual = A.getLc().getFirstCarrera();
            while (actual != null) {
                Carrera C = actual.getCarrera();
                System.out.println("nombre  : " + C.getNombre());
                NodoParalelo actualp = A.getLp().getFirstParalelo();
                while (actualp != null) {
                    Paralelo P = actualp.getParalelo();
                    Profesor pro = P.getProfesor();
                    System.out.println("nombre del profesor que la dicta: " + pro.getNombre());
                    actualp = actualp.getNextParalelo();
                }
                actual = actual.getNextCarrera();
            }
        } else {
            System.out.println("asignatura no existe");
        }
    }

    public static void requerimiento2(ListaProfesores lpro, Scanner sc) {
        int cont = 0;
        NodoProfesor actual = lpro.getFirstProfesor();
        while (actual != null) {
            Profesor P = actual.getProfesor();
            if (P instanceof JornadaCompleta) {
                cont++;
            }
            actual = actual.getNextProfesor();
        }
        System.out.println("la cantidad de profesor jornadas completa es : " + cont);
    }

    public static void requerimiento3(Scanner sc, ListaProfesores lpro) {
        System.out.print("ingrese rut del profesor a buscar : ");
        String rutb = sc.next();
        Profesor P = lpro.buscarProfesor(rutb);
        if (P != null) {
            System.out.println("nombre : " + P.getNombre());
            System.out.println("rut : " + P.getRut());
            NodoParalelo actual = P.getLp().getFirstParalelo();
            while (actual != null) {
                Paralelo Pa = actual.getParalelo();
                Asignatura A = Pa.getAsignatura();
                System.out.println("codigo : " + A.getCodigo());
                System.out.println("nombre : " + A.getNombre());
                System.out.println("paralelo : " + Pa.getNumero());
                actual = actual.getNextParalelo();
            }
            if (P instanceof JornadaCompleta) {
                System.out.println("titulo : " + ((JornadaCompleta) P).getTitulo());
                System.out.println("jerarquia : " + ((JornadaCompleta) P).getJerarquia());
                System.out.println("sueldo : " + P.calcularSueldo());
            } else if (P instanceof Hora) {
                System.out.println("valor de la hora: " + ((Hora) P).getValorhora());
                System.out.println("la cantidad de hora : " + ((Hora) P).getCanthoras());
                System.out.println("sueldo: " + P.calcularSueldo());
            } else if (P instanceof MediaJornada) {
                System.out.println("grado : " + ((MediaJornada) P).getGrado());
                System.out.println("sueldo : " + P.calcularSueldo());
            }
        }
    }

    public static void requerimiento4(Scanner sc, ListaProfesores lpro) {
        NodoProfesor actual = lpro.getFirstProfesor();
        while (actual != null) {
            Profesor P = actual.getProfesor();
            System.out.println("nombre: " + P.getNombre());
            System.out.println("rut : " + P.getRut());
            if (P instanceof JornadaCompleta) {
                System.out.println("sueldo : " + P.calcularSueldo());
            } else if (P instanceof Hora) {
                System.out.println("sueldo : " + P.calcularSueldo());
            } else if (P instanceof MediaJornada) {
                System.out.println("sueldo : " + P.calcularSueldo());
            }
            actual = actual.getNextProfesor();
        }
    }

    public static void requerimiento5(Scanner sc, ListaAsignaturas la, ListaParalelos lp) {
        System.out.print("ingrese numero de paralelo: ");
        int num = sc.nextInt();
        System.out.print("ingrese codigo de la asignatura : ");
        String cod = sc.next();
        Asignatura A = la.buscarAsignatura(cod);
        if (A != null) {
            Paralelo P = A.getLp().buscarParalelo(num);
            if (P != null) {
                Profesor pro = P.getProfesor();
                if (pro != null) {
                    System.out.println("rut : " + pro.getRut());
                    System.out.println("nombre : " + pro.getNombre());
                    if (pro instanceof JornadaCompleta) {
                        System.out.println("tipo jornada completa");
                    } else if (pro instanceof MediaJornada) {
                        System.out.println("tipo media jornada");
                    } else {
                        System.out.println("tipo hora");
                    }
                }
            }
        }
    }

    public static void requerimiento6(Scanner sc, ListaCarreras lc) {
        int cont = 0;
        NodoCarrera actual = lc.getFirstCarrera();
        while (actual != null) {
            Carrera C = actual.getCarrera();
            System.out.println("nombre : " + C.getNombre());
            System.out.println("codigo : " + C.getCodigo());
            NodoAsignatura actualA = C.getLa().getFirstAsignatura();
            while (actualA != null) {
                Asignatura A = actualA.getAsignatura();
                System.out.println("codigo : " + A.getCodigo());
                System.out.println("nombre: " + A.getNombre());
                System.out.println("creditos : " + A.getCreditos());
                NodoParalelo actualP = A.getLp().getFirstParalelo();
                while (actualP != null) {
                    cont++;
                    actualP = actualP.getNextParalelo();
                }
                System.out.println("cantidad de paralelos : " + cont);
                actualA = actualA.getNextAsignatura();
            }
            actual = actual.getNextCarrera();
        }
    }

    public static void requerimiento7(Scanner sc, ListaCarreras lc, ListaAsignaturas la) {
        System.out.print("ingrese codigo de la asignatura: ");
        String cod = sc.next();
        System.out.print("ingrese codigo de la carrera : ");
        int codb = sc.nextInt();
        Carrera C = lc.buscarCarrera(codb);
        if (C != null) {
            Asignatura A = C.getLa().buscarAsignatura(cod);
            if (A != null) {
                System.out.println("asignatura se dicta en la carrera");
            } else {
                System.out.println("no se dicta");
            }
        }
    }

    public static void requerimiento8(Scanner sc, ListaProfesores lpro) {
        System.out.print("ingrese rut del profesor a eliminar : ");
        String rut = sc.next();
        Profesor P = lpro.buscarProfesor(rut);
        if (P != null) {
            NodoParalelo actual = P.getLp().getFirstParalelo();
            Paralelo PA = actual.getParalelo();
            if (PA != null) {
                Asignatura A = PA.getAsignatura();
                if (A != null) {
                    System.out.println("profesor dictando un ramo no se puede eliminar");
                } else {
                    lpro.eliminarProfesor(rut);
                    System.out.println("profesor eliminado");
                }
            }
        } else {
            System.out.println("profesor no existe");
        }
    }

    public static void main(String[] args) {
        ListaCarreras lc = new ListaCarreras();
        ListaAsignaturas la = new ListaAsignaturas();
        ListaParalelos lp = new ListaParalelos();
        ListaProfesores lpro = new ListaProfesores();
        Scanner sc = new Scanner(System.in);
        menuApp(la, lc, lp, lpro, sc);
    }

}
