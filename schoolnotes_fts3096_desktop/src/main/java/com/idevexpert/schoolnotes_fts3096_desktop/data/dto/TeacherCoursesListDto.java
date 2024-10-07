/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.data.dto;
import lombok.Data;
//AccountDao
@Data
public class TeacherCoursesListDto {

    private Integer courseId;
    private String courseCode;
    private String courseName;
    private Integer sectionId;
    private String sectionName;
    private Long   courseTeacherId;

}

