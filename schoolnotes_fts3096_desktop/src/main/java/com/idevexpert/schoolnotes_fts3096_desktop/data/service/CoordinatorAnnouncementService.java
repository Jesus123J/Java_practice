/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.data.service;


import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.CoordinatorSendAnnouncementRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorCountDeviceResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorSendAnnouncementResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 *
 * @author Terminal G
 */
public interface CoordinatorAnnouncementService {
    //  /coordinator/announcement/send

    @POST("api/coordinator/announcement/send")
    @Headers("Content-Type: application/json")
    Call<CoordinatorSendAnnouncementResponse> sendAnnouncement(@Header("Authorization") String authorizationHeader, @Body  CoordinatorSendAnnouncementRequest sendAnnouncementRequest);

    @GET("api/coordinator/announcement/count-device")
    @Headers("Content-Type: application/json")
    Call<CoordinatorCountDeviceResponse> countDevice(@Header("Authorization") String authorizationHeader);

}
