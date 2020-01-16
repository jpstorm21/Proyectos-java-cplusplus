import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Botones extends JButton implements ActionListener{

    private Zombie juego;
    
    public Botones(Zombie juego, String nomBoton){
        super(nomBoton);
        this.juego = juego;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        JOptionPane.showMessageDialog(null, "COMENZO EL JUEGO!!!");
        
        // esto se usa cuando yo clickeo el boton, aqui deberia empezar el juego
        
    }
    
}
