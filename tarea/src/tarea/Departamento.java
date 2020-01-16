
package tarea;


public class Departamento {
    private String codigo;
    private String nombredep;
    private int presupuesto;
    private ListaEmpleados le;

    public Departamento(String codigo, String nombredep, int presupuesto) {
        this.codigo = codigo;
        this.nombredep = nombredep;
        this.presupuesto = presupuesto;
        le = new ListaEmpleados(1000);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombredep() {
        return nombredep;
    }

    public void setNombredep(String nombredep) {
        this.nombredep = nombredep;
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
