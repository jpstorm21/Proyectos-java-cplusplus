/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller5backtracking;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;

/**
 *
 * @author DOMINGOANTONIO
 */
public class Ventana extends JFrame{
    
    private javax.swing.JButton jButtonIniciar;
    private javax.swing.JButton jButtonReiniciar;

    
    public Ventana(){
        
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new Matriz());
        
        
        setVisible(true);
    }
    
}
