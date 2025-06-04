package com.arya.api.mvc.client;

import com.arya.api.mvc.dto.response.PrevisaoRiscoResposta;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Previsao", url = "${api.central.url}/ia")
public interface PrevisaoRiscoClient {

    @GetMapping("/previsao-risco")
    PrevisaoRiscoResposta preverRisco();
}
