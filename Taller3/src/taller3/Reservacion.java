
package taller3;


public class Reservacion {
    private int codigo;
    private Fecha fechainicio;
    private Fecha fechatermino;
    private Habitacion habitacion;
    private Cliente cliente;

    public Reservacion(int codigo) {
        this.codigo = codigo;
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Fecha getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Fecha F) {
        fechainicio = F;
    }

    public Fecha getFechatermino() {
        return fechatermino;
    }

    public void setFechatermino(Fecha F) {
         fechatermino = F;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion H) {
        habitacion = H;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente C) {
        cliente = C;
    }
    
    
            
}
