/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.managementwarehousestore.controller;

import com.idevexpert.managementwarehousestore.data.dto.ClientDto;
import com.idevexpert.managementwarehousestore.data.dto.ProductDto;
import com.idevexpert.managementwarehousestore.model.ModelClient;
import com.idevexpert.managementwarehousestore.view.administrator.JinternalJframeClient;
import com.idevexpert.managementwarehousestore.view.administrator.componentJdialog.JdialogClient;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus Gutierrez
 */
public class ControllerClient extends ModelClient implements ActionListener {

    public ControllerClient(JinternalJframeClient jinternalJframeClient, JdialogClient jdialogClient) {
        this.jinternalJframeClient = jinternalJframeClient;
        this.jdialogClient = jdialogClient;
        init();
        this.jinternalJframeClient.jButton1.addActionListener(this);
        this.jinternalJframeClient.jButton2.addActionListener(this);
        this.jinternalJframeClient.jButton3.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.jinternalJframeClient.jButton2)) {
            System.out.println("Boton de Eliminar");
            deleteData();
//            this.jdialogUser.jButton4.addActionListener(this);
//            this.jdialogUser.setLocationRelativeTo(null);
//            this.jdialogUser.setVisible(true);
        }
        if (e.getSource().equals(this.jinternalJframeClient.jButton1)) {
            updateData();
            int indexTable = this.jinternalJframeClient.jTable1.getSelectedRow();
            if (indexTable == -1) {
                JOptionPane.showMessageDialog(null, "Deve de seleccionar un indece de la tabla", "Error", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            this.jdialogClient.jtextfieldUtil9.setText(this.jinternalJframeClient.jTable1.getValueAt(indexTable, 1).toString());
            this.jdialogClient.jtextfieldUtil12.setText(this.jinternalJframeClient.jTable1.getValueAt(indexTable, 2).toString());
            this.jdialogClient.jtextfieldUtil10.setText(this.jinternalJframeClient.jTable1.getValueAt(indexTable, 3).toString());
            this.jdialogClient.jtextfieldUtil13.setText(this.jinternalJframeClient.jTable1.getValueAt(indexTable, 4).toString());
            this.jdialogClient.jtextfieldUtil11.setText(this.jinternalJframeClient.jTable1.getValueAt(indexTable, 5).toString());

            this.jdialogClient.jButton4.addActionListener(this);
            this.jdialogClient.setLocationRelativeTo(null);
            this.jdialogClient.setVisible(true);
        }
        if (e.getSource().equals(this.jinternalJframeClient.jButton3)) {
            insertData();

            this.jdialogClient.jButton4.addActionListener(this);
            this.jdialogClient.setLocationRelativeTo(null);
            this.jdialogClient.setVisible(true);
        }

        if (e.getSource().equals(this.jdialogClient.jButton4)) {
            System.out.println("Component dando click");
            int indexTable = this.jinternalJframeClient.jTable1.getSelectedRow();
            switch (submit) {

                case "insert" -> {

                    String nombre = this.jdialogClient.jtextfieldUtil9.getText();
                    String apellido = this.jdialogClient.jtextfieldUtil12.getText();
                    String dni = this.jdialogClient.jtextfieldUtil10.getText();
                    String direccion = this.jdialogClient.jtextfieldUtil13.getText();
                    String telefono = this.jdialogClient.jtextfieldUtil11.getText();

//                    this.jdialogProduct.jComboBox1.setSelectedItem(this.jinternalJframeProduct.jTable1.getValueAt(indexTable, 5).toString());
                    if (nombre.isBlank() || apellido.isBlank() || dni.isBlank() || direccion.isBlank() || telefono.isBlank()) {
                        JOptionPane.showMessageDialog(null, "Todos los componentes deben de llenarse", "Información", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }

                    ClientDto client = new ClientDto();
                    client.setName(nombre);
                    client.setApellido(apellido);
                    client.setDireccion(direccion);
                    client.setDni(dni);
                    client.setTelefono(telefono);

                    clientDao.insert(client);
                    loadingDataTable();
                    JOptionPane.showMessageDialog(null, "Se registro correctamente", "", JOptionPane.INFORMATION_MESSAGE);
                    jdialogClient.setVisible(false);
                    return;

                }

                case "update" -> {
                    int idClient = Integer.parseInt(this.jinternalJframeClient.jTable1.getValueAt(indexTable, 0).toString());

                    String nombre = this.jdialogClient.jtextfieldUtil9.getText();
                    String apellido = this.jdialogClient.jtextfieldUtil12.getText();
                    String dni = this.jdialogClient.jtextfieldUtil10.getText();
                    String direccion = this.jdialogClient.jtextfieldUtil13.getText();
                    String telefono = this.jdialogClient.jtextfieldUtil11.getText();

                    ClientDto client = new ClientDto();
                    client.setId(idClient);
                    client.setName(nombre);
                    client.setApellido(apellido);
                    client.setDireccion(direccion);
                    client.setDni(dni);
                    client.setTelefono(telefono);

                    clientDao.update(client);

                    loadingDataTable();
                    JOptionPane.showMessageDialog(null, "Se actulizo los datos", "", JOptionPane.INFORMATION_MESSAGE);
                    jdialogClient.setVisible(false);
                }

            }
        }
    }
}
