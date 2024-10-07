package com.idevexpert.schoolnotes_fts3096_desktop.data.dto;

import lombok.Builder;
import lombok.Data;

/*
@author YANPIER
 */
@Data
@Builder
public class StudentsAssignedProxyDto {

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
    private String sex ;
    private Long accountId;
    private String studentCode;
    private Integer amountCourses;

}