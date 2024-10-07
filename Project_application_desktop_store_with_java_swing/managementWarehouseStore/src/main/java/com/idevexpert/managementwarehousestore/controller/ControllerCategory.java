/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.managementwarehousestore.controller;

import com.idevexpert.managementwarehousestore.data.dto.CategoriaDto;
import com.idevexpert.managementwarehousestore.data.dto.ClientDto;
import com.idevexpert.managementwarehousestore.model.ModelCategory;
import com.idevexpert.managementwarehousestore.view.administrator.JinternalJframeCategory;
import com.idevexpert.managementwarehousestore.view.administrator.componentJdialog.JdialogCategory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus Gutierrez
 */
public class ControllerCategory extends ModelCategory implements ActionListener {

    public ControllerCategory(JinternalJframeCategory jinternalJframeCategory, JdialogCategory jdialogCategory) {
        this.jinternalJframeCategory = jinternalJframeCategory;
        this.jdialogCategory = jdialogCategory;
        init();
        this.jinternalJframeCategory.jButton1.addActionListener(this);
        this.jinternalJframeCategory.jButton2.addActionListener(this);
        this.jinternalJframeCategory.jButton3.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.jinternalJframeCategory.jButton2)) {
            System.out.println("Boton de Eliminar");
            deleteData();
        }

        if (e.getSource().equals(this.jinternalJframeCategory.jButton1)) {
            updateData();
            int indexTable = this.jinternalJframeCategory.jTable1.getSelectedRow();
            if (indexTable == -1) {
                JOptionPane.showMessageDialog(null, "Deve de seleccionar un indece de la tabla", "Error", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            this.jdialogCategory.jtextfieldUtil9.setText(this.jinternalJframeCategory.jTable1.getValueAt(indexTable, 3).toString());
            this.jdialogCategory.jtextfieldUtil1.setText(this.jinternalJframeCategory.jTable1.getValueAt(indexTable, 1).toString());
            this.jdialogCategory.jtextfieldUtil2.setText(this.jinternalJframeCategory.jTable1.getValueAt(indexTable, 2).toString());

            this.jdialogCategory.jButton4.addActionListener(this);
            this.jdialogCategory.setLocationRelativeTo(null);
            this.jdialogCategory.setVisible(true);
        }
        if (e.getSource().equals(this.jinternalJframeCategory.jButton3)) {
            insertData();

            this.jdialogCategory.jButton4.addActionListener(this);
            this.jdialogCategory.setLocationRelativeTo(null);
            this.jdialogCategory.setVisible(true);
        }

        if (e.getSource().equals(this.jdialogCategory.jButton4)) {
            System.out.println("Component dando click");
            int indexTable = this.jinternalJframeCategory.jTable1.getSelectedRow();
            switch (submit) {

                case "insert" -> {

                    String tipo = this.jdialogCategory.jtextfieldUtil1.getText();
                    String material = this.jdialogCategory.jtextfieldUtil2.getText();
                    String description = this.jdialogCategory.jtextfieldUtil9.getText();
                    CategoriaDto categoria = new CategoriaDto();
                    if (tipo.isBlank() || material.isBlank() || description.isBlank()) {
                        JOptionPane.showMessageDialog(null, "Todos los componentes deben de llenarse", "Información", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    categoria.setDescripcion(description);
                    categoria.setTipo(tipo);
                    categoria.setMaterial(material);

                    categoriaDao.insert(categoria);
                    loadingDataTable();
                    JOptionPane.showMessageDialog(null, "Se registro correctamente", "", JOptionPane.INFORMATION_MESSAGE);
                    jdialogCategory.setVisible(false);
                    return;

                }

                case "update" -> {
                    int idCategoria = Integer.parseInt(this.jinternalJframeCategory.jTable1.getValueAt(indexTable, 0).toString());

                    String tipo = this.jdialogCategory.jtextfieldUtil1.getText();
                    String material = this.jdialogCategory.jtextfieldUtil2.getText();
                    String description = this.jdialogCategory.jtextfieldUtil9.getText();
                    CategoriaDto categoria = new CategoriaDto();
                    categoria.setId(idCategoria);
                    categoria.setDescripcion(description);
                    categoria.setTipo(tipo);
                    categoria.setMaterial(material);

                    categoriaDao.update(categoria);
                    loadingDataTable();
                    JOptionPane.showMessageDialog(null, "Se actulizo los datos", "", JOptionPane.INFORMATION_MESSAGE);
                    jdialogCategory.setVisible(false);
                }

            }
        }

    }

}
