/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.managementwarehousestore.model;

import com.idevexpert.managementwarehousestore.data.dao.CategoriaDaoImpl;
import com.idevexpert.managementwarehousestore.data.dao.ProductDaoImpl;
import com.idevexpert.managementwarehousestore.data.dao.daoImpl.CategoriaDao;
import com.idevexpert.managementwarehousestore.data.dao.daoImpl.ProductDao;
import com.idevexpert.managementwarehousestore.data.dto.CategoriaDto;
import com.idevexpert.managementwarehousestore.view.administrator.JinternalJframeProduct;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jesus Gutierrez
 */
public class ModelProduct extends ModelAdministrator {

    public String submit;
    protected ProductDao productDao = new ProductDaoImpl();
    protected CategoriaDao categoriaDao = new CategoriaDaoImpl();

    @Override
    public void init() {
        loadingDataTable();
    }

    public JinternalJframeProduct getJinternalJframeProduct() {
        return this.jinternalJframeProduct;
    }

    public void loadingDataTable() {
        ((DefaultTableModel) this.jinternalJframeProduct.jTable1.getModel()).setRowCount(0);
        productDao.getAll().forEach(e
                -> {
            System.out.println("Se ve components");
            CategoriaDto categoriDao = categoriaDao.getById(e.getIdCategoria());
            ((DefaultTableModel) this.jinternalJframeProduct.jTable1.getModel()).addRow(
                    new Object[]{e.getId(),
                        e.getNombre(), e.getCantidad(),
                        e.getPrecio(),
                        e.getDescription(),
                        categoriDao.getTipo()
                    });
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
        int indexTable = this.jinternalJframeProduct.jTable1.getSelectedRow();
        if (indexTable == -1) {
            JOptionPane.showMessageDialog(null, "Deve de seleccionar un indece de la tabla", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        submit = "delete";
        if (JOptionPane.showConfirmDialog(null, "Esta segur@ que desea eliminar el producto ? ", "ALERTA", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) != 0) {
            return;
        }
        int idProductDelete = Integer.parseInt(this.jinternalJframeProduct.jTable1.getValueAt(indexTable, 0).toString());
        productDao.delete(idProductDelete);

        JOptionPane.showMessageDialog(null, "Datos Eliminados ", "Información", JOptionPane.INFORMATION_MESSAGE);
        loadingDataTable();
    }

    private void componentJdialogVisible() {
        this.jdialogProduct.jtextfieldUtil12.setText("");
        this.jdialogProduct.jtextfieldUtil10.setText("");
        this.jdialogProduct.jtextfieldUtil11.setText("");
        this.jdialogProduct.jtextfieldUtil13.setText("");
        this.jdialogProduct.jComboBox1.setSelectedIndex(0);
        ActionListener[] action = this.jdialogProduct.jButton4.getActionListeners();
        for (ActionListener actionListener : action) {
            this.jdialogProduct.jButton4.removeActionListener(actionListener);
        }
    }
}
