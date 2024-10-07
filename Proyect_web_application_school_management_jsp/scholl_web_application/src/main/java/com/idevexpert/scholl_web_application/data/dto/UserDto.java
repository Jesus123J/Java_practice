/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.scholl_web_application.data.dto;

/**
 *
 * @author Jesus Gutierrez
 */
public class UserDto {
    private int idUser;
    private String user;
    private String password;
    private int idTypeRol;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdTypeRol() {
        return idTypeRol;
    }

    public void setIdTypeRol(int idTypeRol) {
        this.idTypeRol = idTypeRol;
    }
}
