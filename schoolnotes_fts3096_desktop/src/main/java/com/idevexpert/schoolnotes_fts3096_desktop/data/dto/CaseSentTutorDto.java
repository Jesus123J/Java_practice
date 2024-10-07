/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.data.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CaseSentTutorDto {

    private Long idRecordSituation;
    private Long idStudentCourseTeacher;
    private String accountTypeName;
    private String studentFullName;
    private String situationTypeName;
    private String createTime;
    private String courseName;
    private String sectionName;
    private String teacherFullName;
    private String noteTypeName;
    private Double value;
    private String situationDescription;
    private String nameSituationStatus;
    private Double studentQualification;

}
