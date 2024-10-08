/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.data.api;


import com.idevexpert.schoolnotes_fts3096_desktop.view.JframeMain;
import okhttp3.*;
import raven.toast.Notifications;

public class WebSocketClient {

    private final OkHttpClient client;
    private WebSocket webSocket;
    private JframeMain jframeMain;
    private int conteo;
    public WebSocketClient(JframeMain jframeMain) {
        client = new OkHttpClient();
        this.jframeMain = jframeMain;
    }

    public void start() {
        Request request = new Request.Builder().url("ws://localhost:9091/ws/registro").build();
        webSocket = client.newWebSocket(request, new WebSocketListener() {
            @Override
            public void onOpen(WebSocket webSocket, Response response) {
                System.out.println("Conexión abierta");
            }

            @Override
            public void onMessage(WebSocket webSocket, String text) {
                System.out.println("Mensaje recibido: " + text);
                conteo++;
                System.out.println("Conteo " + conteo);
                jframeMain.badgeButton1.setText(""+conteo);
                Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.BOTTOM_RIGHT, "Se registro un horario");
                // Aquí puedes manejar la actualización de la UI o cualquier otra lógica
            }

            @Override
            public void onFailure(WebSocket webSocket, Throwable t, Response response) {
                System.err.println("Error en WebSocket: " + t.getMessage());
            }

            @Override
            public void onClosing(WebSocket webSocket, int code, String reason) {
                webSocket.close(1000, null);
                System.out.println("Conexión cerrada");
            }
        });
    }

    public void sendMessage(String message) {
        if (webSocket != null) {
            webSocket.send(message);
        }
    }
}
