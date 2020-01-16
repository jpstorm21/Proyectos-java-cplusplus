package taller5_2;

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
 * Panel del juego (Donde se muestra todo)
 * @author JOSE
 */
public class PanelGame extends JPanel{

    //Backtracking en si
    private BackGame backGame;
    private int[][] matrizActual; //matrizActual a dibujar
    private int size;
    private int cellSize; //64 x 64 pixeles tamaño de cada celda
    //Punto inicial donde comienza el tablero (x, y)
    private int x;
    private int y;
    //Tiempo de juego
    private Timer tiempo;
    //Lista de estados de la matriz
    private NodoMatriz nodoMatriz;
    //Estados del juego
    private ESTADO estado; //estado actual
    private static enum ESTADO{NADA, ANALIZANDO, SOLUCION, NOSOLUCION};
    
    public PanelGame(int size){
        if (size <= 0){
            throw new IllegalArgumentException("Tamaño debe ser mayor que 0");
        }
        this.size = size;
        //definido por el programador
        this.cellSize = 64;
        this.x = 80;
        this.y = 64;
        this.estado = ESTADO.NADA;
        this.backGame = new BackGame(this.size);
         //Genera el estado inicial
        this.backGame.generar();
        this.nodoMatriz = this.backGame.getListaMatrices().getFirst();
        this.matrizActual = this.nodoMatriz.getMatriz();
        //Inicia Botón reiniciar e iniciar y tiempo
        this.iniciarTimer();
        this.iniciarBotones();     
    }
    /**
     * Inicia los botones reiniciar e iniciar
     */
    private void iniciarBotones(){
        this.setLayout(new FlowLayout());
        JButton btnReiniciar = new JButton("Reiniciar");
        //Cada vez que se presiona reiniciar, se genera otra vez el backgame
        btnReiniciar.addActionListener((ActionEvent)->{
            this.estado = ESTADO.NADA;
            this.backGame.reiniciar();
            this.backGame.generar();
            this.nodoMatriz = this.backGame.getListaMatrices().getFirst();
            this.matrizActual = this.nodoMatriz.getMatriz();
            this.tiempo.stop();
        });
        JButton btnIniciar = new JButton("Iniciar");
        btnIniciar.addActionListener((ActionEvent)->{
            if (this.estado == ESTADO.NADA){
                this.estado = ESTADO.ANALIZANDO;
                this.backGame.resolver();
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
                this.matrizActual = this.nodoMatriz.getMatriz();
                this.nodoMatriz = this.nodoMatriz.getNext();
            }else{
                //Hay solución
                if (this.backGame.exito()){
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
        dibujarObjetos(g); //Zombies, Survivors y bombas   
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
        int totalSize = cellSize * this.size;
        //Dibuja el tablero (blanco)
        g.setColor(Color.WHITE);
        g.fillRect(x, y, totalSize, totalSize);
        //Si hay una bomba, entonces dibuja cuadrados rojos de marca
        g.setColor(new Color(255, 0, 0, 128));
        for(int i = 0; i < this.size; i++){
            for(int j = 0; j < this.size; j++){
                int id = this.matrizActual[i][j];
                if (id == BackGame.ID.BOMBA.ordinal()){
                    g.fillRect(x + i*cellSize, y , cellSize, totalSize);
                    g.fillRect(x, y + j*cellSize, totalSize, cellSize);
                }
            }
        }
        //Líneas de borde
        g.setColor(Color.GRAY);
        for(int i = 0; i <= this.size; i++){
            for(int j = 0; j <= this.size; j++){
                g.drawLine(x + i*cellSize, y, x + i*cellSize, y + totalSize);
                g.drawLine(x, y + j*cellSize, x + totalSize, y + j*cellSize);
            }
        }
        //Vuelve al color original
        g.setColor(Color.BLACK);
    }
    
    /**
     * Dibuja los objetos en el tablero (Zombies, Survivor y bombas)
     * @param g Gráficos
     */
    public void dibujarObjetos(Graphics g){
        //Esto varía según cuántos gif hay en la carpeta resources 
        //No es necesaria variar, puede ser un zombie o un survivor para todo
        //Pero quise que no se repitiera
        int cantZombies = 5;  //zombie0.gif hasta zombie6.gif
        int cantSurvivors = 4; //survivor0.gif hasta survivor4.gif
        
        for(int i = 0; i < this.size; i++){
            for(int j = 0; j < this.size; j++){
                int id = this.matrizActual[i][j];
                ImageIcon spr = null; //Sprite (el gif)
                int gifIndex = 0; //Para elegir un gif de todos
                if (id == BackGame.ID.ZOMBIE.ordinal()){
                    gifIndex = (i + j) % cantZombies;
                    spr = new ImageIcon("recursos/zombie" + gifIndex + ".gif");
                }else if (id == BackGame.ID.SURVIVOR.ordinal()){
                    gifIndex = (i + j) % cantSurvivors;
                    spr = new ImageIcon("recursos/survivor" + gifIndex + ".gif");
                }else if (id == BackGame.ID.BOMBA.ordinal()){
                    spr = new ImageIcon("recursos/bomba1.gif");
                }
                if (spr != null){
                    //ancho y alto del spr
                    int w = spr.getIconWidth();
                    int h = spr.getIconHeight();
                    //Esto es simplemente para ubicar bien la bomba
                    if (id == BackGame.ID.BOMBA.ordinal()){
                        w = w*2;
                        h = h*2;
                    }
                    //Dibuja el gif
                    spr.paintIcon(this, g, 
                            x + i*cellSize + w/3, 
                            y + j*cellSize + h/3);
                }
            }
        }
    }
    
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
                + this.cellSize * this.size + 32) / 2 
                + metrics.getAscent();
                
        g.drawString(strEstado, i, j);
    }
}
