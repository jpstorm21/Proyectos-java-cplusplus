/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talleer3;

/**
 *
 * @author Victor Huerta
 */
public abstract class Pagina extends PaginaGrupo {
    protected String categoria;
    protected String clasificacion;

    public Pagina(String categoria, String clasificacion, int codigo, String nombre, String fechaCreacion) {
        super(codigo, nombre, fechaCreacion);
        this.categoria = categoria;
        this.clasificacion = clasificacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
    
    
}
