/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.scholl_web_application.data.dao;

import com.idevexpert.scholl_web_application.data.connectiondb.ConnectionDataBase;
import com.idevexpert.scholl_web_application.data.dto.PagosDto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jesus Gutierrez
 */
public class PagosDao implements ConnectionDataBase {

    public List<PagosDto> getAllPagos() {
        List<PagosDto> pagosList = new ArrayList<>();
        try {

            String query = "SELECT * FROM pagos";
            try (PreparedStatement preparedStatement = connectionDataBase.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    PagosDto pago = new PagosDto(
                            resultSet.getInt("idpagos"),
                            resultSet.getString("valor"),
                            resultSet.getString("description"),
                            resultSet.getInt("idUser")
                    );
                    pagosList.add(pago);
                }

            }
            return pagosList;
        } catch (SQLException ex) {
            return pagosList;
        }
    }

  public void insertPago(PagosDto pago) {
    try {
        String query = "INSERT INTO paginaweb.pagos (valor, description, idUser) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connectionDataBase.prepareStatement(query);
        preparedStatement.setString(1, pago.getValor());
        preparedStatement.setString(2, pago.getDescription());
        preparedStatement.setInt(3, pago.getIdUser());
        preparedStatement.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace(); // Imprime la excepción para depurar posibles errores
    }
}

    public void updatePago(PagosDto pago) {
        try {
            String query = "UPDATE pagos SET valor = ?, description = ?, idUser = ? WHERE idpagos = ?";
            try (PreparedStatement preparedStatement = connectionDataBase.prepareStatement(query)) {
                preparedStatement.setString(1, pago.getValor());
                preparedStatement.setString(2, pago.getDescription());
                preparedStatement.setInt(3, pago.getIdUser());
                preparedStatement.setInt(4, pago.getIdPagos());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {

        }
    }

    public void deletePago(int idpagos) {
        try {
            String query = "DELETE FROM pagos WHERE idpagos = ?";
            try (PreparedStatement preparedStatement = connectionDataBase.prepareStatement(query)) {
                preparedStatement.setInt(1, idpagos);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {

        }
    }
}
