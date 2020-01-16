/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallercuatro4;

import java.util.ArrayList;
import ucn.*;

/**
 *
 * @author Usuario
 */
public class TallerCuatro4 {

    public static void LeerPersonas(IReparadores sistema) {
        In personas = new In("personas.txt");
        while (!personas.isEmpty()) {
            String linea = personas.readLine();
            String[] token = linea.split(",");
            String rut = token[0];
            String nombre = token[1];
            String apellido = token[2];
            int edad = Integer.parseInt(token[3]);
            int telefono = Integer.parseInt(token[4]);
            String mail = token[5];
            String tipo = token[6];
            if (tipo.equalsIgnoreCase("T")) {
                String cargo = token[7];
                Persona t = new Trabajador(rut, nombre, apellido, edad, telefono, mail, cargo);
                sistema.IngresarPersona(t);
            } else if (tipo.equalsIgnoreCase("TS")) {
                String cargo2 = token[7];
                Persona t2 = new TrabajadorServicio(rut, nombre, apellido, edad, telefono, mail, cargo2);
                sistema.IngresarPersona(t2);
            } else if (tipo.equalsIgnoreCase("C")) {
                int org = Integer.parseInt(token[7]);
                if (org == 0) {
                    Persona C = new Cliente(rut, nombre, apellido, edad, telefono, mail);
                    ((Cliente) C).setOrganizacion(null);
                    sistema.IngresarPersona(C);
                } else {
                    Persona C2 = new Cliente(rut, nombre, apellido, edad, telefono, mail);
                    String rutOrg = token[8];
                    String nombreOrg = token[9];
                    String dirOrg = token[10];
                    Organizacion Or = new Organizacion(rutOrg, nombreOrg, dirOrg);
                    ((Cliente) C2).setOrganizacion(Or);
                    sistema.IngresarPersona(C2);
                }
            }
        }
        personas.close();
    }

    public static void LeerServicios(IReparadores sistema) {
        In servicios = new In("servicios.txt");
        while (!servicios.isEmpty()) {
            String linea = servicios.readLine();
            String[] token = linea.split(",");
            int cod = Integer.parseInt(token[0]);
            String fecha = token[1];
            String hora = token[2];
            Servicio servicio = new Servicio(cod, fecha, hora);
            int codCertificacion = Integer.parseInt(token[6]);
            Certificacion cer = sistema.BuscarCertificacion(codCertificacion);
            if (cer != null) {
                servicio.setCertificacion(cer);
            }
            Persona p = sistema.BuscarPerona(token[3]);
            if (p instanceof Cliente) {
                Cliente c = (Cliente) p;
                servicio.setCliente(c);
            }
            Persona t1 = sistema.BuscarPerona(token[4]);
            if (t1 instanceof TrabajadorServicio) {
                TrabajadorServicio trabajador = (TrabajadorServicio) t1;
                servicio.setTrabajador1(trabajador);
                trabajador.getServicios().insertarOrdenadoServicio(servicio);

            }

            if (!token[5].equals("0")) {
                Persona t2 = sistema.BuscarPerona(token[5]);
                if (t2 instanceof TrabajadorServicio) {
                    TrabajadorServicio trabajador2 = (TrabajadorServicio) t2;
                    servicio.setTrabajador2(trabajador2);
                    trabajador2.getServicios().insertarOrdenadoServicio(servicio);
                    ((Cliente) p).getServicios().insertarOrdenadoServicio(servicio);
                    sistema.IngresarOrdServicios(servicio);
                }
            } else {
                servicio.setTrabajador2(null);
                ((Cliente) p).getServicios().insertarOrdenadoServicio(servicio);
                sistema.IngresarOrdServicios(servicio);
            }

        }
        servicios.close();

    }

    public static void LeerMateriales(IReparadores sistema) {
        In materiales = new In("materiales.txt");
        while (!materiales.isEmpty()) {
            String linea = materiales.readLine();
            String[] token = linea.split(",");
            int codigo = Integer.parseInt(token[0]);
            String nombre = token[1];
            int Stock = Integer.parseInt(token[2]);
            String descripcion = token[3];
            Material material = new Material(codigo, nombre, Stock, descripcion);
            sistema.IngresarMaterial(material);
        }
        materiales.close();
    }

    public static void LeerCertificaciones(IReparadores sistema) {
        In certificacioness = new In("certificaciones.txt");
        while (!certificacioness.isEmpty()) {
            String linea = certificacioness.readLine();
            String[] token = linea.split(",");
            int codigoC = Integer.parseInt(token[0]);
            String tipoSer = token[1];
            Certificacion cert = new Certificacion(codigoC, tipoSer);
            sistema.IngresarCertificacion(cert);

        }
        certificacioness.close();
    }

    public static void LeerHistoricoCertificado(IReparadores sistema) {
        In historicoCertificado = new In("historico_certificado.txt");
        while (!historicoCertificado.isEmpty()) {
            String linea = historicoCertificado.readLine();
            String[] token = linea.split(",");
            String fecha = token[0];
            int puntaje = Integer.parseInt(token[1]);
            HistoricoCertificado hist = new HistoricoCertificado(fecha, puntaje);
            Certificacion cert = sistema.BuscarCertificacion(Integer.parseInt(token[2]));
            if (cert != null) {
                hist.setCertificacion(cert);

            }
            Persona trab = sistema.BuscarPerona(token[3]);
            if (trab instanceof TrabajadorServicio) {
                TrabajadorServicio trabajadorServ = (TrabajadorServicio) trab;
                hist.setTrabajador(trabajadorServ);
                trabajadorServ.getHistcertificaciones().add(hist);
                trabajadorServ.getCertificaciones().add(cert);
                
            }
            sistema.IngresarHistoricoCertificado(hist);
        }
        historicoCertificado.close();
    }

    public static void LeerServicioMaterial(IReparadores sistema) {
        In servicioMat = new In("servicio_material.txt");
        while (!servicioMat.isEmpty()) {
            String linea = servicioMat.readLine();
            String[] token = linea.split(",");
            int codServ = Integer.parseInt(token[0]);
            Servicio servi = sistema.BuscarOrdServicio(codServ);
            if (servi != null) {
                Material mate = sistema.BuscarMaterial(Integer.parseInt(token[1]));
                if (mate != null) {
                    servi.setMaterialUsado(Integer.parseInt(token[2]));
                    servi.getMateriales().ingresarMaterial(mate);
                }
            }
        }
        servicioMat.close();

    }

    public static void LeerSolicitudMaterial(IReparadores sistema) {
        In solicitudMaterial = new In("solicitud_material.txt ");
        while (!solicitudMaterial.isEmpty()) {
            String linea = solicitudMaterial.readLine();
            String[] token = linea.split(",");
            int codigoSolicitud = Integer.parseInt(token[0]);
            String fecha = token[1];
            String hora = token[2];
            SolicitudMaterial soli = new SolicitudMaterial(codigoSolicitud, fecha, hora);
            Persona trabajadorServ = sistema.BuscarPerona(token[3]);
            if (trabajadorServ != null) {
                if (trabajadorServ instanceof TrabajadorServicio) {
                    TrabajadorServicio trabajador = (TrabajadorServicio) trabajadorServ;
                    soli.setTrabajador(trabajador);
                }
            }
            String rutJefeAdmi = token[4];
            Persona JefeAdmi = sistema.BuscarPerona(rutJefeAdmi);
            if (JefeAdmi != null) {
                if (JefeAdmi instanceof Trabajador) {
                    Trabajador jefe = (Trabajador) JefeAdmi;
                    soli.setJefeAdmin(jefe);
                }

            }
            String rutJefeFi = token[5];
            Persona JefeFi = sistema.BuscarPerona(rutJefeFi);
            if (JefeFi != null) {
                if (JefeFi instanceof Trabajador) {
                    Trabajador jefeFi = (Trabajador) JefeFi;
                    soli.setJefeFinanza(jefeFi);
                }
            }
             ((TrabajadorServicio)trabajadorServ).getSolMateriales().ingresarSolicitudMaterial(soli);
            sistema.IngresarSolicitudMaterial(soli);
        }
        solicitudMaterial.close();
    }

    public static void LeerSolicitudMaterialM(IReparadores sistema) {
        In solicitudMAterial2 = new In("solicitud_material_material.txt");
        while (!solicitudMAterial2.isEmpty()) {
            String linea = solicitudMAterial2.readLine();
            String[] token = linea.split(",");
            int codSoli = Integer.parseInt(token[0]);
            SolicitudMaterial soli2 = sistema.BuscarSolicitudMaterial(codSoli);
            if (soli2 != null) {
                int codMaterial = Integer.parseInt(token[1]);
                Material materi = sistema.BuscarMaterial(codMaterial);
                if (materi != null) {
                    int cant = Integer.parseInt(token[2]);
                    soli2.setCantpedida(cant);
                    soli2.getMateriales().ingresarMaterial(materi);

                }

            }

        }
        solicitudMAterial2.close();
    }

    public static void DatosMateriales(IReparadores sistema) {
        ListaMateriales materialesEnTodos = sistema.MaterialesTodosServicios();
        ListaMateriales materialesEnNada = sistema.MaterialesNingunServicio();
        NodoMaterial current1 = materialesEnTodos.getFirst();
        StdOut.println("Materiales presentes en todos los servicios:");
        do {
            if (current1 != null) {
                Material actual = current1.getMaterial();
                StdOut.println("Nombre: " + actual.getNombre() + ", Codigo: " + actual.getCodMaterial() + ", Stock: " + actual.getStock());
                current1 = current1.getNext();
            }
        } while (current1 != null);

        NodoMaterial current2 = materialesEnNada.getFirst();
        StdOut.println("Materiales en ningun servicio:");
        do {
            if (current2 != null) {
                Material actual = current2.getMaterial();
                StdOut.println("Nombre: " + actual.getNombre() + ", Codigo: " + actual.getCodMaterial() + ", Stock: " + actual.getStock());
                current2 = current2.getNext();
            }
        } while (current2 != null);

    }

    public static void ServciosUnTrabajador(IReparadores sistema) {
        ListaOrdServicios servicioUnTrabajador = sistema.servicioUnTrabajadorServicio_Organizacion();
        NodoServicio ser = servicioUnTrabajador.getFirst();
        StdOut.println("Datos servicios con un trabajador :");
        while (ser != null) {
            System.out.println("codigo: " + ser.getServicio().getCodServicio());
            System.out.println("fecha: " + ser.getServicio().getFechaServicio());
            System.out.println("hora: " + ser.getServicio().getHoraServicio());
            System.out.println("cliente : " + ser.getServicio().getCliente().getNombres());
            System.out.println("trabajador 1 : " + ser.getServicio().getTrabajador1().getNombres());
            System.out.println("certificacion : " + ser.getServicio().getCertificacion().getTipoServicio());
            ser = ser.getNext();
        }

    }

    public static void SoloMateriales3Al10mat(IReparadores sistema) {

        NodoSolicitudMaterial soliMa = sistema.Materiales3al10().getFirst();
        System.out.println("Solicitudes con 3 a 10 materiales");
        do {
            if (soliMa != null) {
                SolicitudMaterial actual = soliMa.getSolicitudMaterial();
                StdOut.println("Codigo: " + actual.getCodSolicitud() + ", fecha: " + actual.getFechaSolicitud() + ", Hora: " + actual.getHoraSolicitud() + ", Nombre Jefe Administracion: " + actual.getJefeAdmin().getNombres() + "" + actual.getJefeAdmin().getApellidos() + ", Nombre Jefe Finanzas: " + actual.getJefeFinanza().getNombres() + actual.getJefeFinanza().getApellidos() + ",Nombre Trabajador : " + actual.getTrabajador().getNombres() + actual.getTrabajador().getApellidos() + ", Material: " + actual.getMateriales().getFirst().getMaterial().getNombre() + ", Cantidad: " + actual.getMateriales().getFirst().getMaterial().getStock());
                soliMa = soliMa.getNext();
            }
        } while (soliMa != null);
    }

    public static void TrabajadorConMasServicios(IReparadores sistema) {
        TrabajadorServicio trabajadorUnico = sistema.TrabajadorConMasServicios();
        System.out.println("Nombre :" + trabajadorUnico.getNombres() + " Apellido" + trabajadorUnico.getApellidos());
        ArrayList<HistoricoCertificado> listaHist = trabajadorUnico.getHistcertificaciones();
        for (HistoricoCertificado iter : listaHist) {
            System.out.println("fecha: " + iter.getFecha() + " puntaje obtenido: " + iter.getPuntaje() + "codigo certificado: " + iter.getCertificacion().getCodCertificacion() + "Tipo de servicio: " + iter.getCertificacion().getTipoServicio());
            if (iter.getPuntaje() >= 80) {
                System.out.println("Examen Aprobado");
            } else {
                System.out.println("Examen Reprobado");
            }

        }

    }

    public static void mostrarMenu(IReparadores sistema) {
        int opcion = 0;
        while (opcion != 5) {
            System.out.println("----------------------------------------------------------");
            System.out.println("\t[MENU]");
            System.out.println("1. Materiales en todos los  servicios y en ningun servicio");
            System.out.println("2. Servicios con un trabajador");
            System.out.println("3. Materiales entre 3 a 10 cantidades");
            System.out.println("4. Trabajador con mas  Servicios ");
            System.out.println("5. Salir");
            System.out.print("> ");
            opcion = StdIn.readInt();
            switch (opcion) {
                case 1:
                    System.out.println("----------------------------------------------------------");
                    DatosMateriales(sistema);
                    break;
                case 2:
                    System.out.println("----------------------------------------------------------");
                    ServciosUnTrabajador(sistema);
                    break;
                case 3:
                    System.out.println("----------------------------------------------------------");
                    SoloMateriales3Al10mat(sistema);
                    break;
                case 4:
                    System.out.println("----------------------------------------------------------");
                    TrabajadorConMasServicios(sistema);
                    break;

                default:
                    opcion = 5;

            }
        }
    }

    public static void main(String[] args) {
        IReparadores sistema = new Reparadores();
        LeerPersonas(sistema);
        LeerCertificaciones(sistema);
        LeerHistoricoCertificado(sistema);
        LeerMateriales(sistema);
        LeerServicioMaterial(sistema);
        LeerServicios(sistema);
        LeerSolicitudMaterial(sistema);
        LeerSolicitudMaterialM(sistema);
        mostrarMenu(sistema);
    }
}
