package com.arya.api.mvc.controller;

import com.arya.api.mvc.client.HubOperacionalClient;
import com.arya.api.mvc.dto.request.EnderecoCadastroRequest;
import com.arya.api.mvc.dto.request.HubOperacionalCadastroRequest;
import com.arya.api.mvc.dto.response.HubOperacionalResposta;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hubs")
@RequiredArgsConstructor
public class HubOperacionalMvcController {

    private final HubOperacionalClient hubClient;



    @GetMapping
    public String listar(Model model) {
        List<HubOperacionalResposta> hubs = hubClient.listar();
        model.addAttribute("hubs", hubs);
        return "hub/listar";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("hub", new HubOperacionalCadastroRequest());
        return "hub/form";
    }

    @PostMapping
    public String salvar(@ModelAttribute("hub") HubOperacionalCadastroRequest request) {
        hubClient.cadastrar(request);
        return "redirect:/hubs";
    }


    @GetMapping("/editar/{id}")
    public String editar(@PathVariable String id, Model model) {
        HubOperacionalResposta resposta = hubClient.buscarPorId(id);

        HubOperacionalCadastroRequest request = new HubOperacionalCadastroRequest();
        request.setNome(resposta.getNome());
        request.setStatus(resposta.getStatus());

        EnderecoCadastroRequest endereco = new EnderecoCadastroRequest();
        endereco.setBairro(resposta.getEndereco().getBairro());
        endereco.setCidade(resposta.getEndereco().getCidade());
        endereco.setEstado(resposta.getEndereco().getEstado());
        endereco.setPais(resposta.getEndereco().getPais());

        request.setEndereco(endereco);

        model.addAttribute("hub", request);
        model.addAttribute("idHub", resposta.getIdHub());

        return "hub/form";
    }


    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable String id, @ModelAttribute("hub") HubOperacionalCadastroRequest request) {
        hubClient.atualizar(id, request);
        return "redirect:/hubs";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable String id) {
        hubClient.deletar(id);
        return "redirect:/hubs";
    }
}
