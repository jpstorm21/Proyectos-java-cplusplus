package taller3;

import ucn.*;

/**
 *
 * @author Usuario
 */
public class Taller3 {
 
    /**
     *
     * @param lh es la lista de las habitaciones 
     * @param lp es la lsita de las personas
     * @param lr es la lsita de las reservaciones
     * creamos un menu donde al seleccionar la opcion se ejecutara y desplegara lo solicitado
     */
    public static void menuApp(ListaHabitaciones lh, ListaPersonas lp, ListaReservaciones lr) {
        int opcion = 0;
        while (opcion != 4) {
            StdOut.println("\t [menu]");
            StdOut.println("bienvenidos al Hotel Olimpo");
            StdOut.println("1-realizar reservacion: ");
            StdOut.println("2-desplegar reservaciones");
            StdOut.println("3-desplegar sueldos:");
            StdOut.println("4-salir: ");
            StdOut.println("---------------------------------");
            StdOut.print(">");
            opcion = StdIn.readInt();
            switch (opcion) {
                case 1:
                    Taller3.realizarReservacion(lh, lp, lr);
                    break;
                case 2:
                    Taller3.desplegarReservacion(lh, lp, lr);
                    break;
                case 3:
                    Taller3.desplegarSueldos(lh, lp, lr);
                    break;
                default:
                    opcion = 4;
            }

        }
    }

    /**
     *
     * @param lh aqui leemos el txt habitaciones y mandamos los datos a la lista habitaciones
     */
    public static void leerHabitaciones(ListaHabitaciones lh) {
        In habitaciones = new In("habitaciones.txt");
        while (!habitaciones.isEmpty()) {
            String leelinea = habitaciones.readLine();
            String[] linea = leelinea.split(",");
            int numero = Integer.parseInt(linea[0]);
            int valordia = Integer.parseInt(linea[1]);
            String tipo = linea[2];
            Habitacion H = new Habitacion(numero, valordia, tipo);
            lh.ingreasarHabitacion(H);

        }
        habitaciones.close();

    }

    /**
     *
     * @param lp leemos el txt personas y mandamos los datos persona a la lista personas
     */
    public static void leerPersonas(ListaPersonas lp) {
        In personas = new In("personas.txt");
        while (!personas.isEmpty()) {
            String leelinea = personas.readLine();
            String[] linea = leelinea.split(",");
            String codigo = linea[0];
            char letra = codigo.charAt(0);
            char A = 'C';
            if (letra == A) {
                String nombre = linea[1];
                String apellido = linea[2];
                int telefono = Integer.parseInt(linea[3]);
                Persona P = new Cliente(codigo, nombre, apellido, telefono);
                lp.ingresarPersona(P);
            } else {
                String nombre = linea[1];
                String apellido = linea[2];
                int telefono = Integer.parseInt(linea[3]);
                String email = linea[4];
                int sueldo = Integer.parseInt(linea[5]);
                Persona P = new Trabajador(email, sueldo, codigo, nombre, apellido, telefono);
                lp.ingresarPersona(P);
            }
        }
        personas.close();
    }

    /**
     *
     * @param lh utilizaremos la lista habitaciones
     * @param lp tambien la lista personas
     * @param lr leeremos el txt reservaciones y mandaremos la informacion a lista reservaciones para trabajar
     * ademas en esta parte dividimos la fecha en sus respectivas variables (dia, mes, año)
     * 
     */
    public static void leerReservaciones(ListaHabitaciones lh, ListaPersonas lp, ListaReservaciones lr) {
        In reservaciones = new In("reservaciones.txt");
        while (!reservaciones.isEmpty()) {
            String leelinea = reservaciones.readLine();
            String[] linea = leelinea.split(",");
            int codigo = Integer.parseInt(linea[0]);
            Reservacion R = new Reservacion(codigo);
            String codcliente = linea[1];
            Persona P = lp.buscarPersona(codcliente);
            int numhabitacion = Integer.parseInt(linea[2]);
            Habitacion H = lh.buscarHabitacion(numhabitacion);
            int diaI = Integer.parseInt(linea[3]);
            int mesI = Integer.parseInt(linea[4]);
            int añoI = Integer.parseInt(linea[5]);
            Fecha FI = new Fecha(diaI, mesI, añoI);
            int diaT = Integer.parseInt(linea[6]);
            int mesT = Integer.parseInt(linea[7]);
            int añoT = Integer.parseInt(linea[8]);
            Fecha FT = new Fecha(diaT, mesT, añoT);
            R.setFechainicio(FI);
            R.setFechatermino(FT);
            R.setHabitacion(H);
            R.setCliente((Cliente) P);
            lr.ingresarReservacion(R);
            ((Cliente) P).getLr().ingresarReservacion(R);
            H.getLr().ingresarReservacion(R);

        }
        reservaciones.close();
    }

    /**
     *
     * @param lh utilizamos la lista habitaciones
     * @param lp utilizamos la lista personas
     * @param lr y la lista reservaciones
     * en esta parte realizamos la accion de realizar la reservacion, pidiendo la fecha y el estado de la persona(registrado o no)
     * vemos la disponibilidad de las habitaciones
     */
   
    public static void realizarReservacion(ListaHabitaciones lh, ListaPersonas lp, ListaReservaciones lr) {
        StdOut.print("esta registrado[1] si o [2] no: ");
        int registro = StdIn.readInt();
        int ultimoCodCliente = 0;
        int ultimoCodReservacion = 0;
        if (registro == 1) {
            StdOut.print("ingrese su codigo:");
            String codb = StdIn.readString();
            Persona P = lp.buscarPersona(codb);
            if (P != null) {
                StdOut.println("entre que fecha quiere realizar la reservacion :");
                StdOut.println("ingrese fecha de inicio");
                StdOut.print("ingrese dia :");
                int diaI = StdIn.readInt();
                while (diaI < 1 || diaI > 31) {
                    StdOut.println("dia fuera de rango");
                    StdOut.print("ingrese dia :");
                    diaI = StdIn.readInt();
                }
                StdOut.print("ingrese mes :");
                int mesI = StdIn.readInt();
                while (mesI < 1 || mesI > 12) {
                    StdOut.println("mes fuera de rango");
                    StdOut.print("ingrese mes:");
                    mesI = StdIn.readInt();
                }
                StdOut.print("ingrese año :");
                int añoI = StdIn.readInt();
                Fecha FI = new Fecha(diaI, mesI, añoI);
                long CantDiasInicio = FI.getAño() * 365 + FI.getMes() * 31 + FI.getDia();
                StdOut.println("ingrese fecha de termino");
                StdOut.print("ingrese dia :");
                int diaT = StdIn.readInt();
                while (diaT < 1 || diaT > 31) {
                    StdOut.println("dia fuera de rango");
                    StdOut.print("ingrese dia:");
                    diaT = StdIn.readInt();
                }
                StdOut.print("ingrese mes:");
                int mesT = StdIn.readInt();
                while (mesT < 1 || mesT > 12) {
                    StdOut.println("mes fuera de rango");
                    StdOut.print("ingrese mes:");
                    mesT = StdIn.readInt();
                }
                StdOut.print("ingrese año :");
                int añoT = StdIn.readInt();
                Fecha FT = new Fecha(diaT, mesT, añoT);
                long CantDiasTermino = FT.getAño() * 365 + FT.getMes() * 31 + FT.getDia();
                ListaHabitaciones lhDisponibles = new ListaHabitaciones(1000);
                for (int i = 0; i < lh.getCanthabitaciones(); i++) {
                    Habitacion H = lh.getHabitacion(i);
                    boolean ingresa = true;
                    for (int k = 0; k < H.getLr().getCantreservaciones(); k++) {
                        Fecha FI2 = H.getLr().getReservacion(k).getFechainicio();
                        Fecha FT2 = H.getLr().getReservacion(k).getFechatermino();
                        long CantDiasInicio2 = FI2.getAño() * 365 + FI2.getMes() * 31 + FI2.getDia();
                        long CantDiasTermino2 = FT2.getAño() * 365 + FT2.getMes() * 31 + FT2.getDia();
                        if ((CantDiasInicio2 <= CantDiasTermino && CantDiasTermino2 >= CantDiasTermino) || (CantDiasInicio >= CantDiasInicio2 && CantDiasTermino2 >= CantDiasInicio)) {
                            ingresa = false;
                            break;
                        } else if (CantDiasInicio2 > CantDiasInicio && CantDiasTermino2 < CantDiasTermino) {
                            ingresa = false;
                            break;
                        }
                    }
                    if (ingresa == true) {
                        lhDisponibles.ingreasarHabitacion(lh.getHabitacion(i));
                    }
                }
                for (int w = 0; w < lhDisponibles.getCanthabitaciones(); w++) {
                    Habitacion H = lhDisponibles.getHabitacion(w);
                    StdOut.println("------------------------------");
                    StdOut.println("numero: " + H.getNumero());
                    StdOut.println("tipo: " + H.getTipo());
                    StdOut.println("valor por dia : " + H.getValorPorDia());
                    StdOut.println("------------------------------");
                }
                StdOut.print("ingrese numero de habitacion que desea reservar:");
                int numero = StdIn.readInt();
                Habitacion H = lhDisponibles.buscarHabitacion(numero);
                for (int i = 0; i < lr.getCantreservaciones(); i++) {
                    Reservacion R = lr.getReservacion(i);
                    ultimoCodReservacion++;
                }
                int codR = ultimoCodReservacion + 1;
                Reservacion R = new Reservacion(codR);
                boolean sepudo = lr.ingresarReservacion(R);
                if (sepudo == true) {
                    StdOut.println("reservacion realizada exitosamente");
                    ((Cliente) P).getLr().ingresarReservacion(R);
                    H.getLr().ingresarReservacion(R);
                    R.setFechainicio(FI);
                    R.setFechatermino(FT);
                    R.setHabitacion(H);
                }
            } else {
                StdOut.println("cliente no existe");
            }

        } else {
            StdOut.print("ingrese su nombre: ");
            String nombre = StdIn.readString();
            StdOut.print("ingrese apellido:");
            String apellido = StdIn.readString();
            StdOut.print("ingrese su telefono: ");
            int telefono = StdIn.readInt();
            for (int i = 0; i < lp.getCantpersonas(); i++) {
                Persona P = lp.getPersona(i);
                if (P instanceof Cliente) {
                    ultimoCodCliente++;
                }
            }
            String codigo = "C" + (ultimoCodCliente + 1);
            StdOut.println(codigo);
            Persona P = new Cliente(codigo, nombre, apellido, telefono);
            boolean sepudo = lp.ingresarPersona(P);
            if (sepudo == true) {
                StdOut.println("cliente registrado exitosamente");
                StdOut.println("entre que fecha quiere realizar la reservacion :");
                StdOut.println("ingrese fecha de inicio");
                StdOut.print("ingrese dia :");
                int diaI = StdIn.readInt();
                while (diaI < 1 || diaI > 31) {
                    StdOut.println("dia fuera de rango");
                    StdOut.print("ingrese dia :");
                    diaI = StdIn.readInt();
                }
                StdOut.print("ingrese mes :");
                int mesI = StdIn.readInt();
                while (mesI < 1 || mesI > 12) {
                    StdOut.println("mes fuera de rango");
                    StdOut.print("ingrese mes:");
                    mesI = StdIn.readInt();
                }
                StdOut.print("ingrese año :");
                int añoI = StdIn.readInt();
                Fecha FI = new Fecha(diaI, mesI, añoI);
                long CantDiasInicio = FI.getAño() * 365 + FI.getMes() * 31 + FI.getDia();
                StdOut.println("ingrese fecha de termino");
                StdOut.print("ingrese dia :");
                int diaT = StdIn.readInt();
                while (diaT < 1 || diaT > 31) {
                    StdOut.println("dia fuera de rango");
                    StdOut.print("ingrese dia:");
                    diaT = StdIn.readInt();
                }
                StdOut.print("ingrese mes:");
                int mesT = StdIn.readInt();
                while (mesT < 1 || mesT > 12) {
                    StdOut.println("mes fuera de rango");
                    StdOut.print("ingrese mes:");
                    mesT = StdIn.readInt();
                }
                StdOut.print("ingrese año :");
                int añoT = StdIn.readInt();
                Fecha FT = new Fecha(diaT, mesT, añoT);
                long CantDiasTermino = FT.getAño() * 365 + FT.getMes() * 31 + FT.getDia();
                ListaHabitaciones lhDisponibles = new ListaHabitaciones(1000);
                for (int i = 0; i < lh.getCanthabitaciones(); i++) {
                    Habitacion H = lh.getHabitacion(i);
                    boolean ingresa = true;
                    for (int k = 0; k < H.getLr().getCantreservaciones(); k++) {
                        Fecha FI2 = H.getLr().getReservacion(k).getFechainicio();
                        Fecha FT2 = H.getLr().getReservacion(k).getFechatermino();
                        long CantDiasInicio2 = FI2.getAño() * 365 + FI2.getMes() * 31 + FI2.getDia();
                        long CantDiasTermino2 = FT2.getAño() * 365 + FT2.getMes() * 31 + FT2.getDia();
                        if ((CantDiasInicio2 <= CantDiasTermino && CantDiasTermino2 >= CantDiasTermino) || (CantDiasInicio >= CantDiasInicio2 && CantDiasTermino2 >= CantDiasInicio)) {
                            ingresa = false;
                            break;
                        } else if (CantDiasInicio2 > CantDiasInicio && CantDiasTermino2 < CantDiasTermino) {
                            ingresa = false;
                            break;
                        }
                    }
                    if (ingresa == true) {
                        lhDisponibles.ingreasarHabitacion(lh.getHabitacion(i));
                    }
                }
                for (int w = 0; w < lhDisponibles.getCanthabitaciones(); w++) {
                    Habitacion H = lhDisponibles.getHabitacion(w);
                    StdOut.println("------------------------------");
                    StdOut.println("numero: " + H.getNumero());
                    StdOut.println("tipo: " + H.getTipo());
                    StdOut.println("valor por dia : " + H.getValorPorDia());
                    StdOut.println("------------------------------");
                }
                StdOut.print("ingrese numero de habitacion que desea reservar:");
                int numero = StdIn.readInt();
                Habitacion H = lhDisponibles.buscarHabitacion(numero);
                for (int i = 0; i < lr.getCantreservaciones(); i++) {
                    Reservacion R = lr.getReservacion(i);
                    ultimoCodReservacion++;
                }
                int codR = ultimoCodReservacion + 1;
                Reservacion R = new Reservacion(codR);
                boolean sepudo2 = lr.ingresarReservacion(R);
                if (sepudo2 == true) {
                    StdOut.println("reservacion realizada exitosamente");
                    ((Cliente) P).getLr().ingresarReservacion(R);
                    H.getLr().ingresarReservacion(R);
                    R.setFechainicio(FI);
                    R.setFechatermino(FT);
                    R.setHabitacion(H);
                }
            }

        }
    }

    /**
     *
     * @param lh usaremos lista habitaciones
     * @param lp la lista de personas
     * @param lr y la lista reservaciones
     * desplegaremos los datos de las reservaciones, datos del cliente, de la habitacion reservada, etc
     */
    public static void desplegarReservacion(ListaHabitaciones lh, ListaPersonas lp, ListaReservaciones lr) {
        StdOut.print("ingrese codigo del cliente que desea buscar:");
        String codb = StdIn.readString();
        Persona P = lp.buscarPersona(codb);
        if (P != null) {
            StdOut.println("------------------------------");
            StdOut.println("nombre: " + ((Cliente) P).getNombre());
            StdOut.println("apellido: " + ((Cliente) P).getApellido());
            StdOut.println("telefono: " + ((Cliente) P).getTelefono());
            StdOut.println("------------------------------");
            for (int i = 0; i < ((Cliente) P).getLr().getCantreservaciones(); i++) {
                Reservacion R = ((Cliente) P).getLr().getReservacion(i);
                StdOut.println("------------------------------");
                StdOut.println("codigo de reservacion: " + R.getCodigo());
                Habitacion H = R.getHabitacion();
                StdOut.println("numero: " + H.getNumero());
                StdOut.println("valor: " + H.getValorPorDia());
                StdOut.println("tipo : " + H.getTipo());
                StdOut.println("fecha de inicio :" + R.getFechainicio().getDia() + "-" + R.getFechainicio().getMes() + "-" + R.getFechainicio().getAño());
                StdOut.println("fecha de termino :" + R.getFechatermino().getDia() + "-" + R.getFechatermino().getMes() + "-" + R.getFechatermino().getAño());
                StdOut.println("------------------------------");
            }
        } else {
            StdOut.println("cliente no existe");
        }
    }

    /**
     *
     * @param lh usamos lista habitaciones
     * @param lp la lista personas
     * @param lr la lista reservacion
     * aqui desplegamos los sueldos de los trabajadores
     */
    public static void desplegarSueldos(ListaHabitaciones lh, ListaPersonas lp, ListaReservaciones lr) {
        int sumaSueldo = 0;
        for (int i = 0; i < lp.getCantpersonas(); i++) {
            Persona P = lp.getPersona(i);
            if (P instanceof Trabajador) {
                StdOut.println("------------------------------");
                StdOut.println("codigo : " + P.getCodigo());
                StdOut.println("nombre: " + P.getNombre());
                StdOut.println("apellido: " + P.getApellido());
                StdOut.println("sueldo: " + ((Trabajador) P).getSueldo());
                StdOut.println("------------------------------");
                int sueldo = ((Trabajador) P).getSueldo();
                sumaSueldo = sumaSueldo + sueldo;
            }
        }
        StdOut.println("------------------------------");
        StdOut.println("total de sueldos: " + sumaSueldo);
        StdOut.println("------------------------------");
    }

   
    public static void main(String[] args) {
        ListaHabitaciones lh = new ListaHabitaciones(1000);
        ListaPersonas lp = new ListaPersonas(1000);
        ListaReservaciones lr = new ListaReservaciones(1000);
        Taller3.leerHabitaciones(lh);
        Taller3.leerPersonas(lp);
        Taller3.leerReservaciones(lh, lp, lr);
        Taller3.menuApp(lh, lp, lr);
    }

}
