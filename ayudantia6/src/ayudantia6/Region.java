
package ayudantia6;

public class Region {
    private ListaDonantes ld;
    private String nomRegion;
    private static int montoPorRegion; // meta de cada region
    private int montoActual; // monto que se acumula a medida que donan

    public Region(String nomRegion) {
        this.nomRegion = nomRegion;
        
        ld = new ListaDonantes(1000);
    }

    public ListaDonantes getLd() {
        return ld;
    }

    public void setLd(ListaDonantes ld) {
        this.ld = ld;
    }

    public String getNomRegion() {
        return nomRegion;
    }

    public void setNomRegion(String nomRegion) {
        this.nomRegion = nomRegion;
    }

    public int getMontoPorRegion() {
        return montoPorRegion;
    }

    public  void setMontoPorRegion(int montoPorRegion) {
        Region.montoPorRegion = montoPorRegion;
    }

    public int getMontoActual() {
        return montoActual;
    }

    public void setMontoActual(int montoActual) {
        this.montoActual = montoActual;
    }
    
    
    
    
}
