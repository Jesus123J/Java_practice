/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.data.service;


import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.LoginAccountRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.LoginAccountResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 *
 * @author Terminal G
 */
public interface LoginAccountService {
    @POST("api/account/login")
    Call<LoginAccountResponse>loginAccount(@Header("Client") String client, @Body LoginAccountRequest accountLoginRequest);
}
