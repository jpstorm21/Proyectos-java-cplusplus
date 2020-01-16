/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingsoftware1;

/**
 *
 * @author Juan Pablo Martinez
 */
public class ClienteControlador {
    private ClienteVista vista;
    private Cliente modelo;

    public ClienteControlador(ClienteVista vista,Cliente modelo) {
        this.vista = vista;
        this.modelo= modelo;
    }

    public ClienteVista getVista() {
        return vista;
    }

    public void setVista(ClienteVista vista) {
        this.vista = vista;
    }

    public Cliente getModelo() {
        return modelo;
    }

    public void setModelo(Cliente modelo) {
        this.modelo = modelo;
    }
    public int getId(){
        return modelo.getId();
    }
    public String getNombre(){
        return modelo.getNombre();
    }
    public String getApellido(){
        return modelo.getApellido();
    }
    public void setId(int id) {
         modelo.setId(id);
    }
    public void setNombre(String nombre){
        modelo.setNombre(nombre);
    }
    public void setApellido(String apellido){
        modelo.setApellido(apellido);
    }
    public void actualizarVista(){
        vista.imprimirDatos(modelo.getId(),modelo.getNombre(),modelo.getApellido());
    }    
}
