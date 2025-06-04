package com.arya.api.mvc.client;

import com.arya.api.mvc.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "droneinteligente", url = "${api.central.url}/ia")
public interface DroneInteligenciaClient {
}
