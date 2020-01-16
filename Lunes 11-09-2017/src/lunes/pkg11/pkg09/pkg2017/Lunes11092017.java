/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lunes.pkg11.pkg09.pkg2017;

import java.util.Scanner;

public class Lunes11092017 {

    public static void leerEmpresas(ListaEmpresas le, ListaTrabajadores lt, Scanner sc) {

        System.out.println("Ingrese cantidad de empresas: ");
        int cant = sc.nextInt();

        int i = 0;
        for (i = 0; i < cant; i++) {
            System.out.println("Ingrese còdigo de la empresa: ");
            String codigo = sc.next();
            System.out.println("Ingrese nombre de la empresa: ");
            String nombre = sc.next();
            Empresa E = new Empresa(codigo, nombre);
            le.ingresarEmpresa(E);
        }

        System.out.println("Ingrese RUT del trabajador: ");
        String rut = sc.next();
        while (rut != "-1") {
            System.out.println("Ingrese nombre del trabajador: ");
            String nombre = sc.next();
            System.out.println("Ingrese cantidad de familiares: ");
            int cantidad = sc.nextInt();
            System.out.println("Ingrese cantidad de horas trabajadas: ");
            int horas = sc.nextInt();
            System.out.println("Ingrese código de la empresa a la cual pertenece: ");
            String cod = sc.next();
            Trabajador T = new Trabajador(rut, nombre, cantidad, horas);
            Empresa E = le.buscarEmpresa(cod);
            T.setEmpresa(E);
            E.getLt().ingresarTrabajador(T);
            lt.ingresarTrabajador(T);
            System.out.println("Ingrese RUT del trabajador: ");
            rut = sc.next();
        }
    }

    public static void RF1(ListaEmpresas le) {        
        for(int i = 0; i < le.getCantidadEmpresas(); i++){
            int mayor = -999;
            Trabajador T = null;
            Empresa E = le.getEmpresa(i);
            for(int j = 0; j < E.getLt().getCantidadTrabajadores(); j++){
                Trabajador T2 = E.getLt().getTrabajador(j);
                if(T2.calcularBono()> mayor){
                    mayor  = T2.calcularBono();
                    T = T2;
                }
            }
            System.out.println("El trabajador con mayor bono de la empresa " + E.getNombre() + "es: " + T.getNombre() + "con un bono de: " + mayor);
            
        }
        
        

    }
    
    public static void RF2(ListaEmpresas le, Scanner sc){
        System.out.println("Ingrese codigo de la empresa: ");
        String codigo = sc.next();
        Empresa E = le.buscarEmpresa(codigo);
        if(E != null){
            int mayor = -999;
            String nombre = " ";
            for(int i = 0; i < E.getLt().getCantidadTrabajadores(); i++){
                Trabajador T = E.getLt().getTrabajador(i);
                if(T.getCantFamily() > mayor){
                    mayor = T.getCantFamily();
                    nombre = T.getNombre();
                }
            }
            System.out.println("El trabajador " + nombre + "tiene la mayor cantidad de familiares con: " + mayor);
            
            
        }else{
            System.out.println("La empresa no existe ");
        }
        
        
        
    }
    
    public static void RF3(ListaEmpresas le, ListaTrabajadores lt, Scanner sc){
        for(int i = 0; i < le.getCantidadEmpresas(); i++){
            Empresa E = le.getEmpresa(i);
            System.out.println("El código de la empresa es:  " + E.getCodigo());
            System.out.println("El nombre de la empresa es: " + E.getNombre());
            for(int j = 0; j < E.getLt().getCantidadTrabajadores(); j++ ){
                Trabajador T = E.getLt().getTrabajador(j);
                System.out.println("RUT: " + T.getRut());
                System.out.println("Nombre: " + T.getNombre());
                System.out.println("Cantidad de familiares: " + T.getCantFamily());        
            }
        }
    }

    public static void main(String[] args) {
        ListaEmpresas le = new ListaEmpresas(1000);
        ListaTrabajadores lt = new ListaTrabajadores(1000);
        Scanner sc = new Scanner(System.in);
        leerEmpresas(le, lt, sc);
        RF1(le);
        RF2(le, sc);
        RF3(le, lt, sc);
    }

}
