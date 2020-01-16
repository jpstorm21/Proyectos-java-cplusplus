package ficha1;

public class NodoEmpleado {
   private Empleado empleado;
   private NodoEmpleado siguienteEmpleado;
   
   public NodoEmpleado(Empleado E){
       this.empleado = E;
       siguienteEmpleado = null;
   }
   public Empleado getEmpleado(){
       return empleado;
   }
   public NodoEmpleado getSiguienteEmpleado(){
       return siguienteEmpleado;
   }
   public void setSiguienteEmpleado(NodoEmpleado N){
       this.siguienteEmpleado = N;
   }
}
