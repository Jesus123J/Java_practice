/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.data.service;


import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.CoordinatorAssingStudentByTutorRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.CoordinatorDesAssingStudentByTutorRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.CoordinatorStudentsAssignedByTutorRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorAssingStudentByTutorResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorDesAssingStudentByTutorResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorListPersonTutorResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorStudentsAssignedByTutorResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorStudentsAvailableTutorResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 *
 * @author YANPIER
 */
public interface CoordinatorTutorService {

    @GET("api/coordinator/tutor/list-person-tutor")
    @Headers("Content-Type: application/json")
    Call<CoordinatorListPersonTutorResponse> listPersonTutor(@Header("Authorization") String authorizationHeader);

    @POST("api/coordinator/tutor/assign-student-by-tutor")
    @Headers("Content-Type: application/json")
    Call<CoordinatorAssingStudentByTutorResponse> assingStudentByTutor(@Header("Authorization") String authorizationHeader, @Body CoordinatorAssingStudentByTutorRequest coordinatorAssingStudentByTutorRequest);

    @POST("api/coordinator/tutor/desassign-student-by-tutor")
    @Headers("Content-Type: application/json")
    Call<CoordinatorDesAssingStudentByTutorResponse> desAssingStudentByTutor(@Header("Authorization") String authorizationHeader, @Body CoordinatorDesAssingStudentByTutorRequest coordinatorDesAssingStudentByTutorRequest);

    @POST("api/coordinator/tutor/students-assigned-by-tutor")
    @Headers("Content-Type: application/json")
    Call<CoordinatorStudentsAssignedByTutorResponse> studentsAssignedByTutor(@Header("Authorization") String authorizationHeader, @Body CoordinatorStudentsAssignedByTutorRequest coordinatorStudentsAssignedByTutorRequest);
    
    @GET("api/coordinator/tutor/students-available-tutor")
    @Headers("Content-Type: application/json")
    Call<CoordinatorStudentsAvailableTutorResponse>studentsAvailableTutor(@Header("Authorization") String authorizationHeader);
}
