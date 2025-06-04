package com.arya.api.mvc.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsuarioTrocarSenhaRequest {

    @NotBlank
    private String senhaAtual;

    @NotBlank
    private String novaSenha;
}