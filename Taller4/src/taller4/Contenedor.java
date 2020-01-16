
package taller4;


public  abstract class Contenedor {
    protected int codigo;
    protected String nombre;
    protected static int codigoUniversal;

    protected Contenedor(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigoUniversal() {
        return codigoUniversal;
    }

    public void setCodigoUniversal(int codigoUniversal) {
        Contenedor.codigoUniversal = codigoUniversal;
    }
    
    

  
    
}
