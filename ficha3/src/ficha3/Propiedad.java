
package ficha3;


public class Propiedad {
    private String direccion;
    private int mt2;
    private Comuna refcomuna;
    private Dueño refdueño;
    
    private int rutd;
    private int contribuciones;
    

    public Propiedad(String direccion, int mt2,int rutd,int contribuciones) {
        this.direccion = direccion;
        this.mt2 = mt2;
        this.contribuciones= contribuciones;
        
        this.rutd=rutd;
        
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getMt2() {
        return mt2;
    }

    public int getContribuciones() {
        return contribuciones;
    }

    public void setContribuciones(int contribuciones) {
        this.contribuciones = contribuciones;
    }

    public void setMt2(int mt2) {
        this.mt2 = mt2;
    }

    public Comuna getRefcomuna() {
        return refcomuna;
    }

    public void setRefcomuna(Comuna C) {
        refcomuna = C;
    }

    public Dueño getRefdueño() {
        return refdueño;
    }

    public void setRefdueño(Dueño D) {
        refdueño = D;
    }

   

    public int getRutd() {
        return rutd;
    }

    public void setRutd(int rutd) {
        this.rutd = rutd;
    }

   
    
    
}
