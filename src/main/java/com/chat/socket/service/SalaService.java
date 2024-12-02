package com.chat.socket.service;

import com.chat.socket.dto.SalaDatosRequest;
import com.chat.socket.models.Sala;
import com.chat.socket.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    public Sala buscarSalaChat(SalaDatosRequest request) {
        Sala sala = salaRepository.findByCelular1AndCelular2(request.getCelular1(), request.getCelular2());
        if (sala != null) {
            return sala;
        } else {
            sala = salaRepository.findByCelular1AndCelular2(request.getCelular2(), request.getCelular1());
            if (sala != null) {
                return sala;
            } else {
                sala = new Sala();
                sala.setIdsala(generateRandomString());
                sala.setCelular1(request.getCelular1());
                sala.setCelular2(request.getCelular2());
                salaRepository.save(sala);
                return sala;
            }
        }
    }


    public static String generateRandomString() {
        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(15);

        for (int i = 0; i < 15; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }

        return sb.toString();
    }

}
