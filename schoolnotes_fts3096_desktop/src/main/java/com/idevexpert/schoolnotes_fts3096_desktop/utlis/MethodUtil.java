/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.utlis;

import com.idevexpert.schoolnotes_fts3096_desktop.controller.ControllerCoordinator;
import com.idevexpert.schoolnotes_fts3096_desktop.data.dto.AccountByPersonListDto;
import com.idevexpert.schoolnotes_fts3096_desktop.data.dto.PersonDto;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorAccountsByPersonListResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.CoordinatorPeopleListResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.view.coordinator.additionalComponent.GlassPaneLogin;
import java.awt.Component;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import raven.popup.GlassPanePopup;

import raven.popup.component.SimplePopupBorder;

//import raven.glasspanepopup.DefaultOption;
//import raven.glasspanepopup.GlassPanePopup;
/**
 *
 * @author Jesus Gutierrez
 */
public abstract class MethodUtil {

    private static ControllerCoordinator controllerCoordinator; // Referencia al controlador

    public static void setControllerCoordinator(ControllerCoordinator controller) {
        controllerCoordinator = controller; // Asignar la referencia
    }

    public static void onMouseClick(JComponent component) {
        if (controllerCoordinator != null) {
            controllerCoordinator.handleMouseClick(component); // Llamar al método en ControllerCoordinator
        }
    }

    public static void clearRowTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        table.setModel(model);
    }

    public static void insertDataTable(Object dataInstance, JTable jTable) {
        DefaultTableModel modelTable = (DefaultTableModel) jTable.getModel();
        modelTable.setRowCount(0);
        if (dataInstance instanceof CoordinatorPeopleListResponse) {
            CoordinatorPeopleListResponse coordinatorPeopleListResponse = (CoordinatorPeopleListResponse) dataInstance;
            if (coordinatorPeopleListResponse.getListPerson() == null) {
                return;
            }
            for (PersonDto personDto : coordinatorPeopleListResponse.getListPerson()) {
                modelTable.addRow(new Object[]{
                    personDto.getName(),
                    personDto.getLastname(),
                    personDto.getMotherLastname(),
                    personDto.getDni(),
                    personDto.getMail(),
                    personDto.getCellphone(),
                    personDto.getPhone(),
                    personDto.getAddress(),
                    personDto.getAge(),
                    personDto.getSex()});
            }
            jTable.setModel(modelTable);
        } else if (dataInstance instanceof CoordinatorAccountsByPersonListResponse) {
            CoordinatorAccountsByPersonListResponse coordinatorAccountsByPersonListResponse = (CoordinatorAccountsByPersonListResponse) dataInstance;
            if (coordinatorAccountsByPersonListResponse.getAccountsList() == null) {
                return;
            }
            for (AccountByPersonListDto accountByPersonListDto : coordinatorAccountsByPersonListResponse.getAccountsList()) {
                modelTable.addRow(new Object[]{
                    accountByPersonListDto.getCode(),
                    accountByPersonListDto.getUsername(),
                    accountByPersonListDto.getAccountTypeName(),
                    // 1 account desbloc   and  9 account bloc
                    accountByPersonListDto.getStatus() == 1 ? "DESBLOQUIADO" : "BLOQUIADO"
                });
            }
        }
    }

    // To use this method you first have to initialize the jframe with "GlassPanePopup.install(jframeMain)"
    public static void centerComponent(JComponent component, Integer[] locationComponent, int blockBackground) {
        GlassPanePopup.showPopup(new GlassPaneLogin(component));
//        if (locationComponent == null) {
//            if (blockBackground == 1) {
//                GlassPanePopup.showPopup(component);
//            } else {
//                GlassPanePopup.showPopup(component, new DefaultOption() {
//                    @Override
//                    public boolean blockBackground() {
//                        return false;
//                    }
//                });
//            }
//
//        } else {
//            if (blockBackground == 1) {
//                GlassPanePopup.showPopup(component, new DefaultOption() {
//
//                    @Override
//                    public String getLayout(Component parent, float animate) {
//                        Point p1 = parent.getLocation();
//                        Point b1 = component.getLocation();
//                        int x = b1.x + p1.x + 5;
//                        int y = b1.y + p1.y + 25;
////                        int x = b1.x + p1.x  + 10 ;
////                        int y = b1.y + p1.y - 5;
//                        y += (1f - animate) * -10f;
//                        return "pos " + x + "px " + y + "px";
//                    }
//                });
//            } else {
//                GlassPanePopup.showPopup(component, new DefaultOption() {
//                    @Override
//                    public boolean blockBackground() {
//                        return false;
//                    }
//
//                    @Override
//                    public String getLayout(Component parent, float animate) {
//                        Point p1 = parent.getLocation();
//                        Point b1 = component.getLocation();
//                        int x = b1.x + p1.x + 5;
//                        int y = b1.y + p1.y + 25;
////                        int x = b1.x + p1.x  + 10 ;
////                        int y = b1.y + p1.y - 5;
//                        y += (1f - animate) * -10f;
//                        return "pos " + x + "px " + y + "px";
//                    }
//                });
//            }
//        }
    }

    public static void settingPhoto(String resurces, JLabel component) {
        int width = component.getWidth();
        int higth = component.getHeight();
        ImageIcon icon = new ImageIcon(MethodUtil.class.getResource(resurces));
        Image image = icon.getImage().getScaledInstance(width, higth, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        component.setIcon(icon);
    }
}
