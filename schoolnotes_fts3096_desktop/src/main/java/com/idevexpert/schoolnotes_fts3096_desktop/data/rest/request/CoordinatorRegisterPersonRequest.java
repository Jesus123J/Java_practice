/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request;

import lombok.Data;

@Data
public class CoordinatorRegisterPersonRequest {
    private String name;
    private String lastname;
    private String motherLastname;
    private String dni;
    private String mail;
    private String cellphone;
    private String phone;
    private String address;
    private String birthdate;
    private String sex;

}