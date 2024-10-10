/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.model;

import com.idevexpert.schoolnotes_fts3096_desktop.controller.ControllerCoordinator;
import com.idevexpert.schoolnotes_fts3096_desktop.controller.ControllerTeacher;
import com.idevexpert.schoolnotes_fts3096_desktop.controller.ControllerTutor;
import com.idevexpert.schoolnotes_fts3096_desktop.data.api.WebSocketClient;
import com.idevexpert.schoolnotes_fts3096_desktop.data.dao.LoginDao;
import com.idevexpert.schoolnotes_fts3096_desktop.utlis.LockFile;
import com.idevexpert.schoolnotes_fts3096_desktop.utlis.LodingJpanel;
import com.idevexpert.schoolnotes_fts3096_desktop.utlis.MethodUtil;
import com.idevexpert.schoolnotes_fts3096_desktop.view.JframeMain;
import com.idevexpert.schoolnotes_fts3096_desktop.view.coordinator.additionalComponent.CreateAccountPerson;
import com.idevexpert.schoolnotes_fts3096_desktop.view.login.LoginJPanel;
import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import raven.popup.DefaultOption;
import raven.popup.GlassPanePopup;
import raven.popup.component.SimplePopupBorder;
import raven.popup.component.SimplePopupBorderOption;

/**
 *
 * @author Jesus Gutierrez
 */
public class LoginModel extends LoginDao {

    protected JframeMain jFrameMain;
    protected LoginJPanel loginJPanel;
    private String[] dataAccount;

    public LoginModel() {
        loginJPanel = new LoginJPanel();
        init();
        WebSocketClient webSocketClient = new WebSocketClient(jFrameMain);
        webSocketClient.start();
        webSocketClient.sendMessage("Hola desde la app de escritorio");
    }

    public void cleanComponentsAlert() {
        loginJPanel.textField1.setHelperText("");
        loginJPanel.passwordField1.setHelperText("");
        loginJPanel.jLabel2.setText("");
    }

    protected void accountVerification() {
        jFrameMain.setEnabled(false);
        loginJPanel.button1.setText("");
        loginJPanel.button1.setIcon(iconGif);
        Thread thread = new Thread(
                new Runnable() {
            @Override
            public void run() {
                dataAccount = accountVerification(loginJPanel.textField1, loginJPanel.passwordField1, loginJPanel, jFrameMain);
                if (dataAccount == null) {
                    return;
                }
                switch (dataAccount[0]) {
                    case "COORDINADOR":
                        new ControllerCoordinator(dataAccount[1], jFrameMain);
                        break;
                    case "PROFESOR":
                        new ControllerTeacher(dataAccount[1], jFrameMain);
                        break;
                    case "TUTOR":
                        new ControllerTutor(dataAccount[1], jFrameMain);
                        break;
                }
            }
        }
        );
        thread.start();
    }

    public void init() {
        if (LockFile.checkLockFile()) {
            System.out.println("file alredy exists");
            System.exit(0);
        }
        LockFile.createLockFile();
        LockFile.startLockFileMonitor();
        jFrameMain = new JframeMain();
        jFrameMain.setSize(800, 600);
        jFrameMain.setMinimumSize(new Dimension(800, 600));
        GlassPanePopup.showPopup(new SimplePopupBorder(loginJPanel, null, new SimplePopupBorderOption()
                .setRoundBorder(30)
                .setWidth(300)), new DefaultOption() {
            @Override
            public boolean closeWhenPressedEsc() {
                return false;
            }
            

        });
        jFrameMain.revalidate();
        jFrameMain.repaint();
        jFrameMain.toFront();
        jFrameMain.setLocationRelativeTo(null);
        jFrameMain.setVisible(true);

    }
}
