package problema;

public class Carrera {
    private int codigo;
    private String nombre;
    private ListaAsignaturas listaAsignaturas;
    
    public Carrera(int codigo, String nombre){
        this.codigo = codigo;
        this.nombre = nombre;
        listaAsignaturas = new ListaAsignaturas();
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public ListaAsignaturas getListaAsignaturas() {
        return listaAsignaturas;
    }
    public void setListaAsignaturas(ListaAsignaturas listaAsignaturas) {
        this.listaAsignaturas = listaAsignaturas;
    }   
}
