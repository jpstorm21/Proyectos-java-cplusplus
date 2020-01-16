/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4sgdosemestre2017;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ListaCertificaciones {
    private ArrayList<Certificacion> lc;
    private int contador;

    public ListaCertificaciones() {
        this.lc = new ArrayList<Certificacion>();
        this.contador = 0;
    }
    public int getContador() {
        return contador;
    }
    public void ingresarCertificaion(Certificacion c){
        lc.add(c);
        contador++;
    }
    public Certificacion buscarCertificacion(int codigo){
        Certificacion c = null;
        for(Certificacion iterador:lc){
            if(iterador.getCodigo() == codigo){
                c = iterador;
                break;
            }
        }
        return c;
    }   
}
