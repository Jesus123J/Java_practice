/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.managementwarehousestore.data.dao;

import com.idevexpert.managementwarehousestore.data.ConnectionDataBase;
import com.idevexpert.managementwarehousestore.data.dao.daoImpl.ClientDao;
import com.idevexpert.managementwarehousestore.data.dto.ClientDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesus Gutierrez
 */
public class ClientDaoImpl implements ConnectionDataBase, ClientDao {

    Connection connection = connectionSqlServer;

    @Override
    public void insert(ClientDto client) {
        String sql = "INSERT INTO client (name, apellido, dni, direccion, telefono) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getApellido());
            stmt.setString(3, client.getDni());
            stmt.setString(4, client.getDireccion());
            stmt.setString(5, client.getTelefono());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(ClientDto client) {
        String sql = "UPDATE client SET name = ?, apellido = ?, dni = ?, direccion = ?, telefono = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getApellido());
            stmt.setString(3, client.getDni());
            stmt.setString(4, client.getDireccion());
            stmt.setString(5, client.getTelefono());
            stmt.setInt(6, client.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int clientId) {
        String sql = "DELETE FROM client WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, clientId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ClientDto getById(int clientId) {
        String sql = "SELECT * FROM client WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, clientId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extractClientFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ClientDto> getAll() {
        List<ClientDto> clients = new ArrayList<>();
        String sql = "SELECT * FROM client";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                clients.add(extractClientFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    private ClientDto extractClientFromResultSet(ResultSet rs) throws SQLException {
        ClientDto client = new ClientDto();
        client.setId(rs.getInt("id"));
        client.setName(rs.getString("name"));
        client.setApellido(rs.getString("apellido"));
        client.setDni(rs.getString("dni"));
        client.setDireccion(rs.getString("direccion"));
        client.setTelefono(rs.getString("telefono"));
        return client;
    }
}
