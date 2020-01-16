package taller2;

import ucn.*;

public class Taller2 {

    public static void menu(ListaClientes lc, ListaTiendas lt, ListaOrdenCompra lo, ListaProductos lp) {
        int opcionmenu = 0;
        while (opcionmenu != 4) {
            StdOut.println("menu: ");
            StdOut.println("RF1(opcion 1)");
            StdOut.println("RF2(opcion 2)");
            StdOut.println("RF3(opcion 3)");
            StdOut.println("RF4(salir opcion 4)");
            StdOut.println("------------------");
            StdOut.print("ingrese opcion: ");
            opcionmenu = StdIn.readInt();
            if (opcionmenu == 1) {

            }
            if (opcionmenu == 2) {

            }
            if (opcionmenu == 3) {

            }
        }
    }

    public static void leetiendas(ListaTiendas lt) {
        
        In tiendas = new In("tiendas.txt");
        while(!tiendas.isEmpty()){
            String leelinea = tiendas.readLine();
            String [] linea = leelinea.split(";");
            int cod = Integer.parseInt(linea[0]);
            String direccion = linea[1];
            Tienda T= new Tienda(cod,direccion);
            ListaClientes lc =new ListaClientes(1000);
            T.setLc(lc);
            lt.ingresarTienda(T);
        }
        tiendas.close();
    }
    

    public static void main(String[] args) {
        ListaClientes lc = new ListaClientes(1000);
        ListaTiendas lt = new ListaTiendas(1000);
        ListaOrdenCompra lo = new ListaOrdenCompra(1000);
        ListaProductos lp = new ListaProductos(1000);
        menu(lc, lt, lo, lp);
    }

}
