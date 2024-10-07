/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.data.service;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 *
 * @author Jesus Gutierrez
 */
public interface ApiVerification {

    @GET("/")
    Call<Void> connectionVerification();
}