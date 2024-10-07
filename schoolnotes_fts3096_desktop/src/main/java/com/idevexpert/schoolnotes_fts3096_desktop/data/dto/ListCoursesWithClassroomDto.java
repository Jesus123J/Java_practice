package com.idevexpert.schoolnotes_fts3096_desktop.data.dto;

import lombok.Data;

/*
@author YANPIER
 */
@Data
public class ListCoursesWithClassroomDto {

    private Long idCourseTeacher;
    private Long idCourse;
    private String codeCourse;
    private String nameCourse;
    private Long idSection;
    private String codeSection;
}