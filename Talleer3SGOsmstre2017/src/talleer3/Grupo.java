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
public class Grupo extends PaginaGrupo {
    private ListaUsuarios lu;

    public Grupo(int codigo, String nombre, String fechaCreacion) {
        super(codigo, nombre, fechaCreacion);
        lu = new ListaUsuarios(1000);
    }

    public ListaUsuarios getLu() {
        return lu;
    }

    public void setLu(ListaUsuarios lu) {
        this.lu = lu;
    }


    
    
}
