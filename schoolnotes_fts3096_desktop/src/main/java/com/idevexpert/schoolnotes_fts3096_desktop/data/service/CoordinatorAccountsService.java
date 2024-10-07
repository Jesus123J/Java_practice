package com.idevexpert.schoolnotes_fts3096_desktop.data.service;


import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.CoordinatorEditAccountWithStatusRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorAccountListResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorEditAccountWithStatusResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/*
 * @author YANPIER
 */
public interface CoordinatorAccountsService {
    
    @GET("api/coordinator/accounts/account-list")
    @Headers("Content-Type: application/json")
    Call<CoordinatorAccountListResponse> accountList (@Header("Authorization") String authorizationHeader);
    
    @POST("api/coordinator/accounts/edit-account")
    @Headers("Content-Type: application/json")
    Call<CoordinatorEditAccountWithStatusResponse>editAccountWithStatus(@Header("Authorization") String authorizationHeader, @Body CoordinatorEditAccountWithStatusRequest coordinatorEditAccountWithStatusRequest);
    
    
}
