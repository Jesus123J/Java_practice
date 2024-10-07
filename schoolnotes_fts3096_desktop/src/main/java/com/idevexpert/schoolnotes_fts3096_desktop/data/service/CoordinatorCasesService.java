/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.data.service;


import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.CoordinatorCloseCaseRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.CoordinatorCompleteCaseInformationRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.CoordinatorDeriveTutorCaseRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorCloseCaseResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorCompleteCaseInformationResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorDeriveTeacherCaseRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorDeriveTeacherCaseResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorDeriveTutorCaseResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorListCaseResponse;
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
public interface CoordinatorCasesService {

    @GET("api/coordinator/case/list")
    @Headers("Content-Type: application/json")
    Call<CoordinatorListCaseResponse> listCase(@Header("Authorization") String authorizationHeader);

    @POST("api/coordinator/case/complete-case-information")
    @Headers("Content-Type: application/json")
    Call<CoordinatorCompleteCaseInformationResponse> completeCaseInformation(@Header("Authorization") String authorization, @Body CoordinatorCompleteCaseInformationRequest completeCaseInformationRequest);

    @POST("api/coordinator/case/derive-teacher")
    @Headers("Content-Type: application/json")
    Call<CoordinatorDeriveTeacherCaseResponse>deriveTeacherCase(@Header("Authorization") String authorization , @Body CoordinatorDeriveTeacherCaseRequest deriveTeacherCaseRequest);

   @POST("api/coordinator/case/derive-tutor")
   @Headers("Content-Type: application/json")
   Call<CoordinatorDeriveTutorCaseResponse>deriveTutorCase(@Header("Authorization") String authorization  , @Body CoordinatorDeriveTutorCaseRequest deriveTutorCaseRequest);
   
   @POST("api/coordinator/case/close-case")
   @Headers("Content-Type: application/json")
   Call<CoordinatorCloseCaseResponse>closeCase(@Header("Authorization") String authorization  , @Body CoordinatorCloseCaseRequest closeCaseRequest);
}
