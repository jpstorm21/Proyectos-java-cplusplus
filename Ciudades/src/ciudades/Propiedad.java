/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciudades;


public class Propiedad {
    private String nombre;
    private int precio;
    private Comuna comuna;
    private Dueño Dueño;
    
    public Propiedad(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre; 
    }
    
    public int getPrecio(){
        return precio;
    }
    
    public void setPrecio(int precio){
        this.precio = precio;
    }
    
    public Comuna getComuna(){
        return comuna;
    }
    
    public void setComuna(Comuna comuna){
        this.comuna = comuna;
    }
    
    public Dueño getPersona(){
        return Dueño;
    }
    
    public void setPersona(Dueño dueño){
        this.Dueño = dueño;
    }
            
    
}
