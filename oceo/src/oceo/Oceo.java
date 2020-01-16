package oceo;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.keepautomation.barcode.BarCode;
import ucn.*;

public class Oceo {

    public static void main(String[] args) throws IOException {
        BarCode barra = new BarCode();
        barra.setCodeToEncode("23467434123742");
        try {
            barra.draw("C:\\Users\\ASUS\\Documents\\ucn/ds.png");
        } catch (Exception ex) {
            Logger.getLogger(Oceo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
