/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import ucn.*;

/**
 *
 * @author Juan Pablo Martinez
 */
public class Prueba {

    /*
        
     */
    public static void main(String[] args) {
        int[] codigos = new int[999];
        int[] stocks = new int[999];
        String[] productos = new String[999];
        int cant = 0;
        int opcion;
        StdOut.println("------ Inventario ------");
        StdOut.println("***Menú***");
        StdOut.println("1) Ingresar nuevos productos \n2) Resgitrar salida de producto \n3) Desplegar productos \n4) Salir");
        StdOut.println("Ingrese una opción: ");
        opcion = StdIn.readInt();
        while (opcion != 4) {
            if (opcion == 1) {
                int cantIngreso = 0;
                StdOut.println("¿Cuántos productos desea ingresar?: ");
                cantIngreso = StdIn.readInt();
                if (cantIngreso > 0) {
                    for (int j = 0; j < cantIngreso; j++) {
                        int codigo;
                        boolean encontrado = false;
                        StdOut.println("Ingrese el código del producto: ");
                        codigo = StdIn.readInt();
                        int i = 0;
                        for (i = 0; i < cant; i++) {
                            if (codigo == codigos[i]) {
                                encontrado = true;
                                break;
                            }
                        }
                        if (encontrado) {
                            int stock = 0;
                            StdOut.println("Ingrese cantidad de productos a ingresar del codigo " + codigo + ": ");
                            stock = StdIn.readInt();
                            if (stock > 0) {
                                stocks[i] = stocks[i] + stock;
                            }
                        } else {
                            String nombreProducto = "";
                            int stock;
                            StdOut.println("***Se creará un nuevo producto***");
                            StdOut.println("ingrese el nombre del producto: ");
                            nombreProducto = StdIn.readString();
                            StdOut.println("Ingrese el stock inicial del producto: ");
                            stock = StdIn.readInt();
                            codigos[cant] = codigo;
                            productos[cant] = nombreProducto;
                            if (stock > 0) {
                                stocks[cant] = stock;
                            } else {
                                stocks[cant] = 0;
                            }
                            cant++;
                        }
                    }
                }
            } else if (opcion == 2) {
                int codigo;
                StdOut.println("Ingrese el código del producto al que desea disminiur el stock: ");
                codigo = StdIn.readInt();
                boolean encontrado = false;
                int i;
                for (i = 0; i < cant; i++) {
                    if (codigo == codigos[i]) {
                        encontrado = true;
                    }
                }
                if (encontrado) {
                    int stockMenos = 0;
                    StdOut.println("ingrese el numero de productos a disminuir: ");
                    stockMenos = StdIn.readInt();
                    if (stockMenos > 0) {
                        if (stockMenos <= (stocks[i] - stockMenos)) {
                            stocks[i] = stocks[i] - stockMenos;
                        } else {
                            StdOut.println("***La cantidad a disminuir supera al stock del producto***");
                        }
                    }
                } else {
                    StdOut.println("El producto no esta registrado");
                }
            } else if (opcion == 3) {
                for (int i = 0; i < cant - 1; i++) {
                    for (int j = i + 1; j < cant; j++) {
                        if (stocks[i] < stocks[j]) {
                            int auxS = stocks[i];
                            stocks[i] = stocks[j];
                            stocks[j] = auxS;
                            int auxC = codigos[i];
                            codigos[i] = codigos[j];
                            codigos[j] = auxC;
                            String auxP = productos[i];
                            productos[i] = productos[j];
                            productos[j] = auxP;
                        }
                    }
                }
                StdOut.println("Codigo / Producto / Stock");
                for (int i = 0; i < cant; i++) {
                    StdOut.println(codigos[i] + " / " + productos[i] + " / " + stocks[i]);
                }
            } else {
                StdOut.println("---Opción ingresada inválida---");
            }
            StdOut.println("***Menú***");
            StdOut.println("1) Ingresar nuevos productos \n2) Resgitrar salida de producto \n3) Desplegar productos \n4) Salir");
            StdOut.println("Ingrese una opción: ");
            opcion = StdIn.readInt();
        }
        StdOut.println("******* Gracias por utilizar nuestro programa :D *******");

    }

}
