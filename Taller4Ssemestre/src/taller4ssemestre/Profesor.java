/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4ssemestre;

/**
 *
 * @author Usuario
 */
public class Profesor extends Persona {
    private int MensajesEnviados;
    private int MensajesRecibidos;

    public Profesor(int MensajesEnviados, int MensajesRecibidos, String rut, String nombre, String apellido, String correo, String alias) {
        super(rut, nombre, apellido, correo, alias);
        this.MensajesEnviados = MensajesEnviados;
        this.MensajesRecibidos = MensajesRecibidos;
    }

    public int getMensajesEnviados() {
        return MensajesEnviados;
    }

    public void setMensajesEnviados(int MensajesEnviados) {
        this.MensajesEnviados = MensajesEnviados;
    }

    public int getMensajesRecibidos() {
        return MensajesRecibidos;
    }

    public void setMensajesRecibidos(int MensajesRecibidos) {
        this.MensajesRecibidos = MensajesRecibidos;
    }

    @Override
    public int CalcularNota() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
