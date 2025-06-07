package com.arya.api.mvc.controller;


import com.arya.api.mvc.client.DroneClient;
import com.arya.api.mvc.client.HubOperacionalClient;
import com.arya.api.mvc.client.OcorrenciaClient;
import com.arya.api.mvc.client.PerguntaIaClient;
import com.arya.api.mvc.dto.request.PerguntaRequest;
import com.arya.api.mvc.dto.response.DroneResponse;
import com.arya.api.mvc.dto.response.HubOperacionalResposta;
import com.arya.api.mvc.dto.response.OcorrenciaResposta;
import com.arya.api.mvc.dto.response.RespostaNaturalIA;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final OcorrenciaClient ocorrenciaClient;

    private final HubOperacionalClient hubClient;

    private final DroneClient droneClient;

    private final PerguntaIaClient perguntaIaClient;


    @GetMapping("/home")
    public String home(Model model) {
        List<OcorrenciaResposta> ocorrencias = ocorrenciaClient.listarTodos();
        List<HubOperacionalResposta> hub = hubClient.listar();
        List<DroneResponse> drones = droneClient.listarTodos();
        model.addAttribute("drones", drones);
        model.addAttribute("ocorrencias", ocorrencias);
        model.addAttribute("hubs", hub);
        return "home";
    }

    @PostMapping("/perguntar-ia")
    @ResponseBody
    public RespostaNaturalIA perguntarIa(@RequestBody PerguntaRequest request) {
        return perguntaIaClient.perguntar(request);
    }

}
