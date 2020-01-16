
package problemaversion2nexos;

public class Carrera {
    private int codigo;
    private String nombre;
    private ListaAsignaturas la;

    public Carrera(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.la = new ListaAsignaturas();
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

    public ListaAsignaturas getLa() {
        return la;
    }

    public void setLa(ListaAsignaturas la) {
        this.la = la;
    }
    
    
}
