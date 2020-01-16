/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudioamigatiwok;
import Ventana.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Juan Pablo Martinez
 */
public class EstudioAmigaTiwok {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(EstudioAmigaTiwok.class.getName()).log(Level.SEVERE, null, ex);
        }
        Conexion c = new Conexion();
        AdminMangas am = new AdminMangas(c);
        am.setVisible(true);
    }

}
