package problema;

public abstract class Profesor {
    private String rut;
    private String nombre;
    private ListaParalelos listaParalelos;
    
    protected Profesor(String rut, String nombre){
        this.rut = rut;
        this.nombre = nombre;
        listaParalelos = new ListaParalelos();
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getRut(){
        return rut;
    }
    public void setRut(String rut){
        this.rut = rut;
    }
    public ListaParalelos getListaParalelos(){
        return listaParalelos;
    }
    public void setListaParalelos(ListaParalelos listasParalelos){
        this.listaParalelos = listaParalelos;
    }
    public abstract int calcularSueldo();
}
