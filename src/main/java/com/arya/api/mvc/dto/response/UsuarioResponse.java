package com.arya.api.mvc.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UsuarioResponse {
    private String usuarioId;
    private String nome;
    private String email;
    private LocalDate dataNasc;
}