/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.idevexpert.managementwarehousestore.data.dao.daoImpl;

/**
 *
 * @author Jesus Gutierrez
 */
import com.idevexpert.managementwarehousestore.data.dto.UserDto;
import java.util.List;

public interface UserDao {

    void insert(UserDto user);

    void update(UserDto user);

    void delete(int userId);

    UserDto getById(int userId);

    UserDto getByIdPerson(int userId);

    List<UserDto> getAll();

    UserDto getByUsername(String username);
}
