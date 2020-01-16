/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juank.BuscaMinas.logica;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import juank.BuscaMinas.Ventanas.VentanaPrincipal;
import juank.BuscaMinas.utils.Cronometro;

/**
 *
 * @author Juan K
 */
public class Juego implements Runnable{
    private volatile boolean corriendo = false;
    private static Thread thread;
    private VentanaPrincipal ventana;
    private int [][] grid = new int [11][11];
    private int minas = 15;
    private int banderas = 15;
    private int alto,ancho;
    private Board tablero;
    private Cronometro temp;      

    public Juego() {
        this.ventana = new VentanaPrincipal(this,banderas);
        this.ventana.setTitle("Busca Minas. Juan Carlos Lamas Alfaro.");
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setResizable(false);       
        this.ventana.setVisible(true);
        this.alto = this.ventana.getHeight();
        this.ancho = this.ventana.getWidth();        
        this.temp = new Cronometro (); 
    }
    
    public void iniciar(){
        corriendo = true;
        thread = new Thread (this, "Busca minas");
        thread.start();
    }
    
    public synchronized void detener(){        
        System.out.println("> Thread 'Busca minas' detenido con exito.");
        corriendo = false;
        thread.stop();
        System.gc();
        tablero.paint(tablero.getGraphics());
        tablero.initBoard();
        tablero.paint(tablero.getGraphics());
        ventana.getjCaraLabel().setIcon(new ImageIcon((new ImageIcon("src/juank/BuscaMinas/img/happy.png")).getImage().getScaledInstance(ventana.getjCaraLabel().getWidth(), ventana.getjCaraLabel().getHeight(), Image.SCALE_DEFAULT)));
        try {
            thread.join();
        } catch (InterruptedException ex) {
            System.out.println("> Error al detener el Thread 'Busca minas'.");
        }
    }
    
    public synchronized void reiniciar(){   
        Cronometro.reiniciar();
        temp.resume();
        tablero.enable();
        this.detener();
       // this.iniciar();
    }
            
    @Override
    public void run() {
        System.out.println("> El Thread 'Busca minas' se está ejecutando con exito.");
        tablero = new Board(grid,minas,this,banderas);
        
        temp.start();
        
        ventana.jBoard.add("Center", tablero);
        tablero.setSize(415, 400);
        tablero.paint(tablero.getGraphics());     
        this.ventana.setSize(1, 1);
        this.ventana.setSize(this.ancho-55, this.alto);
    }
    
    public void win(){
        System.out.println("Ganaste...");
        this.detener();
    }
    
    public void lose(){
        tablero.aparecerMinas();
        ImageIcon imagenCara = new ImageIcon("src/juank/BuscaMinas/img/sad.png");
        Icon iconoCara = new ImageIcon(imagenCara.getImage().getScaledInstance(ventana.getjCaraLabel().getWidth(), ventana.getjCaraLabel().getHeight(), Image.SCALE_DEFAULT));
        ventana.getjCaraLabel().setIcon(iconoCara);
        
        temp.suspend();
        tablero.disable();
    }

    public boolean isCorriendo() {
        return corriendo;
    }

    public void setCorriendo(boolean corriendo) {
        this.corriendo = corriendo;
    }
    public static Thread getThread() {
        return thread;
    }
    public static void setThread(Thread thread) {
        Juego.thread = thread;
    }
    public VentanaPrincipal getVentana() {
        return ventana;
    }
    public void setVentana(VentanaPrincipal ventana) {
        this.ventana = ventana;
    }
    public int[][] getGrid() {
        return grid;
    }
    public void setGrid(int[][] grid) {
        this.grid = grid;
    }
    public int getMinas() {
        return minas;
    }
    public void setMinas(int minas) {
        this.minas = minas;
    }
    public int getBanderas() {
        return banderas;
    }
    public void setBanderas(int banderas) {
        this.banderas = banderas;
    }
    public int getAlto() {
        return alto;
    }
    public void setAlto(int alto) {
        this.alto = alto;
    }
    public int getAncho() {
        return ancho;
    }
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    public Board getTablero() {
        return tablero;
    }
    public void setTablero(Board tablero) {
        this.tablero = tablero;
    }
    public Cronometro getTemp() {
        return temp;
    }
    public void setTemp(Cronometro temp) {
        this.temp = temp;
    }    
}
