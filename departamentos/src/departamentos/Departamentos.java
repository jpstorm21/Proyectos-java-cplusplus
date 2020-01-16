
package departamentos;
import java.util.Scanner;
public class Departamentos {

    public static void leerDepartamentos(ListaDepartamentos ld,Scanner sc){
        System.out.print("ingrese codigo(FIN 999) : ");
        String cod = sc.next();
        while(!cod.equals("999")){
            System.out.print("ingrese nombre : ");
            String nombre = sc.next();
            System.out.print("ingrese presupuesto : ");
            int presupuesto = sc.nextInt();
            Departamento D = new Departamento(cod,nombre,presupuesto);
            boolean ingreso = ld.ingresarDepartamento(D);
            if(ingreso){
                System.out.println("departamento ingresado correctamente");
            }else{
                System.out.println("lista llena");
            }
            System.out.print("ingrese codigo(FIN 999): ");
            cod = sc.next();
        }
        
    }
    public static void leerEmpleados(ListaEmpleados le , Scanner sc,ListaDepartamentos ld){
        System.out.print("ingrese cantidad de empleados : ");
        int cant  = sc.nextInt();
        for(int i = 0; i<cant;i++){
            System.out.print("ingrese nombre : ");
            String nombre = sc.next();
            System.out.print("ingrese rut: ");
            String rut = sc.next();
            System.out.print("ingrese codigo del departamento al cual pertenece: ");
            String cod = sc.next();
            Departamento D = ld.BuscarDepartamento(cod);
            if(D != null){
                System.out.print("ingrese sueldo: ");
                int sueldo =sc.nextInt();
                Empleado E = new Empleado(nombre,rut,sueldo);
                boolean ingreso = le.ingresarEmpleado(E);
                if(ingreso){
                    System.out.println("empleado ingresado correctamente");
                    D.getLe().ingresarEmpleado(E);
                    E.setDepartamento(D);
                }else{
                    System.out.println("lista llena");
                }
            }
            
        }
    }
    public static void informacionDeptos(ListaDepartamentos ld ){
        for(int i = 0; i<ld.getCantDeptos();i++){
            Departamento D = ld.getDepartamento(i);
            System.out.println("Datos del departamento " + (i+1) + " :");
            System.out.println("nombre: "  + D.getNombre());
            System.out.println("codigo: "  + D.getCodigo());
            System.out.println("presupuesto : " + D.getPresupuesto());
        }
        System.out.println("la cantidad total de departamentos es: " + ld.getCantDeptos());
    }
    public static void PorDepartamento(ListaDepartamentos ld,Scanner sc){
        System.out.print("ingrese codigo del departamento : ");
        String codb = sc.next();
        Departamento D = ld.BuscarDepartamento(codb);
        for(int i =0; i<D.getLe().getCantEmple();i++){
            Empleado E = D.getLe().getEmpleado(i);
            System.out.println("Datos del empleado " + (i+1) + ":" );
            System.out.println("nombre  : " + E.getNombre());
            System.out.println("rut: " + E.getRut());
            System.out.println("sueldo: " + E.getSueldo());
            System.out.println("nombre del departamento al cual pertenece : " + E.getDepartamento().getNombre());
        }
    }
    public static void porEmpleado(ListaEmpleados le,Scanner sc){
        System.out.print("ingrese rut del empleado a buscar : ");
        String rutb =sc.next();
        Empleado E = le.buscarEmpleado(rutb);
        System.out.println("nombre : " + E.getNombre());
        System.out.println("nombre del departamento al cual pertenece: " + E.getDepartamento().getNombre());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaDepartamentos ld = new ListaDepartamentos(1000);
        ListaEmpleados le = new ListaEmpleados(1000);
        Departamentos.leerDepartamentos(ld, sc);
        Departamentos.leerEmpleados(le, sc, ld);
        Departamentos.informacionDeptos(ld);
        Departamentos.PorDepartamento(ld, sc);
        Departamentos.porEmpleado(le, sc);
    }
    
}
