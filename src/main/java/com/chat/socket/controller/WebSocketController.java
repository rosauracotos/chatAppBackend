package com.chat.socket.controller;

import com.chat.socket.dto.ChatMessage;
import com.chat.socket.service.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @Autowired
    private MensajeService mensajeService;

    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/{roomId}")
    public ChatMessage chat(@DestinationVariable String roomId, ChatMessage message){
        System.out.println(message);
        mensajeService.guardar(message);
        return new ChatMessage(message.getMessage(), message.getUser(), message.getSalaId(), message.getIdpersona());
    }

}
