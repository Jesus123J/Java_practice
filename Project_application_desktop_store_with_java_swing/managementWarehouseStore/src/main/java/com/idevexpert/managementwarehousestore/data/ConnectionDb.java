/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.managementwarehousestore.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jesus Gutierrez
 */
public class ConnectionDb {
// Configuración de MySQL
    private static final String MYSQL_URL = "jdbc:mysql://localhost:3306/storeJewelry";
    private static final String MYSQL_USER = "root";
    private static final String MYSQL_PASSWORD = "";

    // Configuración de SQL Server
    private static final String SQLSERVER_URL = "jdbc:sqlserver://localhost:1433;databaseName=storeJewelry";
    private static final String SQLSERVER_USER = "sa";
    private static final String SQLSERVER_PASSWORD = "1234";

    /**
     * Método para conectar a MySQL
     * @return Connection a MySQL
     */
    public static Connection connectionMySQL() {
        try {
            Connection connection = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD);
            System.out.println("Conexión exitosa a MySQL");
            return connection;
        } catch (SQLException e) {
            System.out.println("Error en la conexión a MySQL: " + e.getMessage());
            return null;
        }
    }

    /**
     * Método para conectar a SQL Server
     * @return Connection a SQL Server
     */
    public static Connection connectionSQLServer() {
        try {
            Connection connection = DriverManager.getConnection(SQLSERVER_URL, SQLSERVER_USER, SQLSERVER_PASSWORD);
            System.out.println("Conexión exitosa a SQL Server");
            return connection;
        } catch (SQLException e) {
            System.out.println("Error en la conexión a SQL Server: " + e.getMessage());
            return null;
        }
    }
}
