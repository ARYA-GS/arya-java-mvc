package com.arya.api.mvc.controller;

import com.arya.api.mvc.dto.request.LoginRequest;
import com.arya.api.mvc.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "login";
    }

    @PostMapping("/login")
    public String realizarLogin(@ModelAttribute LoginRequest loginRequest, HttpSession session, Model model) {
        try {
            String token = usuarioService.login(loginRequest);
            session.setAttribute("token", token);
            return "redirect:/home";
        } catch (Exception e) {
            e.printStackTrace(); // loga no console
            model.addAttribute("erro", "Login inválido.");
            return "login";
        }
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}


