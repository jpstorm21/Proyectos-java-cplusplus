/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidor;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Pablo Martinez
 */
public class Consumidor extends Thread {
    private Buffer buffer;
    private int pos;

    public Consumidor (Buffer buffer, int pos) {
        this.buffer = buffer;
        this.pos = pos;
    }
     @Override
    public void run(){
        for(int i = 0; i< pos;i++){
           int dato;
            try {               
                dato = buffer.quitarDato();
                System.out.println(i+"consumidor consume: " + dato);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
       }
    }
    public static void main(String[] args) {
        Buffer b = new Buffer(5);
        Productor p = new Productor(b,100);
        Consumidor c = new Consumidor(b,100);
        p.start();
        c.start();
        
    }
}
