/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.data.service;


import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.TeacherListNoteTypesByCourseRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.TeacherNoteStudentRegisterRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.TeacherListNoteTypesByCourseResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.TeacherNoteStudentRegisterResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 *
 * @author YANPIER
 */
public interface TeacherUploadNotesService {
    
    @POST("api/teacher/notes/note-student-register")
    @Headers("Content-Type: application/json")
    Call<TeacherNoteStudentRegisterResponse> noteStudentRegisterResponse(@Header("Authorization") String authorizationHeader, @Body TeacherNoteStudentRegisterRequest teacherNoteStudentRegisterRequest);

    @POST("api/teacher/notes/list-note-types-by-course")
    @Headers("Content-Type: application/json")
    Call<TeacherListNoteTypesByCourseResponse> listNoteTypesByCourse(@Header("Authorization") String authorizationHeader, @Body TeacherListNoteTypesByCourseRequest teacherNoteStudentRegisterRequest);

}
