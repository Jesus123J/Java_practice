/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.managementwarehousestore.data.dao;

import com.idevexpert.managementwarehousestore.data.ConnectionDataBase;
import com.idevexpert.managementwarehousestore.data.dao.daoImpl.UserDao;
import com.idevexpert.managementwarehousestore.data.dto.UserDto;
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
public class UserDaoImpl implements ConnectionDataBase, UserDao {
    
    Connection connection  = connectionSqlServer;
    
    @Override
    public void insert(UserDto user) {
        String sql = "INSERT INTO [user] (idPerson, user, password) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, user.getIdPerson());
            stmt.setString(2, user.getUser());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(UserDto user) {
        String sql = "UPDATE [user] SET idPerson = ?, user = ?, password = ? WHERE iduser = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, user.getIdPerson());
            stmt.setString(2, user.getUser());
            stmt.setString(3, user.getPassword());
            stmt.setInt(4, user.getIdUser());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int userId) {
        String sql = "DELETE FROM [user] WHERE iduser = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserDto getById(int userId) {
        String sql = "SELECT * FROM [user] WHERE iduser = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extractUserFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<UserDto> getAll() {
        List<UserDto> users = new ArrayList<>();
        String sql = "SELECT * FROM [user]";
        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                users.add(extractUserFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public UserDto getByUsername(String username) {
       String sql = "SELECT * FROM [user] WHERE user = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extractUserFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private UserDto extractUserFromResultSet(ResultSet rs) throws SQLException {
        UserDto user = new UserDto();
        user.setIdUser(rs.getInt("iduser"));
        user.setIdPerson(rs.getInt("idPerson"));
        user.setUser(rs.getString("user"));
        user.setPassword(rs.getString("password"));
        return user;
    }

    @Override
    public UserDto getByIdPerson(int idPerson) {

        String sql = "SELECT * FROM [user] WHERE idPerson = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idPerson);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extractUserFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
