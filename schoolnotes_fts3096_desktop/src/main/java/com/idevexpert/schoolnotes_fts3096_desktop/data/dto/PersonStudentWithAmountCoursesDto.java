/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.data.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonStudentWithAmountCoursesDto {

    private Long studentPersonId;
    private String code;
    private String name;
    private String lastname;
    private String motherLastname;
    private Integer amountCourses;
    private Long studentAccountId;

}
