package com.chat.socket.repository;

import com.chat.socket.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    Persona findByCelular(String celular);

    List<Persona> findByIdNot(Long id);

}
