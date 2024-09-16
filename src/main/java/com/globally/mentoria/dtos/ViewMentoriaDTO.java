package com.globally.mentoria.dtos;

import com.globally.mentoria.Mentoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ViewMentoriaDTO {
    private Long id;
    private Long userKey;
    private Long mentorKey;
    private String dia;
    private String mes;
    private String ano;
    private String hora;
    private String dataHoraCompleta;


    public ViewMentoriaDTO(Mentoria ed) {
        this.id = ed.getId();
        this.userKey = ed.getUserKey();
        this.mentorKey = ed.getMentorKey();

        LocalDateTime dataHora = ed.getDataHora();
        this.dia = String.valueOf(dataHora.getDayOfMonth());
        this.mes = String.valueOf(dataHora.getMonthValue());
        this.ano = String.valueOf(dataHora.getYear());
        this.hora = dataHora.toLocalTime().toString();

        this.dataHoraCompleta = ed.getDataHora().toString();
    }

}
