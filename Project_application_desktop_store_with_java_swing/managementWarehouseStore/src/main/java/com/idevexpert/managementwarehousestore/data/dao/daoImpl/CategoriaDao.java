/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.idevexpert.managementwarehousestore.data.dao.daoImpl;

import com.idevexpert.managementwarehousestore.data.dto.CategoriaDto;
import java.util.List;

/**
 *
 * @author Jesus Gutierrez
 */
public interface CategoriaDao {
    int insert(CategoriaDto categoria);
    void update(CategoriaDto categoria);
    void delete(int id);
    CategoriaDto getById(int id);
    List<CategoriaDto> getAll();
}
