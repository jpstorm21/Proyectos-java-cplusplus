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
public class Prueba2016Progra1 {

    public static void ingresarPag(Scanner sc,interfaced sistema){
        System.out.print("ingrese url");
        String url = sc.next();
        System.out.print("ingrese pais");
        String pais = sc.next();
        if(pais.equalsIgnoreCase("chile")){
            System.out.print("ingrese region: ");
            int region = sc.nextInt();
            Pagina P = new Chilena(region,0,url);
            sistema.registraNuevoSitio(P);
        }else{
            System.out.println("ingrese pais: ");
            String nacionalidad = sc.next();
            Pagina P = new Internacional(nacionalidad,0,url);
            sistema.registraNuevoSitio(P);
        }
    }
    public static void InformaTrafico(Scanner sc,interfaced sistema){
        System.out.print("ingrese url de la pagina que desea saber su trafico: ");
        String url = sc.next();
        Pagina P = sistema.InformarTrafico(url);
        if(P != null){
            System.out.println("La pagina : " + P.getUrl());
            System.out.println("tiene una cantidad de visitas de : " + P.getCantVisitas());
        }else{
            System.out.println("pagina no existe");
        }
    }
    public static void DiezMejores(interfaced sistema){
        sistema.Ordenar();
        NodoPagina  actual = sistema.getLp().getFirst();
        int pos = 0;
        while(actual != null){
            Pagina p = sistema.ObtenerPagina(actual);
            if(pos > 10){
                if(p instanceof Chilena){
                    System.out.println("url: " + p.getUrl());
                    pos++;
                }
            }else{
                break;
            }
            actual = actual.getNext();
        }       
    }
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        interfaced sistema = new Sistema();
        Pagina P = new Chilena(4,0,"www.ucn.cl");
        Pagina P2 = new Chilena(4,0,"www.xvideos.cl");
        P.setCantVisitas(3);
        P2.setCantVisitas(6);
        sistema.registraNuevoSitio(P);
        sistema.registraNuevoSitio(P2);
        NodoPagina actualp = sistema.getLp().getFirst();
        System.out.println("sin ordenar");
        while(actualp != null){
            System.out.println("cant visitas: " + actualp.getPagina().getCantVisitas());
            actualp = actualp.getNext();
        }
        sistema.Ordenar();
        NodoPagina actual = sistema.getLp().getFirst();
        System.out.println("ordenadas");
        while(actual != null){
            System.out.println("cant visitas: " + actual.getPagina().getCantVisitas());
            actual = actual.getNext();
        }
    }
    
}
