/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller5_parte2sgdo2017;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Usuario
 */
public class LITIOBOT extends JFrame{
    private InterfazGrafica interfaz;

    public LITIOBOT(String titulo,int ancho,int alto, int tamaño) {
        super(titulo);
        this.setSize(ancho, alto);
        this.setPreferredSize(new Dimension(ancho, alto));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.interfaz = new InterfazGrafica(tamaño);
        this.setContentPane(this.interfaz);
        this.pack();
    }
    
}
