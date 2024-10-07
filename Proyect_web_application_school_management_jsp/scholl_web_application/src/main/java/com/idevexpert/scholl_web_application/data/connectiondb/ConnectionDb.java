/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.scholl_web_application.data.connectiondb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jesus Gutierrez
 */
public class ConnectionDb {

    private static final String URL = "jdbc:mysql://localhost:3306/paginaweb";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection connectionDb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Se logro conectar con la base de datos");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Se produjo un error en la conexion de con la base de datos");
            return null;
        } catch (ClassNotFoundException ex) {
            return null;
        }
    }
}
