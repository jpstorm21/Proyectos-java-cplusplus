
package taller3;

public class Habitacion {
    private int numero;
    private int ValorPorDia;
    private String tipo;
    private ListaReservaciones  lr;

    public Habitacion(int numero, int ValorPorDia, String tipo) {
        this.numero = numero;
        this.ValorPorDia = ValorPorDia;
        this.tipo = tipo;
        lr = new ListaReservaciones(1000);
    }

    public ListaReservaciones getLr() {
        return lr;
    }

    public void setLr(ListaReservaciones lr) {
        this.lr = lr;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getValorPorDia() {
        return ValorPorDia;
    }

    public void setValorPorDia(int ValorPorDia) {
        this.ValorPorDia = ValorPorDia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
