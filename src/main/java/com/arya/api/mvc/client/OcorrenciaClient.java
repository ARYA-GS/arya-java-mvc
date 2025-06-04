package com.arya.api.mvc.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "ocorrencia", url = "${api.central.url}/ocorrencias")
public interface OcorrenciaClient {
}
