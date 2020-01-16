/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diccionario;

/**
 *
 * @author Usuario
 */
public interface InterfaceDiccionario {
    public void insertarPalabra(String palabra,String Significado);
    public String buscarSignificado(String palabra);
    public String [] listadoPalabras();
    public String [] listaPalabrasP(String letra);
}
