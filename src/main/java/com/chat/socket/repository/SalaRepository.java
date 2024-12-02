package com.chat.socket.repository;

import com.chat.socket.models.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {

    public Sala findByCelular1AndCelular2(String celular1, String celular2);

}
