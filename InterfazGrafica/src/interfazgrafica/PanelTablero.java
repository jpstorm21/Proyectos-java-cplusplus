/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazgrafica;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class PanelTablero extends JPanel {

    public PanelTablero(JButton botonIniciar, JButton botonReiniciar) {
        super();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        int x = 117, y = 32, size = 256;
        g.fillRect(x, y, size, size);
        //Dibuja Contorno de las Celdas
        g.setColor(Color.BLACK);
        for (int i = 0; i <= 8; i++) {
            g.drawLine(x + 32 * i, y, x + 32 * i, y + size);
            g.drawLine(x, y + 32 * i, x + size, y + 32 * i);
        }
    }
}
