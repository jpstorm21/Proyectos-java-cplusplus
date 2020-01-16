
package taller2sgosmestre;

public class Libro {
    private String identificador;
    private String titulo;
    private String autor;
    private int AñoPublicacion;
    private ListaPrestamos lp;

    public Libro(String identificador, String titulo, String autor, int AñoPublicacion) {
        this.identificador = identificador;
        this.titulo = titulo;
        this.autor = autor;
        this.AñoPublicacion = AñoPublicacion;
        lp = new ListaPrestamos(1000);
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAñoPublicacion() {
        return AñoPublicacion;
    }

    public void setAñoPublicacion(int AñoPublicacion) {
        this.AñoPublicacion = AñoPublicacion;
    }

    public ListaPrestamos getLp() {
        return lp;
    }

    public void setLp(ListaPrestamos lp) {
        this.lp = lp;
    }
    
    
}
