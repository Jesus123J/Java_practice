/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.managementwarehousestore.data.dao;

import com.idevexpert.managementwarehousestore.data.ConnectionDataBase;
import com.idevexpert.managementwarehousestore.data.dao.daoImpl.PersonDao;
import com.idevexpert.managementwarehousestore.data.dto.PersonDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesus Gutierrez
 */
public class PersonDaoImpl implements ConnectionDataBase, PersonDao {

    Connection connection = connectionSqlServer;

    @Override
    public int insert(PersonDto person) {
        String sql = "INSERT INTO person (name, lastName, Telefono) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, person.getName());
            stmt.setString(2, person.getLastName());
            stmt.setString(3, person.getTelefono());
            stmt.executeUpdate();
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            } catch (Exception e) {
                System.out.println("Insert " + e.getMessage());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void update(PersonDto person) {
        String sql = "UPDATE person SET name = ?, lastName = ?, Telefono = ? WHERE idperson = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, person.getName());
            stmt.setString(2, person.getLastName());
            stmt.setString(3, person.getTelefono());
            stmt.setInt(4, person.getIdperson());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int personId) {
        String sql = "DELETE FROM person WHERE idperson = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, personId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PersonDto getById(int personId) {
        String sql = "SELECT * FROM person WHERE idperson = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, personId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extractPersonFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<PersonDto> getAll() {
        List<PersonDto> persons = new ArrayList<>();
        String sql = "SELECT * FROM person";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                persons.add(extractPersonFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    private PersonDto extractPersonFromResultSet(ResultSet rs) throws SQLException {
        PersonDto person = new PersonDto();
        person.setIdperson(rs.getInt("idperson"));
        person.setName(rs.getString("name"));
        person.setLastName(rs.getString("lastName"));
        person.setTelefono(rs.getString("Telefono"));
        return person;
    }
}
