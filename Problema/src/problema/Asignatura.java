package problema;

public class Asignatura {
    private String codigo;
    private String nombre;
    private int creditos;
    private ListaCarreras listaCarreras;
    private ListaParalelos listaParalelos;
    
    public Asignatura(String codigo, String nombre, int creditos){
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        listaCarreras = new ListaCarreras();
        listaParalelos = new ListaParalelos();
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCreditos() {
        return creditos;
    }
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    public ListaCarreras getListaCarreras(){
        return listaCarreras;
    }
    public void setListaCarreras(ListaCarreras listaCarreras){
        this.listaCarreras = listaCarreras;
    }
    public ListaParalelos getListaParalelos(){
        return listaParalelos;
    }
    public void setListaParalelos(ListaParalelos listaParalelos){
        this.listaParalelos = listaParalelos;
    }
}
