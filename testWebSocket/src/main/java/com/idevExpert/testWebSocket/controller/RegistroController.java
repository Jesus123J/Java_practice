package com.idevExpert.testWebSocket.controller;


import com.idevExpert.testWebSocket.data.dto.RegistroDTO;
import com.idevExpert.testWebSocket.data.service.RegistroWebSocketHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registro")
public class RegistroController {

    private final RegistroWebSocketHandler registroWebSocketHandler;

    @Autowired
    public RegistroController(RegistroWebSocketHandler registroWebSocketHandler) {
        this.registroWebSocketHandler = registroWebSocketHandler;
    }

    @PostMapping("/nuevo")
    public ResponseEntity<String> registrarNuevo(@RequestBody RegistroDTO registro) {
        // Procesas el registro y guardas en base de datos

        // Notifica a los clientes conectados mediante WebSocket
        registroWebSocketHandler.notifyClients("Nuevo registro agregado");

        return ResponseEntity.ok("Registro recibido");
    }
}
