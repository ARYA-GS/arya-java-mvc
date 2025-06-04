package com.arya.api.mvc.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResetarSenhaRequest {
    @NotBlank
    private String novaSenha;

    @NotBlank
    private String confirmarSenha;


}
