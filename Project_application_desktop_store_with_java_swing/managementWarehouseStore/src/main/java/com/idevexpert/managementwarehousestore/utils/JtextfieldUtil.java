/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.managementwarehousestore.utils;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author Jesus Gutierrez
 */
public class JtextfieldUtil extends JTextField {

    LineBorder lineBorder = new LineBorder(Color.BLACK, 1);
    EmptyBorder emptyBorder = new EmptyBorder(5, 10, 5, 10);
    CompoundBorder compoundBorder = new CompoundBorder(lineBorder, emptyBorder);

    public JtextfieldUtil() {
        setForeground(Color.WHITE);
        setOpaque(false);
        setBorder(compoundBorder);
    }

}
