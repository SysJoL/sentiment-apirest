package com.sentiment.demo.repository;

import com.sentiment.demo.dto.Prevision;
import com.sentiment.demo.entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    // Spring Data JPA crea la consulta automáticamente
    long countBySentimiento(Prevision sentimiento);

    @Query(value = "SELECT * FROM comentarios WHERE sentimiento = :sentimiento ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Optional<Comentario> findRandomBySentimiento(@Param("sentimiento") String sentimiento);
}