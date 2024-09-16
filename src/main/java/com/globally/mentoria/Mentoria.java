package com.globally.mentoria;

import com.globally.mentoria.dtos.SendMentoriaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Entity
@Table(name = "mentorias_nova")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mentoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_key", nullable = false)
    private Long userKey;

    @Column(name = "mentor_key", nullable = false)
    private Long mentorKey;

    @Column(name = "data_hora", columnDefinition = "TIMESTAMP")
    private LocalDateTime dataHora;

    public Mentoria(SendMentoriaDTO dto) {
        this.userKey = dto.getUserKey();
        this.mentorKey = dto.getMentorKey();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        try {
            this.dataHora = LocalDateTime.parse(dto.getDataHora(), formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Data inválida: " + e.getMessage());
        }
    }
}
