
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class Tablero extends JPanel{
    
    private int tam;


    
    public Tablero(int tam) {

        this.setPreferredSize(new Dimension(450,450));
        this.tam = tam;
        // podrian hacer el tablero de booleans
    }
  
    
    @Override
    public void paintComponent( Graphics g ) {
        super.paintComponent(g);  
        dibujarMatriz(g);
        dibujarAlgoEnElTablero(g);
    }
    
    private void dibujarMatriz(Graphics g){
        Graphics2D g2 = (Graphics2D)g;   
        int tamañoDeCelda = 60;
        int lado = tamañoDeCelda * tam;
        int offset =tamañoDeCelda;
        
        g2.setColor(Color.WHITE);
        g2.fillRect(offset, offset, lado, lado); // un rectangulo
        g2.setColor(Color.RED);
      
        for(int i = 0; i <= tam; i++){
            for(int j = 0; j <= tam; j++){
                
                g2.drawLine(offset + i*(tamañoDeCelda), offset + j*(tamañoDeCelda), 
                            offset + lado, offset + j*(tamañoDeCelda));
                g2.drawLine(offset + i*(tamañoDeCelda), offset + j*(tamañoDeCelda), 
                            offset + i*(tamañoDeCelda), offset + lado);
            
            }
        }
    }
    
    private void dibujarAlgoEnElTablero(Graphics g){
        
       Image img = Toolkit.getDefaultToolkit().getImage("zombie1.gif");
       
       
       Graphics2D g2 = (Graphics2D)g;
       int tamañoDeCelda = 60;
       int lado = tamañoDeCelda * tam;
       int offset =tamañoDeCelda;
       
       // aqui el 1 y el 2 funcionan como posiciones de matriz
        int columna1 = offset + 0*(tamañoDeCelda) + tamañoDeCelda/2;
        int fila1 = offset + 0*(tamañoDeCelda) + tamañoDeCelda/2;
        int columna = offset + 3*(tamañoDeCelda) + tamañoDeCelda/2;
        int fila = offset + 3*(tamañoDeCelda) + tamañoDeCelda/2;
        g2.drawImage(img, columna-35,fila-30,tamañoDeCelda, tamañoDeCelda, this);
        g2.drawImage(img, columna1-35,fila1-30,tamañoDeCelda,tamañoDeCelda,this);
        
       }
   
        
    }

