
package problemaversion2nexos;

public class Asignatura {
    private String codigo;
    private String nombre;
    private int creditos;
    private ListaCarreras lc;
    private ListaParalelos lp;

    public Asignatura(String codigo, String nombre, int creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        lc = new ListaCarreras ();
        this.lp = new ListaParalelos();
        
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public ListaCarreras getLc() {
        return lc;
    }

    public ListaParalelos getLp() {
        return lp;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public void setLc(ListaCarreras lc) {
        this.lc = lc;
    }

    public void setLp(ListaParalelos lp) {
        this.lp = lp;
    }
    
    
}
