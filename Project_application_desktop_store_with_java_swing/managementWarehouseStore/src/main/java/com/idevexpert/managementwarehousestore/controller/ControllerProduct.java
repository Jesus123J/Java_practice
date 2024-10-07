/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.managementwarehousestore.controller;

import com.idevexpert.managementwarehousestore.data.dto.CategoriaDto;
import com.idevexpert.managementwarehousestore.data.dto.ProductDto;
import com.idevexpert.managementwarehousestore.model.ModelProduct;
import com.idevexpert.managementwarehousestore.view.administrator.JinternalJframeProduct;
import com.idevexpert.managementwarehousestore.view.administrator.componentJdialog.JdialogProduct;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus Gutierrez
 */
public class ControllerProduct extends ModelProduct implements ActionListener {

    List<CategoriaDto> listCategori;

    public ControllerProduct(JinternalJframeProduct jinternalJframeProduct, JdialogProduct jdialogProduct) {

        this.jinternalJframeProduct = jinternalJframeProduct;
        this.jdialogProduct = jdialogProduct;
        init();
        
        this.jinternalJframeProduct.jButton1.addActionListener(this);
        this.jinternalJframeProduct.jButton2.addActionListener(this);
        this.jinternalJframeProduct.jButton3.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.jinternalJframeProduct.jButton2)) {
            System.out.println("Boton de Eliminar");
            deleteData();
//            this.jdialogUser.jButton4.addActionListener(this);
//            this.jdialogUser.setLocationRelativeTo(null);
//            this.jdialogUser.setVisible(true);
        }
        if (e.getSource().equals(this.jinternalJframeProduct.jButton1)) {
            updateData();
            int indexTable = this.jinternalJframeProduct.jTable1.getSelectedRow();
            if (indexTable == -1) {
                JOptionPane.showMessageDialog(null, "Deve de seleccionar un indece de la tabla", "Error", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            this.jdialogProduct.jtextfieldUtil12.setText(this.jinternalJframeProduct.jTable1.getValueAt(indexTable, 1).toString());
            this.jdialogProduct.jtextfieldUtil10.setText(this.jinternalJframeProduct.jTable1.getValueAt(indexTable, 2).toString());
            this.jdialogProduct.jtextfieldUtil11.setText(this.jinternalJframeProduct.jTable1.getValueAt(indexTable, 3).toString());
            this.jdialogProduct.jtextfieldUtil13.setText(this.jinternalJframeProduct.jTable1.getValueAt(indexTable, 4).toString());

            this.jdialogProduct.jComboBox1.removeAllItems();
            this.jdialogProduct.jComboBox1.addItem("Seleccione Categoria");

            listCategori = new ArrayList<>();
            listCategori = categoriaDao.getAll();
            listCategori.forEach(a -> {
                System.out.println("Producto");
                this.jdialogProduct.jComboBox1.addItem(a.getTipo());
                // ((DefaultComboBoxModel) this.jdialogProduct.jComboBox1.getModel()).addElement(a.getTipo());
            });
            this.jdialogProduct.jComboBox1.setSelectedItem(this.jinternalJframeProduct.jTable1.getValueAt(indexTable, 5).toString());
            this.jdialogProduct.jButton4.addActionListener(this);
            this.jdialogProduct.setLocationRelativeTo(null);
            this.jdialogProduct.setVisible(true);
        }
        if (e.getSource().equals(this.jinternalJframeProduct.jButton3)) {
            insertData();
            this.jdialogProduct.jComboBox1.removeAllItems();
            this.jdialogProduct.jComboBox1.addItem("Seleccione Categoria");

            listCategori = new ArrayList<>();
            listCategori = categoriaDao.getAll();
            listCategori.forEach(a -> {
                System.out.println("Producto");
                this.jdialogProduct.jComboBox1.addItem(a.getTipo());
                // ((DefaultComboBoxModel) this.jdialogProduct.jComboBox1.getModel()).addElement(a.getTipo());
            });
            this.jdialogProduct.jButton4.addActionListener(this);
            this.jdialogProduct.setLocationRelativeTo(null);
            this.jdialogProduct.setVisible(true);
        }

        if (e.getSource().equals(this.jdialogProduct.jButton4)) {
            System.out.println("Component dando click");
            int indexTable = this.jinternalJframeProduct.jTable1.getSelectedRow();
            switch (submit) {

                case "insert" -> {
                    listCategori = new ArrayList<>();
                    listCategori = categoriaDao.getAll();

                    String nombre = this.jdialogProduct.jtextfieldUtil12.getText();
                    String cantidad = this.jdialogProduct.jtextfieldUtil10.getText();
                    String precio = this.jdialogProduct.jtextfieldUtil11.getText();
                    String descripcion = this.jdialogProduct.jtextfieldUtil13.getText();

//                    this.jdialogProduct.jComboBox1.setSelectedItem(this.jinternalJframeProduct.jTable1.getValueAt(indexTable, 5).toString());
                    if (nombre.isBlank() || cantidad.isBlank() || precio.isBlank() || descripcion.isBlank() || this.jdialogProduct.jComboBox1.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(null, "Todos los componentes deben de llenarse", "Información", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    ProductDto product = new ProductDto();

                    product.setIdCategoria(listCategori.get(this.jdialogProduct.jComboBox1.getSelectedIndex() - 1).getId());
                    product.setCantidad(Integer.parseInt(cantidad));
                    product.setDescription(descripcion);
                    product.setNombre(nombre);
                    product.setPrecio(Double.parseDouble(precio));
                    productDao.insert(product);
                    loadingDataTable();
                    JOptionPane.showMessageDialog(null, "Se registro correctamente", "", JOptionPane.INFORMATION_MESSAGE);
                    jdialogProduct.setVisible(false);
                    return;

                }

                case "update" -> {
                    int idPerson = Integer.parseInt(this.jinternalJframeProduct.jTable1.getValueAt(indexTable, 0).toString());

                    String nombre = this.jdialogProduct.jtextfieldUtil12.getText();
                    String cantidad = this.jdialogProduct.jtextfieldUtil10.getText();
                    String precio = this.jdialogProduct.jtextfieldUtil11.getText();
                    String descripcion = this.jdialogProduct.jtextfieldUtil13.getText();
                    this.jdialogProduct.jComboBox1.setSelectedItem(this.jinternalJframeProduct.jTable1.getValueAt(indexTable, 5).toString());

                    ProductDto product = new ProductDto();
                    product.setId(idPerson);
                    product.setIdCategoria(listCategori.get(this.jdialogProduct.jComboBox1.getSelectedIndex()).getId());
                    product.setCantidad(Integer.parseInt(cantidad));
                    product.setDescription(descripcion);
                    product.setNombre(nombre);
                    product.setPrecio(Double.parseDouble(precio));

                    productDao.update(product);

                    loadingDataTable();
                    JOptionPane.showMessageDialog(null, "Se actulizo los datos", "", JOptionPane.INFORMATION_MESSAGE);
                    jdialogProduct.setVisible(false);
                }

            }
        }
    }

}
