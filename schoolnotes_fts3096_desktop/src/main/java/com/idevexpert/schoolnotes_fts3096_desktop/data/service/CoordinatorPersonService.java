/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.data.service;


import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.CoordinatorAccountsByPersonListRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.CoordinatorEditAccountWithoutStatusRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.CoordinatorEditPersonDataRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.CoordinatorEditStatusRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.CoordinatorListAvailableAccountTypesRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.CoordinatorRegisterAccountRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.CoordinatorRegisterPersonRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorAccountsByPersonListResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorEditAccountWithoutStatusResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorEditPersonDataResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorEditStatusResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorListAvailableAccountTypesResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorPeopleListResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorRegisterAccountResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorRegisterPersonResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
//import retrofit2.http.POST;

/**
 *
 * @author Terminal G
 */
public interface CoordinatorPersonService {

    @POST("api/coordinator/people/account/accounts-by-person-list")
    @Headers("Content-Type: application/json")
    Call<CoordinatorAccountsByPersonListResponse> listAccountByPerson(@Header("Authorization") String authorizationHeader, @Body CoordinatorAccountsByPersonListRequest coordinatorAccountsByPersonListRequest);

    @GET("api/coordinator/people/person/list")
    @Headers("Content-Type: application/json") // Asegúrate de ajustar el encabezado según sea necesario
    Call<CoordinatorPeopleListResponse> personList(@Header("Authorization") String authorizationHeader);

    @POST("api/coordinator/people/person/register")
    @Headers("Content-Type: application/json")
    Call<CoordinatorRegisterPersonResponse> coordinatorRegister(@Header("Authorization") String authorizationHeader, @Body CoordinatorRegisterPersonRequest coordinatorRegisterPersonRequest);

    @POST("api/coordinator/people/person/edit")
    @Headers("Content-Type: application/json")
    Call<CoordinatorEditPersonDataResponse> coordinatorEdit(@Header("Authorization") String authorizationHeader, @Body CoordinatorEditPersonDataRequest coordinatorEditPersonDataRequest);

    
    //
    @POST("api/coordinator/people/account/register-account/list-available-account-types")
    @Headers("Content-Type: application/json")
    Call<CoordinatorListAvailableAccountTypesResponse> listAvailableAccountTypes(@Header("Authorization") String authorization, @Body CoordinatorListAvailableAccountTypesRequest coordinatorListAvailableAccountTypesRequest);

    @POST("api/coordinator/people/account/edit-account-without-status")
    @Headers("Content-Type: application/json")
    Call<CoordinatorEditAccountWithoutStatusResponse> edtiAccountWithoutStatus(@Header("Authorization") String authorization, @Body CoordinatorEditAccountWithoutStatusRequest editAccountWithStatusRequest);
      /**********************/
    @POST("api/coordinator/people/account/register-account")
    @Headers("Content-Type: application/json")
    Call<CoordinatorRegisterAccountResponse>registerAccount(@Header("Authorization") String authorizationHeader,@Body CoordinatorRegisterAccountRequest coordinatorRegisterAccountRequest);
    /*************************************/
    
    @POST("api/coordinator/people/account/edit-status")
    @Headers("Content-Type: application/json")
    Call<CoordinatorEditStatusResponse>editStatus(@Header("Authorization") String authorizationHeader,@Body CoordinatorEditStatusRequest editStatusRequest );
 

}
