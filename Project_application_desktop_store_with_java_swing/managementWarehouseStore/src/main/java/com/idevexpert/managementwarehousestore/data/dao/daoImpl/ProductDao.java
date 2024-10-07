/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.idevexpert.managementwarehousestore.data.dao.daoImpl;

/**
 *
 * @author Jesus Gutierrez
 */
import com.idevexpert.managementwarehousestore.data.dto.ProductDto;
import java.util.List;

public interface ProductDao {

    void insert(ProductDto product);

    void update(ProductDto product);

    void delete(int productId);

    ProductDto getById(int productId);

    List<ProductDto> getAll();
}
