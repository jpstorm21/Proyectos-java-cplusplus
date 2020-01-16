/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller5_parte2sgdo2017;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Usuario
 */
public class InterfazGrafica extends JPanel {
    private Backtraking backtraking;
    private int [][] matriz;
    private int tamaño;
    private int x;
    private int y;
    private int celda;
    private Timer tiempo;
    //Lista de estados de la matriz
    private NodoMatriz nodoMatriz;
    //Estados del juego
    private ESTADO estado; //estado actual
    private static enum ESTADO{NADA, ANALIZANDO, SOLUCION, NOSOLUCION};

    public InterfazGrafica(int tamaño) {
        this.tamaño = tamaño;
        //definido por el programador
        this.celda = 64;
        this.x = 80;
        this.y = 64;
        this.estado = ESTADO.NADA;
        this.backtraking = new Backtraking(this.tamaño);
         //Genera el estado inicial
       this.backtraking.generar();
        this.nodoMatriz = this.backtraking.getListaMatrices().getFirst();
        this.matriz = this.nodoMatriz.getMatriz();
        //Inicia Botón reiniciar e iniciar y tiempo
        this.iniciarTimer();
        this.iniciarBotones();    
    }
    private void iniciarBotones(){
        this.setLayout(new FlowLayout());
        JButton btnReiniciar = new JButton("Reiniciar");
        btnReiniciar.addActionListener((ActionEvent)->{
            this.estado = ESTADO.NADA;
            this.backtraking.reiniciar();
            this.backtraking.generar();
            this.nodoMatriz = this.backtraking.getListaMatrices().getFirst();
            this.matriz = this.nodoMatriz.getMatriz();
            this.tiempo.stop();
        });
        JButton btnIniciar = new JButton("Iniciar");
        btnIniciar.addActionListener((ActionEvent)->{
            if (this.estado == ESTADO.NADA){
                this.estado = ESTADO.ANALIZANDO;
                this.backtraking.resolver();
                //Comienza el timer
                this.tiempo.start();
            }
        });
        this.add(btnReiniciar);
        this.add(btnIniciar);
    }
    
    /**
     * Inicia el Timer (para que empiece a reproducirse la secuencia de estados
     * de matriz)
     */
    private void iniciarTimer(){
        int vecesPorSeg = 500; //en ms
        this.tiempo = new Timer(vecesPorSeg, (ActionEvent) ->{
            if (this.nodoMatriz != null){
                this.matriz = this.nodoMatriz.getMatriz();
                this.nodoMatriz = this.nodoMatriz.getNext();
            }else{
                //Hay solución
                if (this.backtraking.exito()){
                    this.estado = ESTADO.SOLUCION;
                }else{ //No hay solución
                    this.estado = ESTADO.NOSOLUCION;
                }
            }
            this.repaint();
        });
    }
      @Override
    /**
     * Se encarga de dibujar todo
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //dibujar(g);
        dibujarTablero(g);  
        Font font =  new Font("Verdana", Font.BOLD, 12);
        g.setFont(font);
        dibujarIntegrantes(g); //Dibuja los integrantes del taller y el paralelo
        dibujarEstado(g, font); //Dibuja estado del juego, analizando, fin o no solución
    }
    
    /**
     * Dibuja el tablero de size x size
     * @param g Gráficos
     */
    public void dibujarTablero(Graphics g){
        int totalSize = celda * this.tamaño;
        //Dibuja el tablero (blanco)
        g.setColor(Color.WHITE);
        g.fillRect(x, y, totalSize, totalSize);
        g.setColor(Color.GREEN);
        for(int i = 0; i < this.tamaño; i++){
            for(int j = 0; j < this.tamaño; j++){
                int id = this.matriz[i][j];
                if (id == Backtraking.ID.LITIO.ordinal()){
                    g.fillRect(x + i*celda, y , celda, totalSize);
                    g.fillRect(x, y + j*celda, totalSize, celda);
                }
            }
        }
        //Líneas de borde
        g.setColor(Color.GRAY);
        for(int i = 0; i <= this.tamaño; i++){
            for(int j = 0; j <= this.tamaño; j++){
                g.drawLine(x + i*celda, y, x + i*celda, y + totalSize);
                g.drawLine(x, y + j*celda, x + totalSize, y + j*celda);
            }
        }
        //Vuelve al color original
        g.setColor(Color.BLACK);
    }
    
    /**
     * Dibuja los objetos en el tablero (Zombies, Survivor y bombas)
     * @param g Gráficos
     */
    
    
    /**
     * Dibuja los integrantes del grupo y el paralelo
     * (Método de ejemplo)
     * @param g Gráficos
     */
    public void dibujarIntegrantes(Graphics g){
        String strAlumnos = "Alumno(s): Juan Martinez";
        String strParalelo = "Programacion 1";
        g.drawString(strAlumnos, 16, this.getHeight() - 16);
        g.drawString(strParalelo, this.getWidth() - 144, this.getHeight() - 16);
    }
    
    /**
     * Dibuja el estado del juego
     * (Si está analizando, si encontró solución, o si no hay solución)
     * @param g Gráficos
     * @param font Fuente
     */
    public void dibujarEstado(Graphics g, Font font){
        String strEstado = "";
        if (this.estado != null){
            switch (this.estado) {
                case ANALIZANDO:
                    strEstado = "Analizando...";
                    break;
                case SOLUCION:
                    strEstado = "Ataque aéreo listo! Hora de aplastar zombies!";
                    break;
                case NOSOLUCION:
                    strEstado = "Lamentablemente, no podremos salvarlos...";
                    break;
                default:
                    break;
            }
        }
        FontMetrics metrics = g.getFontMetrics(font);
        int i = (this.getWidth() - metrics.stringWidth(strEstado)) / 2;
        int j = (this.getHeight() 
                - metrics.getHeight() 
                + this.celda * this.tamaño + 32) / 2 
                + metrics.getAscent();
                
        g.drawString(strEstado, i, j);
    }
    
}
