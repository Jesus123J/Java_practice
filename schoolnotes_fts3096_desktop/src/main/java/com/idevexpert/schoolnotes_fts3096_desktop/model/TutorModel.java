/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.model;

import com.idevexpert.schoolnotes_fts3096_desktop.data.dao.TutorDao;
import com.idevexpert.schoolnotes_fts3096_desktop.view.JframeMain;

/**
 *
 * @author Jesus Gutierrez
 */
public class TutorModel extends  TutorDao{
    private String token;
    public JframeMain jframeMain;
    public TutorModel(String token,JframeMain jframeMain) {
        this.token = token;
        this.jframeMain = jframeMain;
    }
    
    
}
