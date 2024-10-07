/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.idevexpert.managementwarehousestore.data.dao.daoImpl;

/**
 *
 * @author Jesus Gutierrez
 */
import com.idevexpert.managementwarehousestore.data.dto.ClientDto;
import java.util.List;

public interface ClientDao {

    void insert(ClientDto client);

    void update(ClientDto client);

    void delete(int clientId);

    ClientDto getById(int clientId);

    List<ClientDto> getAll();
}
