package com.arya.api.mvc.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class RecuperacaoToken {

    private String token;
    private String email;
    private LocalDateTime expiracao;

    public boolean expirado() {
        return expiracao.isBefore(LocalDateTime.now());
    }
}