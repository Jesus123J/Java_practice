/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.data.dao;

import com.idevexpert.schoolnotes_fts3096_desktop.controller.ControllerTeacher;
import com.idevexpert.schoolnotes_fts3096_desktop.data.api.Api;
import com.idevexpert.schoolnotes_fts3096_desktop.data.service.TeacherCases;
import com.idevexpert.schoolnotes_fts3096_desktop.data.service.TeacherCoursesService;
import com.idevexpert.schoolnotes_fts3096_desktop.data.service.TeacherUploadNotesService;

/**
 *
 * @author Jesus Gutierrez
 */
public class TeacherDao {

    private Api api;

    public TeacherDao() {
        api = new Api(TeacherCases.class,
                TeacherCoursesService.class,
                TeacherUploadNotesService.class);
    }

    protected void listCase(ControllerTeacher controllerTeacher) {

    }

    protected void completeCaseInformation(ControllerTeacher controllerTeacher) {

    }

    protected void assingHomework(ControllerTeacher controllerTeacher) {

    }

    protected void qualificationHomework(ControllerTeacher controllerTeacher) {

    }

    protected void closeCase(ControllerTeacher controllerTeacher) {

    }

    protected void listCoursesWithClassroomResponse(ControllerTeacher controllerTeacher) {

    }

    protected void listStudentsResponse(ControllerTeacher controllerTeacher) {

    }

    protected void noteStudentRegisterResponse(ControllerTeacher controllerTeacher) {

    }

    protected void listNoteTypesByCourse(ControllerTeacher controllerTeacher) {

    }

}
