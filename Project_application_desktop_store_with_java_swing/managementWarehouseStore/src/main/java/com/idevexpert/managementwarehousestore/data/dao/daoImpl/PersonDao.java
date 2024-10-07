/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.idevexpert.managementwarehousestore.data.dao.daoImpl;

/**
 *
 * @author Jesus Gutierrez
 */
import com.idevexpert.managementwarehousestore.data.dto.PersonDto;
import java.util.List;

public interface PersonDao {

    int insert(PersonDto person);

    void update(PersonDto person);

    void delete(int personId);

    PersonDto getById(int personId);

    List<PersonDto> getAll();
}
