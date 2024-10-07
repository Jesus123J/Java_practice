/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.view.coordinator.additionalComponent;

/**
 *
 * @author Jesus Gutierrez
 */
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.idevexpert.schoolnotes_fts3096_desktop.utlis.ColorUtil;
import com.idevexpert.schoolnotes_fts3096_desktop.utlis.MethodUtil;
import java.awt.Component;
import java.lang.reflect.Method;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableActionCellEditor extends DefaultCellEditor {

    private TableActionEvent event;

    public TableActionCellEditor(TableActionEvent event) {
        super(new JCheckBox());
        this.event = event;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {

        ButtonStateAccountPerson action = new ButtonStateAccountPerson();
        if (FlatMacDarkLaf.isLafDark()) {
            action.setBorder(BorderFactory.createLineBorder(ColorUtil.kPrimaryWhite, 1));
            action.setBackground(ColorUtil.kPrimaryWhite);

        } else {
            action.setBorder(BorderFactory.createLineBorder(ColorUtil.kPrimaryBlack, 1));
            action.setBackground(ColorUtil.kPrimaryGray);
        }
        action.setFocusable(false);
        action.initEvent(event, row);
        jtable.setFocusable(false);
        return action;
    }
}
