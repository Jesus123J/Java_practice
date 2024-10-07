/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.managementwarehousestore.data.dto;

/**
 *
 * @author Jesus Gutierrez
 */
public class PersonDto {
    private String name;
    private String lastName;
    private String telefono;
    private int idperson;

    public PersonDto() {
    }
    
    public PersonDto(String name, String lastName, String telefono) {
        this.name = name;
        this.lastName = lastName;
        this.telefono = telefono;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

  
    public int getIdperson() {
        return idperson;
    }

    public void setIdperson(int idperson) {
        this.idperson = idperson;
    }
    
    
}
