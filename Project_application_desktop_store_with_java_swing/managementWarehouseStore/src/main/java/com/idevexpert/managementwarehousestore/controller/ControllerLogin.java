/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.managementwarehousestore.controller;

import com.idevexpert.managementwarehousestore.data.ConnectionDb;
import com.idevexpert.managementwarehousestore.model.ModelLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Jesus Gutierrez
 */
public class ControllerLogin extends ModelLogin implements ActionListener, DocumentListener {

    public ControllerLogin() {
        
        if (ConnectionDb.connectionMySQL() == null || ConnectionDb.connectionSQLServer() == null) {
            System.out.println("I entered the login view");
            init();
            JOptionPane.showMessageDialog(jframeLogin, "Se produjo un error en la conexion con la base de datos", "Error de Conexion", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        } else {
            System.out.println("I entered the login view");
            jpanelCentralLogin.jButton1.addActionListener(this);
            jpanelCentralLogin.jPasswordField1.getDocument().addDocumentListener(this);
            jpanelCentralLogin.jtextfieldUtil1.getDocument().addDocumentListener(this);
            init();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(jpanelCentralLogin.jButton1)) {
            awaitComponentEnter();
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        if (jpanelCentralLogin.jtextfieldUtil1.getDocument().equals(e)) {
            jpanelCentralLogin.jLabel4.setText("");
        }
        if (jpanelCentralLogin.jPasswordField1.getDocument().equals(e)) {
            jpanelCentralLogin.jLabel4.setText("");
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        if (jpanelCentralLogin.jtextfieldUtil1.getDocument().equals(e)) {
            jpanelCentralLogin.jLabel4.setText("");
        }
        if (jpanelCentralLogin.jPasswordField1.getDocument().equals(e)) {
            jpanelCentralLogin.jLabel4.setText("");
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }

}
