package com.arya.api.mvc.controller;

import com.arya.api.mvc.client.UsuarioClient;
import com.arya.api.mvc.dto.request.ResetarSenhaRequest;
import com.arya.api.mvc.dto.request.SolicitarRecuperacaoRequest;
import com.arya.api.mvc.service.RecuperacaoSenhaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/recuperar-senha")
@RequiredArgsConstructor
public class RecuperacaoSenhaController {

    private final RecuperacaoSenhaService service;
    private final UsuarioClient usuarioClient;


    @GetMapping
    public String formEmail(Model model) {
        model.addAttribute("request", new SolicitarRecuperacaoRequest());
        return "usuarios/recuperar-form";
    }

    @PostMapping
    public String solicitar(@ModelAttribute SolicitarRecuperacaoRequest request, Model model) {
        String email = request.getEmail();

        if (!usuarioClient.existeEmail(email)) {
            model.addAttribute("erro", "Email não cadastrado");
            model.addAttribute("request", new SolicitarRecuperacaoRequest());
            return "usuarios/recuperar-form";
        }

        String token = service.gerarToken(email);
        model.addAttribute("link", "/recuperar-senha/" + token);
        return "usuarios/recuperar-link";
    }

    @GetMapping("/{token}")
    public String formResetar(@PathVariable String token, Model model) {
        if (!service.tokenValido(token)) return "erro/token-invalido";

        model.addAttribute("token", token);
        model.addAttribute("request", new ResetarSenhaRequest());
        return "usuarios/resetar-form";
    }

    @PostMapping("/{token}")
    public String resetar(@PathVariable String token, @ModelAttribute ResetarSenhaRequest request, Model model) {
        if (!request.getNovaSenha().equals(request.getConfirmarSenha())) {
            model.addAttribute("erro", "Senhas não coincidem");
            return "usuarios/resetar-form";
        }

        String email = service.getEmailByToken(token);
        if (email == null) return "erro/token-invalido";

        usuarioClient.resetarSenhaPorEmail(
                new ResetarSenhaRequest(email, request.getNovaSenha())
        );
        service.invalidarToken(token);
        return "redirect:/login";
    }
}


