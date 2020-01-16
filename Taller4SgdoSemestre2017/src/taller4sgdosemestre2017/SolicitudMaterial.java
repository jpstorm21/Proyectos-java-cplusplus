
package taller4sgdosemestre2017;

public class SolicitudMaterial {
    private int codigo;
    private String fecha;
    private String hora;
    private Trabajador jefeFinanza;
    private Trabajador jefeAdmin;
    private ListaMateriales lm;
    private Trabajador trabajadorServicio;
    private int cant;
    public SolicitudMaterial(int codigo, String fecha, String hora) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.hora = hora;
        this.lm = new ListaMateriales();
        this.cant = 0;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Trabajador getJefeFinanza() {
        return jefeFinanza;
    }

    public void setJefeFinanza(Trabajador jefeFinanza) {
        this.jefeFinanza = jefeFinanza;
    }

    public Trabajador getJefeAdmin() {
        return jefeAdmin;
    }

    public void setJefeAdmin(Trabajador jefeAdmin) {
        this.jefeAdmin = jefeAdmin;
    }

    public ListaMateriales getLm() {
        return lm;
    }

    public void setLm(ListaMateriales lm) {
        this.lm = lm;
    }

    public Trabajador getTrabajadorServicio() {
        return trabajadorServicio;
    }

    public void setTrabajadorServicio(Trabajador trabajadorServicio) {
        this.trabajadorServicio = trabajadorServicio;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }
    
    public void cantTotalPedida(int cantidad){
        /*NodoMaterial actual = lm.getFirst();
        int cantTotal = 0;
        while(actual != null){
            Material m =  actual.getMaterial();
            cantTotal = cantTotal + m.getCantidad();
            actual = actual.getNext();
        }*/
        this.cant = cant + cantidad;
        
    }

}
