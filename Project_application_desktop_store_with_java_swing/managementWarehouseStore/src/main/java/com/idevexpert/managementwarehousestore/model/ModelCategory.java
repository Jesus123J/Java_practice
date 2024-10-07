/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.managementwarehousestore.model;

import com.idevexpert.managementwarehousestore.data.dao.CategoriaDaoImpl;
import com.idevexpert.managementwarehousestore.data.dao.daoImpl.CategoriaDao;
import com.idevexpert.managementwarehousestore.view.administrator.JinternalJframeCategory;
import com.idevexpert.managementwarehousestore.view.administrator.JinternalJframeClient;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jesus Gutierrez
 */
public class ModelCategory extends ModelAdministrator {

    public String submit;
    protected CategoriaDao categoriaDao = new CategoriaDaoImpl();

    public JinternalJframeCategory getJinternalJframeCategoria() {
        return this.jinternalJframeCategory;
    }

    @Override
    public void init() {
        loadingDataTable();
    }

    private void componentJdialogVisible() {
        this.jdialogCategory.jtextfieldUtil1.setText("");
        this.jdialogCategory.jtextfieldUtil2.setText("");
        this.jdialogCategory.jtextfieldUtil9.setText("");

        ActionListener[] action = this.jdialogCategory.jButton4.getActionListeners();
        for (ActionListener actionListener : action) {
            this.jdialogCategory.jButton4.removeActionListener(actionListener);
        }
    }

    public void loadingDataTable() {
        ((DefaultTableModel) this.jinternalJframeCategory.jTable1.getModel()).setRowCount(0);
        categoriaDao.getAll().forEach(e -> {
            ((DefaultTableModel) this.jinternalJframeCategory.jTable1.getModel()).addRow(
                    new Object[]{
                        e.getId(),
                        e.getTipo(),
                        e.getMaterial(),
                        e.getDescripcion()
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
        int indexTable = this.jinternalJframeCategory.jTable1.getSelectedRow();
        if (indexTable == -1) {
            JOptionPane.showMessageDialog(null, "Deve de seleccionar un indece de la tabla", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        submit = "delete";
        if (JOptionPane.showConfirmDialog(null, "Esta segur@ que desea eliminar el producto ? ", "ALERTA", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) != 0) {
            return;
        }
        int idProductDelete = Integer.parseInt(this.jinternalJframeCategory.jTable1.getValueAt(indexTable, 0).toString());
        categoriaDao.delete(idProductDelete);
        loadingDataTable();
    }

}
