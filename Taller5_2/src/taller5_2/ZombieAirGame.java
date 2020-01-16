package taller5_2;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author JOSE
 */
public class ZombieAirGame extends JFrame{
    
    private PanelGame panelGame;
    
    public ZombieAirGame(String titulo, int ancho, int alto, int matrizSize){
        super(titulo);
        this.setSize(ancho, alto);
        this.setPreferredSize(new Dimension(ancho, alto));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.panelGame = new PanelGame(matrizSize);
        this.setContentPane(this.panelGame);
        this.pack();
    }
    
}
