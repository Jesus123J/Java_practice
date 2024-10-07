/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.managementwarehousestore.model;

import com.idevexpert.managementwarehousestore.utils.JpanelDarkUtil;
import com.idevexpert.managementwarehousestore.view.administrator.JinternalJframeBill;
import com.idevexpert.managementwarehousestore.view.administrator.JinternalJframeCategory;
import com.idevexpert.managementwarehousestore.view.administrator.JinternalJframeClient;
import com.idevexpert.managementwarehousestore.view.administrator.JinternalJframeHistory;
import com.idevexpert.managementwarehousestore.view.administrator.JinternalJframeProduct;
import com.idevexpert.managementwarehousestore.view.administrator.JinternalJframeUser;
import com.idevexpert.managementwarehousestore.view.administrator.JpanelJdesktopBody;
import com.idevexpert.managementwarehousestore.view.administrator.componentJdialog.JdialogCategory;
import com.idevexpert.managementwarehousestore.view.administrator.componentJdialog.JdialogClient;
import com.idevexpert.managementwarehousestore.view.administrator.componentJdialog.JdialogProduct;
import com.idevexpert.managementwarehousestore.view.administrator.componentJdialog.JdialogUser;
import com.idevexpert.managementwarehousestore.view.login.JframeLogin;
import java.awt.Color;
import javax.swing.JLayeredPane;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Jesus Gutierrez
 */
public  class ModelAdministrator {

    protected JinternalJframeBill jinternalJframeBill = new JinternalJframeBill();
    protected JinternalJframeClient jinternalJframeClient = new JinternalJframeClient();
    protected JinternalJframeCategory jinternalJframeCategory = new JinternalJframeCategory();
    protected JinternalJframeProduct jinternalJframeProduct = new JinternalJframeProduct();
    protected JinternalJframeUser jinternalJframeUser = new JinternalJframeUser();
    protected JinternalJframeHistory jinternalJframeHistory = new JinternalJframeHistory();
    protected JpanelDarkUtil jpanelDarkUtil;
    protected JpanelJdesktopBody jpanelJdesktopBody = new JpanelJdesktopBody();

    protected JdialogUser jdialogUser;
    protected JdialogCategory jdialogCategory;
    protected JdialogClient jdialogClient;
    protected JdialogProduct jdialogProduct;

    protected JframeLogin jframeLogin;
    private MigLayout migLayout;

    public void init() {
        jdialogCategory = new JdialogCategory(jframeLogin, true);
        jdialogClient = new JdialogClient(jframeLogin, true);
        jdialogProduct = new JdialogProduct(jframeLogin, true);
        jdialogUser = new JdialogUser(jframeLogin, true);
        
        migLayout = new MigLayout("fill, insets 0");
        jframeLogin.jLayeredPane1.setLayer(jpanelJdesktopBody, JLayeredPane.DEFAULT_LAYER);
        jframeLogin.jLayeredPane1.add(jpanelJdesktopBody, "pos 0 0 100% 100%");
        jpanelJdesktopBody.setBackground(Color.red);
        jframeLogin.setEnabled(true);
        jframeLogin.jMenuBar1.setVisible(true);
    }

}
