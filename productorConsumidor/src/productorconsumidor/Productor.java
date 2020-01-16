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
public class Productor extends Thread {
    private Random numero =new Random();
    private Buffer buffer;
    private int pos;

    public Productor(Buffer buffer, int pos) {
        this.buffer = buffer;
        this.pos = pos;
    }
    
    @Override
    public void run(){
        for(int i = 0; i< pos;i++){
           int dato = numero.nextInt(100);
            try {
                System.out.println(i+": productor produce: " + dato);
                buffer.ingresarDato(dato);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
       }
    }
    
}
