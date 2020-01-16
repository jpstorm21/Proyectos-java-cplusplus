package taller5;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author 
 */
public class OrdenaCajas extends JFrame{
    
    private PanelCajas panelGame;
    
    public OrdenaCajas(String titulo, int ancho, int alto){
        super(titulo);
        this.setSize(ancho, alto);
        this.setPreferredSize(new Dimension(ancho, alto));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.panelGame = new PanelCajas(10);
        this.setContentPane(this.panelGame);
        this.pack();
    }
    
}
