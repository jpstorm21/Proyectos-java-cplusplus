package App;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUIApp extends JFrame 
{
    public GUIApp()
    {
        super();
        this.setTitle("Mi primer JFrame!");
        this.setSize(480, 480);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.iniciarComponentes();
        this.setVisible(true);
    }
    
    private void iniciarComponentes()
    {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        
        JPanel panelIntegrantes = new JPanel();
        JLabel labelIntegrantes = new JLabel("Realizado por Integrate1, Integrante2");
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
    
    public static void main(String[] args)
    {
        GUIApp app = new GUIApp();
    }
}