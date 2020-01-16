/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayudantia1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author Juan Pablo Martinez
 */
public class Ayudantia1 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("inventaprodrio");
        
        CreationHelper help = book.getCreationHelper();
        Drawing draw = sheet.createDrawingPatriarch();
        

        FileOutputStream fileOut = new FileOutputStream("reporteInventario.xlsx");
        book.write(fileOut);
        fileOut.close();
        
    }
}
