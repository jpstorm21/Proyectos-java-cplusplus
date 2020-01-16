package ficha1;

public class Departamento {
    private String codigo;
    private String nombre;
    private int presupuesto;
    private ListaEmpleados listaEmpleados;
    
    public Departamento(String codigo, String nombre, int presupuesto){
        this.codigo = codigo;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        listaEmpleados = new ListaEmpleados();
    }
    
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getCodigo(){
        return codigo;
    }
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    public int getPresupuesto(){
        return presupuesto;
    }
    public void setPresupuesto(int presupuesto){
        this.presupuesto = presupuesto;
    }
    public ListaEmpleados getListaEmpleados(){
        return listaEmpleados;
    }
    public void setListaEmpleados(ListaEmpleados listaEmpleados){
        this.listaEmpleados = listaEmpleados;
    }
}
