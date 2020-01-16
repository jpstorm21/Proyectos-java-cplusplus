package ayudantia.pkg11;

import ucn.*;

/**
 *
 * @author Cristóbal
 */
public class APP {

    public static void leerDatos(Interface sistema) {
        System.out.print("Ingrese su nombre(FIN DE DATOS XX): ");
        String nombre = StdIn.readString();
        while (!nombre.equalsIgnoreCase("XX")) {
            System.out.print("Ingrese su rut: ");
            String rut = StdIn.readString();
            Cliente C = new Cliente(nombre, rut);
            sistema.ingresarCliente(C);
            System.out.print("Ingrese su nombre(FIN DE DATOS XX): ");
            nombre = StdIn.readString();
        }
    }

    public static void leerProductos(Interface sistema) {
        System.out.print("Ingrese rut del cliente a registrar sus productos y envios: ");
        String rut = StdIn.readString();
        Cliente C1 = sistema.buscarCliente(rut);
        if (C1 != null) {
            System.out.print("Ingrese cantidad de pedidos: ");
            int cant = StdIn.readInt();
            for (int i = 0; i < cant; i++) {
                System.out.print("Ingrese id: ");
                String id = StdIn.readString();
                System.out.print("Ingrese nombre del producto: ");
                String nom = StdIn.readString();
                Producto P = new Producto(id, nom);
                System.out.print("Ingrese rut destinatario: ");
                String destinatario = StdIn.readString();
                System.out.print("Ingrese estado: ");
                String estado = StdIn.readString();
                Envio E = new Envio(estado);
                P.setEnvio(E);
                C1.getListaEnvios().ingresarEnvio(E);
                C1.getListaProductos().ingresarProducto(P);
                Cliente C = sistema.buscarCliente(destinatario);
                E.setCliente(C);
                E.getLp().ingresarProducto(P);
                sistema.ingresarEnvio(E);
                sistema.ingresarProducto(P);
            }
        } else {
            System.out.println("cliente no existe");
        }
    }

    public static void desplegarListaProductosXcliente(Interface sistema) {
        NodoCliente actual = sistema.getListaClientes().getFirst();
        while (actual != null) {
            Cliente C = sistema.obtenerCliente(actual);
            NodoProducto actualP = C.getListaProductos().getFirst();
            while (actualP != null) {
                Producto P = actualP.getProducto();
                System.out.println("Nombre del producto: " + P.getNombre());
                actualP = actualP.getNext();
            }
            actual = actual.getNext();
        }
    }

    public static void RF4(Interface sistema) {

    }

    public static void main(String[] args) {
        Interface sistema = new InterfaceImpl();
        leerDatos(sistema);
        leerProductos(sistema);
        desplegarListaProductosXcliente(sistema);

    }

}
