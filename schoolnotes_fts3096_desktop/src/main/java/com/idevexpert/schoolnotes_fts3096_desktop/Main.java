/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop;

import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.idevexpert.schoolnotes_fts3096_desktop.controller.ControllerLogin;
import com.idevexpert.schoolnotes_fts3096_desktop.utlis.ColorUtil;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author Jesus Gutierrez
 */
public class Main {

    private static ControllerLogin controllerLogin;

    public static void main(String[] args) {
       UIManager.put("ScrollBar.thumb", new ColorUIResource(ColorUtil.kPrimaryGreenDark));
        FlatMacDarkLaf.setup();
        System.out.println("Opening application");
        controllerLogin = new ControllerLogin();
        System.out.println("finish process");
    }
}
