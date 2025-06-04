package com.arya.api.mvc.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SolicitarRecuperacaoRequest {
    @NotBlank
    @Email
    private String email;
}