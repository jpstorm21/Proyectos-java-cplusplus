/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba2016progra1;

/**
 *
 * @author Usuario
 */
public interface interfaced {
    public void registraNuevoSitio(Pagina p);
    public Pagina InformarTrafico(String url);
    public Pagina Primero();
    public Pagina ObtenerPagina(NodoPagina actual);
    public ListaPaginas DiezMejoresCOM();
    public ListaPaginas CincuentaMejores();
    public void Ordenar();
    public ListaPaginas getLp();
    public void Fordenar(Pagina [] vector, int pos);
    
}
