/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.managementwarehousestore.model;

import com.idevexpert.managementwarehousestore.controller.ControllerAdministrator;
import com.idevexpert.managementwarehousestore.data.ConnectionDb;
import com.idevexpert.managementwarehousestore.data.dao.UserDaoImpl;
import com.idevexpert.managementwarehousestore.data.dao.daoImpl.UserDao;
import com.idevexpert.managementwarehousestore.utils.JframeLoading;
//import com.idevexpert.managementwarehousestore.data.dbQueries.LoginService;
import com.idevexpert.managementwarehousestore.utils.JpanelDarkUtil;
import com.idevexpert.managementwarehousestore.view.administrator.JpanelJdesktopBody;
import com.idevexpert.managementwarehousestore.view.login.JframeLogin;
import com.idevexpert.managementwarehousestore.view.login.component.JpanelCentralLogin;
import java.awt.Color;
import java.awt.Insets;
import java.sql.Connection;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import net.miginfocom.swing.MigLayout;

public class ModelLogin {

    protected ConnectionDb connectionDb = new ConnectionDb();
    protected JpanelCentralLogin jpanelCentralLogin = new JpanelCentralLogin();
    protected JframeLogin jframeLogin = new JframeLogin();
    protected JpanelDarkUtil jpanelDarkUtil = new JpanelDarkUtil();
    private final UserDao userDao = new UserDaoImpl();
    private ControllerAdministrator controllerAdministrator;
    private final MigLayout layout = new MigLayout("fill, insets 0");

    public void init() {
        jframeLogin.jLayeredPane1.setLayout(layout);
        jframeLogin.setBackground(Color.WHITE);
        jpanelDarkUtil.add(jpanelCentralLogin);
        jframeLogin.jLayeredPane1.setLayer(jpanelDarkUtil, JLayeredPane.PALETTE_LAYER);
        jframeLogin.jLayeredPane1.add(jpanelDarkUtil, "pos 0 0 100% 100%");
        jframeLogin.setSize(1200, 800);
        jframeLogin.jMenuBar1.setVisible(false);
        jframeLogin.setLocationRelativeTo(null);
        jframeLogin.setVisible(true);
    }
    JframeLoading jframeLoading = new JframeLoading();

    public void awaitComponentEnter() {
        jframeLoading.setVisible(true);
        
        new Thread(() -> {
            if (new String(jpanelCentralLogin.jPasswordField1.getPassword()).isBlank() || jpanelCentralLogin.jtextfieldUtil1.getText().isBlank()) {
                jframeLoading.setVisible(false);
                JOptionPane.showMessageDialog(null, "llene los campus");
                return;
            }
            try {
                if (userDao.getByUsername(jpanelCentralLogin.jtextfieldUtil1.getText()).getPassword().equalsIgnoreCase(new String(jpanelCentralLogin.jPasswordField1.getPassword()))) {
                    jframeLogin.setEnabled(false);
                    jpanelDarkUtil.setVisible(false);
                    System.out.println("I entered the coordiantor view");
                    jframeLoading.setVisible(false);
                    controllerAdministrator = new ControllerAdministrator(jframeLogin, jpanelDarkUtil);
                } else {
                    jframeLoading.setVisible(false);
                    jpanelCentralLogin.jLabel4.setText("Datos incorrectos inténtalo de nuevo");
                }
            } catch (Exception e) {
                jframeLoading.setVisible(false);
                jpanelCentralLogin.jLabel4.setText("Datos incorrectos inténtalo de nuevo");
            }
        }).start();
    }
}
