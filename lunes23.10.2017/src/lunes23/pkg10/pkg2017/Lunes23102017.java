
package lunes23.pkg10.pkg2017;

import ucn.*; 

public class Lunes23102017 {
    
    public static void leerDatos(ListaEmpleados le){
        
        System.out.print("Ingrese rut: ");
        String rut =StdIn.readString();
        while(!rut.equalsIgnoreCase("111")){
            System.out.print("Ingrese nombre: ");
            String nombre = StdIn.readString();
            Empleado E = new Empleado(rut,nombre);
            System.out.print("Ingrese cantidad de teléfonos: ");
            int cant = StdIn.readInt();
            for(int i = 0; i < cant; i++){
                System.out.print("Ingrese número del teléfono " + (i+1) + " : ");
                int num = StdIn.readInt();
                Telefono T = new Telefono(num);
                E.getLt().ingresarTelefono(T);
            }
            le.ingresarEmpleado(E);
            System.out.print("Ingrese rut: ");
            rut =StdIn.readString(); 
        }
    }
    
    public static void RF1(ListaEmpleados le){
        System.out.print("Ingre rut del empleado: ");
        String rut = StdIn.readString();
        Empleado E = le.buscarEmpleado(rut);
        if(E != null){
            System.out.print("Ingrese número teléfono: ");
            int num = StdIn.readInt();
            Telefono T = new Telefono(num);
            E.getLt().ingresarTelefono(T);
        }else{
            System.out.print("No se pudo ingresar");
        }
    }
    
    public static void RF2(ListaEmpleados le){
        System.out.print("Ingre rut del empleado: ");
        String rut = StdIn.readString();
        Empleado E = le.buscarEmpleado(rut);
        if(E != null){
            System.out.print("Ingrese teléfono a eliminar: ");
            int num = StdIn.readInt();
            E.getLt().eliminarTelefono(num);
            System.out.println("Se eliminó exitosamente");
        }else{
            System.out.println("El empleado no existe");
        }
    }
    
    public static void RF3(ListaEmpleados le){
        NodoEmpleado actual = le.getFirst();
        while(actual != null){
            Empleado E = actual.getEmpleado();
            if(E.getLt().getFirst() == null){
                le.eliminarEmpleado(E.getRut());
            }
            actual = actual.getNext();
        }
        
    }
    public static void main(String[] args) {
        Interfaz.main(args);
    }
    
}
