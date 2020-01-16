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
public class ListaHistoricoCertificaciones {

    private ArrayList<HistoricoCertificado> lhc;
    private int contador;

    public ListaHistoricoCertificaciones() {
        this.lhc = new ArrayList<HistoricoCertificado>();
        this.contador = contador;
    }

    public int getContador() {
        return contador;
    }

    public void ingresarHistoricoCertificado(HistoricoCertificado hc) {
        lhc.add(hc);
        contador++;
    }
    public HistoricoCertificado buscarHistoricoCertificado(int codigo){
        HistoricoCertificado hc = null;
        for(HistoricoCertificado iterador : lhc){
            if(iterador.getCertificacion().getCodigo() == codigo){
                hc = iterador;
                break;
            }
        }
        return hc;
    }
    public HistoricoCertificado getHistoricoCertificado(int i){
        HistoricoCertificado hc = lhc.get(i);
        return hc;
    }
}
