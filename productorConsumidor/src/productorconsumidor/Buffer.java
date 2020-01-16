/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidor;

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
        hayEspacio.acquire();
        mutex.acquire();
        buffer[posProductor] = dato;
        System.out.println("productor produce : " + dato);
        posProductor =(posProductor+1)%buffer.length;
        mutex.release();
        hayDatos.release();
    }
    
    public int quitarDato() throws InterruptedException{
        hayDatos.acquire();
        mutex.acquire();
        int pos = posConsumidor;
        posConsumidor =(1+posConsumidor)%buffer.length;
        System.out.println("consumidor consume: " + buffer[pos]);
        mutex.release();
        hayEspacio.release();
        return buffer[pos];
    }
    

}
