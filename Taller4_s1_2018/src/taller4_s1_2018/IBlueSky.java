/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4_s1_2018;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author Juan Pablo Martinez
 */
public interface IBlueSky {
    void IngresarSocio(Socio s);
    void IngresarInstrumento(Instrumento i);
    void IngresarPrestamo(Prestamo p);
    void IngresarFiestaEstelar(FiestaEstelar fe);
    Socio buscarSocio(String rut);
    Prestamo buscarPrestamo(String id);
    Instrumento buscarInstrumento(String idI);
    FiestaEstelar buscarFiestaEstelar(Date fecha);
    ArrayList<Instrumento> getListaInstrumentos();
    LinkedList<FiestaEstelar> getListaFiestaEstelares();
    ArrayList<Socio> getListaSocios();
    ListaPrestamos getListaPrestamos();
    Date getFecha();
    Socio getUsuario();
    void setUsuario(Socio socioLogeado);
}
