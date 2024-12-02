package com.chat.socket.controller;

import com.chat.socket.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/validarcel/{numcel}")
    public ResponseEntity<?> obtenerPersonaId(@PathVariable("numcel") String numcel) {
        return ResponseEntity.ok(personaService.validarCelular(numcel));
    }


    @GetMapping("/listarContactos/{idPersona}")
    public ResponseEntity<?> obtenerContactos(@PathVariable("idPersona") Long idPersona) {
        return ResponseEntity.ok(personaService.obtenerContactos(idPersona));
    }



}
