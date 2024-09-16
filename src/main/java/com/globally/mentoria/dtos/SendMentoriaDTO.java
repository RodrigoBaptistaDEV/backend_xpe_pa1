package com.globally.mentoria.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SendMentoriaDTO {
    @NotNull
    private Long userKey;

    @NotNull
    private Long mentorKey;

    @NotNull
    @Schema(description = "Data e hora no formato dd/MM/yyyy HH:mm", example = "16/09/2023 14:30")
    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}$",
            message = "Data e hora devem estar no formato dd/MM/yyyy HH:mm")
    private String dataHora;

}
