
package departamentos;

public class Departamento {
    private String codigo;
    private String nombre;
    private int presupuesto;
    private ListaEmpleados le;
    public Departamento(String codigo,String nombre,int presuspuesto){
        this.codigo=codigo;
        this.nombre=nombre;
        this.presupuesto = presupuesto;
        le = new ListaEmpleados(1000);
    }
    public String getCodigo(){
        return codigo;
    }
    public void setCodigo(String codigo){
        this.codigo=codigo;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public ListaEmpleados getLe() {
        return le;
    }

    public void setLe(ListaEmpleados le) {
        this.le = le;
    }
    
    
}
