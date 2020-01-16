/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juank.BuscaMinas.logica;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;

/**
 *
 * @author Juan K
 */
public class Board extends Canvas implements MouseListener {

    private int[][] grid;
    private Graphics gr2;
    private Graphics gr = this.getGraphics();
    private int gWidth, gHeight, minas, banderas;
    private Juego juego;
    private ImageIcon mina, bandera;
    private Image imgMina, imgBandera;

    /**
     * constructor del tablero
     */
    public Board() {
    }

    Board(int[][] grid, int minas, Juego juego, int banderas) {
        this.banderas = banderas;
        this.minas = minas;
        this.grid = grid;
        this.juego = juego;
        this.mina = new ImageIcon("src/juank/BuscaMinas/img/mina.png");
        this.imgMina = mina.getImage();
        this.bandera = new ImageIcon("src/juank/BuscaMinas/img/bandera.png");
        this.imgBandera = bandera.getImage();
        addMouseListener(this);
        initBoard();
    }

    /**
     * init del tablero
     */
    public void initBoard() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                grid[i][j] = 0;
            }
        }
        posicionarMinas();
    }

    public void aparecerMinas() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (grid[i][j] == 9) {
                    grid[i][j] = 14;
                }
            }
        }
        this.paint(this.getGraphics());
    }

    /**
     * pintar el tablero
     */
    @Override
    public void paint(Graphics g) {
        System.out.println("> Pintando...");
        gr = g;
        gWidth = getBounds().width / 11;
        gHeight = getBounds().height / 11;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                drawCell(i, j);
            }
        }
    }

    /**
     * dibujar una celda especifica en el tablero.
     */
    private void drawCell(int x, int y) {
        gr = this.getGraphics();
        int dark = 0;
        gr.setColor(Color.black);
        gr.drawRect(x * gWidth, y * gHeight, gWidth, gHeight);
        if ((x + y) % 2 == 0) {
            dark = 20;
        }
        switch (grid[x][y]) {
            case 0:
                gr.setColor(new Color(130 + dark, 230 + dark, 230 + dark));
                break;//sin clic y sin mina
            case 1:
                gr.dispose();
                gr2 = this.getGraphics();
                gr2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
                gr2.setColor(Color.red);
                gr2.drawString("1", (x * gWidth) + (gWidth / 2) - 4, (y * gHeight) + (gHeight / 2) + 7);
                break;
            case 2:
                gr.dispose();
                gr2 = this.getGraphics();
                gr2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
                gr2.setColor(Color.red);
                gr2.drawString("2", (x * gWidth) + (gWidth / 2) - 4, (y * gHeight) + (gHeight / 2) + 7);
                break;
            case 3:
                gr.dispose();
                gr2 = this.getGraphics();
                gr2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
                gr2.setColor(Color.red);
                gr2.drawString("3", (x * gWidth) + (gWidth / 2) - 4, (y * gHeight) + (gHeight / 2) + 7);
                break;
            case 4:
                gr.dispose();
                gr2 = this.getGraphics();
                gr2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
                gr2.setColor(Color.red);
                gr2.drawString("4", (x * gWidth) + (gWidth / 2) - 4, (y * gHeight) + (gHeight / 2) + 7);
                break;
            case 5:
                gr.dispose();
                gr2 = this.getGraphics();
                gr2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
                gr2.setColor(Color.red);
                gr2.drawString("5", (x * gWidth) + (gWidth / 2) - 4, (y * gHeight) + (gHeight / 2) + 7);
                break;
            case 6:
                gr.dispose();
                gr2 = this.getGraphics();
                gr2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
                gr2.setColor(Color.red);
                gr2.drawString("6", (x * gWidth) + (gWidth / 2) - 4, (y * gHeight) + (gHeight / 2) + 7);
                break;
            case 7:
                gr.dispose();
                gr2 = this.getGraphics();
                gr2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
                gr2.setColor(Color.red);
                gr2.drawString("7", (x * gWidth) + (gWidth / 2) - 4, (y * gHeight) + (gHeight / 2) + 7);
                break;
            case 8:
                gr.dispose();
                gr2 = this.getGraphics();
                gr2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
                gr2.setColor(Color.red);
                gr2.drawString("8", (x * gWidth) + (gWidth / 2) - 4, (y * gHeight) + (gHeight / 2) + 7);
                break;
            case 9:
                gr.setColor(new Color(130 + dark, 230 + dark, 230 + dark));
                break;//sin clic y con mina
            case 10:
                gr.setColor(new Color(168 + dark, 168 + dark, 168 + dark));
                break;//con clic y sin nada
            case 11:
                gr2 = this.getGraphics();
                gr.setColor(new Color(168 + dark, 168 + dark, 168 + dark));
                gr.dispose();
                gr2.drawImage(imgMina, x * gWidth + 1, y * gHeight + 1, gWidth - 1, gHeight - 1, Color.red, this);
                break;//con clic y con mina
            case 12:
                gr2 = this.getGraphics();
                gr.setColor(Color.black);
                gr.dispose();
                gr2.drawImage(imgBandera, x * gWidth + 1, y * gHeight + 1, gWidth - 1, gHeight - 1, new Color(130 + dark, 230 + dark, 230 + dark), this);
                break;//con bandera y sin nada
            case 13:
                gr2 = this.getGraphics();
                gr.setColor(Color.black);
                gr.dispose();
                gr2.drawImage(imgBandera, x * gWidth + 1, y * gHeight + 1, gWidth - 1, gHeight - 1, new Color(130 + dark, 230 + dark, 230 + dark), this);
                break;//con bandera y con mina  
            case 14:
                gr2 = this.getGraphics();
                gr.setColor(new Color(168 + dark, 168 + dark, 168 + dark));
                gr.dispose();
                gr2.drawImage(imgMina, x * gWidth + 1, y * gHeight + 1, gWidth - 1, gHeight - 1, Color.gray, this);
                break;//mina
        }
        gr.fillRect(x * gWidth + 1, y * gHeight + 1, gWidth - 1, gHeight - 1);
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    /**
     * mouse click
     *
     * @param e espera del clic
     */
    @Override
    public void mousePressed(MouseEvent e) {
        int x, y;
        x = e.getX() / gWidth;
        y = e.getY() / gHeight;
        System.out.println("click " + x + " " + y + " tipo: " + grid[x][y]);
        if ((e.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK) {//primario
            System.out.println(">>Click con el botón izquierdo");
            if (legal(x, y)) {
                if (grid[x][y] == 9) { //si donde se presiona hay minas
                    System.out.println("   mina");
                    grid[x][y] = 11;
                    juego.lose();
                } else if (grid[x][y] == 0) {//si donde se presiona no hay minas
                    int m = 0;
                    if ((x - 1) >= 0) {
                        if (grid[x - 1][y] == 9 || grid[x - 1][y] == 11 || grid[x - 1][y] == 13 || grid[x - 1][y] == 14) {
                            m++;
                        }
                    }
                    if ((x + 1) <= 10) {
                        if (grid[x + 1][y] == 9 || grid[x + 1][y] == 11 || grid[x + 1][y] == 13 || grid[x + 1][y] == 14) {
                            m++;
                        }
                    }
                    if ((y - 1) >= 0) {
                        if (grid[x][y - 1] == 9 || grid[x][y - 1] == 11 || grid[x][y - 1] == 13 || grid[x][y - 1] == 14) {
                            m++;
                        }
                    }
                    if ((y + 1) <= 10) {
                        if (grid[x][y + 1] == 9 || grid[x][y + 1] == 11 || grid[x][y + 1] == 13 || grid[x][y + 1] == 14) {
                            m++;
                        }
                    }
                    if ((y + 1) <= 10 && (x + 1) <= 10) {
                        if (grid[x + 1][y + 1] == 9 || grid[x + 1][y + 1] == 11 || grid[x + 1][y + 1] == 13 || grid[x + 1][y + 1] == 14) {
                            m++;
                        }
                    }
                    if ((y - 1) >= 0 && (x - 1) >= 0) {
                        if (grid[x - 1][y - 1] == 9 || grid[x - 1][y - 1] == 11 || grid[x - 1][y - 1] == 13 || grid[x - 1][y - 1] == 14) {
                            m++;
                        }
                    }
                    if ((y + 1) <= 10 && (x - 1) >= 0) {
                        if (grid[x - 1][y + 1] == 9 || grid[x - 1][y + 1] == 11 || grid[x - 1][y + 1] == 13 || grid[x - 1][y + 1] == 14) {
                            m++;
                        }
                    }
                    if ((y - 1) >= 0 && (x + 1) <= 10) {
                        if (grid[x + 1][y - 1] == 9 || grid[x + 1][y - 1] == 11 || grid[x + 1][y - 1] == 13 || grid[x + 1][y - 1] == 14) {
                            m++;
                        }
                    }
                    if (m != 0) {
                        System.out.println("   " + m + " minas cerca");
                        grid[x][y] = m;
                    } else {
                        System.out.println("   nada");
                        grid[x][y] = 10;
                    }
                }
            }
        } else {//secundario
            System.out.println(">>Click con el botón derecho");
            if (legal(x, y)) {
                if (grid[x][y] == 9) { //si donde se presiona hay minas
                    System.out.println("   mina correctamente encontrada");
                    grid[x][y] = 13;
                    this.banderas--;
                    this.juego.getVentana().getJResto().setText("" + banderas);
                } else if (grid[x][y] == 0) {//si donde se presiona no hay minas
                    System.out.println("   mina no encontrada");
                    grid[x][y] = 12;
                    this.banderas--;
                    this.juego.getVentana().getJResto().setText("" + banderas);
                }
            }
        }
        this.paint(this.getGraphics());
    }

    /**
     * Returns true si esta dentro de los rangos aceptables (11x11)
     */
    private boolean legal(int x, int y) {
        return (x >= 0 && x < 11 && y >= 0 && y < 11);
    }

    private void posicionarMinas() {
        for (int i = 0; i < minas; i++) {
            grid[(int) (Math.random() * 10) + 1][(int) (Math.random() * 10) + 1] = 9;
        }
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    public Graphics getGr2() {
        return gr2;
    }

    public void setGr2(Graphics gr2) {
        this.gr2 = gr2;
    }

    public Graphics getGr() {
        return gr;
    }

    public void setGr(Graphics gr) {
        this.gr = gr;
    }

    public int getgWidth() {
        return gWidth;
    }

    public void setgWidth(int gWidth) {
        this.gWidth = gWidth;
    }

    public int getgHeight() {
        return gHeight;
    }

    public void setgHeight(int gHeight) {
        this.gHeight = gHeight;
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

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public ImageIcon getMina() {
        return mina;
    }

    public void setMina(ImageIcon mina) {
        this.mina = mina;
    }

    public ImageIcon getBandera() {
        return bandera;
    }

    public void setBandera(ImageIcon bandera) {
        this.bandera = bandera;
    }

    public Image getImgMina() {
        return imgMina;
    }

    public void setImgMina(Image imgMina) {
        this.imgMina = imgMina;
    }

    public Image getImgBandera() {
        return imgBandera;
    }

    public void setImgBandera(Image imgBandera) {
        this.imgBandera = imgBandera;
    }

}
