package com.sentiment.demo.entity;

import com.sentiment.demo.dto.Prevision;
import jakarta.persistence.*;
import lombok.*; // Importa las anotaciones de Lombok

import java.time.LocalDateTime;

@Entity
@Table(name = "comentarios")
@Getter                 // Genera todos los Getters
@Setter                 // Genera todos los Setters
@NoArgsConstructor      // Genera el constructor vacío (obligatorio para JPA)
@AllArgsConstructor     // Genera un constructor con todos los campos
@Builder                // Permite crear objetos con Comentario.builder()...
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 2000)
    private String texto;

    @Enumerated(EnumType.STRING)
    private Prevision sentimiento;

    private double probabilidad;

    private LocalDateTime fecha;

}