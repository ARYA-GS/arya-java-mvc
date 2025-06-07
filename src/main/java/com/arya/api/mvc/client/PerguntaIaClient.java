package com.arya.api.mvc.client;

import com.arya.api.mvc.dto.request.PerguntaRequest;
import com.arya.api.mvc.dto.response.RespostaNaturalIA;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "pergunta", url = "${api.central.url}/ia")
public interface PerguntaIaClient {

    @PostMapping("/perguntar")
    RespostaNaturalIA perguntar(@RequestBody PerguntaRequest request);
}
