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
public class Alumno extends Persona{
    private int AsignaturasInscritas;
    private int MensajesEnviados;

    public Alumno(int AsignaturasInscritas, int MensajesEnviados, String rut, String nombre, String apellido, String correo, String alias) {
        super(rut, nombre, apellido, correo, alias);
        this.AsignaturasInscritas = AsignaturasInscritas;
        this.MensajesEnviados = MensajesEnviados;
    }

    public int getAsignaturasInscritas() {
        return AsignaturasInscritas;
    }

    public void setAsignaturasInscritas(int AsignaturasInscritas) {
        this.AsignaturasInscritas = AsignaturasInscritas;
    }

    public int getMensajesEnviados() {
        return MensajesEnviados;
    }

    public void setMensajesEnviados(int MensajesEnviados) {
        this.MensajesEnviados = MensajesEnviados;
    }

    @Override
    public int CalcularNota() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
