package taller5;

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
 *
 * @author
 */
public class PanelCajas extends JPanel {

    //Backtracking en si
    private char[][] matrizActual; //matrizActual a dibujar
    private int size;
    private int cellSize; //64 x 64 pixeles tamaño de cada celda
    //Punto inicial donde comienza el tablero (x, y)
    private int x;
    private int y;
    private BackOrdenar backOrdenar;
    private NodoMatriz nodoMatriz;
    
    private Timer tiempo;
    private ESTADO estado;

    private static enum ESTADO {
        NADA, ANALIZANDO, SOLUCION, NOSOLUCION
    };

    public PanelCajas(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Tamaño debe ser mayor que 0");
        }
        this.size = size;
        //definido por el programador
        this.cellSize = 40;
        this.x = 80;
        this.y = 64;

        this.estado = ESTADO.NADA;
        this.backOrdenar = new BackOrdenar(this.size);
        this.backOrdenar.generar();
        this.nodoMatriz = this.backOrdenar.getListaMatrices().getFirst();
        this.matrizActual = this.nodoMatriz.getMatriz();
    
        
        //Inicia Botón reiniciar e iniciar
        this.iniciarTimer();
        this.iniciarBotones();
    }

    /**
     * Inicia los botones reiniciar e iniciar
     */
    private void iniciarBotones() {
        this.setLayout(new FlowLayout());
        JButton btnReiniciar = new JButton("Reiniciar");
        //Cada vez que se presiona reiniciar, se genera otra vez el backgame
        btnReiniciar.addActionListener((ActionEvent) -> {
            this.estado = ESTADO.NADA;
            this.backOrdenar.reiniciar();
            this.backOrdenar.generar();
            this.nodoMatriz = this.backOrdenar.getListaMatrices().getFirst();
            this.matrizActual = this.nodoMatriz.getMatriz();
            this.tiempo.stop();
        });
        JButton btnIniciar = new JButton("Iniciar");
        btnIniciar.addActionListener((ActionEvent) -> {
            //que hace iniciar
            if (this.estado == ESTADO.NADA) {
                this.estado = ESTADO.ANALIZANDO;
                this.backOrdenar.resolver();
                
                this.tiempo.start();
            }
        });
        this.add(btnReiniciar);
        this.add(btnIniciar);
    }

    private void iniciarTimer() {
        int vecesPorSeg = 500; //en ms
        this.tiempo = new Timer(vecesPorSeg, (ActionEvent) -> {
            if (this.nodoMatriz != null) {
                this.matrizActual = this.nodoMatriz.getMatriz();
                this.nodoMatriz = this.nodoMatriz.getNext();
            } else {
                //Hay solución
               if (this.backOrdenar.exito(16)) {
                    this.estado = ESTADO.SOLUCION;
                } else { //No hay solución
                    this.estado = ESTADO.NOSOLUCION;
                }
                
            }
             
            this.repaint();
        });
    }

    /**
     * Inicia el Timer (para que empiece a reproducirse la secuencia de estados
     * de matriz)
     */
    @Override
    /**
     * Se encarga de dibujar todo
     */

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //dibujar(g);
        dibujarTablero(g);
        dibujarObjetos(g); //Zombies, Survivors y bombas   
        Font font = new Font("Verdana", Font.BOLD, 12);
        g.setFont(font);
        dibujarIntegrantes(g); //Dibuja los integrantes del taller y el paralelo
        dibujarEstado(g, font);
    }

    /**
     * Dibuja el tablero de size x size
     *
     * @param g Gráficos
     */
    public void dibujarTablero(Graphics g) {
        int totalSize = cellSize * this.size;
        //Dibuja el tablero (blanco)
        g.setColor(Color.WHITE);
        g.fillRect(x, y, totalSize, totalSize);
        //Si hay una bomba, entonces dibuja cuadrados rojos de marca
        
        //Líneas de borde
        g.setColor(Color.GRAY);
        for (int i = 0; i <= this.size; i++) {
            for (int j = 0; j <= this.size; j++) {
                g.drawLine(x + i * cellSize, y, x + i * cellSize, y + totalSize);
                g.drawLine(x, y + j * cellSize, x + totalSize, y + j * cellSize);
            }
        }
        //Vuelve al color original
        g.setColor(Color.BLACK);
    }

    /**
     * Dibuja los objetos en el tablero 
     *
     * @param g Gráficos
     */
    public void dibujarObjetos(Graphics g) {
       
        int totalSize = cellSize * this.size;
        g.fillRect(x, y, totalSize, totalSize);
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                int id = this.matrizActual[i][j];
                if (id == 'o') {
                    g.setColor(Color.RED);
                    g.fillRect(x + j * cellSize, y + i * cellSize, cellSize, cellSize);
                } else if (id == 'c') {
                    g.setColor(Color.YELLOW);
                    g.fillRect(x + j * cellSize, y + i * cellSize, cellSize, cellSize);
                }else if (id == 'l'){
                    g.setColor(Color.WHITE);
                    g.fillRect(x + j * cellSize, y + i * cellSize, cellSize-1, cellSize-1);
                }
            }
        }
    }

    /**
     * Dibuja los integrantes del grupo 
     *
     * @param g Gráficos
     */
    public void dibujarIntegrantes(Graphics g) {
        String strAlumnos = "Alumno(s): Cristobal Jofre - Luis Molina";
        String strParalelo = "Programacion 1";
        String strDatos= "\n Cantidad cajas: 4 \n Tamaño cajas: 2x2";
        g.drawString(strAlumnos, 16, this.getHeight() - 16);
        g.drawString(strDatos, 16, this.getHeight() - 2);
        g.drawString(strParalelo, this.getWidth() - 144, this.getHeight() - 16);
    }

    /**
     * Dibuja el estado del juego (Si está analizando, si encontró solución, o
     * si no hay solución)
     *
     * @param g Gráficos
     * @param font Fuente
     */
    public void dibujarEstado(Graphics g, Font font) {
        String strEstado = "";
        if (this.estado != null) {
            switch (this.estado) {
                case ANALIZANDO:
                    strEstado = "Analizando...";
                    break;
                case SOLUCION:
                    strEstado = "Se encontro solución!";
                    break;
                case NOSOLUCION:
                    strEstado = "Imposible ordenarlos";
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
