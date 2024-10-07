/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.scholl_web_application.data.dao;

import com.idevexpert.scholl_web_application.data.connectiondb.ConnectionDataBase;
import com.idevexpert.scholl_web_application.data.connectiondb.ConnectionDb;
import com.idevexpert.scholl_web_application.data.dto.UserDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jesus Gutierrez
 */
public class UserDao extends UserDto implements ConnectionDataBase {

    public static int user_register(String name, String email, String user, String password) {
        try {

            ResultSet generatedKeys = null;

            // Insertar en la tabla `user`
            String userSql = "INSERT INTO user (user, password, idtypeRol) VALUES (?, ?, ?)";
            PreparedStatement userStmt = connectionDataBase.prepareStatement(userSql, PreparedStatement.RETURN_GENERATED_KEYS);
            userStmt.setString(1, user);
            userStmt.setString(2, password);
            userStmt.setInt(3, 1);
            int affectedRows = userStmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            // Obtener el ID generado
            generatedKeys = userStmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int userId = generatedKeys.getInt(1);

                // Insertar en la tabla `person` usando el ID del usuario
                String personSql = "INSERT INTO person (nombre, apellido, email, idUser) VALUES (?, ?, ?, ?)";
                PreparedStatement personStmt = connectionDataBase.prepareStatement(personSql);
                personStmt.setString(1, name.split(" ")[0]);
                personStmt.setString(2, name.split(" ")[1]);
                personStmt.setString(3, email);
                personStmt.setInt(4, userId);
                personStmt.executeUpdate();
                return 1;
            } else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        } catch (SQLException e) {
        }
        return 2;
    }

    public static int user_and_password(String user, String password) {
        try {
            ResultSet rs = connectionDataBase.prepareStatement("SELECT * FROM user WHERE user.user='" + user + "' AND user.password='" + password + "';").executeQuery();
            while (rs.next()) {
                if (rs.getString("user").equalsIgnoreCase(user)) {
                    return 1;
                }
            }
            return 2;
        } catch (SQLException ex) {
            return 3;
        }
    }
}
