/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.data.dao;

import com.idevexpert.schoolnotes_fts3096_desktop.data.api.Api;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.CoordinatorAccountsByPersonListRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorAccountsByPersonListResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorPeopleListResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.service.CoordinatorAccountsService;
import com.idevexpert.schoolnotes_fts3096_desktop.data.service.CoordinatorAnnouncementService;
import com.idevexpert.schoolnotes_fts3096_desktop.data.service.CoordinatorAssignCoordinadorService;
import com.idevexpert.schoolnotes_fts3096_desktop.data.service.CoordinatorCasesService;
import com.idevexpert.schoolnotes_fts3096_desktop.data.service.CoordinatorPersonService;
import com.idevexpert.schoolnotes_fts3096_desktop.data.service.CoordinatorProxyService;
import com.idevexpert.schoolnotes_fts3096_desktop.data.service.CoordinatorTeacherService;
import com.idevexpert.schoolnotes_fts3096_desktop.data.service.CoordinatorTutorService;
import com.idevexpert.schoolnotes_fts3096_desktop.exceptions.ErrorService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import retrofit2.Response;

/**
 *
 * @author Jesus Gutierrez
 */
public class CoordinatorDao {

    private Api api;

    public CoordinatorDao() {
        api = new Api(
                CoordinatorAnnouncementService.class,
                CoordinatorAssignCoordinadorService.class,
                CoordinatorAccountsService.class,
                CoordinatorCasesService.class,
                CoordinatorPersonService.class,
                CoordinatorProxyService.class,
                CoordinatorTeacherService.class,
                CoordinatorTutorService.class);
    }

    protected void announcementSendCoordinato() {
        // .coordinatorAnnouncementJpanel;
    }

    protected void announcementCountDevice() {

    }

    protected void studentsAvailableCoordinator() {

    }

    protected void studentsAssignedToTheCoordinator() {

    }

    protected void assignStudentByCoordinator() {

    }

    protected void desAssignStudentByCoordinator() {

    }

    protected void accountList() {

    }

    protected void editAccountWithStatus() {

    }

    protected void listCase() {

    }

    protected void completeCaseInformation() {

    }

    protected void deriveTeacherCase() {

    }

    protected void deriveTutorCase() {

    }

    protected void closeCase() {

    }

    protected CoordinatorAccountsByPersonListResponse listAccountByPerson(String token, Long idPerson) {
        CoordinatorAccountsByPersonListRequest coordinatorAccountsByPersonListRequest = new CoordinatorAccountsByPersonListRequest();
        coordinatorAccountsByPersonListRequest.setPersonId(idPerson);
        try {
            return api.getService(CoordinatorPersonService.class).listAccountByPerson(token, coordinatorAccountsByPersonListRequest).execute().body();
        } catch (IOException ex) {
            return null;
        }
    }

    protected CoordinatorPeopleListResponse personList(String token) {
        try {
            return api.getService(CoordinatorPersonService.class).personList(token).execute().body();
        } catch (Exception e) {
            return null;
        }
    }

    protected void coordinatorRegister() {

    }

    protected void coordinatorEdit() {

    }

    protected void listAvailableAccountTypes() {

    }

    protected void edtiAccountWithoutStatus() {

    }

    protected void registerAccount() {

    }

    protected void editStatus() {

    }

    protected void listPersonProxy() {

    }

    protected void assingStudentByProxy() {

    }

    protected void desassingStudentByProxy() {

    }

    protected void studentsAssignedByProxy() {

    }

    protected void studentsAvailableProxy() {

    }

    protected void listTeacherCourse() {

    }

    protected void listTeacherWithCourses() {

    }

    protected void listCoursesToBeAssigned() {

    }

    protected void listSectionsToBeAssigned() {

    }

    protected void assingCoursesByTeacherAccount() {

    }

    protected void desassingCoursesByTeacherAccount() {

    }

    protected void listPersonTutor() {

    }

    protected void assingStudentByTutor() {

    }

    protected void desAssingStudentByTutor() {

    }

    protected void studentsAssignedByTutor() {

    }

    protected void studentsAvailableTutor() {

    }
}
