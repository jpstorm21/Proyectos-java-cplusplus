/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallercuatro4;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Reparadores implements IReparadores {

    private ListaMateriales listaMateriales;
    private ListaOrdServicios listaOrdServicios;
    private ListaPersonas listaPersonas;
    private ListaSolicitudMateriales listaSolicitudMateriales;
    private ArrayList<Certificacion> certificaciones;
    private ArrayList<HistoricoCertificado> histcertificaciones;

    public Reparadores() {
        certificaciones = new ArrayList();
        histcertificaciones = new ArrayList();
        listaMateriales = new ListaMateriales();
        listaOrdServicios = new ListaOrdServicios();
        listaPersonas = new ListaPersonas();
        listaSolicitudMateriales = new ListaSolicitudMateriales();
    }

    @Override
    public void IngresarPersona(Persona P) {
        listaPersonas.ingresarPersona(P);
    }

    @Override
    public void IngresarMaterial(Material M) {
        listaMateriales.ingresarMaterial(M);
    }

    @Override
    public void IngresarOrdServicios(Servicio S) {
        listaOrdServicios.insertarOrdenadoServicio(S);
    }

    @Override
    public void IngresarSolicitudMaterial(SolicitudMaterial Sol) {
        listaSolicitudMateriales.ingresarSolicitudMaterial(Sol);
    }

    @Override
    public Persona BuscarPerona(String rut) {
        Persona p = listaPersonas.buscarPersona(rut);
        if (p != null) {
            return p;

        } else {
            return null;
        }

    }

    @Override
    public Material BuscarMaterial(int cod) {
        Material M = listaMateriales.buscarMaterial(cod);
        if (M != null) {
            return M;
        } else {
            return null;
        }

    }

    @Override
    public Servicio BuscarOrdServicio(int codServ) {
        Servicio Ser = listaOrdServicios.buscarServicio(codServ);
        if (Ser != null) {
            return Ser;
        } else {
            return null;
        }
    }

    @Override
    public SolicitudMaterial BuscarSolicitudMaterial(int codSol) {
        SolicitudMaterial Sol = listaSolicitudMateriales.buscarSolicitudMaterial(codSol);
        if (Sol != null) {
            return Sol;
        } else {
            return null;
        }
    }

    @Override
    public void IngresarCertificacion(Certificacion cer) {
        certificaciones.add(cer);
    }

    @Override
    public Certificacion BuscarCertificacion(int codCer) {

        Certificacion c = null;
        for (Certificacion certificacione : certificaciones) {
            if (certificacione.getCodCertificacion() == codCer) {
                c = certificacione;
                break;
            }

        }
        if (c != null) {
            return c;

        } else {
            return null;
        }
    }

    @Override
    public void IngresarHistoricoCertificado(HistoricoCertificado historicoCertificado) {
        histcertificaciones.add(historicoCertificado);
    }

    @Override
    public HistoricoCertificado BuscarHistorico(String fecha, String rut) {
        HistoricoCertificado his = null;

        for (HistoricoCertificado histcertificacione : histcertificaciones) {
            if (histcertificacione.getFecha().equalsIgnoreCase(fecha)) {
                his = histcertificacione;
                break;
            }

        }

        if (his != null) {
            return his;

        } else {
            return null;
        }

    }

    @Override
    public ListaMateriales MaterialesTodosServicios() {
        ListaMateriales materialesTodosServicios = new ListaMateriales();
        NodoMaterial currentMaterial = listaMateriales.getFirst();
        do {
            NodoServicio currentServicio = listaOrdServicios.getFirst();
            do {
                if (currentServicio.getServicio().getMateriales().buscarMaterial(currentMaterial.getMaterial().getCodMaterial()) == null) {
                    break;
                }
                currentServicio = currentServicio.getNext();
            } while (currentServicio != null);
            if (currentServicio == null) {
                materialesTodosServicios.ingresarMaterial(currentMaterial.getMaterial());
            }
            currentMaterial = currentMaterial.getNext();
        } while (currentMaterial != null);
        return materialesTodosServicios;
    }

    @Override
    public ListaMateriales MaterialesNingunServicio() {
        ListaMateriales materialesTodosServicios = new ListaMateriales();
        NodoMaterial currentMaterial = listaMateriales.getFirst();
        do {
            NodoServicio currentServicio = listaOrdServicios.getFirst();
            do {
                if (currentServicio.getServicio().getMateriales().buscarMaterial(currentMaterial.getMaterial().getCodMaterial()) != null) {
                    break;
                }
                currentServicio = currentServicio.getNext();
            } while (currentServicio != null);
            if (currentServicio == null) {
                materialesTodosServicios.ingresarMaterial(currentMaterial.getMaterial());
            }
            currentMaterial = currentMaterial.getNext();
        } while (currentMaterial != null);
        return materialesTodosServicios;
    }

    @Override
    public ListaOrdServicios servicioUnTrabajadorServicio_Organizacion() {
        ListaOrdServicios listaOrd = new ListaOrdServicios();
        NodoServicio servicio = listaOrdServicios.getFirst();
        while (servicio != null) {
            Persona tr = servicio.getServicio().getTrabajador2();
            if (tr == null) {
                if (servicio.getServicio().getCliente().getOrganizacion() != null) {
                    listaOrd.insertarOrdenadoServicio(servicio.getServicio());
                }
            }
            servicio = servicio.getNext();
        }
        return listaOrd;

    }

    @Override
    public ListaSolicitudMateriales Materiales3al10() {
        ListaSolicitudMateriales ListaMateriales3Al10 = new ListaSolicitudMateriales();
        NodoSolicitudMaterial currentSolicitud = listaSolicitudMateriales.getFirst();
        while (currentSolicitud.getSolicitudMaterial().getCantpedida() > 3 && currentSolicitud.getSolicitudMaterial().getCantpedida() < 10) {
            ListaMateriales3Al10.ingresarSolicitudMaterial(currentSolicitud.getSolicitudMaterial());
            currentSolicitud = currentSolicitud.getNext();
        }
        return ListaMateriales3Al10;
    }

    @Override
    public TrabajadorServicio TrabajadorConMasServicios() {
        NodoPersona actual = listaPersonas.getFirst();
        TrabajadorServicio mayorP = null;
        int mayor = -1;
        while (actual != null) {
            Persona P = actual.getPersona();
            if (P instanceof TrabajadorServicio) {
                if (((TrabajadorServicio) P).getServicios().getCant() > mayor) {
                    mayor = ((TrabajadorServicio) P).getServicios().getCant();
                    mayorP = ((TrabajadorServicio) P);
                }
            }
            actual = actual.getNext();
        }
        return mayorP;
    }

}
