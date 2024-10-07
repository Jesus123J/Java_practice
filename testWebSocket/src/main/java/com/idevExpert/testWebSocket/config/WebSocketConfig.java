package com.idevExpert.testWebSocket.config;

import com.idevExpert.testWebSocket.data.service.RegistroWebSocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final RegistroWebSocketHandler registroWebSocketHandler;

    // Inyecta el RegistroWebSocketHandler como un bean
    public WebSocketConfig(RegistroWebSocketHandler registroWebSocketHandler) {
        this.registroWebSocketHandler = registroWebSocketHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(registroWebSocketHandler, "/ws/registro").setAllowedOrigins("*");
    }
}
