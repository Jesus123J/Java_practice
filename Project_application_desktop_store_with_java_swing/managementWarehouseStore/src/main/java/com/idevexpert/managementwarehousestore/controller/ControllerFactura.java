/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.managementwarehousestore.controller;

import com.idevexpert.managementwarehousestore.model.ModelBill;
import com.idevexpert.managementwarehousestore.utils.JpanelDarkUtil;
import com.idevexpert.managementwarehousestore.view.administrator.JinternalJframeBill;
import com.idevexpert.managementwarehousestore.view.login.JframeLogin;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jesus Gutierrez
 */
public class ControllerFactura extends ModelBill implements ActionListener {

    public ControllerFactura( JinternalJframeBill jinternalJframeBill,JframeLogin jframeLogin, JpanelDarkUtil jpanelDarkUtil) {
        this.jpanelDarkUtil = jpanelDarkUtil;
        this.jframeLogin = jframeLogin;
        this.jinternalJframeBill = jinternalJframeBill;
        init();
        this.jinternalJframeBill.jButton3.addActionListener(this);
        this.jinternalJframeBill.jButton2.addActionListener(this);
        this.jinternalJframeBill.jButton4.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.jinternalJframeBill.jButton3)) {
            insertData();
        }
        if (e.getSource().equals(this.jinternalJframeBill.jButton2)) {
            deleteData();
        }
        if (e.getSource().equals(this.jinternalJframeBill.jButton4)) {
            generarReportImprit();
//            try {
//                Desktop.getDesktop().open(new File("//src/Reportes/Reporte_EmisionGuiaNet.pdf"));
//            } catch (IOException ex) {
//                Logger.getLogger(ControllerFactura.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
    }
}
