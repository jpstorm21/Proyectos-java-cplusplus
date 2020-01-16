
package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import ucn.StdIn;

public class APP {

    
    public static void LeerDatos(Sistema tienda){
        int opcion = -1;
        int opcionP = 0;
        while(opcion != 0){
            System.out.println("***********************************************************");
            System.out.println("Ingreso de datos del cliente que va a realizar una compra.");
            System.out.println("***********************************************************");
            System.out.println("Ingrese rut:");
            String rut = StdIn.readString();
            System.out.println("Ingrese nombre:");
            String nombre = StdIn.readString();
            Cliente c = new Cliente(rut,nombre);
            opcionP = 0;
            while(opcionP != -1){
                System.out.println("***************************************************************************");
                System.out.println("Ingreso de datos del los productos que va a comprar el cliente "+nombre+".");
                System.out.println("***************************************************************************");
                    System.out.println("Ingrese codigo:");
                    int cod = StdIn.readInt();
                    System.out.println("Ingrese nombre:");
                    String nomP = StdIn.readString();
                    Producto p = new Producto(cod,nomP);
                    p.setCliente(c);
                    c.getListaProductos().IngresarProducto(p);
                    tienda.IngresarProducto(p);
                    System.out.println("*****************************************************************************");
                    System.out.println("Desea ingresar otro producto??. NO = -1, Si = cualquier otro numero de 1 a 9");
                    opcionP = StdIn.readInt();
            }
            
            tienda.IngresarCliente(c);
            
            System.out.println("************************************************************************************");
            System.out.println("Desea ingresar otro cliente??. Para salir ingrese 0.Ingrese cualquier numero de 1 a 9 para seguir.");
            opcion = StdIn.readInt();
        }
    }
    
    public static void DesplegarClientes(Sistema tienda){
        Iterator iterador = tienda.getListaClientes();
        
        while(iterador.hasNext()){
            Cliente c = (Cliente)iterador.next();
            System.out.println("Nombre: "+c.getNombre());
        }
    }
    
    public static void DesplegarProductos(Sistema tienda){
        NodoProducto actual = tienda.getListaProductos().getPrimero();
      
        while(actual != null){
            System.out.println("Nombre Producto: "+actual.getProducto().getNombre());
            actual = actual.getSiguiente();
        }
    }
    
    public static void Req1(Sistema tienda){
        System.out.println("***************************************************************");
        System.out.println("\t\t\t Requerimiento 1");
        System.out.println("***************************************************************");
        System.out.println("Ingrese el rut del cliente");
        String rut = StdIn.readString();
        Cliente c = tienda.BuscarCliente(rut);       
        if (c != null){
            System.out.println("***************************************************************");
            System.out.println("\t\tLista de Productos del cliente: "+c.getNombre());
            System.out.println("***************************************************************");
            NodoProducto actual = c.getListaProductos().getPrimero();
            if(actual != null){
                int i = 0;
                while(actual != null){
                    System.out.println("["+(i+1)+"]"+" Nombre Producto: "+actual.getProducto().getNombre()+
                            "\t\tCodigo Producto: "+actual.getProducto().getCodigo());
                    actual = actual.getSiguiente();
                }
            }else{
                System.out.println("El cliente "+c.getNombre()+" no tiene productos comprados");
            }
        }else{
            System.out.println("No existe un cliente con el rut ingresado.");
        }
    } 
    
    public static void req2(Sistema tienda){
        System.out.println("**********************************************************************");
        System.out.println("\t\t\tRequerimiento 2.");
        System.out.println("**********************************************************************");
        System.out.println("\t\tIngrese el codigo del producto");
        int codigo = StdIn.readInt();
        Producto p = tienda.BuscarProducto(codigo);
        if(p != null){
            System.out.println("**********************************************************************");
            System.out.println("El producto codigo "+ p.getCodigo()+ " fue comprado por el cliente: ");
            System.out.println("Nombre Cliente: "+p.getCliente().getNombre());
            System.out.println("Rut del Cliente: "+p.getCliente().getRut());
            System.out.println("**********************************************************************");
        }else{
            System.out.println("No existe un producto con el codigo ingresado");
        }
    }
    
    
    public static void main(String[] args) {
        /*Sistema tienda = new SistemaImpl();
        LeerDatos(tienda);
        //DesplegarClientes(tienda); // no se pedia es solo para probar el programa
        //DesplegarProductos(tienda);// no se pedia es solo para probar el programa
        Req1(tienda);
        req2(tienda);*/
        ArrayList<Integer> lista = new ArrayList<Integer>();
        lista.add(25);
        lista.add(15);
        lista.add(5);
        Collections.sort(lista);
        for(int i= 0;i<lista.size();i++){
            System.out.println(lista.get(i));
        }
        
    }
    
}
