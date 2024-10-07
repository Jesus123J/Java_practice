/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.managementwarehousestore.strategy;

/**
 *
 * @author Jesus Gutierrez
 */

public class DiscountPricingStrategy implements PricingStrategy {

    private static final double IGV_RATE = 0.18; // 18% IGV
    private double discountRate;

    public DiscountPricingStrategy(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public double calculateSubtotal(double unitPrice, int quantity) {
        return unitPrice * quantity;
    }

    @Override
    public double calculateDiscount(double subtotal) {
        return subtotal * discountRate;
    }

    @Override
    public double calculateIGV(double subtotal, double discount) {
        return (subtotal - discount) * IGV_RATE;
    }

    @Override
    public double calculateTotal(double subtotal, double discount, double igv) {
        return subtotal - discount + igv;
    }
}
