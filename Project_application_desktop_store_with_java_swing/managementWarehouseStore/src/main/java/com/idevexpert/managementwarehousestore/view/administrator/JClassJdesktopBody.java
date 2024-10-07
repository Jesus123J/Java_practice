/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.managementwarehousestore.view.administrator;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JDesktopPane;

/**
 *
 * @author Jesus Gutierrez
 */
public class JClassJdesktopBody extends JDesktopPane {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(11, 51, 60)); // Color de fondo personalizado
        g.fillRect(0, 0, getWidth(), getHeight());
    }

}
