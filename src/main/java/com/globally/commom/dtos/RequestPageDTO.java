package com.globally.commom.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RequestPageDTO {
    @NotNull
    Integer pageNumber;
    @NotNull
    Integer pageSize;
    @NotNull
    String sortAttribute;
    @NotNull
    String sortDirection;
}
