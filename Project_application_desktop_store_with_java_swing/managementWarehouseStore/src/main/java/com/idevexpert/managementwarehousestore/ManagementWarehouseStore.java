/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.idevexpert.managementwarehousestore;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.idevexpert.managementwarehousestore.controller.ControllerLogin;
/**
 *
 * @author Jesus Gutierrez
 */
public class ManagementWarehouseStore {

    public static  ControllerLogin controllerLogin;
    public static void main(String[] args) {
        System.out.println("Se inicia el aplicacion");
        FlatMacLightLaf.install();
        controllerLogin = new ControllerLogin();
    }
}
