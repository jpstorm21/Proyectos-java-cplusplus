/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea;

import ucn.StdIn;

/**
 *
 * @author Usuario
 */
public class sistema implements SistemeEmpleados {
    private ListaDepartamentos ld;
    private ListaEmpleados le;

    public sistema() {
        ld = new ListaDepartamentos(1000);
        le = new ListaEmpleados(1000);
    }
    

    @Override
    public void requerimiento1() {
        for(int i = 0;i<ld.getCantdpto();i++){
          Departamento D = ld.getDepartamento(i);
          System.out.println("los datos son del departamento son: ");
          System.out.println("codigo: " + D.getCodigo());
          System.out.println("nombre: " + D.getNombredep());
          System.out.println("presupuesto: " + D.getPresupuesto());
          
      }
      System.out.println("la cantidad de departamentos es: " + ld.getCantdpto());
    }

    @Override
    public void requerimiento2() {
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

    @Override
    public void requerimiento3() {
        System.out.print("ingrese rut del empleado el cual desea buscar: ");
      String rutB = StdIn.readString();
      Empleado E = le.buscarEmpleado(rutB);
      for(int i=0 ; i < 1;i++){
          System.out.println("los datos del empleados son: ");
          System.out.println("nombre: " + E.getNombre());
          System.out.println("codigo de departamento al cual pertenece: " + E.getCodigodepa());
         
      }
    }
    
}
