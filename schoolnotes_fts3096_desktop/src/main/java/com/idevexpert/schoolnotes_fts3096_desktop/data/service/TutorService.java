/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.data.service;


import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.TutorAssignedProxyByStudentRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.TutorCloseCaseRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.TutorCompleteCaseInformationRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.TutorAssignedProxyByStudentResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.TutorCloseCaseResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.TutorCompleteCaseInformationResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.TutorListAssignedStudentsResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.TutorListCaseResponse;
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
public interface TutorService {

    @GET("api/tutor/students/list-assigned-students")
    @Headers("Content-Type: application/json")
    Call<TutorListAssignedStudentsResponse> listAssignedStudents(@Header("Authorization") String token);

    @POST("api/tutor/students/student/assigned-proxy-by-student")
    @Headers("Content-Type: application/json")
    Call<TutorAssignedProxyByStudentResponse> assignedProxyByStudent(@Header("Authorization") String token, @Body TutorAssignedProxyByStudentRequest assignedProxyByStudentRequest);

    @GET("api/tutor/case/list")
    @Headers("Content-Type: application/json")
    Call<TutorListCaseResponse> caseList(@Header("Authorization") String token);

    @POST("api/tutor/case/complete-case-information")
    @Headers("Content-Type: application/json")
    Call<TutorCompleteCaseInformationResponse> completeCaseInformation(@Header("Authorization") String token, @Body TutorCompleteCaseInformationRequest tutorCompleteCaseInformationRequest);

    @POST("api/tutor/case/close-case")
    @Headers("Content-Type: application/json")
    Call<TutorCloseCaseResponse>closeCaseTutor(@Header("Authorization") String token, @Body TutorCloseCaseRequest closeCaseRequest);

}
