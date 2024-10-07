/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.managementwarehousestore.controller;

import com.idevexpert.managementwarehousestore.data.dto.PersonDto;
import com.idevexpert.managementwarehousestore.data.dto.UserDto;
import com.idevexpert.managementwarehousestore.model.ModelUser;
import com.idevexpert.managementwarehousestore.view.administrator.JinternalJframeUser;
import com.idevexpert.managementwarehousestore.view.administrator.componentJdialog.JdialogUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus Gutierrez
 */
public class ControllerUser extends ModelUser implements ActionListener {

    public ControllerUser(JinternalJframeUser jinternalJframeUser, JdialogUser jdialogUser) {
        this.jinternalJframeUser = jinternalJframeUser;
        this.jdialogUser = jdialogUser;
        init();
        this.jinternalJframeUser.jButton1.addActionListener(this);
        this.jinternalJframeUser.jButton2.addActionListener(this);
        this.jinternalJframeUser.jButton3.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.jinternalJframeUser.jButton2)) {
            System.out.println("Boton de Eliminar");
            deleteData();
//            this.jdialogUser.jButton4.addActionListener(this);
//            this.jdialogUser.setLocationRelativeTo(null);
//            this.jdialogUser.setVisible(true);
        }
        if (e.getSource().equals(this.jinternalJframeUser.jButton1)) {
            updateData();
            int indexTable = this.jinternalJframeUser.jTable1.getSelectedRow();
            if (indexTable == -1) {
                JOptionPane.showMessageDialog(null, "Deve de seleccionar un indece de la tabla", "Error", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            this.jdialogUser.jtextfieldUtil1.setText(this.jinternalJframeUser.jTable1.getValueAt(indexTable, 3).toString());
            this.jdialogUser.jPasswordField1.setText(this.jinternalJframeUser.jTable1.getValueAt(indexTable, 4).toString());
            this.jdialogUser.jtextfieldUtil4.setText(this.jinternalJframeUser.jTable1.getValueAt(indexTable, 1).toString());
            this.jdialogUser.jtextfieldUtil2.setText(this.jinternalJframeUser.jTable1.getValueAt(indexTable, 2).toString());
            this.jdialogUser.jtextfieldUtil3.setText(this.jinternalJframeUser.jTable1.getValueAt(indexTable, 5).toString());

            this.jdialogUser.jButton4.addActionListener(this);
            this.jdialogUser.setLocationRelativeTo(null);
            this.jdialogUser.setVisible(true);
        }
        if (e.getSource().equals(this.jinternalJframeUser.jButton3)) {
            insertData();
            this.jdialogUser.jButton4.addActionListener(this);
            this.jdialogUser.setLocationRelativeTo(null);
            this.jdialogUser.setVisible(true);
        }

        if (e.getSource().equals(this.jdialogUser.jButton4)) {
            System.out.println("Component dando click");
            int indexTable = this.jinternalJframeUser.jTable1.getSelectedRow();
            switch (submit) {

                case "insert" -> {
                    String userr = this.jdialogUser.jtextfieldUtil1.getText();
                    String password = new String(this.jdialogUser.jPasswordField1.getPassword());
                    String name = this.jdialogUser.jtextfieldUtil4.getText();
                    String apellido = this.jdialogUser.jtextfieldUtil2.getText();
                    String telefono = this.jdialogUser.jtextfieldUtil3.getText();
                    if (userr.isBlank() || password.isBlank() || name.isBlank() || apellido.isBlank() || telefono.isBlank()) {
                        JOptionPane.showMessageDialog(null, "Todos los componentes deben de llenarse", "Información", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    PersonDto person = new PersonDto(name, apellido, telefono);
                    int idPersonInsert = personDao.insert(person);
                    if (idPersonInsert == -1) {
                        JOptionPane.showMessageDialog(null, "Ocurrio un problema al registrar la persona", "Error", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    UserDto userDtoInsert = new UserDto(idPersonInsert, userr, password);
                    userDao.insert(userDtoInsert);
                    loadingDataTable();
                    JOptionPane.showMessageDialog(null, "Se registro correctamente", "", JOptionPane.INFORMATION_MESSAGE);
                    jdialogUser.setVisible(false);

                }
                case "update" -> {
                    int idPerson = Integer.parseInt(this.jinternalJframeUser.jTable1.getValueAt(indexTable, 0).toString());

                    String userdto = this.jdialogUser.jtextfieldUtil1.getText();
                    String passwordUpdate = new String(this.jdialogUser.jPasswordField1.getPassword());
                    String nameUpdate = this.jdialogUser.jtextfieldUtil4.getText();
                    String apellidopdate = this.jdialogUser.jtextfieldUtil2.getText();
                    String telefonUpdate = this.jdialogUser.jtextfieldUtil3.getText();

                    PersonDto personUpdate = new PersonDto(nameUpdate, apellidopdate, telefonUpdate);
                    personUpdate.setIdperson(idPerson);
                    personDao.update(personUpdate);
                    UserDto userDtoWithId = userDao.getByIdPerson(idPerson);
                    UserDto userdtoo = new UserDto(idPerson, userdto, passwordUpdate);
                    userdtoo.setIdPerson(userDtoWithId.getIdUser());
                    userDao.update(userdtoo);
                    loadingDataTable();
                    JOptionPane.showMessageDialog(null, "Se actulizo los datos", "", JOptionPane.INFORMATION_MESSAGE);
                    jdialogUser.setVisible(false);
                }
            }
        }
    }

}
