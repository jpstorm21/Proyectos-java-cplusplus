

package tarea;
import ucn.*;

public class Tarea {
public static void leerDatos(ListaDepartamentos ld,ListaEmpleados le){
    System.out.print("ingrese codigo del departamento: ");
    String codigo = StdIn.readString();
    while(!codigo.equals("999")){
        System.out.print("ingrese nombre del departamento: ");
        String nombredepa = StdIn.readString();
        System.out.print("ingrese presupuesto del departamento: ");
        int presupuesto = StdIn.readInt();
        Departamento D = new Departamento(codigo,nombredepa,presupuesto);
        ld.ingresarDepto(D);
        System.out.print("ingrese cantidad de empleados: ");
         int cant = StdIn.readInt();
         for(int i = 0;i<cant;i++){
             System.out.print("ingrese nombre del empleado: ");
              String nombre = StdIn.readString();
              System.out.print("ingrese rut del empleado: ");
              String rut = StdIn.readString();
              
              String codedepto = codigo;
              System.out.print("ingrese sueldo del empleado: ");
              int sueldo = StdIn.readInt();
              Empleado E = new Empleado(nombre,rut,codedepto,sueldo);
              le.ingresarEmpleado(E);
              D.getLe().ingresarEmpleado(E);
              
         }
         System.out.print("ingrese codigo del departamento: ");
               codigo = StdIn.readString();
    }
}
  
  
    public static void main(String[] args) {
     ListaDepartamentos ld = new ListaDepartamentos(1000);
     ListaEmpleados le = new ListaEmpleados(1000);
     leerDatos(ld,le);
     SistemeEmpleados sistema = new sistema();
     sistema.requerimiento1();
     sistema.requerimiento2();
     sistema.requerimiento3();
    
}
}