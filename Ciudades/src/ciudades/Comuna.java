/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciudades;


public class Comuna {
    private String nombre;
    private String codigo;
    private ListaPropiedades lp;
    
    public Comuna(String nombre, String codigo){
        this.nombre = nombre;
        this.codigo = codigo;
        lp = new ListaPropiedades(1000);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ListaPropiedades getLp() {
        return lp;
    }

    public void setLd(ListaPropiedades lp) {
        this.lp = lp;
    }
    
    
    
}
