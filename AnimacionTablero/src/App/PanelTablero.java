package App;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelTablero extends JPanel
{
    private ArrayList<int[]> posReina;
    private ArrayList<int[]> secuencia;
    private int indiceSecuencia;
    private Timer timer;
    
    public PanelTablero(JButton botonIniciar, JButton botonReiniciar)
    {
        super();
        this.posReina = new ArrayList<>();
        this.secuencia = new ArrayList<>();
        this.timer = new Timer(10, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (indiceSecuencia < secuencia.size()){
                    indiceSecuencia++;
                    repaint();
                }
            }
        });
        botonIniciar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                timer.start();
                indiceSecuencia = 0;
            }
        });
        botonReiniciar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                timer.stop();
                indiceSecuencia = 0;
                repaint();
            }
        });
        this.ochoreinas(0, -1);
    }
       
    private void ochoreinas(int x, int y)
    {
        if (++y >= 8) {x++; y = 0;}
        while(x < 8 && y < 8 && posReina.size() != 8)
        {
            if (aceptable(x, y))
            {
                int[] posicion = {x, y};
                posReina.add(posicion);
                int[] secuenciaInsercion = {x, y, 1};
                secuencia.add(secuenciaInsercion);
                if (posReina.size() < 8)
                {
                    ochoreinas(x, y);
                    if (posReina.size() != 8)
                    {
                        posReina.remove(posReina.size() - 1);
                        int[] secuenciaEliminacion = {x, y, 0};
                        secuencia.add(secuenciaEliminacion);
                    }
                }
            }
            if (++y >= 8) {x++; y = 0;}
        }
    }
    
    private boolean aceptable(int x, int y)
    {
        for (int i = 0; i < posReina.size(); i++) 
        {
            int pos[] = posReina.get(i), rx = pos[0], ry = pos[1];
            if (rx == x || ry == y || ry - rx == y - x || ry + rx == y + x) 
                return false;
        }
        return true;
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.white);
        int x = 117, y = 32, size = 256;
        g.fillRect(x, y, size, size);
        //Dibuja Contorno de las Celdas
        g.setColor(Color.BLACK);
        for (int i = 0; i <= 10; i++) 
        {
            g.drawLine(x + 32*i, y, x + 32*i, y + size);
            g.drawLine(x, y + 32*i, x + size, y + 32*i);
        }
        //Dibuja las reinas
        for (int i = 0; i < indiceSecuencia; i++) {
            int sec[] = secuencia.get(i), row = sec[0], col = sec[1], tipo = sec[2];
            if (tipo == 1){
                g.setColor(Color.BLUE);
            }else{
                g.setColor(Color.WHITE);
            }
            g.fillRect(x + 32*col + 1, y + 32*row + 1, 31, 31);
        }
    }
}