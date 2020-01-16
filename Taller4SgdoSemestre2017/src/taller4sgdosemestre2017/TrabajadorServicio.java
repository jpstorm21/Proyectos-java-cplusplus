
package taller4sgdosemestre2017;

public class TrabajadorServicio extends Trabajador {
    private ListaCertificaciones lc;
    private ListaServicios ls;
    private ListaHistoricoCertificaciones lhc;
    private ListaSolicitudMaterial lsm;

    public TrabajadorServicio(String cargo, String rut, String nombre, String apellido, int edad, int telefono, String mail) {
        super(cargo, rut, nombre, apellido, edad, telefono, mail);
        this.lc = new ListaCertificaciones();
        this.ls = new ListaServicios();
        this.lhc = new ListaHistoricoCertificaciones();
        this.lsm = new ListaSolicitudMaterial();
    }

    public ListaCertificaciones getLc() {
        return lc;
    }

    public void setLc(ListaCertificaciones lc) {
        this.lc = lc;
    }

    public ListaServicios getLs() {
        return ls;
    }

    public void setLs(ListaServicios ls) {
        this.ls = ls;
    }

    public ListaHistoricoCertificaciones getLhc() {
        return lhc;
    }

    public void setLhc(ListaHistoricoCertificaciones lhc) {
        this.lhc = lhc;
    }

    public ListaSolicitudMaterial getLsm() {
        return lsm;
    }

    public void setLsm(ListaSolicitudMaterial lsm) {
        this.lsm = lsm;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    
}
