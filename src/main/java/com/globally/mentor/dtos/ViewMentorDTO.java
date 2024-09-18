package com.globally.mentor.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ViewMentorDTO {

    private Long id;
    private String nome;
    private String email;
    private String descricaoCurta;
    private String descricaoLonga;
}
