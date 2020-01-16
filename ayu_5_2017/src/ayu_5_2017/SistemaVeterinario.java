/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayu_5_2017;

/**
 *
 * @author Eduardo
 */

public interface SistemaVeterinario {
    
    public void ingresarDueño(Dueño D);
    public void ingresarMascota(Mascota M);
    public void desplegarTotalMascotas();
    public void desplegarMascotasDeUnDueño(String nom);
    public void desplegarDueñosConConejoMayor();
    public int promedioPorPersona();
}
