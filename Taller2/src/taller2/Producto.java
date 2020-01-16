
package taller2;


public class Producto {
    private String codproducto;
    private String nombrep;
    private int precio;
    private String plataforma;
    
    

    public Producto(String codproducto, String nombrep, int precio, String plataforma) {
        this.codproducto = codproducto;
        this.nombrep = nombrep;
        this.precio = precio;
        this.plataforma = plataforma;
        
    }

    public String getCodproducto() {
        return codproducto;
    }

   

    public void setCodproducto(String codproducto) {
        this.codproducto = codproducto;
    }

    

    public String getNombrep() {
        return nombrep;
    }

    public void setNombrep(String nombrep) {
        this.nombrep = nombrep;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
    
}
