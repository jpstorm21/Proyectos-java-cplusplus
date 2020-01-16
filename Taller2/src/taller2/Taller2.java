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
              Taller2.RF1(lc, lt, lo, lp);
            }
            if (opcionmenu == 2) {
                Taller2.RF2(lc, lt, lo, lp);
            }
            if (opcionmenu == 3) {
                Taller2.RF3(lc, lt, lo, lp);
            }
        }
    }
/**
 * 
 * @param lt Lista general de las tiendas 
 * En esta funcion leemos y guardamos la informacion que se enncuentra en el archivo "tiendas.txt" 
 */
    public static void leetiendas(ListaTiendas lt) {

        In tiendas = new In("tiendas.txt");
        while (!tiendas.isEmpty()) {
            String leelinea = tiendas.readLine();
            String[] linea = leelinea.split(";");
            int cod = Integer.parseInt(linea[0]);
            String direccion = linea[1];
            Tienda T = new Tienda(cod, direccion);
            lt.ingresarTienda(T);
        }
        tiendas.close();

    }
/**
 * 
 * @param lc Lista general de los Clientes 
 * @param lt Lista general de las Tiendas
 * En esta funcion leemos y guardamos la informacion que se enncuentra en el archivo "clientes.txt" 
 */
    public static void leeclientes(ListaClientes lc, ListaTiendas lt) {

        In clientes = new In("clientes.txt");
        while (!clientes.isEmpty()) {
            String leelinea = clientes.readLine();
            String[] linea = leelinea.split(";");
            String rut = linea[0];
            String nombre = linea[1];
            String apellido = linea[2];
            String sexo = linea[3];
            int telefono = Integer.parseInt(linea[4]);
            String email = linea[5];
            int codigoTienda = Integer.parseInt(linea[6]);
            Tienda T = lt.buscarTienda(codigoTienda);
            Cliente C = new Cliente(rut, nombre, apellido, sexo, telefono, email);
            C.setReftienda(T);
            lc.ingresarCliente(C);
            T.getLc().ingresarCliente(C);

        }
        clientes.close();

    }
    /**
     * 
     * @param lp Lista general de los productos
     * En esta funcion leemos y guardamos la informacion que se enncuentra en el archivo "productos.txt" 
     */
    public static void leeproductos(ListaProductos lp) {

        In productos = new In("productos.txt");
        while (!productos.isEmpty()) {
            String leelinea = productos.readLine();
            String[] linea = leelinea.split(";");
            String codProducto = linea[0];
            String nombre = linea[1];
            int precio = Integer.parseInt(linea[2]);
            String plataforma = linea[3];
            Producto P = new Producto(codProducto, nombre, precio, plataforma);
            lp.ingresarProducto(P);

        }

        productos.close();

    }
    /**
     * 
     * @param lc Lista general de Clientes
     * @param lo Lista general de Ordenes
     * @param lp Lista general de productos
     * En esta funcion leemos y guardamos la informacion que se enncuentra en el archivo "orden_compra.txt" 
     */
    public static void leeordencompra(ListaClientes lc, ListaOrdenCompra lo, ListaProductos lp) {

        In orden_compra = new In("orden_compra.txt");
        while (!orden_compra.isEmpty()) {
            String leelinea = orden_compra.readLine();
            String[] linea = leelinea.split(";");
            int numeroOrden = Integer.parseInt(linea[0]);
            String rut = linea[1];
            String[] fechaComp = linea[2].split(" ");
            String[] fechaDMA = fechaComp[0].split("/");
            String[] fechaHora = fechaComp[1].split(":");
            int dia = Integer.parseInt(fechaDMA[0]);
            int mes = Integer.parseInt(fechaDMA[1]);
            int año = Integer.parseInt(fechaDMA[2]);
            int hora = Integer.parseInt(fechaHora[0]);
            int minuto = Integer.parseInt(fechaHora[1]);
            int segundos = Integer.parseInt(fechaHora[2]);
            Fecha F = new Fecha(dia, mes, año, hora, minuto, segundos);
            Cliente C = lc.buscarCliente(rut);
            OrdenCompra OC = new OrdenCompra(numeroOrden);
            OC.setFechaorden(F);
            OC.setRefcliente(C);

            C.getLo().ingresarOrden(OC);
            lo.ingresarOrden(OC);

        }
        orden_compra.close();

    }
    /**
     * 
     * @param lc Lista General Clientes
     * @param lo Lista General Ordenes
     * @param lp Lista General Productos
     * @param lt Lista General Tiendas
     * En esta funcion leemos y guardamos la informacion que se enncuentra en el archivo "orden_compra_productos.txt" 
     */
    public static void ordenCompraProductos(ListaClientes lc, ListaOrdenCompra lo, ListaProductos lp, ListaTiendas lt) {

        In orden_compra_productos = new In("orden_compra_productos.txt");
        while (!orden_compra_productos.isEmpty()) {
            String leelinea = orden_compra_productos.readLine();
            String[] linea = leelinea.split(";");
            int numeroOr = Integer.parseInt(linea[0]);
            OrdenCompra OC = lo.buscarOrden(numeroOr);
            String codigoProd = linea[1];
            Producto P = lp.buscarOrden(codigoProd);
            int cantidad = Integer.parseInt(linea[2]);

            OC.getLp().ingresarProducto(P);
            OC.SumarTotal(cantidad);

        }
        orden_compra_productos.close();
    }
     /**
      * 
      * @param lc Definidos Arriba
      * @param lt Definidos Arriba 
      * @param lo Definidos Arriba
      * @param lp Definidos Arriba
      * En este procedimiento (RF1) imprimimos los datos de las tiendas en dicho mes
      */
    public static void RF1(ListaClientes lc, ListaTiendas lt, ListaOrdenCompra lo, ListaProductos lp) {
     StdOut.print("por favor ingrese mes que se desea examinar: ");
       int mes = StdIn.readInt();
       while(mes<1 || mes >12){
           StdOut.println("mes ingresado no valido ingrese nuevamente:");
           mes = StdIn.readInt();
       }
           int mayor = -1;
           Tienda t = null;
           for(int i=0; i<lt.getCantiendas(); i++){
               Tienda T = lt.getTienda(i);
               int suma = 0;
               for(int j=0; j<T.getLc().getCantclientes(); j++){
                   Cliente C = T.getLc().getCliente(j);
                   for(int w=0; w< C.getLo().getCant();w++){
                       OrdenCompra OC = C.getLo().getOrden(w);
                       if(mes == OC.getFechaorden().getMes() ){
                           
                               suma = suma + OC.getValorTotal();
                           
                       }
                   }
               }
               if(suma > mayor){
                   mayor = suma;
                   t = T;
               }
           }
           StdOut.println("codigo de la tienda: " + t.getCodtienda());
           StdOut.println("la direccion de la tienda: " + t.getDireccion());
           StdOut.println("ingreso obtenido en dicho mes es:" + mayor);
       }
    
    /**
     * 
     * @param lc Definidos Arriba
     * @param lt Definidos Arriba
     * @param lo Definidos Arriba
     * @param lp Definidos Arriba
     * En este procedimiento (RF2) desplegamos los datos de los compradores de sexo femenino y con mayor a 3 ordenes de compra
     * de una tienda ingresada por pantalla
     */
    public static void RF2(ListaClientes lc, ListaTiendas lt, ListaOrdenCompra lo, ListaProductos lp) {
        StdOut.print("ingrese codigo de la tienda cual desea buscar: ");
        int codb = StdIn.readInt();
        Tienda T = lt.buscarTienda(codb);
        for (int i = 0; i < T.getLc().getCantclientes(); i++) {
            Cliente C = T.getLc().getCliente(i);

            if (C.getSexo().equalsIgnoreCase("Femenino") && C.getLo().getCant() > 2) {
                StdOut.println("rut: " + C.getRut());
                StdOut.println("nombre: " + C.getNombre());
                StdOut.println("apellido: " + C.getApellido());
                for (int j = 0; j < C.getLo().getCant(); j++) {
                    OrdenCompra OC = C.getLo().getOrden(j);
                    StdOut.println("numero de la orden de compra: " + OC.getNumOrden());
                    for (int w = 0; w < OC.getLp().getCantp(); w++) {
                        StdOut.println("Codigo producto: " + T.getLc().getCliente(i).getLo().getOrden(j).getLp().getProducto(w).getCodproducto());
                        StdOut.println("Nombre producto: " + T.getLc().getCliente(i).getLo().getOrden(j).getLp().getProducto(w).getNombrep());
                        StdOut.println("Cantidad producto: " + T.getLc().getCliente(i).getLo().getOrden(j).getCantidad(w));

                    }
                }

            }
            if (!C.getSexo().equalsIgnoreCase("Femenino") || C.getLo().getCant() <= 2) {

                StdOut.println("cliente " + C.getNombre() + "no cumple las condiciones");

            }

        }
    }
    /**
     * 
     * @param lc Definidos Arriba
     * @param lt Definidos Arriba
     * @param lo Definidos Arriba
     * @param lp Definidos Arriba
     * En este procedimiento (RF3) imprimimos las ordenes de compra y los datos de los clientes que compraron sobre las 18:30 horas
     */
    public static void RF3(ListaClientes lc, ListaTiendas lt, ListaOrdenCompra lo, ListaProductos lp) {

        for (int i = 0; i < lt.getCantiendas(); i++) {
            StdOut.println("codigo de tienda" + " " + lt.getTienda(i).getCodtienda());
            StdOut.println("direccion : " + " " + lt.getTienda(i).getDireccion());

            for (int j = 0; j < lt.getTienda(i).getLc().getCantclientes(); j++) {
                Cliente C = lt.getTienda(i).getLc().getCliente(j);
                boolean orden = false;
                for (int w = 0; w < C.getLo().getCant(); w++) {
                    if (C.getLo().getOrden(w).getFechaorden().getHora() > 18) {
                        orden = true;
                    }
                    if (C.getLo().getOrden(w).getFechaorden().getHora() > 18) {
                        orden = true;
                    }
                }
                if (orden == true) {
                    StdOut.println("rut :" + C.getRut());
                    StdOut.println("nombre: " + C.getNombre());
                    StdOut.println("apellido: " + C.getApellido());
                    StdOut.println("relefono: " + C.getEmail());
                    StdOut.println("mail: " + C.getTelefono());

                }
            }

        }
    }
   /**
    * 
    * @param args
    * Aqui llamamos todas las Funciones.
    */
    public static void main(String[] args) {
        ListaClientes lc = new ListaClientes(1000);
        ListaTiendas lt = new ListaTiendas(1000);
        ListaOrdenCompra lo = new ListaOrdenCompra(1000);
        ListaProductos lp = new ListaProductos(1000);

        leetiendas(lt);
        leeclientes(lc, lt);
        leeproductos(lp);
        leeordencompra(lc, lo, lp);
        ordenCompraProductos(lc, lo, lp, lt);
        Taller2.menu(lc, lt, lo, lp);
    }

}
