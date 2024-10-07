/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.managementwarehousestore.strategy;

/**
 *
 * @author Jesus Gutierrez
 */
public interface PricingStrategy {

    double calculateSubtotal(double unitPrice, int quantity);

    double calculateDiscount(double subtotal);

    double calculateIGV(double subtotal, double discount);

    double calculateTotal(double subtotal, double discount, double igv);
}
