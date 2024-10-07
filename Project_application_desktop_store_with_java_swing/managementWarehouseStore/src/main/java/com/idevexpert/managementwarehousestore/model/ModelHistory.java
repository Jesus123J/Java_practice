/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.managementwarehousestore.model;

import com.idevexpert.managementwarehousestore.data.ConnectionDataBase;
import com.idevexpert.managementwarehousestore.data.dao.FacturaDaoImpl;
import com.idevexpert.managementwarehousestore.data.dto.FacturaDto;
import com.idevexpert.managementwarehousestore.view.administrator.JinternalJframeHistory;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jesus Gutierrez
 */
public class ModelHistory extends ModelAdministrator {

    @Override
    public void init() {

        DefaultTableModel tableModel = new DefaultTableModel(new String[]{"ID", "ID Cliente", "ID Producto", "Cantidad", "Fecha"}, 0);
        this.jinternalJframeHistory.jTable1.setModel(tableModel);
        this.jinternalJframeHistory.jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = jinternalJframeHistory.jTable1.getSelectedRow();
                    int facturaId = (int) tableModel.getValueAt(row, 0);
                    showJasperReport(facturaId);
                }
            }

        });
        loadAllFacturas();
    }

    private void loadAllFacturas() {
        try {
            List<FacturaDto> facturas = FacturaDaoImpl.getAllFacturas();
            updateTable(facturas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadFacturasByDate() {
        try {
            String date = this.jinternalJframeHistory.jFormattedTextField1.getText();
            List<FacturaDto> facturas = FacturaDaoImpl.getFacturasByDate(date);
            updateTable(facturas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

  
     public List<FacturaDto> getFacturasByDateRange(String startDate, String endDate) throws SQLException {
        String query = "SELECT * FROM factura WHERE STR_TO_DATE(date, '%d-%m-%Y %H:%i:%s') BETWEEN STR_TO_DATE(?, '%d-%m-%Y %H:%i:%s') AND STR_TO_DATE(?, '%d-%m-%Y %H:%i:%s')";
        List<FacturaDto> facturas = new ArrayList<>();
        try (PreparedStatement pstmt = ConnectionDataBase.connectionMysql.prepareStatement(query)) {
            pstmt.setString(1, startDate);
            pstmt.setString(2, endDate);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    FacturaDto factura = new FacturaDto(
                            rs.getInt("id"),
                            rs.getInt("idClient"),
                            rs.getInt("idProduct"),
                            rs.getInt("cantidad"),
                            rs.getString("date")
                    );
                    facturas.add(factura);
                }
            }
        }
        return facturas;
    }

    private void updateTable(List<FacturaDto> facturas) {
        ((DefaultTableModel) this.jinternalJframeHistory.jTable1.getModel()).setRowCount(0);
        for (FacturaDto factura : facturas) {
            ((DefaultTableModel) this.jinternalJframeHistory.jTable1.getModel()).addRow(new Object[]{factura.getId(), factura.getIdClient(), factura.getIdProduct(), factura.getCantidad(), factura.getDate()});
        }
    }

    private void showJasperReport(int facturaId) {

    }
}
