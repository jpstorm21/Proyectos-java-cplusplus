/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemainventario;
import Ventanas.*;
import Clases.ConexionDB;
/**
 *
 * @author Juan Pablo Martinez
 */
public class SistemaImplements implements Sistema {
    
    private Inicio inicio;
    private ConexionDB conexion;
    
    public SistemaImplements() {
        conexion = new ConexionDB();
        inicio = new Inicio(conexion);   
    }

    @Override
    public void IniciarSistema(boolean estado) {      
       inicio.setVisible(true);
    }
    
    
}
