/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.managementwarehousestore.data.dao;

import com.idevexpert.managementwarehousestore.data.ConnectionDataBase;
import com.idevexpert.managementwarehousestore.data.dao.daoImpl.ProductDao;
import com.idevexpert.managementwarehousestore.data.dto.ProductDto;
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
public class ProductDaoImpl implements ConnectionDataBase, ProductDao {

    Connection connection = connectionSqlServer;

    @Override
    public void insert(ProductDto product) {
        String sql = "INSERT INTO product (nombre, cantidad, precio, description, idCategoria) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, product.getNombre());
            stmt.setInt(2, product.getCantidad());
            stmt.setDouble(3, product.getPrecio());
            stmt.setString(4, product.getDescription());
            stmt.setInt(5, product.getIdCategoria());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(ProductDto product) {
        String sql = "UPDATE product SET nombre = ?, cantidad = ?, precio = ?, description = ?, idCategoria = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, product.getNombre());
            stmt.setInt(2, product.getCantidad());
            stmt.setDouble(3, product.getPrecio());
            stmt.setString(4, product.getDescription());
            stmt.setInt(5, product.getIdCategoria());
            stmt.setInt(6, product.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int productId) {
        String sql = "DELETE FROM product WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, productId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ProductDto getById(int productId) {
        String sql = "SELECT * FROM product WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, productId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extractProductFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ProductDto> getAll() {
        List<ProductDto> products = new ArrayList<>();
        String sql = "SELECT * FROM product";
        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                products.add(extractProductFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    private ProductDto extractProductFromResultSet(ResultSet rs) throws SQLException {
        ProductDto product = new ProductDto();
        product.setId(rs.getInt("id"));
        product.setNombre(rs.getString("nombre"));
        product.setCantidad(rs.getInt("cantidad"));
        product.setPrecio(rs.getDouble("precio"));
        product.setDescription(rs.getString("description"));
        product.setIdCategoria(rs.getInt("idCategoria"));
        return product;
    }

}
