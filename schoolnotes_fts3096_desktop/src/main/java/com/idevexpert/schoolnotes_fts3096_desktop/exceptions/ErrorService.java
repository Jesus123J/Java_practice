/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.exceptions;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus Gutierrez
 */
public class ErrorService extends IOException {

    public ErrorService(String messenger, Integer typeMessenger) {
        super(messenger);
        if (typeMessenger == null) {
            JOptionPane.showMessageDialog(null, messenger);
        }
        JOptionPane.showMessageDialog(null, messenger, "", typeMessenger);

    }
}
