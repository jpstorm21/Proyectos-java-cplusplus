package taller4sgdosemestre2017;

public class Reparadores implements Ireparadores {

    private ListaPersonas lp;
    private ListaCertificaciones lc;
    private ListaSolicitudMaterial lsm;
    private ListaServicios ls;
    private ListaMateriales lm;
    private ListaHistoricoCertificaciones lhc;

    public Reparadores() {
        this.lp = new ListaPersonas();
        this.lc = new ListaCertificaciones();
        this.lsm = new ListaSolicitudMaterial();
        this.ls = new ListaServicios();
        this.lm = new ListaMateriales();
        this.lhc = new ListaHistoricoCertificaciones();
    }

    public ListaPersonas getLp() {
        return lp;
    }

    public void setLp(ListaPersonas lp) {
        this.lp = lp;
    }

    public ListaCertificaciones getLc() {
        return lc;
    }

    public void setLc(ListaCertificaciones lc) {
        this.lc = lc;
    }

    public ListaSolicitudMaterial getLsm() {
        return lsm;
    }

    public void setLsm(ListaSolicitudMaterial lsm) {
        this.lsm = lsm;
    }

    public ListaServicios getLs() {
        return ls;
    }

    public void setLs(ListaServicios ls) {
        this.ls = ls;
    }

    public ListaMateriales getLm() {
        return lm;
    }

    public void setLm(ListaMateriales lm) {
        this.lm = lm;
    }

    public ListaHistoricoCertificaciones getLhc() {
        return lhc;
    }

    public void setLhc(ListaHistoricoCertificaciones lhc) {
        this.lhc = lhc;
    }

    @Override
    public void ingresarPersona(Persona P) {
        lp.ingresarPersona(P);
    }

    @Override
    public void ingresarServicio(Servicio s) {
        ls.ingresarServicio(s);
    }

    @Override
    public void ingresarMaterialAServicio(Servicio s, Material M) {
        s.getLm().ingresarMaterial(M);
    }

    @Override
    public void ingresarMaterial(Material M) {
        lm.ingresarMaterial(M);
    }

    @Override
    public void ingresarCertificacione(Certificacion c) {
        lc.ingresarCertificaion(c);
    }

    @Override
    public void ingresarSolicitudMaterial(SolicitudMaterial sm) {
        lsm.ingresarSolicitudMaterial(sm);
    }

    @Override
    public void ingresarMaterialASolicitudMaterial(SolicitudMaterial sm, Material M) {
       sm.getLm().ingresarMaterial(M);
                      
    }

    @Override
    public void ingresarHistoricoCertificacion(HistoricoCertificado hc) {
        lhc.ingresarHistoricoCertificado(hc);
    }

    @Override
    public Persona buscarPersona(String rut) {
        Persona P = lp.buscarPersona(rut);
        if (P != null) {
            return P;
        } else {
            return null;
        }
    }

    @Override
    public Certificacion buscarCertificacion(int codigo) {
        Certificacion c = lc.buscarCertificacion(codigo);
        if (c != null) {
            return c;
        } else {
            return null;
        }
    }

    @Override
    public Servicio buscarServicio(int codigo) {
        Servicio s = ls.buscarServicio(codigo);
        if (s != null) {
            return s;
        } else {
            return null;
        }
    }

    @Override
    public Material buscarMaterial(int codigo) {
        Material M = lm.buscarMaterial(codigo);
        if (M != null) {
            return M;
        } else {
            return null;
        }
    }

    @Override
    public SolicitudMaterial buscarSolicitudMaterial(int codigo) {
        SolicitudMaterial sm = lsm.buscarSolicitudMaterial(codigo);
        if (sm != null) {
            return sm;
        } else {
            return null;
        }
    }

    @Override
    public ListaMateriales MaterialesTodosServicios() {
        ListaMateriales lm1 = new ListaMateriales();
        NodoMaterial actualMaterial = lm.getFirst();
        while (actualMaterial != null) {
            boolean esta = false;
            Material M = actualMaterial.getMaterial();
            NodoServicio actual = ls.getFirst();
            while (actual != null) {
                Servicio s = actual.getServicio();
                if (s.getLm().buscarMaterial(M.getCodigo()) == null) {
                    esta = false;
                    break;
                } else {
                    esta = true;
                }
                actual = actual.getNext();
            }
            if (esta) {
                lm1.ingresarMaterial(M);
            }
            actualMaterial = actualMaterial.getNext();
        }
        return lm1;
    }

    @Override
    public ListaMateriales MaterialesNingunServicios() {
        ListaMateriales lm1 = new ListaMateriales();
        NodoMaterial actualMaterial = lm.getFirst();
        while (actualMaterial != null) {
            boolean esta = false;
            Material M = actualMaterial.getMaterial();
            NodoServicio actual = ls.getFirst();
            while (actual != null) {
                Servicio s = actual.getServicio();
                if (s.getLm().buscarMaterial(M.getCodigo()) == null) {
                    esta = true;
                } else {
                    esta = false;
                    break;
                }
                actual = actual.getNext();
            }
            if (esta) {
                lm1.ingresarMaterial(M);
            }
            actualMaterial = actualMaterial.getNext();
        }
        return lm1;
    }

    @Override
    public ListaServicios ServicioUnTrabajadorServicio_organizacion() {
        NodoServicio actual = ls.getFirst();
        ListaServicios ls1 = new ListaServicios();
        while (actual != null) {
            Servicio s = actual.getServicio();
            if (s.getTrabajador2() == null) {
                if (s.getCliente().getOrganizacion() != null) {
                    ls1.ingresarServicio(s);
                }
            }
            actual = actual.getNext();
        }
        return ls1;
    }

    @Override
    public ListaSolicitudMaterial solMateriales() {
        NodoSolicitudMaterial actual = lsm.getFirst();
        ListaSolicitudMaterial lsm1 = new ListaSolicitudMaterial();
        while (actual != null) {
            SolicitudMaterial sm = actual.getSolicitudMaterial();
            if (sm.getCant() >= 3 && sm.getCant() <= 10) { //sm.cantTotalPedida() >= 3 && sm.cantTotalPedida() <= 10
                lsm1.ingresarSolicitudMaterial(sm);
            }
            actual = actual.getNext();
        }
        return lsm1;
    }

    @Override
    public TrabajadorServicio trabajadorConMasServicio() {
        NodoPersona actual = lp.getFirst();
        int mayor = -9999;
        TrabajadorServicio T = null;
        while (actual != null) {
            Persona P = actual.getPersona();
            if (P instanceof TrabajadorServicio) {
                if (((TrabajadorServicio) P).getLs().getCant() > mayor) {
                    mayor = ((TrabajadorServicio) P).getLs().getCant();
                    T = ((TrabajadorServicio) P);
                }
            }
            actual = actual.getNext();
        }
        return T;
    }
}
