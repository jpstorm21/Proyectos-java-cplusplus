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
public abstract class PaginaGrupo {
    protected int codigo;
    protected String nombre;
    protected String fechaCreacion;
    protected ListaUsuarios lu;
    protected Usuario refUsuario;

    public PaginaGrupo(int codigo, String nombre, String fechaCreacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        lu = new ListaUsuarios(1000);
        
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

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public ListaUsuarios getLu() {
        return lu;
    }

    public void setLu(ListaUsuarios lu) {
        this.lu = lu;
    }

    public Usuario getRefUsuario() {
        return refUsuario;
    }

    public void setRefUsuario(Usuario refUsuario) {
        this.refUsuario = refUsuario;
    }
    
    
    
    
    
}
