package com.arya.api.mvc.controller;


import com.arya.api.mvc.dto.request.UsuarioCadastroRequest;
import com.arya.api.mvc.dto.request.UsuarioTrocarSenhaRequest;
import com.arya.api.mvc.dto.response.UsuarioResponse;
import com.arya.api.mvc.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/cadastro")
    public String telaCadastro(Model model) {
        model.addAttribute("usuario", new UsuarioCadastroRequest());
        return "usuarios/cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrar(@ModelAttribute UsuarioCadastroRequest request, Model model) {
        usuarioService.cadastrar(request);
        return "redirect:/login";
    }

    @GetMapping("/trocar-senha")
    public String telaTrocarSenha(Model model) {
        model.addAttribute("senhaRequest", new UsuarioTrocarSenhaRequest());
        return "usuarios/trocar-senha";
    }

    @PostMapping("/trocar-senha")
    public String trocarSenha(@ModelAttribute("senhaRequest") UsuarioTrocarSenhaRequest request,
                              HttpSession session,
                              Model model) {
        String userId = (String) session.getAttribute("userId");
        if (userId == null) {
            model.addAttribute("erro", "Usuário não autenticado");
            return "usuarios/trocar-senha";
        }

        usuarioService.trocarSenha(userId, request);
        return "redirect:/home";
    }
}
