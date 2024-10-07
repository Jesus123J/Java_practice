/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.data.service;


import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorAlertsForCoordinatorResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorSummaryForCoordinatorResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

/**
 *
 * @author YANPIER
 */
public interface CoodinatorSummaryService {
    
    @GET("api/coordinator/summary/information")
    @Headers("Content-Type: application/json")
    Call<CoordinatorSummaryForCoordinatorResponse> summaryForCoordinator (@Header("Authorization") String authorizationHeader);
    
    @GET("api/coordinator/summary/alerts")
    @Headers("Content-Type: application/json")
    Call<CoordinatorAlertsForCoordinatorResponse> alertsForCoordinator (@Header("Authorization") String authorizationHeader);
    
    
    
}
