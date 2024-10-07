/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.managementwarehousestore.controller;

import com.idevexpert.managementwarehousestore.model.ModelAdministrator;
import com.idevexpert.managementwarehousestore.utils.JpanelDarkUtil;
import com.idevexpert.managementwarehousestore.view.login.JframeLogin;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus Gutierrez
 */
public class ControllerAdministrator extends ModelAdministrator implements ActionListener {

    public ControllerAdministrator(JframeLogin jframeLogin, JpanelDarkUtil jpanelDarkUtil) {
        this.jpanelDarkUtil = jpanelDarkUtil;
        this.jframeLogin = jframeLogin;
        this.jframeLogin.toFront();
        jinternalJframeClient.jButton3.addActionListener(this);
        jinternalJframeUser.jButton3.addActionListener(this);
        jinternalJframeCategory.jButton3.addActionListener(this);
        jinternalJframeProduct.jButton3.addActionListener(this);

        jframeLogin.jMenu1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Se preciona");
                ControllerUser controllerUser = new ControllerUser(jinternalJframeUser, jdialogUser);
                updateComponent(controllerUser.getInternalJframe());

            }
        });
        jframeLogin.jMenu2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ControllerProduct controllerProduct = new ControllerProduct(jinternalJframeProduct, jdialogProduct);
                updateComponent(controllerProduct.getJinternalJframeProduct());
            }
        });
        jframeLogin.jMenu3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ControllerClient controllerClient = new ControllerClient(jinternalJframeClient, jdialogClient);
                updateComponent(controllerClient.getJinternalJframeClient());
            }
        });
        jframeLogin.jMenu4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ControllerCategory controllerCategory = new ControllerCategory(jinternalJframeCategory, jdialogCategory);
                updateComponent(controllerCategory.getJinternalJframeCategoria());
            }
        });
        jframeLogin.jMenu5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ControllerFactura controllerFactura = new ControllerFactura(jinternalJframeBill, jframeLogin , jpanelDarkUtil);
                updateComponent(controllerFactura.getIternalFactura());
            }
        });
       
        jframeLogin.jMenu7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ControllerHistory controllerHistory = new ControllerHistory(jinternalJframeHistory);
                updateComponent(controllerHistory.getInternalHistory());
            }
        });
        jframeLogin.jMenu8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int option = JOptionPane.showConfirmDialog(jframeLogin, "Desea Cerrar sesíon ? ", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (option == 0) {
                    System.exit(0);
                }
            }
        });
        init();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e.getSource().equals(jinternalJframeUser.jButton3)) {
//            jdialogUser.setLocationRelativeTo(jframeLogin);
//            jdialogUser.setVisible(true);
//        }
//        if (e.getSource().equals(jinternalJframeClient.jButton3)) {
//            jdialogClient.setLocationRelativeTo(jframeLogin);
//            jdialogClient.setVisible(true);
//        }
//        if (e.getSource().equals(jinternalJframeProduct.jButton3)) {
//            jdialogProduct.setLocationRelativeTo(jframeLogin);
//            jdialogProduct.setVisible(true);
//        }
//        if (e.getSource().equals(jinternalJframeCategory.jButton3)) {
//            jdialogCategory.setLocationRelativeTo(jframeLogin);
//            jdialogCategory.setVisible(true);
//        }
    }

    private void updateComponent(JInternalFrame internalFrame) {
        System.out.println("Se actuliza component");

        int x = (jpanelJdesktopBody.jDesktopPane1.getWidth() / 2) - internalFrame.getWidth() / 2;
        int y = (jpanelJdesktopBody.jDesktopPane1.getHeight() / 2) - internalFrame.getHeight() / 2;

        if (internalFrame.isShowing()) {
            internalFrame.setLocation(x, y);
        } else {
            jpanelJdesktopBody.jDesktopPane1.add(internalFrame);
            internalFrame.setLocation(x, y);
            internalFrame.show();
            internalFrame.setVisible(true);
            internalFrame.toFront();
        }
    }

}
