/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.data.service;


import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.TeacherAssingHomeworkRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.TeacherCloseCaseRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.TeacherCompleteCaseInformationRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.TeacherQualificationHomeworkRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.TeacherAssingHomeworkResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.TeacherCloseCaseResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.TeacherCompleteCaseInformationResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.TeacherListCaseResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.TeacherQualificationHomeworkResponse;
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
public interface TeacherCases {

    @GET("api/teacher/case/list")
    @Headers("Content-Type: application/json")
    Call<TeacherListCaseResponse> listCase(@Header("Authorization") String token);

    @POST("api/teacher/case/complete-case-information")
    @Headers("Content-Type: application/json")
    Call<TeacherCompleteCaseInformationResponse> completeCaseInformation(@Header("Authorization") String token, @Body TeacherCompleteCaseInformationRequest completeCaseInformationRequest);

    @POST("api/teacher/case/assing-homework")
    @Headers("Content-Type: application/json")
    Call<TeacherAssingHomeworkResponse> assingHomework(@Header("Authorization") String token, @Body TeacherAssingHomeworkRequest assingHomeworkRequest);

    @POST("api/teacher/case/qualification-homework")
    @Headers("Content-Type: application/json")
    Call<TeacherQualificationHomeworkResponse> qualificationHomework(@Header("Authorization") String token, @Body TeacherQualificationHomeworkRequest qualificationHomeworkRequest);

    @POST("api/teacher/cases/close-case")
    @Headers("Content-Type: application/json")
    Call<TeacherCloseCaseResponse> closeCase(@Header("Authorization") String token, @Body TeacherCloseCaseRequest closeCaseRequest);

}
