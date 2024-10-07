/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.scholl_web_application.data.dto;

/**
 *
 * @author Jesus Gutierrez
 */
public class PagosDto {
    private int idPagos;
    private String valor;
    private String description;
    private int idUser;

    public PagosDto(int idPagos, String valor, String description, int idUser) {
        this.idPagos = idPagos;
        this.valor = valor;
        this.description = description;
        this.idUser = idUser;
    }

    public int getIdPagos() {
        return idPagos;
    }

    public void setIdPagos(int idPagos) {
        this.idPagos = idPagos;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }


}
