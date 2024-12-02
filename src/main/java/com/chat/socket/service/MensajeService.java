package com.chat.socket.service;

import com.chat.socket.dto.ChatMessage;
import com.chat.socket.dto.MessageResponse;
import com.chat.socket.models.Mensaje;
import com.chat.socket.repository.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MensajeService {

    @Autowired
    private MensajeRepository mensajeRepository;

    public List<MessageResponse> obtenerMensajesDeSalaID(String salaId, String celular) {
        List<Mensaje> mensajes = mensajeRepository.findByIdSalaOrderById(salaId);
        List<MessageResponse> mensajesFormatList = new ArrayList<>();
        if (!mensajes.isEmpty()) {
            for (Mensaje mensaje: mensajes) {
                MessageResponse messageResponse = new MessageResponse();
                messageResponse.setMessage(mensaje.getMensaje());
                messageResponse.setMessage_side("receiver");
                if (mensaje.getCelular().equals(celular)) {
                    messageResponse.setMessage_side("sender");
                }
                mensajesFormatList.add(messageResponse);
            }
        }
        return mensajesFormatList;
    }

    public Mensaje guardar(ChatMessage chatMessage) {
        Mensaje mensaje = new Mensaje();
        mensaje.setMensaje(chatMessage.getMessage());
        mensaje.setCelular(chatMessage.getUser());
        mensaje.setIdSala(chatMessage.getSalaId());
        return mensajeRepository.save(mensaje);
    }

}
