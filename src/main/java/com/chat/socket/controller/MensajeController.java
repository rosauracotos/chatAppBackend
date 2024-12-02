package com.chat.socket.controller;

import com.chat.socket.dto.ChatRequest;
import com.chat.socket.service.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mensaje")
public class MensajeController {

    @Autowired
    private MensajeService mensajeService;

    @PostMapping("/obtenerChat")
    public ResponseEntity<?> guardar (@RequestBody ChatRequest request){
        return ResponseEntity.ok(mensajeService.obtenerMensajesDeSalaID(request.getSalaId(), request.getCelular()));
    }
}
