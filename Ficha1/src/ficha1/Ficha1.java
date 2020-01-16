package ficha1;
import ucn.*;

public class Ficha1 {
    
    public static void leerDatosDepartamentos(ListaDepartamento ld){
        StdOut.println("Ingrese código del departamento(fin de datos 999: ");
        String codigo = StdIn.readString();
        while(!codigo.equalsIgnoreCase("999")){
            StdOut.println("Ingrese nobre dle departamento: ");
            String nombre = StdIn.readString();
            StdOut.println("Ingrese presupuesto del departamento: ");
            int presupuesto = StdIn.readInt();
            Departamento D = new Departamento(codigo, nombre, presupuesto);
            ld.insertarDepartamento(D);     
            StdOut.println("Ingrese código del departamento(fin de datos 999: ");
            codigo = StdIn.readString();
        }
    }
    
    public static void leesDatosEmpleados(ListaEmpleados le, ListaDepartamento ld){
        StdOut.println("Ingrese cantidad de empleados: ");
        int cantEmpleados = StdIn.readInt();
        for(int i = 0; i < cantEmpleados; i++){
            StdOut.println("Ingrese nombre empleado: ");
            String nomEmpleado = StdIn.readString();
            StdOut.println("Ingrese rut del empleado: ");
            String rut = StdIn.readString();
            StdOut.println("Ingrese codigo del departamento al que pertenece el empleado: ");
            String codDepartamento = StdIn.readString(); 
            StdOut.println("Ingrese sueldo del empleado: ");
            int sueldo = StdIn.readInt();
            Empleado E = new Empleado(nomEmpleado, rut, sueldo);
            le.insertarEmpleado(E);
            if(ld.encontrarDepartamento(codDepartamento) != null){
                Departamento D = ld.encontrarDepartamento(codDepartamento);
                E.setDepartamento(D);
                D.getListaEmpleados().insertarEmpleado(E);
            }else{
                StdOut.println("Departamentono no existe");
            }                     
        }    
    }
    
    public static void desplegarInformacionDepartamentos(ListaEmpleados le, ListaDepartamento ld){
        NodoDepartamento actualDepartamento = ld.getFirstDepartamento();
        for(int i = 0; i < ld.cantDepartamentos(); i++){
            Departamento D = actualDepartamento.getDepartamento();
            StdOut.println("Nombre Departamento : " + D.getNombre() + "  Codigo Departamento: " + D.getCodigo() + "  Presupuesto Departamento: " + D.getPresupuesto());
            NodoEmpleado actualEmpleado = le.getFirstEmpleado();
            for(int j = 0; j < D.getListaEmpleados().cantDepartamentos(); j++){
                Empleado E = actualEmpleado.getEmpleado();
                StdOut.println("Nombre Empleado: " + E.getNombre() + "  Rut Empleado: " + E.getRut());
                actualEmpleado = actualEmpleado.getSiguienteEmpleado();
            }
            actualDepartamento = actualDepartamento.getSiguienteDepartamento(); 
        }
    }
    
    public static void desplegarInformacionEmpleado(ListaEmpleados le){
        StdOut.println("Ingresar rut del empleado: ");
        String rut = StdIn.readString();
        Empleado E = le.encontrarEmpleado(rut);
        if(E != null){
            StdOut.println("Nombre empleado: " + E.getNombre() + "  Sueldo: " + E.getSueldo());
            StdOut.println("Departamento en el cual trabaja: " + E.getDepartamento().getNombre());
        }else{
            StdOut.println("El empleado no existe.");
        }
    }
   
    public static void desplegarCantidadDepartamentos(ListaDepartamento ld){
        StdOut.println("Cantidad de departamentos: " + ld.cantDepartamentos());
    }

    public static void main(String[] args) {
        ListaDepartamento ld = new ListaDepartamento();
        ListaEmpleados le = new ListaEmpleados();
        Ficha1.leerDatosDepartamentos(ld);
        Ficha1.leesDatosEmpleados(le, ld);
        Ficha1.desplegarInformacionDepartamentos(le, ld);
        Ficha1.desplegarInformacionEmpleado(le);
        Ficha1.desplegarCantidadDepartamentos(ld);
    }
    
}
