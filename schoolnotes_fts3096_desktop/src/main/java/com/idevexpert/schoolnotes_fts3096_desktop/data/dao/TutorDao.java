/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.data.dao;

import com.idevexpert.schoolnotes_fts3096_desktop.controller.ControllerTutor;
import com.idevexpert.schoolnotes_fts3096_desktop.data.api.Api;
import com.idevexpert.schoolnotes_fts3096_desktop.data.service.TeacherCases;
import com.idevexpert.schoolnotes_fts3096_desktop.data.service.TeacherCoursesService;
import com.idevexpert.schoolnotes_fts3096_desktop.data.service.TeacherUploadNotesService;
import com.idevexpert.schoolnotes_fts3096_desktop.data.service.TutorService;

/**
 *
 * @author Jesus Gutierrez
 */
public class TutorDao {

    private Api api;

    public TutorDao() {
        api = new Api(TutorService.class);
    }

    protected void listAssignedStudents(ControllerTutor controllerTutor) {

    }

    protected void assignedProxyByStudent(ControllerTutor controllerTutor) {

    }

    protected void caseList(ControllerTutor controllerTutor) {

    }

    protected void completeCaseInformation(ControllerTutor controllerTutor) {

    }

    protected void closeCaseTutor(ControllerTutor controllerTutor) {

    }

}
