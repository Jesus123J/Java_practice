/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.managementwarehousestore.data.dao;

/**
 *
 * @author Jesus Gutierrez
 */
import com.idevexpert.managementwarehousestore.data.ConnectionDataBase;
import com.idevexpert.managementwarehousestore.data.dto.FacturaDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FacturaDaoImpl implements ConnectionDataBase {

    static Connection connection = connectionSqlServer;

    public static List<FacturaDto> getAllFacturas() throws SQLException {
        String query = "SELECT * FROM factura";
        List<FacturaDto> facturas = new ArrayList<>();
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                FacturaDto factura = new FacturaDto(
                        rs.getInt("id"),
                        rs.getInt("idClient"),
                        rs.getInt("idProduct"),
                        rs.getInt("cantidad"),
                        rs.getString("date")
                );
                facturas.add(factura);
            }
        }
        return facturas;
    }

    public static List<FacturaDto> getFacturasByDate(String date) throws SQLException {
        String query = "SELECT * FROM factura WHERE date = ?";
        List<FacturaDto> facturas = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, date);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    FacturaDto factura = new FacturaDto(
                            rs.getInt("id"),
                            rs.getInt("idClient"),
                            rs.getInt("idProduct"),
                            rs.getInt("cantidad"),
                            rs.getString("date")
                    );
                    facturas.add(factura);
                }
            }
        }
        return facturas;
    }

    public int registrarFactura(int idClient, int idProduct, int cantidad) throws SQLException {
        try {
            connection.setAutoCommit(false);
            int cantidadDisponible = obtenerCantidadProducto(idProduct);
            if (cantidadDisponible < cantidad) {
                JOptionPane.showMessageDialog(null, "No se puede comprar tal cantidad de producto no hay stock");
                return 1;
            }

            // Registrar la factura
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDateTime = dateTime.format(formatter);
            String insertFacturaSQL = "INSERT INTO factura (idClient, idProduct, cantidad , date) VALUES (?, ?, ? ,?)";
            try (PreparedStatement pstmt = connection.prepareStatement(insertFacturaSQL)) {
                pstmt.setInt(1, idClient);
                pstmt.setInt(2, idProduct);
                pstmt.setInt(3, cantidad);
                pstmt.setString(4, formattedDateTime);
                pstmt.executeUpdate();
            }

            // Actualizar la cantidad del producto
            actualizarCantidadProducto(idProduct, cantidadDisponible - cantidad);

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
        return 0;
    }

    private int obtenerCantidadProducto(int idProduct) throws SQLException {
        String selectProductSQL = "SELECT cantidad FROM product WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(selectProductSQL)) {
            pstmt.setInt(1, idProduct);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("cantidad");
                } else {
                    throw new SQLException("Producto no encontrado.");
                }
            }
        }
    }

    private void actualizarCantidadProducto(int idProduct, int nuevaCantidad) throws SQLException {
        if (nuevaCantidad < 0) {
            throw new SQLException("La cantidad del producto no puede ser negativa.");
        }

        String updateProductSQL = "UPDATE product SET cantidad = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(updateProductSQL)) {
            pstmt.setInt(1, nuevaCantidad);
            pstmt.setInt(2, idProduct);
            pstmt.executeUpdate();
        }
    }
}
