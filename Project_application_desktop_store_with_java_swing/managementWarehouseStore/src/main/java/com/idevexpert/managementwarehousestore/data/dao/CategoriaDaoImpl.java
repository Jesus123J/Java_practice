/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.managementwarehousestore.data.dao;

import com.idevexpert.managementwarehousestore.data.ConnectionDataBase;
import com.idevexpert.managementwarehousestore.data.dao.daoImpl.CategoriaDao;
import com.idevexpert.managementwarehousestore.data.dto.CategoriaDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus Gutierrez
 */
public class CategoriaDaoImpl implements CategoriaDao, ConnectionDataBase {
    Connection connection = connectionSqlServer;
    @Override
    public int insert(CategoriaDto categoria) {
        String sql = "INSERT INTO categoria (tipo, material, descripcion) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, categoria.getTipo());
            stmt.setString(2, categoria.getMaterial());
            stmt.setString(3, categoria.getDescripcion());
            stmt.executeUpdate();
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void update(CategoriaDto categoria) {
        String sql = "UPDATE categoria SET tipo = ?, material = ?, descripcion = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, categoria.getTipo());
            stmt.setString(2, categoria.getMaterial());
            stmt.setString(3, categoria.getDescripcion());
            stmt.setInt(4, categoria.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM categoria WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se elimino el dato", "", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            if (e.getErrorCode() == 1451) { // MySQL error code for foreign key constraint violation
                JOptionPane.showMessageDialog(null, "No se puede Elimanar porque esta siendo utlizada la categoria", "", JOptionPane.INFORMATION_MESSAGE);
            } else {
                e.printStackTrace();
            }
        }
    }

    @Override
    public CategoriaDto getById(int id) {
        String sql = "SELECT * FROM categoria WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extractCategoriaFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CategoriaDto> getAll() {
        List<CategoriaDto> categorias = new ArrayList<>();
        String sql = "SELECT * FROM categoria";
        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                categorias.add(extractCategoriaFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categorias;
    }

    private CategoriaDto extractCategoriaFromResultSet(ResultSet rs) throws SQLException {
        CategoriaDto categoria = new CategoriaDto();
        categoria.setId(rs.getInt("id"));
        categoria.setTipo(rs.getString("tipo"));
        categoria.setMaterial(rs.getString("material"));
        categoria.setDescripcion(rs.getString("descripcion"));
        return categoria;
    }

}
