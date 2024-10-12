/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.view.coordinator;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.idevexpert.schoolnotes_fts3096_desktop.utlis.ColorUtil;
import com.idevexpert.schoolnotes_fts3096_desktop.view.coordinator.additionalComponent.ButtonStateAccountPerson;
import com.idevexpert.schoolnotes_fts3096_desktop.view.coordinator.additionalComponent.TableActionCellEditor;
import com.idevexpert.schoolnotes_fts3096_desktop.view.coordinator.additionalComponent.TableActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import org.apache.commons.lang3.StringUtils;
import raven.datetime.component.date.DatePicker;

/**
 *
 * @author Jesus Gutierrez
 */
public class CoordinatorPersonJpanel extends javax.swing.JPanel {

    private DatePicker datePicker = new DatePicker();

    private TableCellRenderer createCustomRenderer(int positionText) {
        return new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel labelComponent = new JLabel();
                labelComponent.setHorizontalAlignment(positionText);
                Border blackLineBorder = BorderFactory.createLineBorder(FlatMacDarkLaf.isLafDark() ? ColorUtil.kPrimaryGray : ColorUtil.kPrimaryBlack, 1);
                Border marginBorder = BorderFactory.createEmptyBorder(10, 15, 10, 15);
                labelComponent.setBorder(BorderFactory.createCompoundBorder(blackLineBorder, marginBorder));
                labelComponent.setOpaque(true);
                labelComponent.setText(value == null ? "" : value.toString());
                labelComponent.setFont(new Font("bold", Font.PLAIN, 18));
                if (isSelected) {
                    if (FlatMacDarkLaf.isLafDark()) {
                        labelComponent.setForeground(ColorUtil.kPrimaryBlack);
                        labelComponent.setBackground(ColorUtil.kPrimaryWhite);
                    } else {
                        labelComponent.setForeground(ColorUtil.kPrimaryBlack);
                        labelComponent.setBackground(ColorUtil.kPrimaryGray);
                    }
                } else {
                    if (FlatMacDarkLaf.isLafDark()) {
                        labelComponent.setForeground(ColorUtil.kPrimaryWhite);
                        labelComponent.setBackground(ColorUtil.kPrimaryTransparent);
                    } else {
                        labelComponent.setForeground(ColorUtil.kPrimaryBlack);
                        labelComponent.setBackground(ColorUtil.kPrimaryTransparent);
                    }

                }
                return labelComponent;
            }
        };

    }

    private void configureColumn(int index, int minWidth, int positionText, JTable table) {
        table.getTableHeader().getColumnModel().getColumn(index).setCellRenderer(createCustomRenderer(positionText));
        table.getTableHeader().getColumnModel().getColumn(index).setMinWidth(minWidth);
    }

    public CoordinatorPersonJpanel(TableActionEvent event) {
        initComponents();
        datePicker.setEditor(jFormattedTextFieldDate);

        //
        //
        textFieldPersonSearch.setBackground(ColorUtil.kPrimaryTransparent);
        textFieldDni.setBackground(ColorUtil.kPrimaryTransparent);
        textFieldPhone.setBackground(ColorUtil.kPrimaryTransparent);
        textFieldLastName.setBackground(ColorUtil.kPrimaryTransparent);
        textFieldName.setBackground(ColorUtil.kPrimaryTransparent);
        textFieldMotherLastName.setBackground(ColorUtil.kPrimaryTransparent);
        textFieldCellPhone.setBackground(ColorUtil.kPrimaryTransparent);
        textFieldAddress.setBackground(ColorUtil.kPrimaryTransparent);
        textFieldEmail.setBackground(ColorUtil.kPrimaryTransparent);
        //
        //jTableDataAccount.setBackground(ColorUtil.kPrimaryTransparent);
        jTableDataAccount.getTableHeader().setEnabled(false);
        jTableDataPerson.getTableHeader().setEnabled(false);
        jTableDataPerson.getTableHeader().setReorderingAllowed(false);
        jTableDataPerson.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableDataPerson.setFocusable(false);
        jTableDataPerson.getTableHeader().setBackground(ColorUtil.kPrimaryWhite);
        jTableDataPerson.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        //
        jTableDataAccount.getTableHeader().setReorderingAllowed(false);
        jTableDataAccount.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableDataAccount.setFocusable(false);
        jScrollPane2.setFocusable(false);
        jTableDataAccount.getTableHeader().setBackground(ColorUtil.kPrimaryWhite);
        jTableDataAccount.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        jTableDataPerson.getTableHeader().setDefaultRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel labelComponent = new JLabel();
                labelComponent.setHorizontalAlignment(JLabel.CENTER);
                labelComponent.setBorder(BorderFactory.createLineBorder(ColorUtil.kPrimaryGray, 2));
                labelComponent.setOpaque(true);
                labelComponent.setText(value.toString());
                labelComponent.setBackground(ColorUtil.kPrimaryGreenDark);
                labelComponent.setForeground(ColorUtil.kPrimaryWhite);
                labelComponent.setFont(new Font("bold", 2, 18));
                labelComponent.setSize(new Dimension(20, 30));
                return labelComponent;
            }
        }
        );
        jTableDataAccount.getTableHeader().setDefaultRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel labelComponent = new JLabel();
                labelComponent.setHorizontalAlignment(JLabel.CENTER);
                labelComponent.setBorder(BorderFactory.createLineBorder(ColorUtil.kPrimaryGray, 2));
                labelComponent.setOpaque(true);
                labelComponent.setText(value.toString());
                labelComponent.setBackground(ColorUtil.kPrimaryGreenDark);
                labelComponent.setForeground(ColorUtil.kPrimaryWhite);
                labelComponent.setFont(new Font("bold", 2, 18));
                labelComponent.setSize(new Dimension(20, 30));
                return labelComponent;
            }
        }
        );
        //
        jTableDataAccount.getTableHeader().getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                ButtonStateAccountPerson buttonStateAccountPerson = new ButtonStateAccountPerson();
                if (isSelected) {
                    if (FlatMacDarkLaf.isLafDark()) {
                        buttonStateAccountPerson.setBorder(BorderFactory.createLineBorder(ColorUtil.kPrimaryWhite, 1));
                        buttonStateAccountPerson.setBackground(ColorUtil.kPrimaryWhite);

                    } else {
                        buttonStateAccountPerson.setBorder(BorderFactory.createLineBorder(ColorUtil.kPrimaryBlack, 1));
                        buttonStateAccountPerson.setBackground(ColorUtil.kPrimaryGray);
                    }
                } else {
                    if (FlatMacDarkLaf.isLafDark()) {
                        buttonStateAccountPerson.setBorder(BorderFactory.createLineBorder(ColorUtil.kPrimaryWhite, 1));
                        buttonStateAccountPerson.setBackground(ColorUtil.kPrimaryTransparent);
                    } else {
                        buttonStateAccountPerson.setBorder(BorderFactory.createLineBorder(ColorUtil.kPrimaryBlack, 1));
                        buttonStateAccountPerson.setBackground(ColorUtil.kPrimaryTransparent);
                    }

                }
                return buttonStateAccountPerson;
            }
        });

        jTableDataAccount.getTableHeader().getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));
        jTableDataAccount.getTableHeader().getColumnModel().getColumn(4).setMinWidth(300);
        jTableDataAccount.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(300);
        jTableDataAccount.setRowHeight(40);
        for (int i = 0; i < jTableDataAccount.getColumnCount(); i++) {
            switch (i) {
                case 0:
                    //CÓDIGO
                    configureColumn(i, 200, JLabel.LEFT, jTableDataAccount);
                    break;
                case 1:
                    //USUARIO
                    configureColumn(i, 200, JLabel.LEFT, jTableDataAccount);
                    break;
                case 2:
                    //TIPO DE CUENTA
                    configureColumn(i, 200, JLabel.CENTER, jTableDataAccount);
                    break;
                case 3:
                    //ESTADO
                    configureColumn(i, 200, JLabel.CENTER, jTableDataAccount);
                    break;
                case 4:
                    //ACCIÓN
                    break;
            }
        }
        jTableDataPerson.setRowHeight(30);
        for (int i = 0; i < jTableDataPerson.getColumnCount(); i++) {
            switch (i) {
                case 0:
                    //Name
                    configureColumn(i, 200, JLabel.LEFT, jTableDataPerson);
                    break;
                case 1:
                    //LastName
                    configureColumn(i, 350, JLabel.LEFT, jTableDataPerson);
                    break;
                case 2:
                    //MotherLastName
                    configureColumn(i, 350, JLabel.LEFT, jTableDataPerson);
                    break;
                case 3:
                    //Dni
                    configureColumn(i, 150, JLabel.RIGHT, jTableDataPerson);
                    break;
                case 4:
                    //mail
                    configureColumn(i, 350, JLabel.LEFT, jTableDataPerson);
                    break;
                case 5:
                    //cellphone
                    configureColumn(i, 150, JLabel.RIGHT, jTableDataPerson);
                    break;
                case 6:
                    //phone
                    configureColumn(i, 200, JLabel.RIGHT, jTableDataPerson);
                    break;
                case 7:
                    //address
                    configureColumn(i, 350, JLabel.LEFT, jTableDataPerson);
                    break;
                case 8:
                    //age
                    configureColumn(i, 100, JLabel.CENTER, jTableDataPerson);
                    break;
                case 9:
                    //sex
                    configureColumn(i, 100, JLabel.CENTER, jTableDataPerson);
                    break;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDataPerson = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        buttonEditOrRegister = new com.idevexpert.schoolnotes_fts3096_desktop.utlis.Button();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        textFieldPhone = new com.idevexpert.schoolnotes_fts3096_desktop.utlis.TextField();
        textFieldDni = new com.idevexpert.schoolnotes_fts3096_desktop.utlis.TextField();
        textFieldMotherLastName = new com.idevexpert.schoolnotes_fts3096_desktop.utlis.TextField();
        textFieldLastName = new com.idevexpert.schoolnotes_fts3096_desktop.utlis.TextField();
        textFieldName = new com.idevexpert.schoolnotes_fts3096_desktop.utlis.TextField();
        textFieldEmail = new com.idevexpert.schoolnotes_fts3096_desktop.utlis.TextField();
        jFormattedTextFieldDate = new javax.swing.JFormattedTextField();
        textFieldCellPhone = new com.idevexpert.schoolnotes_fts3096_desktop.utlis.TextField();
        textFieldAddress = new com.idevexpert.schoolnotes_fts3096_desktop.utlis.TextField();
        jCheckBoxMen = new javax.swing.JCheckBox();
        jCheckBoxWomen = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        button2 = new com.idevexpert.schoolnotes_fts3096_desktop.utlis.Button();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableDataAccount = new javax.swing.JTable();
        buttonCreateAccount = new com.idevexpert.schoolnotes_fts3096_desktop.utlis.Button();
        button1 = new com.idevexpert.schoolnotes_fts3096_desktop.utlis.Button();
        textFieldPersonSearch = new com.idevexpert.schoolnotes_fts3096_desktop.utlis.TextField();

        jTableDataPerson.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTableDataPerson.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "APELLIDO", "APELLIDO MATERNO", "DNI", "EMAIL", "TELÉFONO", "CELULAR", "DIRECCIÓN", "EDAD", "SEXO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableDataPerson);

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        buttonEditOrRegister.setText("EDITAR");
        buttonEditOrRegister.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        textFieldPhone.setLabelText("CELULAR");

        textFieldDni.setLabelText("DNI");

        textFieldMotherLastName.setLabelText("APELLIDO MATERNO");

        textFieldLastName.setLabelText("APELLIDO PATERNO");

        textFieldName.setLabelText("NOMBRE");
        textFieldName.setLineColor(new java.awt.Color(102, 102, 102));

        textFieldEmail.setLabelText("CORREO");

        textFieldCellPhone.setLabelText("TELÉFONO");

        textFieldAddress.setLabelText("DIRECCIÓN");

        jCheckBoxMen.setText("MASCULINO");
        jCheckBoxMen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBoxMenMouseClicked(evt);
            }
        });

        jCheckBoxWomen.setText("FEMENINO");

        jLabel1.setText("Ingrese fecha de cumpleaños");

        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(textFieldCellPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
                            .addComponent(textFieldEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textFieldDni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textFieldMotherLastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textFieldLastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textFieldName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(textFieldAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jFormattedTextFieldDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBoxMen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxWomen)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldMotherLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldCellPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxMen)
                    .addComponent(jCheckBoxWomen))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonEditOrRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                        .addGap(10, 10, 10))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonEditOrRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jTabbedPane1.addTab("DATOS", jPanel4);

        jTableDataAccount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "USUARIO", "TIPO DE CUENTA", "ESTADO", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableDataAccount);

        buttonCreateAccount.setText("NUEVA CUENTA");
        buttonCreateAccount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                    .addComponent(buttonCreateAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCreateAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        jTabbedPane1.addTab("CUENTA", jPanel5);

        button1.setText("NUEVA PERSONA");
        button1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        textFieldPersonSearch.setLabelText("Inserte nombre, apellido o DNI para buscar");
        textFieldPersonSearch.setLineColor(new java.awt.Color(0, 153, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                    .addComponent(textFieldPersonSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jTabbedPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textFieldPersonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxMenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxMenMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxMenMouseClicked

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed

    }//GEN-LAST:event_button2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public com.idevexpert.schoolnotes_fts3096_desktop.utlis.Button button1;
    public com.idevexpert.schoolnotes_fts3096_desktop.utlis.Button button2;
    public com.idevexpert.schoolnotes_fts3096_desktop.utlis.Button buttonCreateAccount;
    public com.idevexpert.schoolnotes_fts3096_desktop.utlis.Button buttonEditOrRegister;
    public javax.swing.JCheckBox jCheckBoxMen;
    public javax.swing.JCheckBox jCheckBoxWomen;
    public javax.swing.JFormattedTextField jFormattedTextFieldDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTable jTableDataAccount;
    public javax.swing.JTable jTableDataPerson;
    public com.idevexpert.schoolnotes_fts3096_desktop.utlis.TextField textFieldAddress;
    public com.idevexpert.schoolnotes_fts3096_desktop.utlis.TextField textFieldCellPhone;
    public com.idevexpert.schoolnotes_fts3096_desktop.utlis.TextField textFieldDni;
    public com.idevexpert.schoolnotes_fts3096_desktop.utlis.TextField textFieldEmail;
    public com.idevexpert.schoolnotes_fts3096_desktop.utlis.TextField textFieldLastName;
    public com.idevexpert.schoolnotes_fts3096_desktop.utlis.TextField textFieldMotherLastName;
    public com.idevexpert.schoolnotes_fts3096_desktop.utlis.TextField textFieldName;
    public com.idevexpert.schoolnotes_fts3096_desktop.utlis.TextField textFieldPersonSearch;
    public com.idevexpert.schoolnotes_fts3096_desktop.utlis.TextField textFieldPhone;
    // End of variables declaration//GEN-END:variables
}
