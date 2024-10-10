/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.controller;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.idevexpert.schoolnotes_fts3096_desktop.exceptions.ErrorService;
import com.idevexpert.schoolnotes_fts3096_desktop.model.CoordinatorModel;
import com.idevexpert.schoolnotes_fts3096_desktop.utlis.ColorUtil;
import com.idevexpert.schoolnotes_fts3096_desktop.utlis.MethodUtil;
import com.idevexpert.schoolnotes_fts3096_desktop.utlis.MyDrawerListener;
import com.idevexpert.schoolnotes_fts3096_desktop.view.JframeMain;
import com.idevexpert.schoolnotes_fts3096_desktop.view.coordinator.CoordinatorPersonJpanel;
import com.idevexpert.schoolnotes_fts3096_desktop.view.coordinator.additionalComponent.CreateAccountPerson;
import com.idevexpert.schoolnotes_fts3096_desktop.view.coordinator.additionalComponent.EditAccountPerson;
import com.idevexpert.schoolnotes_fts3096_desktop.view.coordinator.additionalComponent.MyDraweCoordinatorComponent;
import com.idevexpert.schoolnotes_fts3096_desktop.view.coordinator.additionalComponent.TableActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import raven.alerts.SimpleAlerts;
import raven.drawer.Drawer;
import raven.popup.DefaultOption;
import raven.popup.GlassPanePopup;
import raven.popup.GlassPopup;
import raven.popup.component.GlassPaneChild;
import raven.popup.component.SimplePopupBorder;
import raven.popup.component.SimplePopupBorderOption;

/**
 *
 * @author Jesus Gutierrez
 */
public class ControllerCoordinator extends CoordinatorModel implements
        ActionListener, DocumentListener, MouseListener, TableActionEvent, MyDrawerListener,
        ListSelectionListener {

    public ControllerCoordinator(String token, JframeMain jframeMain) {

        super(token, jframeMain);
        // MethodUtil.setControllerCoordinator(this);
        Drawer.getInstance().setDrawerBuilder(new MyDraweCoordinatorComponent("jose", "pedro", this));
        System.out.println("entering coordinator panel");

        //Interface customized
        super.coordinatorPersonJpanel = new CoordinatorPersonJpanel(this);

        //main button actions
        jframeMain.actionButton2.addActionListener(this);

        //Action listener
        jframeMain.actionButton3.addActionListener(this);
        jframeMain.actionButton2.addActionListener(this);

        //Document listener
        coordinatorPersonJpanel.textFieldPersonSearch.getDocument().addDocumentListener(this);
        coordinatorPersonJpanel.textFieldPhone.getDocument().addDocumentListener(this);
        coordinatorPersonJpanel.textFieldDni.getDocument().addDocumentListener(this);
        coordinatorPersonJpanel.textFieldMotherLastName.getDocument().addDocumentListener(this);
        coordinatorPersonJpanel.textFieldLastName.getDocument().addDocumentListener(this);
        coordinatorPersonJpanel.textFieldName.getDocument().addDocumentListener(this);

        //Mouse listener
        jframeMain.actionButton3.addActionListener(this);
        coordinatorPersonJpanel.jCheckBoxMen.addActionListener(this);
        coordinatorPersonJpanel.jCheckBoxWomen.addActionListener(this);

        coordinatorPersonJpanel.jTableDataPerson.getSelectionModel().addListSelectionListener(this);
        coordinatorPersonJpanel.jTableDataAccount.getSelectionModel().addListSelectionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //people dashboard action buttons
        //header action buttons
//        if (e.getSource().equals(jframeMain.actionButton1)) {
//            eventActionActionButton1();
//        }
        if (e.getSource().equals(jframeMain.actionButton3)) {
            Drawer.getInstance().showDrawer();
        }
        if (e.getSource().equals(jframeMain.actionButton2)) {
            insertComponentCenter(coordinatorDashboardJpanel);
        }
        if (e.getSource().equals(coordinatorNotificationJpanel.jButtonPerson)) {
            System.out.println("entering dashboard person");
            insertDataTablePerson();
            // insertComponentCenter(coordinatorPersonJpanel);
        }
        if (e.getSource().equals(coordinatorNotificationJpanel.jButtonAttendance)) {
            insertComponentCenter(coordinatorAttendanceJpanel);
        }
        if (e.getSource().equals(coordinatorNotificationJpanel.jButtonAnnouncement)) {
            insertComponentCenter(coordinatorAnnouncementJpanel);
        }
        if (e.getSource().equals(coordinatorNotificationJpanel.jButtonTeacher)) {
            insertComponentCenter(coordinatorTeacherJpanel);
        }
        if (e.getSource().equals(coordinatorNotificationJpanel.jButtonTutor)) {
            insertComponentCenter(coordinatorTutorJpanel);
        }
        if (e.getSource().equals(coordinatorNotificationJpanel.jButtonAccounr)) {
            //insertComponentCenter();
        }
        if (e.getSource().equals(coordinatorPersonJpanel.buttonCreateAccount)) {
            accountGlassPaneCreate();
        }
        if (e.getSource().equals(coordinatorPersonJpanel.buttonEditOrRegister)) {

        }

        if (e.getSource().equals(coordinatorNotificationJpanel.jButtonProxy)) {
            insertComponentCenter(coordinatorProxyJpanel);
        }
        if (e.getSource().equals(coordinatorPersonJpanel.jCheckBoxMen)) {
            coordinatorPersonJpanel.jCheckBoxWomen.setSelected(false);
            coordinatorPersonJpanel.jCheckBoxMen.setSelected(true);
        }
        if (e.getSource().equals(coordinatorPersonJpanel.jCheckBoxWomen)) {
            coordinatorPersonJpanel.jCheckBoxMen.setSelected(false);
            coordinatorPersonJpanel.jCheckBoxWomen.setSelected(true);
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        if (e.getDocument().equals(coordinatorPersonJpanel.textFieldPersonSearch.getDocument())) {
            searchDataTablePerson();
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        if (e.getDocument().equals(coordinatorPersonJpanel.textFieldPersonSearch.getDocument())) {
            searchDataTablePerson();
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        if (e.getSource().equals(coordinatorPersonJpanel.jTableDataPerson)) {
//            if (coordinatorPersonJpanel.jTableDataPerson.getSelectedRow() >= 0) {
//               
//            }
//        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

//        if (e.getSource().equals(coordinatorPersonJpanel.jTableDataPerson)) {
//            if (coordinatorPersonJpanel.jTableDataPerson.getSelectedRow() >= 0) {
//                System.out.println("Se mantenio precionado el mouse");
//                listTypeTempOrLinearForTablePerson();
//            }
//        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        if (e.getSource().equals(coordinatorPersonJpanel.jTableDataPerson)) {
//            if (coordinatorPersonJpanel.jTableDataPerson.getSelectedRow() >= 0) {
//                listTypeTempOrLinearForTablePerson();
//                SwingUtilities.updateComponentTreeUI(coordinatorPersonJpanel.jTableDataAccount);
//                jframeMain.revalidate();
//                jframeMain.repaint();
//            }
//        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource().equals(coordinatorNotificationJpanel.jButtonPerson)) {
            coordinatorNotificationJpanel.jPanelPerson.setBackground(ColorUtil.kPrimaryGray);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(coordinatorNotificationJpanel.jButtonPerson)) {
            coordinatorNotificationJpanel.jPanelPerson.setBackground(ColorUtil.kPrimaryWhite);
        }
    }

    //Dashboard person account action button
    @Override
    public void onAction(int row, int typeButton) {
        switch (typeButton) {
            case 1:
                System.out.println("Block");
                break;
            case 2:  //Edit
                GlassPanePopup.showPopup(new SimplePopupBorder(new CreateAccountPerson(), null, new SimplePopupBorderOption()
                        .setRoundBorder(30)
                        .setWidth(500)));

                System.out.println(GlassPanePopup.isShowing("Edit glass"));
                break;
            case 3:
                System.out.println("Edit");
                break;
        }
    }

    @Override
    public void index(int[] index) {
        switch (index[0]) {
            case 0:
                insertCopyDataTablePerson(null, 0);
                insertDataTablePerson();
                break;
            case 1:
                try {
                    switch (index[1]) {
                        case 0:
                            System.out.println("Profesor");
                            break;
                    }
                } catch (Exception e) {
                }

                break;
        }

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getSource().equals(coordinatorPersonJpanel.jTableDataPerson.getSelectionModel())) {
            if (!e.getValueIsAdjusting()) {
                if (coordinatorPersonJpanel.jTableDataPerson.getSelectedRow() >= 0) {
                    System.out.println("se hiso click");
                    listTypeTempOrLinearForTablePerson();
                }
            }
        }
    }

    public void handleMouseClick(JComponent component) {
        GlassPanePopup.closePopup(component);
    }
}
