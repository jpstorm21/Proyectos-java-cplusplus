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
public class IngSoftware1 {
    private static  Cliente llenarDatos(){
        Cliente cliente =  new Cliente();
        cliente.setId(1);
        cliente.setNombre("jp");
        cliente.setApellido("martinez");
        return cliente;
    }
    public static void main(String[] args) {
        Cliente modelo = llenarDatos();
        ClienteVista vista =  new ClienteVista();
        ClienteControlador control = new ClienteControlador(vista,modelo);
        control.actualizarVista();
        control.setNombre("sebon");
        control.actualizarVista();
    }
    
}
