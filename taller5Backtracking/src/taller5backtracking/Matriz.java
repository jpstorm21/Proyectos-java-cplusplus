/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller5backtracking;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author DOMINGOANTONIO
 */
public class Matriz extends Canvas{
    
    public Matriz(){
        
    }
    @Override
    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.drawRect(50,50 , 650, 550);
        g.drawLine(180, 50, 180 ,600 );
        g.drawLine(310, 50, 310 ,600 );
        g.drawLine(440, 50, 440 ,600 );
        g.drawLine(570, 50, 570 ,600 );
        g.drawLine(50, 160, 700,160 );
        g.drawLine(50, 270, 700,270 );
        g.drawLine(50, 380, 700,380 );
        g.drawLine(50, 490, 700,490 );
        
        g.drawString("Taller 5: <Destruccion zombie>", 300, 20);
        
        
    }
}
