/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lunes.pkg11.pkg09.pkg2017;

/**
 *
 * @author Usuario
 */
public class Empresa {
    private String codigo;
    private String nombre;
    private ListaTrabajadores lt;

    public Empresa(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        lt = new ListaTrabajadores(1000);
        
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

    public ListaTrabajadores getLt() {
        return lt;
    }

    public void setLt(ListaTrabajadores lt) {
        this.lt = lt;
    }

    
    
    
    
}
