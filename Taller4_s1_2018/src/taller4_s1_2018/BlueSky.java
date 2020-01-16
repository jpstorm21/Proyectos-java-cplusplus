/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4_s1_2018;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Juan Pablo Martinez
 */
public class BlueSky implements IBlueSky {

    private ArrayList<Instrumento> ListaInstrumentos;
    private LinkedList<FiestaEstelar> listaFiestaEstelares;
    private ArrayList<Socio> ListaSocios;
    private ListaPrestamos listaPrestamos;
    private Date fecha;
    private Socio socioLogeado;

    public BlueSky(String fechaActual) throws ParseException {
        this.ListaInstrumentos = new ArrayList<Instrumento>();
        this.listaFiestaEstelares = new LinkedList<FiestaEstelar>();
        this.ListaSocios = new ArrayList<Socio>();
        this.listaPrestamos = new ListaPrestamos();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        fecha = formato.parse(fechaActual);
        socioLogeado = null;
    }

    public Socio getUsuario() {
        return socioLogeado;
    }

    public void setUsuario(Socio socioLogeado) {
        this.socioLogeado = socioLogeado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Instrumento> getListaInstrumentos() {
        return ListaInstrumentos;
    }

    public void setListaInstrumentos(ArrayList<Instrumento> ListaInstrumentos) {
        this.ListaInstrumentos = ListaInstrumentos;
    }

    public LinkedList<FiestaEstelar> getListaFiestaEstelares() {
        return listaFiestaEstelares;
    }

    public void setListaFiestaEstelares(LinkedList<FiestaEstelar> listaFiestaEstelares) {
        this.listaFiestaEstelares = listaFiestaEstelares;
    }

    public ArrayList<Socio> getListaSocios() {
        return ListaSocios;
    }

    public void setListaSocios(ArrayList<Socio> ListaSocios) {
        this.ListaSocios = ListaSocios;
    }

    public ListaPrestamos getListaPrestamos() {
        return listaPrestamos;
    }

    public void setListaPrestamos(ListaPrestamos listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }

    @Override
    public void IngresarSocio(Socio s) {
        ListaSocios.add(s);
    }

    @Override
    public void IngresarInstrumento(Instrumento i) {
        ListaInstrumentos.add(i);
    }

    @Override
    public void IngresarPrestamo(Prestamo p) {
        listaPrestamos.ingresar(p);
    }

    @Override
    public void IngresarFiestaEstelar(FiestaEstelar fe) {
        listaFiestaEstelares.add(fe);
    }

    @Override
    public Socio buscarSocio(String rut) {
        Iterator<Socio> it = ListaSocios.iterator();
        Socio s = null;
        int pos = 0;
        while (it.hasNext()) {
            if (it.next().getRut().equalsIgnoreCase(rut)) {
                s = ListaSocios.get(pos);
                // s = it.next();
                break;
            }
            pos++;
        }
        if (s != null) {
            return s;
        } else {
            return null;
        }
    }

    @Override
    public Prestamo buscarPrestamo(String id) {
        Prestamo p = listaPrestamos.buscarPrestamo(id);
        if (p != null) {
            return p;
        } else {
            return null;
        }
    }

    @Override
    public Instrumento buscarInstrumento(String idI) {
        Iterator<Instrumento> it = ListaInstrumentos.iterator();
        Instrumento I = null;
        int pos = 0;
        while (it.hasNext()) {
            if (it.next().getIdIntrumento().equalsIgnoreCase(idI)) {
                I = ListaInstrumentos.get(pos);
                break;
            }
            pos++;
        }
        if (I != null) {
            return I;
        } else {
            return null;
        }
    }

    @Override
    public FiestaEstelar buscarFiestaEstelar(Date fecha) {
        Iterator<FiestaEstelar> it = listaFiestaEstelares.iterator();
        FiestaEstelar fe = null;
        int pos = 0;
        while (it.hasNext()) {
            if (it.next().getFechaEvento().compareTo(fecha) == 0) {
                fe = listaFiestaEstelares.get(pos);
                break;
            }
            pos++;
        }
        if (fe != null) {
            return fe;
        } else {
            return null;
        }
    }

}
