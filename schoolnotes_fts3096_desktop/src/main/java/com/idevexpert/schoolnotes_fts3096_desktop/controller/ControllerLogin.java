/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.controller;

import com.idevexpert.schoolnotes_fts3096_desktop.model.LoginModel;
import com.idevexpert.schoolnotes_fts3096_desktop.utlis.LockFile;
import com.idevexpert.schoolnotes_fts3096_desktop.view.JframeMain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author Jesus Gutierrez
 */
public class ControllerLogin extends LoginModel implements ActionListener, KeyListener {

    public ControllerLogin() {
       
        loginJPanel.button1.addActionListener(this);
        loginJPanel.passwordField1.addKeyListener(this);
        loginJPanel.textField1.addKeyListener(this);
        jFrameMain.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                LockFile.deletedfile();
            }

            @Override
            public void windowClosed(WindowEvent e) {
                LockFile.deletedfile();
            }
        });
        loginJPanel.button1.doClick();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(loginJPanel.button1)) {
            accountVerification();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource().equals(loginJPanel.textField1)) {
            cleanComponentsAlert();
        }
        if (e.getSource().equals(loginJPanel.passwordField1)) {
            cleanComponentsAlert();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
