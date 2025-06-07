package com.arya.api.mvc.client;

import com.arya.api.mvc.dto.response.SugestaoDroneResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "droneinteligente", url = "${api.central.url}/ia")
public interface DroneInteligenciaClient {

    @GetMapping("/sugerir-drone/{idOcorrencia}")
    SugestaoDroneResponse sugerirDrone(String idOcorrencia);
}
