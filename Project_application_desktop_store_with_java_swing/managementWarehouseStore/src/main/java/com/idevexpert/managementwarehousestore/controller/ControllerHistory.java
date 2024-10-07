/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.managementwarehousestore.controller;

import com.idevexpert.managementwarehousestore.model.ModelHistory;
import com.idevexpert.managementwarehousestore.view.administrator.JinternalJframeHistory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;

/**
 *
 * @author Jesus Gutierrez
 */
public class ControllerHistory extends ModelHistory implements ActionListener{

    
    public ControllerHistory(JinternalJframeHistory jinternalJframeHistory){
        this.jinternalJframeHistory = jinternalJframeHistory;
        init();   
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.jinternalJframeHistory.jButton1)){
            if(this.jinternalJframeHistory.jFormattedTextField1.getFormatter() == null){
                return;
            }
            getInternalHistory();
        }
    }

    JInternalFrame getInternalHistory() {
        return this.jinternalJframeHistory;
    }
 
}
