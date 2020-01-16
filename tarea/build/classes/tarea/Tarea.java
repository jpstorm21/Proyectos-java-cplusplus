

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
  public static void requerimiento1(ListaDepartamentos ld,ListaEmpleados le){
      for(int i = 0;i<ld.getCantdpto();i++){
          Departamento D = ld.getDepartamento(i);
          System.out.println("los datos son del departamento son: ");
          System.out.println("codigo: " + D.getCodigo());
          System.out.println("nombre: " + D.getNombredep());
          System.out.println("presupuesto: " + D.getPresupuesto());
          
      }
      System.out.println("la cantidad de departamentos es: " + ld.getCantdpto());
  }
  public static void requerimiento2(ListaDepartamentos ld,ListaEmpleados le){
      System.out.print("ingrese codigo del departamento en cual desea buscar: ");
      String codB = StdIn.readString();
      Departamento D = ld.buscarDepto(codB);
      for(int i=0 ; i < D.getLe().getCantemple();i++){
          System.out.println("los datos de sus empleados son: ");
          System.out.println("nombre: " + D.getLe().getEmpleado(i).getNombre());
          System.out.println("rut: " + D.getLe().getEmpleado(i).getRut());
          System.out.println("codigo de departamento: " + D.getLe().getEmpleado(i).getCodigodepa());
          System.out.println("sueldo: " + D.getLe().getEmpleado(i).getSueldo());
      }
          
          
          
      }
  
  public static void requerimiento3(ListaDepartamentos ld,ListaEmpleados le){
      System.out.print("ingrese rut del empleado el cual desea buscar: ");
      String rutB = StdIn.readString();
      Empleado E = le.buscarEmpleado(rutB);
      for(int i=0 ; i < 1;i++){
          System.out.println("los datos del empleados son: ");
          System.out.println("nombre: " + E.getNombre());
          System.out.println("codigo de departamento al cual pertenece: " + E.getCodigodepa());
         
      }
          
          
          
      }
  
    public static void main(String[] args) {
     ListaDepartamentos ld = new ListaDepartamentos(1000);
     ListaEmpleados le = new ListaEmpleados(1000);
     leerDatos(ld,le);
     requerimiento1(ld,le);
     requerimiento2(ld,le);
     requerimiento3(ld,le);
    
}
}