package com.globally.usuario.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SendUserDTO {
    @NotNull
    private String nome;
    @NotNull
    private String email;
    @NotNull
    private String senha;
}
