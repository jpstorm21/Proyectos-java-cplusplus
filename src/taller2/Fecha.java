
package taller2;


public class Fecha {
    private int dia;
    private int mes;
    private int año;
    private int hora;
    private int min;
    private int seg;

    public Fecha(int dia, int mes, int año, int hora, int min, int seg) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        this.hora = hora;
        this.min = min;
        this.seg = seg;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSeg() {
        return seg;
    }

    public void setSeg(int seg) {
        this.seg = seg;
    }
    
}
