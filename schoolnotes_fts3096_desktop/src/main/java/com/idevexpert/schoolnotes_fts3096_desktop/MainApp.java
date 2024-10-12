/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop;

import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javafx.application.Platform;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class MainApp extends JFrame {

    public MainApp() {
        // Configuración de la ventana Swing
        setTitle("Integración de Swing y JavaFX");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton abrirMapaButton = new JButton("Abrir Mapa");
        abrirMapaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirMapa();
            }
        });

        // Agrega el botón a la ventana
        add(abrirMapaButton);
    }

    private void abrirMapa() {
        // Crear un JFXPanel para contener la escena de JavaFX
        JFXPanel jfxPanel = new JFXPanel();

        setVisible(false); // Ocultar la ventana Swing para mostrar el mapa
        // Cargar el archivo HTML del mapa

        // Ejecutar el código de JavaFX en el hilo de JavaFX
        Platform.runLater(() -> {
            // Crear el WebView
            WebView webView = new WebView();
            WebEngine webEngine = webView.getEngine();

            // Cargar el archivo HTML del mapa
            webEngine.load(getClass().getResource("/map.html").toExternalForm());

            // Agregar un listener para recibir la dirección desde JavaScript
            webEngine.setJavaScriptEnabled(true);
            webEngine.getLoadWorker().stateProperty().addListener((obs, oldState, newState) -> {
                if (newState == javafx.concurrent.Worker.State.SUCCEEDED) {
                    // Agregar la función JavaScript que será llamada desde el HTML
                    webEngine.executeScript("window.java = { sendAddress: function(address) { javaAddressHandler(address); } };");
                }
            });

            // Crear la escena y asignarla al JFXPanel
            Scene scene = new Scene(webView, 800, 600);
            jfxPanel.setScene(scene);  // Asignar la escena al JFXPanel
            removeAll();
            getContentPane().add(jfxPanel);
            revalidate();
            repaint();
            // Hacer visible el JFXPanel
            setVisible(true);
        });
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            MainApp mainApp = new MainApp();
            mainApp.setVisible(true);
        });
    }
}
