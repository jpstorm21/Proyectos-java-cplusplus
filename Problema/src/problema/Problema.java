package problema;

import ucn.*;

public class Problema {

    public static void leerCarreras(ListaAsignaturas la, ListaCarreras lc, ListaParalelos lp, ListaProfesores lpro) {
        StdOut.print("ingrese cantidad de carreras: ");
        int cant = StdIn.readInt();
        for (int i = 0; i < cant; i++) {
            StdOut.print("ingrese nombre de la carrera: ");
            String nombre = StdIn.readString();
            StdOut.print("ingrese codigo de la carrera: ");
            int codigo = StdIn.readInt();
            Carrera C = new Carrera(codigo, nombre);
            lc.insertarOrdenado(C);

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
                int jerarquia = StdIn.readInt();
                StdOut.print("ingrese titulo del profesor jornada completa: ");
                String titulo = StdIn.readString();
                Profesor P = new JornadaCompleta(titulo,jerarquia, rut, nombre);
                lpro.insertarProfesor(P);

            } else if (tipo == 2) {
                StdOut.print("ingrse el grado: ");
                int grado = StdIn.readInt();
                Profesor P = new MediaJornada(grado, rut, nombre);
                lpro.insertarProfesor(P);

            } else if (tipo == 3) {
                StdOut.print("ingrese valor de hora: ");
                int valorhora = StdIn.readInt();
                StdOut.print("ingrese cantidad de horas: ");
                int canthoras = StdIn.readInt();
                Profesor P = new Hora(canthoras, valorhora,nombre,rut);
                lpro.insertarProfesor(P);

            } else if (tipo != 1 || tipo != 2 || tipo != 3) {
                StdOut.println("dato no valido ingrese nuevamente");
            }
        }
    }

    public static void leerAsignaturas(ListaAsignaturas la, ListaCarreras lc, ListaParalelos lp, ListaProfesores lpro) {
        StdOut.print("ingrese codigo de la asignatura(xxx para terminar): ");
        String cod = StdIn.readString();
        while (!cod.equals("xxx")) {
            StdOut.print("nombre de la asignatura: ");
            String nombre = StdIn.readString();
            StdOut.print("ingrese creditos de la asignatura: ");
            int creditos = StdIn.readInt();
            Asignatura A = new Asignatura(cod, nombre, creditos);
            la.insertarAsignaturaAlinicio(A);
            NodoCarrera actualCarrera = lc.getPrimerCarrera();
            while(actualCarrera != null ) {
                StdOut.print("codigo de la carrera en que se dicta: ");
                int codigo = StdIn.readInt();
                Carrera C = lc.buscarCarrera(codigo);
                if (C != null) {
                    C.getListaAsignaturas().insertarAsignaturaAlinicio(A);
                    A.getListaCarreras().insertarOrdenado(C);
                }
                StdOut.print("cantidad de paralelos que se dicta la asignatura: ");
                int cantp = StdIn.readInt();
                for (int j = 0; j < cantp; j++) {
                    StdOut.print("numero del  paralelo : ");
                    int numero = StdIn.readInt();
                    StdOut.print("rut del profesor que lo dicta :");
                    String rutp = StdIn.readString();
                    Paralelo PL = new Paralelo(numero);
                    lp.insertarParalelo(PL);

                }
                actualCarrera = actualCarrera.getSiguienteCarrera();
            }
            StdOut.print("ingrese codigo de la asignatura: ");
            cod = StdIn.readString();
        }
    }
    public static void desplegarCarreras1(ListaAsignaturas la, ListaCarreras lc, ListaProfesores lpro, ListaParalelos lp) {
        StdOut.print("ingrese codigo de asignatura que desea buscar: ");
        String codB = StdIn.readString();
        Asignatura A = la.buscarAsignatura(codB);
        if(A != null){
            NodoCarrera actualCarrera = A.getListaCarreras().getPrimerCarrera();
            while(actualCarrera !=null){
                Carrera C = actualCarrera.getCarrera();
                StdOut.println("nombres de carreras en que se imparte la asignatura : " + C.getNombre() );
                actualCarrera = actualCarrera.getSiguienteCarrera();
            }
            NodoParalelo actualParalelo = A.getListaParalelos().getPrimerParalelo();
            while(actualParalelo != null){
                Paralelo p = actualParalelo.getParalelo();
                StdOut.println("nombres de los profesores que dictan la asignatura: " + p.getProfesor().getNombre());
                actualParalelo = actualParalelo.getSiguienteParalelo();
            }
            }else{
           StdOut.println("asignatura no existe ");
        }
        }

    public static void cantidadProfesoresJornadaCompleta2(ListaProfesores lpro) {
        NodoProfesor actual = lpro.getPrimerProfesor();
        int profesoresJC = 0;
        while(actual != null){
            Profesor P = actual.getProfesor();
            if(P instanceof JornadaCompleta){
                profesoresJC++;
            }
            actual = actual.getSiguienteProfesor();
        }
        StdOut.println("cantidad de profesores jornada completa son : " + profesoresJC);
    }
        

    public static void DatosProfesor3(ListaProfesores lpro) {
        StdOut.print("ingrese rut del profesor que desea buscar : ");
        String rutB = StdIn.readString();
        Profesor P = lpro.buscarProfesor(rutB);
        if(P !=null){
            StdOut.println("nombre del profesor : " + P.getNombre());
            StdOut.println("rut del profesor : " + P.getRut());
            if(P instanceof JornadaCompleta){
                StdOut.println("profesor jornada completa");
                StdOut.println("titulo : "  + ((JornadaCompleta) P).getTitulo());
                StdOut.println("jerarquia : " + ((JornadaCompleta)P).getJerarquia() );
            }else if( P instanceof Hora){
                StdOut.println("profesor hora");
                StdOut.println("cantidad de horas del profesor : " + ((Hora)P).getCantHoras());
                StdOut.println("el valor de la hora del profesor es " + ((Hora)P).getValorHora());
            }else if(P instanceof MediaJornada){
                StdOut.println("profesor media jornada");
                StdOut.println("grado del profesor : " + ((MediaJornada) P).getGrado());
            }
            NodoParalelo actualParalelo = P.getListaParalelos().getPrimerParalelo();
            while(actualParalelo != null){
                Paralelo PA = actualParalelo.getParalelo();
                StdOut.println("nombre de las asignatura que dicta : " + PA.getAsignatura().getNombre());
                StdOut.println("codigo de la asignatura: " + PA.getAsignatura().getCodigo());
                StdOut.println("numero del paralelo : " + PA.getNumero());
                actualParalelo = actualParalelo.getSiguienteParalelo();
            }
        }
    }
        

    public static void ProfesoresySueldos4(ListaProfesores lpro) {
        NodoProfesor actualProfesor = lpro.getPrimerProfesor();
        while(actualProfesor != null){
            Profesor P= actualProfesor.getProfesor();
            StdOut.println("nombre : " + P.getNombre());
            StdOut.println("rut: " + P.getRut());
            if(P instanceof JornadaCompleta){
                StdOut.println(" sueldo : " + ((JornadaCompleta)P).calcularSueldo());
            }else if(P instanceof Hora){
                StdOut.println("sueldo : " + ((Hora)P).calcularSueldo());
            }else if (P instanceof MediaJornada){
                StdOut.println("sueldo : " + ((MediaJornada)P).calcularSueldo());
            }
            actualProfesor = actualProfesor.getSiguienteProfesor();
        }
    }
       

    public static void eliminarProfesor8(ListaProfesores lpro,ListaParalelos lp) {
        StdOut.println("Ingrese rut del profesor para eliminar: ");
        String rut = StdIn.readString();
        Profesor P = lpro.buscarProfesor(rut);
        if (P != null) {
            NodoParalelo Pa = P.getListaParalelos().getPrimerParalelo();
            Asignatura A = Pa.getParalelo().getAsignatura();
            if(A != null){
                StdOut.println("profesor esta dictando una asignatura y no se puede eliminar");
            }else{
                boolean eliminar = lpro.eliminarProfesor(rut);
                if(eliminar == true){
                    StdOut.println("profesor eliminado");
                }
            }
           
    }
    }
    public static void CarreraDictaAsignatura7(ListaCarreras lc, ListaAsignaturas la) {
        StdOut.println("Ingrese código de carrera: ");
        int codCarrera = StdIn.readInt();
        StdOut.println("Ingrese código de asignatura: ");
        String codAsignatura = StdIn.readString();
        Carrera C = lc.buscarCarrera(codCarrera);
        if (C != null) {
            Asignatura A = C.getListaAsignaturas().buscarAsignatura(codAsignatura);
            if (A != null) {
                    StdOut.println("La asignatura si se dicta en la carrera.");
                } else {
                    StdOut.println("La asignatura no se dicta en la carrera.");
                }
            } else {
                StdOut.println("Código de la carrera no existe.");
            }
    }

    public static void paraleloAsignatura5(ListaParalelos lp, ListaAsignaturas la) {
        StdOut.print("ingrese codigo de la asignatura: ");
        String cod = StdIn.readString();
        Asignatura A = la.buscarAsignatura(cod);
        if (A != null) {
           StdOut.print("ingrese numero del paralelo : ");
           int numero = StdIn.readInt();
           Paralelo P = A.getListaParalelos().buscarParalelo(numero);
           StdOut.println("nombre del profesor que dicta la asignatura :" + P.getProfesor().getNombre());
           StdOut.println("rut del profesor : " + P.getProfesor().getRut());
           if(P.getProfesor() instanceof JornadaCompleta){
               StdOut.println("profesor jornada completa");
           }else if(P.getProfesor() instanceof MediaJornada){
               StdOut.println("profesor media jornada");
           }else{
               StdOut.println("profesor hora");
           }
        }
    }      
    public static void desplegarCarrreraXnombre6(ListaCarreras lc,ListaAsignaturas la){
        NodoCarrera actualCarrera = lc.getPrimerCarrera();
        while(actualCarrera !=null){
            StdOut.println("datos de las carreras");
            Carrera C = actualCarrera.getCarrera();
            StdOut.println("nombre de la carrera : " + C.getNombre() );
            StdOut.println("codigo : " + C.getCodigo());
            NodoAsignatura actualAsignatura  = C.getListaAsignaturas().getPrimerAsignatura();
            while(actualAsignatura !=null){
                Asignatura A = actualAsignatura.getAsignatura();
                StdOut.println("asignaturas que pertenecen a la carrera");
                StdOut.println("nombre : "  + A.getNombre());
                StdOut.println("codigo : " + A.getCodigo());
                StdOut.println("creditos: " + A.getCreditos());
                int cantparalelos= 0;
                NodoParalelo actual = A.getListaParalelos().getPrimerParalelo();
                while(actual != null){
                    cantparalelos++;
                    actual = actual.getSiguienteParalelo();
                }
                StdOut.println("cantidad de paralelos : "+ cantparalelos);
                actualAsignatura = actualAsignatura.getSiguienteAsignatura();
            }
            actualCarrera = actualCarrera.getSiguienteCarrera();
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
                    Problema.leerCarreras(la, lc, lp, lpro);
                    break;
                case 2:
                    Problema.leerProfesores(la, lc, lp, lpro);
                    break;
                case 3:
                   Problema.leerAsignaturas(la, lc, lp, lpro);
                    break;
                case 4:
                    Problema.desplegarCarreras1(la, lc, lpro, lp);
                    break;
                case 5:
                    Problema.cantidadProfesoresJornadaCompleta2(lpro);
                    break;
                case 6:
                    Problema.DatosProfesor3(lpro);
                    break;
                case 7:
                    Problema.ProfesoresySueldos4(lpro);
                    break;
                case 8:
                  Problema.paraleloAsignatura5(lp, la);
                    break;
                case 9:
                    Problema.desplegarCarrreraXnombre6(lc, la);
                    break;
                case 10:
                    Problema.CarreraDictaAsignatura7(lc, la);
                    break;
                case 11:
                    Problema.eliminarProfesor8(lpro, lp);
                    break;
                default:
                    opcion = 12;
            }

        }
    }

    public static void main(String[] args) {
        ListaProfesores lpro = new ListaProfesores();
        ListaParalelos lp = new ListaParalelos();
        ListaAsignaturas la = new ListaAsignaturas();
        ListaCarreras lc = new ListaCarreras();
        Problema.menuApp(la, lc, lp, lpro);
    }

}
