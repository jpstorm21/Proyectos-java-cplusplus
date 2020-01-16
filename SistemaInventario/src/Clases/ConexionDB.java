/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Juan Pablo Martinez
 */
public class ConexionDB {

    private static Connection connection;

    public ConexionDB() {
        connection = null;
        String urlDatabase = "jdbc:postgresql://localhost:5432/picamadero";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(urlDatabase, "postgres", "postgres");
        } catch (Exception e) {
            System.out.println("Ocurrio un error : " + e.getMessage());
        }
        System.out.println("La conexión se realizo con exito ");
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

    public void test() throws SQLException {
        Statement stmt = null;
        stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM category;");
        while (rs.next()) {
            int id = rs.getInt("id_category");
            String name = rs.getString("category_name");
            System.out.println("ID = " + id);
            System.out.println("NAME = " + name);
            System.out.println();
        }
        rs.close();
        stmt.close();
    }
    
    public void xd(){
        System.out.println("xd");
    }

}
