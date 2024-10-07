/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.managementwarehousestore.model;

import com.idevexpert.managementwarehousestore.data.dao.ClientDaoImpl;
import com.idevexpert.managementwarehousestore.data.dao.daoImpl.ClientDao;
import com.idevexpert.managementwarehousestore.view.administrator.JinternalJframeClient;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jesus Gutierrez
 */
public class ModelClient extends ModelAdministrator {
     public String submit;
    protected ClientDao clientDao = new ClientDaoImpl();

    public JinternalJframeClient getJinternalJframeClient() {
        return this.jinternalJframeClient;
    }

    @Override
    public void init() {
        loadingDataTable();
    }

    private void componentJdialogVisible() {
        this.jdialogClient.jtextfieldUtil12.setText("");
        this.jdialogClient.jtextfieldUtil10.setText("");
        this.jdialogClient.jtextfieldUtil11.setText("");
        this.jdialogClient.jtextfieldUtil13.setText("");
        this.jdialogClient.jtextfieldUtil9.setText("");
        
        ActionListener[] action = this.jdialogClient.jButton4.getActionListeners();
        for (ActionListener actionListener : action) {
            this.jdialogClient.jButton4.removeActionListener(actionListener);
        }
    }

    public void loadingDataTable() {
        ((DefaultTableModel) this.jinternalJframeClient.jTable1.getModel()).setRowCount(0);
        clientDao.getAll().forEach(e -> {
            ((DefaultTableModel) this.jinternalJframeClient.jTable1.getModel()).addRow(
                    new Object[]{
                        e.getId(),
                        e.getName(),
                        e.getApellido(),
                        e.getDni(),
                        e.getDireccion(),
                        e.getTelefono()
                    }
            );
        });
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
        int indexTable = this.jinternalJframeClient.jTable1.getSelectedRow();
        if (indexTable == -1) {
            JOptionPane.showMessageDialog(null, "Deve de seleccionar un indece de la tabla", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        submit = "delete";
        if (JOptionPane.showConfirmDialog(null, "Esta segur@ que desea eliminar el producto ? ", "ALERTA", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) != 0) {
            return;
        }
        int idProductDelete = Integer.parseInt(this.jinternalJframeClient.jTable1.getValueAt(indexTable, 0).toString());
        clientDao.delete(idProductDelete);

        JOptionPane.showMessageDialog(null, "Datos Eliminados ", "Información", JOptionPane.INFORMATION_MESSAGE);
        loadingDataTable();
    }
}
