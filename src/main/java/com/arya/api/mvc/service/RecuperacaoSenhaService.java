package com.arya.api.mvc.service;

import com.arya.api.mvc.dto.request.RecuperacaoToken;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RecuperacaoSenhaService {

    private final Map<String, RecuperacaoToken> tokens = new ConcurrentHashMap<>();

    public String gerarToken(String email) {
        String token = UUID.randomUUID().toString();
        tokens.put(token, new RecuperacaoToken(token, email, LocalDateTime.now().plusMinutes(30)));
        return token;
    }

    public boolean tokenValido(String token) {
        RecuperacaoToken rec = tokens.get(token);
        return rec != null && rec.getExpiracao().isAfter(LocalDateTime.now());
    }

    public String getEmailByToken(String token) {
        RecuperacaoToken rec = tokens.get(token);
        return rec != null ? rec.getEmail() : null;
    }

    public void invalidarToken(String token) {
        tokens.remove(token);
    }
}
