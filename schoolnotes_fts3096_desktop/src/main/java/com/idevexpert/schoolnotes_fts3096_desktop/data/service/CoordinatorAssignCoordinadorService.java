/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.data.service;

import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.CoordinatorAssingStudentByCoordinatorRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.CoordinatorDesAssingStudentByCoordinatorRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorAssingStudentByCoordinatorResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorDesAssingStudentByCoordinatorResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorStudentsAssignedToTheCoordinatorResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorStudentsAvailableCoordinatorResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 *
 * @author Jesus Gutierrez
 */
public interface CoordinatorAssignCoordinadorService {

    @GET("api/coordinator/student-assignment/students-available-coordinator")
    @Headers("Content-Type: application/json")
    Call<CoordinatorStudentsAvailableCoordinatorResponse> studentsAvailableCoordinator(@Header("Authorization") String token);

    @GET("api/coordinator/student-assignment/students-assigned-to-the-coordinator")
   @Headers("Content-Type: application/json")
    Call<CoordinatorStudentsAssignedToTheCoordinatorResponse> studentsAssignedToTheCoordinator(@Header("Authorization") String token);

    @POST("api/coordinator/student-assignment/assign-student-by-coordinator")
   @Headers("Content-Type: application/json")
    Call<CoordinatorAssingStudentByCoordinatorResponse> assignStudentByCoordinator(@Header("Authorization") String token, @Body CoordinatorAssingStudentByCoordinatorRequest assingStudentByCoordinatorRequest);

    @POST("api/coordinator/student-assignment/desassign-student-by-coordinator")
    @Headers("Content-Type: application/json")
    Call<CoordinatorDesAssingStudentByCoordinatorResponse> desAssignStudentByCoordinator(@Header("Authorization") String token, @Body CoordinatorDesAssingStudentByCoordinatorRequest desAssingStudentByCoordinatorRequest);

}
