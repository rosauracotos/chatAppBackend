package com.chat.socket.service;

import com.chat.socket.models.Persona;
import com.chat.socket.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public Persona validarCelular(String celular) {
        return personaRepository.findByCelular(celular);
    }

    public List<Persona> obtenerContactos(Long idPersona) {
        return personaRepository.findByIdNot(idPersona);
    }

}
