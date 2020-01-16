/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productos_consumidor;

/**
 *
 * @author Juan Pablo Martinez
 */
import java.util.concurrent.*;

public class Buffer {

    private Semaphore mutex = new Semaphore(1, true);
    private Semaphore hayDatos = new Semaphore(0, true);
    private Semaphore hayEspacio;
    private int[] buffer;
    private int posConsumidor = 0;
    private int posProductor = 0;

    public Buffer(int max) {
        buffer = new int[max];
        hayEspacio = new Semaphore(buffer.length, true);
    }
    
    public void ingresarDato(int dato) throws InterruptedException{
        hayDatos.acquire();
        mutex.acquire();
        buffer[posConsumidor] = dato;
    }

}
