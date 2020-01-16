package taller2sgosmestre;

public class Prestamo {

    private String codigo;
    private Cliente cliente;
    private Libro libro;
    private Fecha fechaPrestamo;
    private Fecha fechaDevolucion;
    private Fecha fechaDevuelto;

    public Prestamo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Fecha getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Fecha fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Fecha getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Fecha fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Fecha getFechaDevuelto() {
        return fechaDevuelto;
    }

    public void setFechaDevuelto(Fecha fechaDevuelto) {
        this.fechaDevuelto = fechaDevuelto;
    }

    public int Deuda() {
        int deuda = 0;
        int diasDevolucionReal = fechaDevuelto.getAño() * 365 + fechaDevuelto.getDia() + fechaDevuelto.getMes() * 31;
        int diasDevolucion = fechaDevolucion.getAño() * 365 + fechaDevolucion.getDia() + fechaDevolucion.getMes() * 31;
        if (diasDevolucionReal != 0) {
            int dias = diasDevolucionReal - diasDevolucion;
            int factorDeuda = 0;
            if (dias >= 1 && dias <= 7) {
                factorDeuda = 100;
            } else if (dias >= 8 && dias <= 14) {
                factorDeuda = 300;
            } else {
                factorDeuda = 700;
            }
            deuda = dias * factorDeuda;
            return deuda;
        } else {
            return deuda;
        }
    }
}
