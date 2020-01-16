/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallercuatro4;

/**
 *
 * @author Usuario
 */
public class Trabajador extends Persona {
    protected String  cargo;

    public Trabajador( String rut, String nombres, String apellidos, int edad, int telefono, String mail,String cargo) {
        super(rut, nombres, apellidos, edad, telefono, mail);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    
    
}
