package com.arya.api.mvc.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "Previsao", url = "${api.central.url}/ia")
public interface PrevisaoRiscoClient {
}
