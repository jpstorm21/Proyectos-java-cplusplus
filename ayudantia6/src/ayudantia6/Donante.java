package ayudantia6;


public class Donante {
    private String nomDonante;
    private int rut;
    private int montoDonado;
    private String tipoPersona;
    private Region refRegion;

    public Donante(String nomDonante, int rut, int montoDonado, String tipoPersona) {
        this.nomDonante = nomDonante;
        this.rut = rut;
        this.montoDonado = montoDonado;
        this.tipoPersona = tipoPersona;
        refRegion = null;
    }

    public String getNomDonante() {
        return nomDonante;
    }

    public void setNomDonante(String nomDonante) {
        this.nomDonante = nomDonante;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public int getMontoDonado() {
        return montoDonado;
    }

    public void setMontoDonado(int montoDonado) {
        this.montoDonado = montoDonado;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public Region getRefRegion() {
        return refRegion;
    }

    public void setRefRegion(Region refRegion) {
        this.refRegion = refRegion;
    }
    
    
    
    
}