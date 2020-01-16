/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazgrafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class InterfazGrafica extends JFrame {

    public InterfazGrafica() {
        super();
        this.setTitle("primera ventana");
        this.setSize(480, 480);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.iniciarComponentes();
        this.setVisible(true);
    }

    private void iniciarComponentes() {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        JPanel panelIntegrantes = new JPanel();
        JLabel labelIntegrantes = new JLabel("Juan Martinez");
        panelIntegrantes.add(labelIntegrantes);
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());
        JButton botonIniciar = new JButton("Iniciar");
        JButton botonReiniciar = new JButton("Reiniciar");
        panelBotones.add(botonIniciar);
        panelBotones.add(botonReiniciar);
        PanelTablero panelTablero = new PanelTablero(botonIniciar, botonReiniciar);
        panelPrincipal.add(panelTablero, BorderLayout.CENTER);
        panelPrincipal.add(panelIntegrantes, BorderLayout.NORTH);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
        this.add(panelPrincipal);
    }

    public static void main(String[] args) {
        InterfazGrafica app = new InterfazGrafica();
    }

}
