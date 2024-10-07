/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.view;

import com.idevexpert.schoolnotes_fts3096_desktop.utlis.ColorUtil;
import com.idevexpert.schoolnotes_fts3096_desktop.view.coordinator.additionalComponent.MyDraweCoordinatorComponent;
import java.awt.Image;
import javax.swing.ImageIcon;
import raven.drawer.Drawer;
import raven.popup.GlassPanePopup;
import raven.toast.Notifications;

/**
 *
 * @author Jesus Gutierrez
 */
public class JframeMain extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public JframeMain() {
        //  getRootPane().putClientProperty(FlatClientProperties.FULL_WINDOW_CONTENT, true);
        GlassPanePopup.install(this);
        Notifications.getInstance().setJFrame(this);
        initComponents();
        //toggleButton1 = new ToggleButton(this);
        badgeButton1.setBackground(ColorUtil.kPrimaryTransparent);
        actionButton3.setToolTipText("PERFIL");
        actionButton2.setToolTipText("INICIO");
        badgeButton1.setToolTipText("CASOS");
        jPanel3.setBackground(ColorUtil.kPrimaryGreenDark);
        ImageIcon icon = new ImageIcon(getClass().getResource("/logo_school_login.png"));
        Image image = icon.getImage();
        setIconImage(image);
        setTitle("FRANZ TAMAYO SOLARES");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        actionButton3 = new com.idevexpert.schoolnotes_fts3096_desktop.utlis.ActionButton();
        panelRound1 = new com.idevexpert.schoolnotes_fts3096_desktop.utlis.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        badgeButton1 = new com.idevexpert.schoolnotes_fts3096_desktop.view.BadgeButton();
        actionButton2 = new com.idevexpert.schoolnotes_fts3096_desktop.utlis.ActionButton();
        toggleButton1 = new toggle.ToggleButton(this);
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        actionButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/header/menu.png"))); // NOI18N
        actionButton3.setToolTipText("");
        actionButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        actionButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionButton3ActionPerformed(evt);
            }
        });

        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setRoundTopLeft(20);
        panelRound1.setRoundTopRight(20);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        badgeButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/header/notificacion.png"))); // NOI18N
        badgeButton1.setHideActionText(true);
        badgeButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                badgeButton1ActionPerformed(evt);
            }
        });

        actionButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/header/menuHome.png"))); // NOI18N
        actionButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionButton2ActionPerformed(evt);
            }
        });

        toggleButton1.setForeground(new java.awt.Color(0, 0, 0));
        toggleButton1.setSelected(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(actionButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 455, Short.MAX_VALUE)
                .addComponent(badgeButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(actionButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(actionButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(actionButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(badgeButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(toggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel4.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void badgeButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_badgeButton1ActionPerformed
//        MessageAlerts.getInstance().showMessage("", "Hola");
//public void show(Type type, Location location, long duration, String message) {
        Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_RIGHT, 2000, "Hola");
    }//GEN-LAST:event_badgeButton1ActionPerformed

    private void actionButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_actionButton2ActionPerformed

    private void actionButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionButton3ActionPerformed
        Drawer.getInstance().showDrawer();
    }//GEN-LAST:event_actionButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public com.idevexpert.schoolnotes_fts3096_desktop.utlis.ActionButton actionButton2;
    public com.idevexpert.schoolnotes_fts3096_desktop.utlis.ActionButton actionButton3;
    public com.idevexpert.schoolnotes_fts3096_desktop.view.BadgeButton badgeButton1;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel4;
    private com.idevexpert.schoolnotes_fts3096_desktop.utlis.PanelRound panelRound1;
    private toggle.ToggleButton toggleButton1;
    // End of variables declaration//GEN-END:variables
}
