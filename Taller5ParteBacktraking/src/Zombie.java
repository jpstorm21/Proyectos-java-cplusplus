

import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class Zombie extends JFrame{
     
    private Tablero tablero;
   
    
    public Zombie(String titulo){
        
        super(titulo);
        this.registro();
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }
    
    private void registro() {
        
        Container contenedor = this.getContentPane();
        contenedor.setLayout(new BorderLayout());
        JLabel nombre = new JLabel("juan martinez-leonel villagra");
        JLabel ramo = new JLabel("Paralelo: progamacion 1");
        Botones btnInicio = new Botones(this,"Jugar");
        Botones btnReinicio = new Botones(this,"Reiniciar");
       
        this.tablero = new Tablero(5);
        
        contenedor.add(tablero,BorderLayout.CENTER);
        contenedor.add(nombre,BorderLayout.WEST);
        contenedor.add(ramo,BorderLayout.EAST);
        contenedor.add(btnInicio,BorderLayout.NORTH);
        
        contenedor.add(btnReinicio,BorderLayout.SOUTH);
       
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
    }
   
   
}
