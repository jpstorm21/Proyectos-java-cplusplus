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
public interface Interface {
    public void ingresarUsuario(Usuario U);
    public Usuario buscarUsuario(String correoE);
    public void eliminarUsuario(Usuario U);
    public void ingresarPaginaGrupo(PaginaGrupo PG);
    public PaginaGrupo buscarPaginaGrupo(int codigo);
    public void eliminarPaginaGrupo(PaginaGrupo PG);
    public void menuInicio();
    public void menuSesion();
    public void registrarUsuario();
    public void iniciarSesion();
    public void RFA();
    public void RFB();
    public void RFC();
    public void RFD();
    public void RFE();
    public void RFF();
    public void RFG();
    public void setUsuario(Usuario U);

}
