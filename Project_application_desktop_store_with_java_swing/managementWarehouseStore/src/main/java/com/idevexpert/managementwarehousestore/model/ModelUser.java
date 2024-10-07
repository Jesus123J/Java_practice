/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.managementwarehousestore.model;

import com.formdev.flatlaf.util.StringUtils;
import com.idevexpert.managementwarehousestore.data.dao.PersonDaoImpl;
import com.idevexpert.managementwarehousestore.data.dao.UserDaoImpl;
import com.idevexpert.managementwarehousestore.data.dao.daoImpl.PersonDao;
import com.idevexpert.managementwarehousestore.data.dao.daoImpl.UserDao;
import com.idevexpert.managementwarehousestore.data.dto.PersonDto;
import com.idevexpert.managementwarehousestore.data.dto.UserDto;
import com.idevexpert.managementwarehousestore.view.administrator.JinternalJframeUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jesus Gutierrez
 */
public class ModelUser extends ModelAdministrator {

    public String submit;
    protected UserDao userDao = new UserDaoImpl();
    protected PersonDao personDao = new PersonDaoImpl();

    public JinternalJframeUser setInternalJframe(JinternalJframeUser jinternalJframeUser) {
        return this.jinternalJframeUser = jinternalJframeUser;
    }

    public JinternalJframeUser getInternalJframe() {
        return this.jinternalJframeUser;
    }

    public void loadingDataTable() {
        ((DefaultTableModel) this.jinternalJframeUser.jTable1.getModel()).setRowCount(0);
        personDao.getAll().forEach(e
                -> {
            UserDto userDto = userDao.getByIdPerson(e.getIdperson());
            ((DefaultTableModel) this.jinternalJframeUser.jTable1.getModel()).addRow(
                    new Object[]{e.getIdperson(),
                        e.getName(), e.getLastName(),
                        userDto == null ? "" : userDto.getUser(), userDto == null ? "" : userDto.getPassword(),
                        e.getTelefono()});
        });
    }

    /**
     *
     */
    @Override
    public void init() {
        loadingDataTable();
    }

    private void componentJdialogVisible() {
        this.jdialogUser.jtextfieldUtil1.setText("");
        this.jdialogUser.jPasswordField1.setText("");
        this.jdialogUser.jtextfieldUtil2.setText("");
        this.jdialogUser.jtextfieldUtil3.setText("");
        this.jdialogUser.jtextfieldUtil4.setText("");
        ActionListener[] action = this.jdialogUser.jButton4.getActionListeners();
        for (ActionListener actionListener : action) {
            this.jdialogUser.jButton4.removeActionListener(actionListener);
        }
    }

    public void insertData() {
        submit = "insert";
        componentJdialogVisible();
    }

    public void updateData() {
        submit = "update";
        componentJdialogVisible();

    }

    public void deleteData() {
        int indexTable = this.jinternalJframeUser.jTable1.getSelectedRow();
        if (indexTable == -1) {
            JOptionPane.showMessageDialog(null, "Deve de seleccionar un indece de la tabla", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        submit = "delete";
        if (JOptionPane.showConfirmDialog(null, "Esta segur@ que desea eliminar el dato ? ", "ALERTA", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) != 0) {
            return;
        }
        int idPersonDelete = Integer.parseInt(this.jinternalJframeUser.jTable1.getValueAt(indexTable, 0).toString());
        personDao.delete(idPersonDelete);
        UserDto user = userDao.getByIdPerson(idPersonDelete);
        if (user != null) {
            userDao.delete(user.getIdUser());
        }

        JOptionPane.showMessageDialog(null, "Datos Eliminados ", "Información", JOptionPane.INFORMATION_MESSAGE);
        loadingDataTable();
    }

}
