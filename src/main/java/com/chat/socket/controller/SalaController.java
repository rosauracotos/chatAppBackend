package com.chat.socket.controller;

import com.chat.socket.dto.SalaDatosRequest;
import com.chat.socket.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sala")
public class SalaController {

    @Autowired
    private SalaService salaService;

    @PostMapping("/obtenerSala")
    public ResponseEntity<?> guardar (@RequestBody SalaDatosRequest request){
        return ResponseEntity.ok(salaService.buscarSalaChat(request));
    }
}
