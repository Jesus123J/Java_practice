/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.data.dao;

import com.idevexpert.schoolnotes_fts3096_desktop.data.api.Api;
import com.idevexpert.schoolnotes_fts3096_desktop.data.service.ApiVerification;
import java.io.IOException;
import javax.swing.JOptionPane;
import retrofit2.Response;

/**
 *
 * @author Jesus Gutierrez
 */
public class ConnectionDao {
    private Api api;
    public ConnectionDao() {
        api = new Api(ApiVerification.class);
    }

    protected Boolean  verification() {
        try {
            Response<Void> response = api.getService(ApiVerification.class).connectionVerification().execute();
            return response.isSuccessful();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un problema intentalo otra vez","",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            return null;
        }
    }
}
