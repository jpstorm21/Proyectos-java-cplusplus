/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayundantia;


public class Libro {
    private int publicacion;
    private String titulo;
    private int cantpaginas;
    private String editorial;
    private Poeta refpoeta;
    public Libro(int publicacion , String titulo, int cantpaginas, String editorial){
        this.publicacion = publicacion;
        this.titulo = titulo;
        this.cantpaginas = cantpaginas;
        this.editorial = editorial;
    }

    public int getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(int publicacion) {
        this.publicacion = publicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCantpaginas() {
        return cantpaginas;
    }

    public void setCantpaginas(int cantpaginas) {
        this.cantpaginas = cantpaginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Poeta getRefpoeta() {
        return refpoeta;
    }

    public void setRefpoeta(Poeta p) {
        refpoeta = p;
    }
    
}
