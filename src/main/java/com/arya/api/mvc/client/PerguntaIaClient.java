package com.arya.api.mvc.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "pergunta", url = "${api.central.url}/ia")
public interface PerguntaIaClient {
}
