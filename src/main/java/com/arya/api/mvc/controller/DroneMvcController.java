package com.arya.api.mvc.controller;

import com.arya.api.mvc.client.DroneClient;
import com.arya.api.mvc.client.HubOperacionalClient;
import com.arya.api.mvc.dto.request.DroneCadastroRequest;
import com.arya.api.mvc.dto.response.DroneResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/drones")
@RequiredArgsConstructor
public class DroneMvcController {

    private final DroneClient droneClient;
    private final HubOperacionalClient hubClient;

    @GetMapping
    public String listar(Model model) {
        List<DroneResponse> drones = droneClient.listarTodos();
        model.addAttribute("drones", drones);
        return "drone/listar";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("drone", new DroneCadastroRequest());
        model.addAttribute("hubs", hubClient.listar()); // para select de hub
        return "drone/form";
    }

    @PostMapping
    public String salvar(@ModelAttribute("drone") DroneCadastroRequest request,
                         @RequestParam("funcoesString") String funcoesString,
                         BindingResult result, Model model) {

        List<String> funcoes = Arrays.stream(funcoesString.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();
        request.setFuncoes(funcoes);

        if (result.hasErrors()) {
            model.addAttribute("hubs", hubClient.listar());
            return "drone/cadastro";
        }

        droneClient.cadastrar(request);
        return "redirect:/drones";
    }


    @GetMapping("/editar/{id}")
    public String editar(@PathVariable String id, Model model) {
        DroneResponse response = droneClient.buscarPorId(id);

        DroneCadastroRequest request = new DroneCadastroRequest();
        request.setModelo(response.getModelo());
        request.setAlcanceKm(response.getAlcanceKm());
        request.setCargaKg(response.getCargaKg());
        request.setFuncoes(response.getFuncoes());

        model.addAttribute("drone", request);
        model.addAttribute("idDrone", id);
        model.addAttribute("hubs", hubClient.listar());
        return "drone/form";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable String id,
                            @ModelAttribute("drone") DroneCadastroRequest request,
                            @RequestParam("funcoesString") String funcoesString,
                            BindingResult result,
                            Model model) {

        List<String> funcoes = Arrays.stream(funcoesString.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();
        request.setFuncoes(funcoes);

        if (result.hasErrors()) {
            model.addAttribute("hubs", hubClient.listar());
            model.addAttribute("idDrone", id);
            return "drone/form";
        }

        droneClient.atualizar(id, request);
        return "redirect:/drones";
    }


    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable String id) {
        droneClient.deletar(id);
        return "redirect:/drones";
    }
}
