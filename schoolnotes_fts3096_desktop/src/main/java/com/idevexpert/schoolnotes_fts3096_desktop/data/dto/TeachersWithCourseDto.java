/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.data.dto;

import lombok.Data;

//PersonDao
@Data
public class TeachersWithCourseDto {

    private Long idPerson;
    private Long idAccount;
    private String code;
    private String name;
    private String lastname;
    private String motherLastname;
    private String mail;
    private String username;
    private Integer amountCourses;

}
