/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.data.service;


import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.CoordinatorAssingStudentByProxyRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.CoordinatorDesAssingStudentByProxyRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.CoordinatorStudentsAssignedByProxyRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorAssingStudentByProxyResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorDesAssingStudentByProxyResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorListPersonProxyResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorStudentsAssignedByProxyResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorStudentsAvailableProxyResponse;
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
public interface CoordinatorProxyService {
    
    @GET("api/coordinator/proxy/list-person-proxy")
    @Headers("Content-Type: application/json")
    Call<CoordinatorListPersonProxyResponse> listPersonProxy(@Header("Authorization") String authorizationHeader);

    @POST("api/coordinator/proxy/assign-student-by-proxy")
    @Headers("Content-Type: application/json")
    Call<CoordinatorAssingStudentByProxyResponse> assingStudentByProxy(@Header("Authorization") String authorizationHeader, @Body CoordinatorAssingStudentByProxyRequest coordinatorAssingStudentByProxyRequest);
    
    @POST("api/coordinator/proxy/desassign-student-by-proxy")
    @Headers("Content-Type: application/json")
    Call<CoordinatorDesAssingStudentByProxyResponse> desassingStudentByProxy(@Header("Authorization") String authorizationHeader, @Body CoordinatorDesAssingStudentByProxyRequest coordinatorDesAssingStudentByProxyRequest);
    
    @POST("api/coordinator/proxy/students-assigned-by-proxy")
    @Headers("Content-Type: application/json")
    Call<CoordinatorStudentsAssignedByProxyResponse> studentsAssignedByProxy(@Header("Authorization") String authorizationHeader, @Body CoordinatorStudentsAssignedByProxyRequest coordinatorStudentsAssignedByProxyRequest);
    
    @GET("api/coordinator/proxy/students-available-proxy")
    @Headers("Content-Type: application/json")
    Call<CoordinatorStudentsAvailableProxyResponse>studentsAvailableProxy(@Header("Authorization") String authorizationHeader);
}
