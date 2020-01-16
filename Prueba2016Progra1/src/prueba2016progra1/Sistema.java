/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba2016progra1;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Sistema implements interfaced {

    private ListaPaginas lp;

    public Sistema() {
        this.lp = new ListaPaginas();

    }

    @Override
    public Pagina Primero() {
        int mayor = -99;
        Pagina Pmayor = null;
        NodoPagina actual = lp.getFirst();
        while (actual != null) {
            Pagina p = actual.getPagina();
            if (p.cantVisitas >= mayor) {
                Pmayor = p;
            }
            actual = actual.getNext();
        }
        return Pmayor;
    }

    @Override
    public Pagina ObtenerPagina(NodoPagina actual) {
        Pagina P = actual.getPagina();
        return P;
    }

    @Override
    public ListaPaginas DiezMejoresCOM() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaPaginas CincuentaMejores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registraNuevoSitio(Pagina p) {
        lp.ingresarUltimo(p);
    }

    @Override
    public Pagina InformarTrafico(String url) {
        Pagina P = lp.buscar(url);
        if (P != null) {
            return P;
        } else {
            return null;
        }
    }

    @Override
    public void Ordenar() {
        Pagina [] vector =  new Pagina[lp.getCant()];
        int i =0;
        NodoPagina actual = lp.getFirst();
        while(actual !=null){
            vector[i] = actual.getPagina();
            actual = actual.getNext();
            i++;
        }
        Fordenar(vector,i);
        ListaPaginas lp2 = new ListaPaginas();     
        for(int j=0;j<i;j++){
            lp2.ingresarUltimo(vector[j]);
        }
        lp = lp2;
    }

    public ListaPaginas getLp() {
        return lp;
    }

    public void setLp(ListaPaginas lp) {
        this.lp = lp;
    }

    @Override
    public void Fordenar(Pagina [] arreglo,int pos) {
        for (int i = 0; i < pos - 1; i++) {
            for (int j = 0; j < pos - 1; j++) {
                if (arreglo[j].getCantVisitas() < arreglo[j + 1].getCantVisitas()) {
                    Pagina P = arreglo[j + 1];
                    arreglo[j + 1] = arreglo[j];
                    arreglo[j] = P;
                }
            }
        }
    }
}
