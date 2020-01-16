/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudioamigatiwok;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Juan Pablo Martinez
 */
public class Conexion {

    private static Connection connection;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static String USER;
    private static String PASSWORD;
    private static String URL;

    public Conexion() throws ClassNotFoundException, SQLException, IOException {
        connection = null;
        URL = "jdbc:mysql://localhost:3306/crud";
        USER = "root";
        PASSWORD = "";

        Class.forName(DRIVER);
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        if (connection != null) {
            System.out.println("Conexión establecida..");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void desconectar() {
        connection = null;
        if (connection == null) {
            System.out.println("Conexión terminada..");
        }
    }
}
