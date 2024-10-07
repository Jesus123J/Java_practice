/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.managementwarehousestore.model;

import com.idevexpert.managementwarehousestore.data.dao.CategoriaDaoImpl;
import com.idevexpert.managementwarehousestore.data.dao.ClientDaoImpl;
import com.idevexpert.managementwarehousestore.data.dao.FacturaDaoImpl;
import com.idevexpert.managementwarehousestore.data.dao.ProductDaoImpl;
import com.idevexpert.managementwarehousestore.data.dao.daoImpl.CategoriaDao;
import com.idevexpert.managementwarehousestore.data.dao.daoImpl.ClientDao;
import com.idevexpert.managementwarehousestore.data.dao.daoImpl.ProductDao;
import com.idevexpert.managementwarehousestore.data.dto.CategoriaDto;
import com.idevexpert.managementwarehousestore.data.dto.ClientDto;
import com.idevexpert.managementwarehousestore.data.dto.ProductDto;
import com.idevexpert.managementwarehousestore.strategy.DiscountPricingStrategy;
import com.idevexpert.managementwarehousestore.strategy.PricingStrategy;
import com.idevexpert.managementwarehousestore.utils.JframeLoading;
import com.idevexpert.managementwarehousestore.view.administrator.JinternalJframeBill;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Jesus Gutierrez
 */
public class ModelBill extends ModelAdministrator {

    CategoriaDao categoria = new CategoriaDaoImpl();
    ClientDao clientDao = new ClientDaoImpl();
    ProductDao productDao = new ProductDaoImpl();

    List<CategoriaDto> dataCategoria;
    List<ClientDto> dataClient;
    List<ProductDto> product;

    List<CategoriaDto> dataCategoriaComprado;
    List<ClientDto> dataClientComprado;
    List<ProductDto> productComprado;

    @Override
    public void init() {
        ((DefaultTableModel) this.jinternalJframeBill.jTable1.getModel()).setRowCount(0);
        clearComponent();
        loadingDataComboBox();
    }

    public JinternalJframeBill getIternalFactura() {
        return this.jinternalJframeBill;
    }

    public void clearComponent() {
        this.jinternalJframeBill.jComboBox1.setSelectedIndex(0);
        this.jinternalJframeBill.jComboBox2.setSelectedIndex(0);
        this.jinternalJframeBill.jtextfieldUtil1.setText("");
    }

    public void loadingDataComboBox() {
        dataCategoria = new ArrayList<>();
        dataClient = new ArrayList<>();
        product = new ArrayList<>();

        dataCategoriaComprado = new ArrayList<>();
        dataClientComprado = new ArrayList<>();
        productComprado = new ArrayList<>();

        dataCategoria = categoria.getAll();
        dataClient = clientDao.getAll();
        product = productDao.getAll();

        this.jinternalJframeBill.jComboBox1.removeAllItems();
        this.jinternalJframeBill.jComboBox1.addItem("<<Busque Cliente>>");

        dataClient.forEach(e -> {
            this.jinternalJframeBill.jComboBox1.addItem(e.getName());
        });
        this.jinternalJframeBill.jComboBox2.removeAllItems();
        this.jinternalJframeBill.jComboBox2.addItem("<<Busque Producto>>");

        product.forEach(e -> {
            this.jinternalJframeBill.jComboBox2.addItem(e.getNombre());
        });
    }
    PricingStrategy pricingStrategy;

    public void insertData() {
        if (jinternalJframeBill.jComboBox2.getSelectedIndex() == 0
                || jinternalJframeBill.jComboBox1.getSelectedIndex() == 0
                || jinternalJframeBill.jtextfieldUtil1.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Llene los campos");
            return;
        }

        ProductDto productMo = product.get(jinternalJframeBill.jComboBox2.getSelectedIndex() - 1);
        dataClientComprado.add(dataClient.get(this.jinternalJframeBill.jComboBox1.getSelectedIndex() - 1));
        productComprado.add(productMo);
        int row = jinternalJframeBill.jTable1.getRowCount();
        double cantidad = Double.parseDouble(this.jinternalJframeBill.jtextfieldUtil1.getText());
        if (cantidad > 10 && cantidad < 20) {
            pricingStrategy = new DiscountPricingStrategy(0.10);
        } else if (cantidad > 20 && cantidad < 30) {
            pricingStrategy = new DiscountPricingStrategy(0.30);
        } else if (cantidad > 30) {
            pricingStrategy = new DiscountPricingStrategy(0.70);
        } else {
            pricingStrategy = new DiscountPricingStrategy(0);
        }

        ((DefaultTableModel) this.jinternalJframeBill.jTable1.getModel()).addRow(new Object[]{
            row + 1,
            productMo.getNombre(),
            this.jinternalJframeBill.jtextfieldUtil1.getText(),
            productMo.getPrecio(),
            pricingStrategy.calculateSubtotal(productMo.getPrecio(), Integer.parseInt(this.jinternalJframeBill.jtextfieldUtil1.getText())),
            pricingStrategy.calculateDiscount(pricingStrategy.calculateSubtotal(productMo.getPrecio(), Integer.parseInt(this.jinternalJframeBill.jtextfieldUtil1.getText()))),
            pricingStrategy.calculateIGV(
            pricingStrategy.calculateSubtotal(productMo.getPrecio(), Integer.parseInt(this.jinternalJframeBill.jtextfieldUtil1.getText())),
            pricingStrategy.calculateDiscount(pricingStrategy.calculateSubtotal(productMo.getPrecio(), Integer.parseInt(this.jinternalJframeBill.jtextfieldUtil1.getText())))),
            pricingStrategy.calculateTotal(
            pricingStrategy.calculateSubtotal(productMo.getPrecio(), Integer.parseInt(this.jinternalJframeBill.jtextfieldUtil1.getText())),
            pricingStrategy.calculateDiscount(pricingStrategy.calculateSubtotal(productMo.getPrecio(), Integer.parseInt(this.jinternalJframeBill.jtextfieldUtil1.getText()))),
            pricingStrategy.calculateIGV(
            pricingStrategy.calculateSubtotal(productMo.getPrecio(), Integer.parseInt(this.jinternalJframeBill.jtextfieldUtil1.getText())),
            pricingStrategy.calculateDiscount(pricingStrategy.calculateSubtotal(productMo.getPrecio(), Integer.parseInt(this.jinternalJframeBill.jtextfieldUtil1.getText())))))
        });
        //loadingDataComboBox();
        clearComponent();
    }

    public void deleteData() {
        int indexTable = this.jinternalJframeBill.jTable1.getSelectedRow();
        if (indexTable == -1) {
            JOptionPane.showMessageDialog(null, "Deve de seleccionar un indece de la tabla", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        //submit = "delete";
        if (JOptionPane.showConfirmDialog(null, "Esta segur@ que desea eliminar el producto ? ", "ALERTA", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) != 0) {
            return;
        }
        ((DefaultTableModel) this.jinternalJframeBill.jTable1.getModel()).removeRow(this.jinternalJframeBill.jTable1.getSelectedRow());
        dataClientComprado.remove(indexTable);
        productComprado.remove(indexTable);
    }

    JasperViewer viewer;
    JframeLoading jframeLoading = new JframeLoading();

    public void showLoading() {
        this.jframeLogin.setEnabled(false);
        jframeLoading.setVisible(true);
    }

    public void generarReportImprit() {
        showLoading();
        int cantidadCount = this.jinternalJframeBill.jTable1.getRowCount();

        if (cantidadCount == 0) {
            JOptionPane.showMessageDialog(null, "No hay datos que se an guardado");
            this.jframeLogin.setEnabled(true);
            jframeLoading.setVisible(false);
            return;
        }

        if (JOptionPane.showConfirmDialog(null, "Una vez se muestre presivisualisacion del recivo se guardara el product\ny se guardara en la base de datos ya no podra eliminar\nDesea continuar ??") != 0) {
            this.jframeLogin.setEnabled(true);
            jframeLoading.setVisible(false);
            return;
        }
        FacturaDaoImpl facturaDaoImpl = new FacturaDaoImpl();
//        try {
        // int cantidadProduc = Integer.parseInt(this.jinternalJframeBill.jtextfieldUtil1.getText());

//            cantidadCount = cantidadCount - 1;
        int roto = 0;
        for (int i = 0; i < dataClientComprado.size(); i++) {

            try {
                roto = facturaDaoImpl.registrarFactura(dataClientComprado.get(i).getId(),
                        productComprado.get(i).getId(),
                        Integer.parseInt((String) this.jinternalJframeBill.jTable1.getValueAt(i, 2))
                );
                if (roto == 1) {
                    System.out.println("Se rropio");
                    break;
                }
            } catch (SQLException ex) {
                System.out.println("Exeption" + ex.getMessage());
            }
        }
        if (roto == 1) {
            System.out.println("Se cambio");
            jframeLoading.setVisible(false);
            return;
        }
//        } catch (Exception ex) {
//            System.out.println("Error " + ex.getMessage());
//
//        }
        new Thread(() -> {
            try {
                InputStream inputStream = getClass().getResourceAsStream("/Waves.jrxml");
                JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

                // Llenar el informe con datos (puedes pasar una conexión a la base de datos o un JRDataSource)
                Map<String, Object> parameters = new HashMap<>();
                // Añade parámetros aquí si es necesario
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
                try {
                    viewer.setVisible(false);
                } catch (Exception e) {
                }

                // Mostrar vista previa del informe
                viewer = new JasperViewer(jasperPrint, false);
                jframeLogin.setEnabled(true);
                jframeLoading.setVisible(false);

                viewer.setVisible(true);
                viewer.toFront();
////            JRPrintServiceExporter exporter = new JRPrintServiceExporter();
////            exporter.setParameter(JRPrintServiceExporterParameter.JASPER_PRINT, jasperPrint);
////            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, new HashPrintRequestAttributeSet());
////            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, new HashPrintServiceAttributeSet());
////            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
////            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
////
////            // Imprimir el informe
////            exporter.exportReport();
            } catch (JRException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error printing report: " + ex.getMessage());
            }
        }).start();
        clearComponent();
        loadingDataComboBox();
        ((DefaultTableModel) this.jinternalJframeBill.jTable1.getModel()).setRowCount(0);
    }

}
