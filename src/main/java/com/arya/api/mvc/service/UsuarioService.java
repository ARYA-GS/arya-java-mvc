package com.arya.api.mvc.service;

import com.arya.api.mvc.client.LoginClient;
import com.arya.api.mvc.client.UsuarioClient;
import com.arya.api.mvc.dto.request.LoginRequest;
import com.arya.api.mvc.dto.request.UsuarioCadastroRequest;
import com.arya.api.mvc.dto.request.UsuarioTrocarSenhaRequest;
import com.arya.api.mvc.dto.response.TokenResponse;
import com.arya.api.mvc.dto.response.UsuarioResponse;
import com.arya.api.mvc.session.UsuarioSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    @Autowired
    private UsuarioClient usuarioClient;

    @Autowired
    private LoginClient loginClient;

    @Autowired
    private UsuarioSession session;

    public UsuarioResponse cadastrar(UsuarioCadastroRequest request) {
        return usuarioClient.cadastrar(request);
    }

    public String login(LoginRequest request) {
        String token = loginClient.login(request); // agora retorna direto como String
        session.setToken(token);
        return token;
    }

    public UsuarioResponse trocarSenha(String id, UsuarioTrocarSenhaRequest request) {
        return usuarioClient.trocarSenha(id, request);
    }
}
