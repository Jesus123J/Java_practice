/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.data.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonStudentWithAgeDto {

    private Long personId;
    private String name;
    private String lastname;
    private String motherLastname;
    private String dni;
    private String mail;
    private String cellphone;
    private String phone;
    private String address;
    private String birthdate;
    private Integer age;
    private String sex;

}
