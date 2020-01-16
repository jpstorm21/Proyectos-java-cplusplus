
package taller4;

public class Carpeta extends Contenedor {
    private Carpeta padre;
    private ListaContenedores lc;

    public Carpeta(int codigo, String nombre) {
        super(codigo, nombre);
        padre = null;
        lc = new ListaContenedores();
    }

    public Carpeta getPadre() {
        return padre;
    }

    public void setPadre(Carpeta padre) {
        this.padre = padre;
    }

    public ListaContenedores getLc() {
        return lc;
    }

    public void setLc(ListaContenedores lc) {
        this.lc = lc;
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
    

   
    
    
}
